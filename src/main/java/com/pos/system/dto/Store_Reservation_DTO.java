package com.pos.system.dto;

public class Store_Reservation_DTO {



    private int reserv_seq;
    private int store_seq;
    private int table_seq;
    private String user_id;
    private String reserv_time;
    private int reserv_people;
    private String delflag;

    public Store_Reservation_DTO() {
    }

    public Store_Reservation_DTO(int reserv_seq, int store_seq, int table_seq, String user_id, String reserv_time, int reserv_people, String delflag) {
        this.reserv_seq = reserv_seq;
        this.store_seq = store_seq;
        this.table_seq = table_seq;
        this.user_id = user_id;
        this.reserv_time = reserv_time;
        this.reserv_people = reserv_people;
        this.delflag = delflag;
    }

    @Override
    public String toString() {
        return "Store_Reservation_DTO{" +
                "reserv_seq=" + reserv_seq +
                ", store_seq=" + store_seq +
                ", table_seq=" + table_seq +
                ", user_id='" + user_id + '\'' +
                ", reserv_time='" + reserv_time + '\'' +
                ", reserv_people=" + reserv_people +
                ", delflag='" + delflag + '\'' +
                '}';
    }


    public int getReserv_seq() {
        return reserv_seq;
    }

    public void setReserv_seq(int reserv_seq) {
        this.reserv_seq = reserv_seq;
    }

    public int getStore_seq() {
        return store_seq;
    }

    public void setStore_seq(int store_seq) {
        this.store_seq = store_seq;
    }

    public int getTable_seq() {
        return table_seq;
    }

    public void setTable_seq(int table_seq) {
        this.table_seq = table_seq;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getReserv_time() {
        return reserv_time;
    }

    public void setReserv_time(String reserv_time) {
        this.reserv_time = reserv_time;
    }

    public int getReserv_people() {
        return reserv_people;
    }

    public void setReserv_people(int reserv_people) {
        this.reserv_people = reserv_people;
    }

    public String getDelflag() {
        return delflag;
    }

    public void setDelflag(String delflag) {
        this.delflag = delflag;
    }
}
