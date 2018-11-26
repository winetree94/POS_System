package com.pos.system.dto;

public class Pos_Auth_DTO {

	private String service_id;
	private String store_seq;
	
	public Pos_Auth_DTO(String service_id, String store_seq) {
		this.service_id = service_id;
		this.store_seq = store_seq;
	}
	
	public String getService_id() {
		return service_id;
	}
	
	public void setService_id(String service_id) {
		this.service_id = service_id;
	}
	
	public String getStore_seq() {
		return store_seq;
	}
	
	public void setStore_seq(String store_seq) {
		this.store_seq = store_seq;
	}
	
	@Override
	public String toString() {
		return "Pos_Auth_DTO{" +
			"service_id='" + service_id + '\'' +
			", store_seq='" + store_seq + '\'' +
			'}';
	}
}
