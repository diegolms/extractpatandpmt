package br.com.lavid.model;

public class TS {

	private int sync_byte;
	private String transport_error_indicator;
	private String payload_unit_start_indicator;
	private String transport_priority;
	private int PID;
	private String transport_scrambling_control;
	private String adaptation_field_control;
	private String continuity_counter;
	
	
	public int getSync_byte() {
		return sync_byte;
	}
	public void setSync_byte(int sync_byte) {
		this.sync_byte = sync_byte;
	}
	public String getTransport_error_indicator() {
		return transport_error_indicator;
	}
	public void setTransport_error_indicator(String transport_error_indicator) {
		this.transport_error_indicator = transport_error_indicator;
	}
	public String getPayload_unit_start_indicator() {
		return payload_unit_start_indicator;
	}
	public void setPayload_unit_start_indicator(String payload_unit_start_indicator) {
		this.payload_unit_start_indicator = payload_unit_start_indicator;
	}
	public String getTransport_priority() {
		return transport_priority;
	}
	public void setTransport_priority(String transport_priority) {
		this.transport_priority = transport_priority;
	}
	public int getPID() {
		return PID;
	}
	public void setPID(int pID) {
		PID = pID;
	}
	public String getTransport_scrambling_control() {
		return transport_scrambling_control;
	}
	public void setTransport_scrambling_control(String transport_scrambling_control) {
		this.transport_scrambling_control = transport_scrambling_control;
	}
	public String getAdaptation_field_control() {
		return adaptation_field_control;
	}
	public void setAdaptation_field_control(String adaptation_field_control) {
		this.adaptation_field_control = adaptation_field_control;
	}
	public String getContinuity_counter() {
		return continuity_counter;
	}
	public void setContinuity_counter(String continuity_counter) {
		this.continuity_counter = continuity_counter;
	}
	
	
}
