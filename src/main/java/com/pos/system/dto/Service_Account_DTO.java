package com.pos.system.dto;

import org.apache.ibatis.type.Alias;

public class Service_Account_DTO {
	
	private String service_id;
	private String service_email;
	private String service_pw;
	private String service_type;
	private String service_delflag;
	
	public String getService_id() {
		return service_id;
	}
	
	public void setService_id(String service_id) {
		this.service_id = service_id;
	}
	
	public String getService_email() {
		return service_email;
	}
	
	public void setService_email(String service_email) {
		this.service_email = service_email;
	}
	
	public String getService_pw() {
		return service_pw;
	}
	
	public void setService_pw(String service_pw) {
		this.service_pw = service_pw;
	}
	
	public String getService_type() {
		return service_type;
	}
	
	public void setService_type(String service_type) {
		this.service_type = service_type;
	}
	
	public String getService_delflag() {
		return service_delflag;
	}
	
	public void setService_delflag(String service_delflag) {
		this.service_delflag = service_delflag;
	}
	
	public Service_Account_DTO() {
	}
	
	public Service_Account_DTO(String service_id, String service_email, String service_pw, String service_type, String service_delflag) {
		this.service_id = service_id;
		this.service_email = service_email;
		this.service_pw = service_pw;
		this.service_type = service_type;
		this.service_delflag = service_delflag;
	}
	
	@Override
	public String toString() {
		return "Service_Account_DTO{" +
			"service_id='" + service_id + '\'' +
			", service_email='" + service_email + '\'' +
			", service_pw='" + service_pw + '\'' +
			", service_type='" + service_type + '\'' +
			", service_delflag='" + service_delflag + '\'' +
			'}';
	}
}
