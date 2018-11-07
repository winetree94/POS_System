package com.pos.system.dto;

public class Service_Store_DTO {
	
	private int store_seq;
	private String service_id;
	private String store_name;
	private String store_detail;
	private String store_type;
	private String store_address;
	private String store_tel;
	private String store_hour;
	private String delflag;
	private String regdate;
	
	public Service_Store_DTO() {
	}
	
	public Service_Store_DTO(int store_seq, String service_id, String store_name, String store_detail, String store_type, String store_address, String store_tel, String store_hour, String delflag, String regdate) {
		this.store_seq = store_seq;
		this.service_id = service_id;
		this.store_name = store_name;
		this.store_detail = store_detail;
		this.store_type = store_type;
		this.store_address = store_address;
		this.store_tel = store_tel;
		this.store_hour = store_hour;
		this.delflag = delflag;
		this.regdate = regdate;
	}
	
	@Override
	public String toString() {
		return "Service_Store_DTO{" +
			"store_seq=" + store_seq +
			", service_id='" + service_id + '\'' +
			", store_name='" + store_name + '\'' +
			", store_detail='" + store_detail + '\'' +
			", store_type='" + store_type + '\'' +
			", store_address='" + store_address + '\'' +
			", store_tel='" + store_tel + '\'' +
			", store_hour='" + store_hour + '\'' +
			", delflag='" + delflag + '\'' +
			", regdate='" + regdate + '\'' +
			'}';
	}
	
	public int getStore_seq() {
		return store_seq;
	}
	
	public void setStore_seq(int store_seq) {
		this.store_seq = store_seq;
	}
	
	public String getService_id() {
		return service_id;
	}
	
	public void setService_id(String service_id) {
		this.service_id = service_id;
	}
	
	public String getStore_name() {
		return store_name;
	}
	
	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}
	
	public String getStore_detail() {
		return store_detail;
	}
	
	public void setStore_detail(String store_detail) {
		this.store_detail = store_detail;
	}
	
	public String getStore_type() {
		return store_type;
	}
	
	public void setStore_type(String store_type) {
		this.store_type = store_type;
	}
	
	public String getStore_address() {
		return store_address;
	}
	
	public void setStore_address(String store_address) {
		this.store_address = store_address;
	}
	
	public String getStore_tel() {
		return store_tel;
	}
	
	public void setStore_tel(String store_tel) {
		this.store_tel = store_tel;
	}
	
	public String getStore_hour() {
		return store_hour;
	}
	
	public void setStore_hour(String store_hour) {
		this.store_hour = store_hour;
	}
	
	public String getDelflag() {
		return delflag;
	}
	
	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}
	
	public String getRegdate() {
		return regdate;
	}
	
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
}
