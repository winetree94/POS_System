package com.pos.system.dto;

public class Store_Cashbook_DTO {

	private int cash_seq;
	private int store_seq;
	private String cash_date;
	private int cash_deposit;
	private int cash_withdraw;
	private int cash_balance;
	
	public Store_Cashbook_DTO() {
	}
	
	public Store_Cashbook_DTO(int cash_seq, int store_seq, String cash_date, int cash_deposit, int cash_withdraw, int cash_balance) {
		this.cash_seq = cash_seq;
		this.store_seq = store_seq;
		this.cash_date = cash_date;
		this.cash_deposit = cash_deposit;
		this.cash_withdraw = cash_withdraw;
		this.cash_balance = cash_balance;
	}
	
	@Override
	public String toString() {
		return "Store_Cashbook_DTO{" +
			"cash_seq=" + cash_seq +
			", store_seq=" + store_seq +
			", cash_date='" + cash_date + '\'' +
			", cash_deposit=" + cash_deposit +
			", cash_withdraw=" + cash_withdraw +
			", cash_balance=" + cash_balance +
			'}';
	}
	
	public int getCash_seq() {
		return cash_seq;
	}
	
	public void setCash_seq(int cash_seq) {
		this.cash_seq = cash_seq;
	}
	
	public int getStore_seq() {
		return store_seq;
	}
	
	public void setStore_seq(int store_seq) {
		this.store_seq = store_seq;
	}
	
	public String getCash_date() {
		return cash_date;
	}
	
	public void setCash_date(String cash_date) {
		this.cash_date = cash_date;
	}
	
	public int getCash_deposit() {
		return cash_deposit;
	}
	
	public void setCash_deposit(int cash_deposit) {
		this.cash_deposit = cash_deposit;
	}
	
	public int getCash_withdraw() {
		return cash_withdraw;
	}
	
	public void setCash_withdraw(int cash_withdraw) {
		this.cash_withdraw = cash_withdraw;
	}
	
	public int getCash_balance() {
		return cash_balance;
	}
	
	public void setCash_balance(int cash_balance) {
		this.cash_balance = cash_balance;
	}
}
