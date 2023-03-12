package com.account.Dao;

import java.util.List;

import com.account.Dto.TransactionDto;
import com.account.model.Account;
import com.account.model.PaymentDetails;
import com.account.model.TransactionDetails;

public interface AccountDaoInfo {
	public int creditAccount(TransactionDto dto);
	public int debitAccount(TransactionDto dto);
	public void transferAccount(TransactionDto dto);
	public int first(int rid);
	public List<TransactionDetails> getTDetails(int rid,int currentP,int item);
	
	public int payAccount(TransactionDto dto);
	 public void insertPaymentDetails(TransactionDto tdo);
	 public int firstPayment(int rid);
	 public List<PaymentDetails> getPayDetails(int rid,int currentP,int item);
//	 ===See Account details=================
	 public Account getAccDetails(long accountNo);
	 public Account updateAcc(Account account);

}
