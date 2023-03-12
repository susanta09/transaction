package com.account.Service;

import java.util.List;

import com.account.Dto.TransactionDto;
import com.account.model.Account;
import com.account.model.PaymentDetails;
import com.account.model.TransactionDetails;

public interface AccountServiceInfo {
	public int depositAccount(TransactionDto dto);
	public int withdrawAccount(TransactionDto dto);
	//public void transactionData(TransactionDto dto);
	public int firstData(int rid);
	public List<TransactionDetails> tranHisDet(int rid,int currentP,int item);
	 public int transactionPay(TransactionDto tdo);
	 public int firstPaymentData(int rid);
	 public List<PaymentDetails> paymenDetails(int rid,int currentP,int item);
//==============search account number====
	 public Account searchAccount(long accountNo);
	 public Account updateAccount(Account account);
}
