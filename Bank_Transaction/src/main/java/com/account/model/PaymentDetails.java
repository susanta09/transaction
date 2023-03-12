package com.account.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "paymentDetails")
public class PaymentDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int paymentId;
	private long accountNoFrom;
	private long accountNoTo;
	private int tAmount;
	private int rid;
	private LocalDateTime date;

	private String paymentType;
	private String states;
	private String sources;

	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
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
	
	public int gettAmount() {
		return tAmount;
	}
	public void settAmount(int tAmount) {
		this.tAmount = tAmount;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
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
	

}
