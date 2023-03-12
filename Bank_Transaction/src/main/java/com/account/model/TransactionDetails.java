package com.account.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class TransactionDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int transactionId;
	private int rid;
	private int tAmount;
	private String paymentType;
	private String states;
	private String sources;
	private LocalDateTime date;

	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
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
	
	public TransactionDetails() {
		super();
	}
	public TransactionDetails(int transactionId, int rid, int tAmount, String paymentType, String states,
			String sources) {
		super();
		this.transactionId = transactionId;
		this.rid = rid;
		this.tAmount = tAmount;
		this.paymentType = paymentType;
		this.states = states;
		this.sources = sources;
	}
	@Override
	public String toString() {
		return "TransactionDetails [transactionId=" + transactionId + ", rid=" + rid + ", tAmount=" + tAmount
				+ ", paymentType=" + paymentType + ", states=" + states + ", sources=" + sources + "]";
	}
	
	
	

}
