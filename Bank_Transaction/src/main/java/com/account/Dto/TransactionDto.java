package com.account.Dto;

import java.time.LocalDateTime;

public class TransactionDto {
	private int rid;
	private int transactionId;
	
	private long accountNoFrom;
	private long accountNoTo;
	private String accountType;
	private int tAmount;
	private LocalDateTime date;

	private String paymentType;
	private String states;
	private String sources;
//	private String accessible;
//	
//	public String getAccessible() {
//		return accessible;
//	}
//	public void setAccessible(String accessible) {
//		this.accessible = accessible;
//	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public long getAccountNoFrom() {
		return accountNoFrom;
	}
	public void setAccountNoFrom(long accountNoFrom) {
		this.accountNoFrom = accountNoFrom;
	}
	public long getAccountNoTo() {
		return accountNoTo;
	}
	public void setAccountNoTo(long accountNoTo) {
		this.accountNoTo = accountNoTo;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public int gettAmount() {
		return tAmount;
	}
	public void settAmount(int tAmount) {
		this.tAmount = tAmount;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getStates() {
		return states;
	}
	public void setStates(String states) {
		this.states = states;
	}
	public String getSources() {
		return sources;
	}
	public void setSources(String sources) {
		this.sources = sources;
	}
	@Override
	public String toString() {
		return "TransactionDto [rid=" + rid + ", transactionId=" + transactionId + ", accountNoFrom=" + accountNoFrom
				+ ", accountNoTo=" + accountNoTo + ", accountType=" + accountType + ", tAmount=" + tAmount
				+ ", paymentType=" + paymentType + ", states=" + states + ", sources=" + sources + "]";
	}
	
	

}
