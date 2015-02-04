package br.com.lavid.atividade1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import br.com.lavid.model.PAT;
import br.com.lavid.model.TS;

public class Main {

	public static final String PATH_VIDEO = "media/video.ts";

	public static List<PAT> listPats;

	public static void main(String args[]) throws IOException {
		printPATList();
	}

	public static void extractPatPmt() throws FileNotFoundException,
			IOException {
		listPats = new LinkedList<PAT>();
		PAT pat;
		byte[] b = new byte[188]; // Um fluxo de TV Digital eh organizado em
									// pacotes de 188 bytes

		File file = new File(PATH_VIDEO);
		FileInputStream fis = new FileInputStream(file);
		int read = 0;
		while ((read = fis.read(b)) != -1) {
			String resultBinary = convert(b[1]);
			String pid = resultBinary.substring(3); // pega os 5 bits restantes
			boolean maiorQueZero = false;
			for (int i = 0; i < pid.length(); i++) {
				if (pid.charAt(i) == '1') {
					maiorQueZero = true;
					break;
				}
			}

			if (!maiorQueZero) {
				if (b[2] == 0) { // esse pacote de 188 bytes é um PAT
					pat = new PAT();
					pat.setTable_id(b[5]);
					String result = convert(b[6]);
					pat.setSection_syntax_indicator(result.substring(0, 1));
					//cada F é igual a 4 bits ou seja, 
					//x & 0xFF eu extraio os ultimos 8bits de um valor x & 0xFFF 
					//extraio os ultimos 12 bits
					pat.setSection_length(((b[6] & 0xFF) & 0xF) + b[7] & 0xFF);
					pat.setTransport_stream_id(binaryToDecimal(convert(b[8]) + convert(b[9])));
					result = convert(b[10]);
					pat.setVersion_number(((b[10] & 0xFF) >> 1) & 0x1F);
					pat.setCurrent_next_indicator((b[10] & 0xFF) & 0x01);
					pat.setLast_section_number(b[12]);
					listPats.add(pat);
				}
			}
		}
	}

	public static void printPATList() throws FileNotFoundException, IOException {
		extractPatPmt();
		System.out.println("Total PATS - " + listPats.size());
		int cont = 1;
		for(PAT p : listPats){
			System.out.println(cont + " - table_id - " +p.getTable_id()+ " section_syntax_indicator - " +p.getSection_syntax_indicator()
					+" section_lenght - "+p.getSection_length()+ " transport_stream_id - "+p.getTransport_stream_id()+ " current_next_indicator - "+p.getCurrent_next_indicator() );
			cont++;
		}
	}

	// converte o número inteiro em binário de 8 bits
	private static String convert(int i) {
		int num = i;
		StringBuilder buf1 = new StringBuilder();
		StringBuilder buf2 = new StringBuilder();
		while (num != 0) {
			int digit = num % 2;
			buf1.append(digit);
			num = num / 2;
		}
		String binary = buf1.reverse().toString();// reverse to get binary 1010
		int length = binary.length();
		if (length < 8) {
			while (8 - length > 0) {
				buf2.append("0");
				length++;
			}
		}
		String bin = buf2.toString() + binary;
		return bin;
	}
	
	private static String binaryToDecimal(String s){
        int degree = 1;
        int n = 0;
        for (int k=s.length()-1; k>=0; k--){
            n += degree * (s.charAt(k) - '0');
            degree *= 2;
        }
        return n + "";
    }
	
	public static List<PAT> getPATList() throws FileNotFoundException, IOException{
		extractPatPmt();
		return listPats;
	}
	
}
