package com.account.acontrolle;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.account.Dto.TransactionDto;
import com.account.Service.AccountServiceImpl;
import com.account.model.Account;
import com.account.model.PaymentDetails;
import com.account.model.TransactionDetails;

@Controller
public class AController {
	AccountServiceImpl ser=new AccountServiceImpl();
	@RequestMapping("/depo")
	public ModelAndView showDepo()
	{
		TransactionDto tdto=new TransactionDto();
		ModelAndView m=new ModelAndView();
		m.addObject("tr", tdto);
		m.setViewName("deposit");
		return m;
	}
	@RequestMapping("/with")
	public ModelAndView showWithdraw()
	{
		TransactionDto tdto=new TransactionDto();
		ModelAndView m=new ModelAndView();
		m.addObject("tr", tdto);
		m.setViewName("withdraw");
		return m;
	}
//	@RequestMapping("/dep")
//	public void getData(@ModelAttribute("tr") TransactionDto tdto,Model model)
//	{
//		tdto.setRid(4321);
//		System.out.println(tdto);
//		ser.transactionData(tdto);
//	}
	
	@RequestMapping("/dep")
	public ModelAndView addAmount(@ModelAttribute("tr") TransactionDto tdto,Model model)
	{
		tdto.setRid(4321);
		tdto.setDate(LocalDateTime.now());
		int k=ser.depositAccount(tdto);
		System.out.println("Controll-->"+k);
		ModelAndView m=new ModelAndView();
		if(k==1){
			m.addObject("result", "Deposit Transaction is Successfull");
			m.setViewName("success");
			return m;
		}
		else
		{
			m.addObject("result", "Deposit Transaction is Fail");
			m.setViewName("success");
			return m;
		}
	}
	@RequestMapping("/sub")
	public ModelAndView substrucAmount(@ModelAttribute("tr") TransactionDto tdto,Model model)
	{
		tdto.setRid(4321);
		tdto.setDate(LocalDateTime.now());
		int k=ser.withdrawAccount(tdto);
		System.out.println("Controll-->"+k);
		ModelAndView m=new ModelAndView();
		if(k==1){
			m.addObject("result", "Withdraw Transaction is Successfull");
			m.setViewName("success");
			return m;
		}
		else
		{
			m.addObject("result", "Withdraw Transaction is Fail");
			m.setViewName("success");
			return m;
		}
	}
	@RequestMapping("/row")
    public int totalRow(int rid)
    {
    	int n=ser.firstData(rid);
    	System.out.println("row="+n);
    	return n;
    	
    }
	@GetMapping("/emp/{pageno}")
	public ModelAndView pagination(@PathVariable("pageno") int pageNo)
	{
		int tRow=totalRow(rid);
		int item=4;
		int nop=0;
		if(tRow/item==0)
		{
			nop=tRow/item;
		}
		else
		{
			nop=(tRow/item)+1;
		}
		int currentP=pageNo-1;
		int rid=1234;
		List<TransactionDetails> trdh;
		trdh=ser.tranHisDet(rid,currentP,item);
		ModelAndView m=new ModelAndView();
		m.addObject("noP",nop );
		m.addObject("trdh", trdh);
		m.addObject("currentP", currentP);
		m.setViewName("transactionHistroy");
		return m;
	}
	@RequestMapping("/trans")
	public ModelAndView showTran()
	{
		TransactionDto tdto=new TransactionDto();
		ModelAndView m=new ModelAndView();
		m.addObject("tr", tdto);
		m.setViewName("transactionAmount");
		return m;
	}
	@RequestMapping("/tran")
	public ModelAndView transAmount(@ModelAttribute("tr") TransactionDto tdto,Model model)
	{
		tdto.setRid(4321);
		tdto.setDate(LocalDateTime.now());
		int n=ser.transactionPay(tdto);
//		System.out.println("Controll-->"+k);
		ModelAndView m=new ModelAndView();
		if(n==1){
			m.addObject("result", "Payment Process is Successfull");
			m.setViewName("success");
			return m;
		}
		else
		{
			m.addObject("result", "Payment Process is Fail");
			m.setViewName("success");
			return m;
		}
				
	}
	@RequestMapping("/payrow")
    public int totalPaymentRow(int rid)
    {
    	int n=ser.firstPaymentData(rid);
    	return n;	
    }
	@GetMapping("/pay/{pageno}")
	public ModelAndView paginationPayment(@PathVariable("pageno") int pageNo)
	{
		int rid=0;
		int tRow=totalPaymentRow(rid);
		int item=4;
		int nop=0;
		if(tRow/item==0)
		{
			nop=tRow/item;
		}
		else
		{
			nop=(tRow/item)+1;
		}
		int currentP=pageNo-1;
		
		List<PaymentDetails> trdh;
		trdh=ser.paymenDetails(rid,currentP, item);
		ModelAndView m=new ModelAndView();
		m.addObject("noP",nop );
		m.addObject("trdh", trdh);
		m.addObject("currentP", currentP);
		m.setViewName("payment_details");
		return m;
	}
//================admine section===========	
	@RequestMapping(value ="acc/")
	public ModelAndView getAccount(@RequestParam("acno") long accountNo)
	{
		System.out.println(accountNo);
		Account ac=ser.searchAccount(accountNo);
		System.out.println(ac);
		ModelAndView m=new ModelAndView();
		
		m.addObject("acc", ac);
		m.setViewName("accountDetails");
		return m; 
	}
	@RequestMapping("/admin")
	public String admin()
	{
		return "accountDetails";
	}
	@RequestMapping(value ="acBlockUnblock/{b}/{acNo}")
	public ModelAndView acBlockUnblock(@PathVariable("b") String access,@PathVariable("acNo") long accountNo)
	{
		System.out.println("access--"+access);
   		System.out.println("accountNo--"+accountNo);
		Account ac=ser.searchAccount(accountNo);
		System.out.println("before-->"+ac);
		ac.setAccess(access);
		System.out.println(ac);
		Account acc=ser.updateAccount(ac);
		System.out.println(acc);
		ModelAndView m=new ModelAndView();
		m.addObject("acc", acc);
		m.setViewName("accountDetails");
		return m;
	}
	
	int rid=0;
	@RequestMapping(value ="payment/")
	public ModelAndView getPay(@RequestParam("rid") int rid)
	{
		System.out.println(rid);
		int ridp=rid;
		rid=ridp;
//		System.out.println(accountNo);
//		Account ac=ser.searchAccount(accountNo);
//		System.out.println(ac);
//		ModelAndView m=new ModelAndView();
////		
////		m.addObject("acc", ac);
//		m.setViewName("searchPay");
//		paymentDetailsByRid(1,rid);
		return paymentDetailsByRid(1,rid); 
	}
	@RequestMapping("/pay")
	public String pay()
	{
		return "searchPay";
	}
	@GetMapping("/payD/{pageno}/{rid}")
	public ModelAndView paymentDetailsByRid(@PathVariable("pageno") int pageNo,@PathVariable("rid")int rid)
	{
		int tRow=totalPaymentRow(rid);
		int item=4;
		int nop=0;
		if(tRow/item==0)
		{
			nop=tRow/item;
		}
		else
		{
			nop=(tRow/item)+1;
		}
		int currentP=pageNo-1;
		List<PaymentDetails> trdh;
		trdh=ser.paymenDetails(rid,currentP, item);
		ModelAndView m=new ModelAndView();
		m.addObject("noP",nop );
		m.addObject("trdh", trdh);
		m.addObject("currentP", currentP);
		m.addObject("rid",rid);
		m.setViewName("searchPay");
		return m;
	}
	
	@RequestMapping(value ="searchtran/")
	public ModelAndView getTran(@RequestParam("rid") int rid)
	{
		System.out.println(rid);
		int ridp=rid;
		rid=ridp;
		return searchTransaction(1,rid); 
	}
	@RequestMapping("/searchT")
	public String tran()
	{
		return "searchTransaction";
	}
	
	@GetMapping("/tran/{pageno}/{rid}")
	public ModelAndView searchTransaction(@PathVariable("pageno") int pageNo,@PathVariable("rid") int rid)
	{
		int tRow=totalRow(rid);
		int item=4;
		int nop=0;
		if(tRow/item==0)
		{
			nop=tRow/item;
		}
		else
		{
			nop=(tRow/item)+1;
		}
		int currentP=pageNo-1;
		List<TransactionDetails> trdh;
		trdh=ser.tranHisDet(rid,currentP,item);
		ModelAndView m=new ModelAndView();
		m.addObject("noP",nop );
		m.addObject("trdh", trdh);
		m.addObject("rid",rid);
		m.addObject("currentP", currentP);
		m.setViewName("searchTransaction");
		return m;
	}
}
