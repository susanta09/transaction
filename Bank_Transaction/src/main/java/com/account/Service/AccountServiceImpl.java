package com.account.Service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.account.Dao.AccountDaoInfo;
import com.account.Dto.TransactionDto;
import com.account.model.Account;
import com.account.model.PaymentDetails;
import com.account.model.TransactionDetails;

public class AccountServiceImpl implements AccountServiceInfo {
	ApplicationContext context =new ClassPathXmlApplicationContext("hibernate.cfg.xml");
	AccountDaoInfo bi=(AccountDaoInfo)context.getBean("acdao");
	public int depositAccount(TransactionDto dto) {
		
		return bi.creditAccount(dto);
	}
	public int withdrawAccount(TransactionDto dto) {
		
		return bi.debitAccount(dto);
	}
//	public void transactionData(TransactionDto dto) {
//		/*
//		 * Account account = new Account();
//		 * account.setAccountNo(dto.getAccountNoFrom());
//		 * account.setAccountType(dto.getAccountType()); account.setRid(dto.getRid());
//		 * account.setTotalAmount(dto.gettAmount());
//		 */
//		
////		TransactionDetails td=new TransactionDetails();
////		td.setPaymentType(dto.getPaymentType());
////		td.setRid(dto.getRid());
////		td.setSources(dto.getSources());
////		td.settAmount(dto.gettAmount());
////		TransactionDetails t=new TransactionDetails(4, 567,4567, "depo", "success", "online");
//		
//		if(dto.getPaymentType().equals("deposit"))
//		{
//			int i=bi.creditAccount(account);
//			if(i==1)
//			{
//				td.setStates("success");
//			}
//			else
//			{
//				td.setStates("fail");
//			}
//			bi.transferAccount(td);
//		}
//		else if (dto.getPaymentType().equals("deposit")) {
//			
//		}
//		
//		
//		
//		
//	}
	public int firstData(int rid) {
		return bi.first(rid);
		
	}
	public List<TransactionDetails> tranHisDet(int rid,int currentP,int item) {
		return bi.getTDetails(rid,currentP,item);
		
	}
	public int transactionPay(TransactionDto tdo) {
		return bi.payAccount(tdo);
		
	}
	public int firstPaymentData(int rid) {
		return bi.firstPayment(rid);
		
	}
	public List<PaymentDetails> paymenDetails(int rid,int currentP,int item) {
		return bi.getPayDetails(rid,currentP, item);
	}
//==============search account number============================
	public Account searchAccount(long accountNo) {
		
		return bi.getAccDetails(accountNo);
	}
	public Account updateAccount(Account account) {
		return bi.updateAcc(account);
	}

}
