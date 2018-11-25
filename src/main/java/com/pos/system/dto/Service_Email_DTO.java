package com.pos.system.dto;

public class Service_Email_DTO {

    public Service_Email_DTO() {
    }

    @Override
    public String toString() {
        return "Service_Email_DTO{" +
                "service_email='" + service_email + '\'' +
                ", auth_key='" + auth_key + '\'' +
                ", authstatus='" + authstatus + '\'' +
                '}';
    }

    public Service_Email_DTO(String service_email, String auth_key, String authstatus) {
        this.service_email = service_email;
        this.auth_key = auth_key;
        this.authstatus = authstatus;
    }

    public String getService_email() {
        return service_email;
    }

    public void setService_email(String service_email) {
        this.service_email = service_email;
    }

    public String getAuth_key() {
        return auth_key;
    }

    public void setAuth_key(String auth_key) {
        this.auth_key = auth_key;
    }

    public String getAuthstatus() {
        return authstatus;
    }

    public void setAuthstatus(String authstatus) {
        this.authstatus = authstatus;
    }

    private String service_email;
    private String auth_key;
    private String authstatus;


}
