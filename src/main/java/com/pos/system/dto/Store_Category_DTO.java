package com.pos.system.dto;

public class Store_Category_DTO {

    private int menu_seq;
    private int store_seq;
    private String menu_name;
    private String categ_name;
    private String menu_info;
    private String origin_fname;
    private String stored_fname;
    private int menu_price;
    private String delflag;

    public Store_Category_DTO() {
    }

    public Store_Category_DTO(int menu_seq, int store_seq, String menu_name, String categ_name, String menu_info, String origin_fname, String stored_fname, int menu_price, String delflag) {
        this.menu_seq = menu_seq;
        this.store_seq = store_seq;
        this.menu_name = menu_name;
        this.categ_name = categ_name;
        this.menu_info = menu_info;
        this.origin_fname = origin_fname;
        this.stored_fname = stored_fname;
        this.menu_price = menu_price;
        this.delflag = delflag;
    }

    @Override
    public String toString() {
        return "Store_Category_DTO{" +
                "menu_seq=" + menu_seq +
                ", store_seq=" + store_seq +
                ", menu_name='" + menu_name + '\'' +
                ", categ_name='" + categ_name + '\'' +
                ", menu_info='" + menu_info + '\'' +
                ", origin_fname='" + origin_fname + '\'' +
                ", stored_fname='" + stored_fname + '\'' +
                ", menu_price=" + menu_price +
                ", delflag='" + delflag + '\'' +
                '}';
    }

    public int getMenu_seq() {
        return menu_seq;
    }

    public int getStore_seq() {
        return store_seq;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public String getCateg_name() {
        return categ_name;
    }

    public String getMenu_info() {
        return menu_info;
    }

    public String getOrigin_fname() {
        return origin_fname;
    }

    public String getStored_fname() {
        return stored_fname;
    }

    public int getMenu_price() {
        return menu_price;
    }

    public String getDelflag() {
        return delflag;
    }

    public void setMenu_seq(int menu_seq) {
        this.menu_seq = menu_seq;
    }

    public void setStore_seq(int store_seq) {
        this.store_seq = store_seq;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public void setCateg_name(String categ_name) {
        this.categ_name = categ_name;
    }

    public void setMenu_info(String menu_info) {
        this.menu_info = menu_info;
    }

    public void setOrigin_fname(String origin_fname) {
        this.origin_fname = origin_fname;
    }

    public void setStored_fname(String stored_fname) {
        this.stored_fname = stored_fname;
    }

    public void setMenu_price(int menu_price) {
        this.menu_price = menu_price;
    }

    public void setDelflag(String delflag) {
        this.delflag = delflag;
    }
}
