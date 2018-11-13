package com.pos.system.dto;

import java.util.Date;

public class Store_Invoice_DTO {
	
	private int invoice_seq;
	private int store_seq;
	private int table_seq;
	private int ref;
	private int menu_amount;
	private int tax_amount;
	private int total_amount;
	private int discount_amount;
	private int final_amount;
	private Date paid_date;
	private String payment_method;
	private String delflag;
	
	// for insert only
	private int sumorder;
	
	public Store_Invoice_DTO() {
	}
	
	public Store_Invoice_DTO(int invoice_seq, int store_seq, int table_seq, int ref, int menu_amount, int tax_amount, int total_amount, int discount_amount, int final_amount, Date paid_date, String payment_method, String delflag, int sumorder) {
		this.invoice_seq = invoice_seq;
		this.store_seq = store_seq;
		this.table_seq = table_seq;
		this.ref = ref;
		this.menu_amount = menu_amount;
		this.tax_amount = tax_amount;
		this.total_amount = total_amount;
		this.discount_amount = discount_amount;
		this.final_amount = final_amount;
		this.paid_date = paid_date;
		this.payment_method = payment_method;
		this.delflag = delflag;
		this.sumorder = sumorder;
	}
	
	@Override
	public String toString() {
		return "Store_Invoice_DTO{" +
			"invoice_seq=" + invoice_seq +
			", store_seq=" + store_seq +
			", table_seq=" + table_seq +
			", ref=" + ref +
			", menu_amount=" + menu_amount +
			", tax_amount=" + tax_amount +
			", total_amount=" + total_amount +
			", discount_amount=" + discount_amount +
			", final_amount=" + final_amount +
			", paid_date=" + paid_date +
			", payment_method='" + payment_method + '\'' +
			", delflag='" + delflag + '\'' +
			", sumorder=" + sumorder +
			'}';
	}
	
	public int getInvoice_seq() {
		return invoice_seq;
	}
	
	public void setInvoice_seq(int invoice_seq) {
		this.invoice_seq = invoice_seq;
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
	
	public int getRef() {
		return ref;
	}
	
	public void setRef(int ref) {
		this.ref = ref;
	}
	
	public int getMenu_amount() {
		return menu_amount;
	}
	
	public void setMenu_amount(int menu_amount) {
		this.menu_amount = menu_amount;
	}
	
	public int getTax_amount() {
		return tax_amount;
	}
	
	public void setTax_amount(int tax_amount) {
		this.tax_amount = tax_amount;
	}
	
	public int getTotal_amount() {
		return total_amount;
	}
	
	public void setTotal_amount(int total_amount) {
		this.total_amount = total_amount;
	}
	
	public int getDiscount_amount() {
		return discount_amount;
	}
	
	public void setDiscount_amount(int discount_amount) {
		this.discount_amount = discount_amount;
	}
	
	public int getFinal_amount() {
		return final_amount;
	}
	
	public void setFinal_amount(int final_amount) {
		this.final_amount = final_amount;
	}
	
	public Date getPaid_date() {
		return paid_date;
	}
	
	public void setPaid_date(Date paid_date) {
		this.paid_date = paid_date;
	}
	
	public String getPayment_method() {
		return payment_method;
	}
	
	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}
	
	public String getDelflag() {
		return delflag;
	}
	
	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}
	
	public int getSumorder() {
		return sumorder;
	}
	
	public void setSumorder(int sumorder) {
		this.sumorder = sumorder;
	}
}
