package br.com.lavid.atividade2;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.LinkedList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import br.com.lavid.atividade1.Main;
import br.com.lavid.model.PAT;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;



public class MyServer {

	public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/pat", new ExtractPAT());
        server.createContext("/pmt", new ExtractPMT());
        server.setExecutor(null);
        server.start();
    }

    static class ExtractPAT implements HttpHandler {
        public void handle(HttpExchange t) throws IOException {
            List<PAT> list = Main.getPATList();
            String result = listToJSON(list);
            t.sendResponseHeaders(200, result.length());
            OutputStream os = t.getResponseBody();
            os.write(result.getBytes());
            os.close();
        }
        
        
        private String listToJSON(List<PAT> l){
        	JSONArray list = new JSONArray();
        	JSONObject obj = null;
        	for(PAT p : l){
        		obj = new JSONObject();
        		obj.put("table_id", p.getTable_id());
    			obj.put("section_syntax_indicator", p.getSection_syntax_indicator());
    			obj.put("section_lenght" ,p.getSection_length());
    			obj.put("transport_stream_id", p.getTransport_stream_id());
    			obj.put("current_next_indicator", p.getCurrent_next_indicator());
    			list.add(obj);
        	}
        	return JSONValue.toJSONString(list);
        }
    }
    
    static class ExtractPMT implements HttpHandler {
        public void handle(HttpExchange t) throws IOException {
            String result = "PMT";
            t.sendResponseHeaders(200, result.length());
            OutputStream os = t.getResponseBody();
            os.write(result.getBytes());
            os.close();
        }
    }

}
