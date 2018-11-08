package com.pos.system.dto;

public class Store_Table_DTO {


    @Override
    public String toString() {
        return "Store_Table_DTO{" +
                "table_seq=" + table_seq +
                ", store_seq=" + store_seq +
                ", table_name='" + table_name + '\'' +
                ", reservation='" + reservation + '\'' +
                ", min_people=" + min_people +
                ", max_people=" + max_people +
                ", delflag='" + delflag + '\'' +
                '}';
    }

    private int table_seq;
    private int store_seq ;
    private String table_name ;
    private String reservation;
    private int min_people ;
    private int max_people ;
    private String delflag ;

    public Store_Table_DTO() {
    }



    public Store_Table_DTO(int table_seq, int store_seq, String table_name, String reservation, int min_people, int max_people, String delflag) {
        this.table_seq = table_seq;
        this.store_seq = store_seq;
        this.table_name = table_name;
        this.reservation = reservation;
        this.min_people = min_people;
        this.max_people = max_people;
        this.delflag = delflag;
    }
    public int getStore_seq() {
        return store_seq;
    }

    public String getTable_name() {
        return table_name;
    }

    public int getTable_seq() {
        return table_seq;
    }

    public String getReservation() {
        return reservation;
    }

    public int getMin_people() {
        return min_people;
    }

    public int getMax_people() {
        return max_people;
    }

    public String getDelflag() {
        return delflag;
    }

    public void setTable_seq(int table_seq) {
        this.table_seq = table_seq;
    }

    public void setStore_seq(int store_seq) {
        this.store_seq = store_seq;
    }

    public void setTable_name(String table_name) {
        this.table_name = table_name;
    }

    public void setReservation(String reservation) {
        this.reservation = reservation;
    }

    public void setMin_people(int min_people) {
        this.min_people = min_people;
    }

    public void setMax_people(int max_people) {
        this.max_people = max_people;
    }

    public void setDelflag(String delflag) {
        this.delflag = delflag;
    }






}
