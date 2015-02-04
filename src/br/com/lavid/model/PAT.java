package br.com.lavid.model;

public class PAT {
	
	private int table_id;
	private String section_syntax_indicator;
	private int zero = 0;
	private String firstReserved;
	private int section_length;
	private String transport_stream_id;
	private String secondReserved;
	private int version_number;
	private int current_next_indicator;
	private String section_number;
	private int last_section_number;
	
	public int getTable_id() {
		return table_id;
	}
	public void setTable_id(int table_id) {
		this.table_id = table_id;
	}
	public String getSection_syntax_indicator() {
		return section_syntax_indicator;
	}
	public void setSection_syntax_indicator(String section_syntax_indicator) {
		this.section_syntax_indicator = section_syntax_indicator;
	}
	public String getFirstReserved() {
		return firstReserved;
	}
	public void setFirstReserved(String firstReserved) {
		this.firstReserved = firstReserved;
	}
	public int getSection_length() {
		return section_length;
	}
	public void setSection_length(int section_length) {
		this.section_length = section_length;
	}
	public String getSecondReserved() {
		return secondReserved;
	}
	public void setSecondReserved(String secondReserved) {
		this.secondReserved = secondReserved;
	}
	public int getVersion_number() {
		return version_number;
	}
	public void setVersion_number(int version_number) {
		this.version_number = version_number;
	}
	public int getCurrent_next_indicator() {
		return current_next_indicator;
	}
	public void setCurrent_next_indicator(int current_next_indicator) {
		this.current_next_indicator = current_next_indicator;
	}
	public String getSection_number() {
		return section_number;
	}
	public void setSection_number(String section_number) {
		this.section_number = section_number;
	}
	public int getLast_section_number() {
		return last_section_number;
	}
	public void setLast_section_number(int last_section_number) {
		this.last_section_number = last_section_number;
	}
	public String getTransport_stream_id() {
		return transport_stream_id;
	}
	public void setTransport_stream_id(String transport_stream_id) {
		this.transport_stream_id = transport_stream_id;
	}

}
