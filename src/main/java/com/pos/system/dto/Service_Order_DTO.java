package com.pos.system.dto;

public class Service_Order_DTO {
	
	private int order_seq;
	private int store_seq;
	private int table_seq;
	private int menu_seq;
	private String make;
	private String order_date;
	private int menu_price;
	private int ref;
	private String delflag;
	
	public Service_Order_DTO() {
	}
	
	public Service_Order_DTO(int order_seq, int store_seq, int table_seq, int menu_seq, String make, String order_date, int menu_price, int ref, String delflag) {
		this.order_seq = order_seq;
		this.store_seq = store_seq;
		this.table_seq = table_seq;
		this.menu_seq = menu_seq;
		this.make = make;
		this.order_date = order_date;
		this.menu_price = menu_price;
		this.ref = ref;
		this.delflag = delflag;
	}
	
	public int getOrder_seq() {
		return order_seq;
	}
	
	public void setOrder_seq(int order_seq) {
		this.order_seq = order_seq;
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
	
	public int getMenu_seq() {
		return menu_seq;
	}
	
	public void setMenu_seq(int menu_seq) {
		this.menu_seq = menu_seq;
	}
	
	public String getMake() {
		return make;
	}
	
	public void setMake(String make) {
		this.make = make;
	}
	
	public String getOrder_date() {
		return order_date;
	}
	
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	
	public int getMenu_price() {
		return menu_price;
	}
	
	public void setMenu_price(int menu_price) {
		this.menu_price = menu_price;
	}
	
	public int getRef() {
		return ref;
	}
	
	public void setRef(int ref) {
		this.ref = ref;
	}
	
	public String getDelflag() {
		return delflag;
	}
	
	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}
	
	@Override
	public String toString() {
		return "Service_Order_DTO{" +
			"order_seq=" + order_seq +
			", store_seq=" + store_seq +
			", table_seq=" + table_seq +
			", menu_seq=" + menu_seq +
			", make='" + make + '\'' +
			", order_date='" + order_date + '\'' +
			", menu_price=" + menu_price +
			", ref=" + ref +
			", delflag='" + delflag + '\'' +
			'}';
	}
}
