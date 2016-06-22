package com.vdinnosoft.rtet.datacomponent.service;
import java.sql.Date;
import com.vdinnosoft.rtet.datacomponent.entity.PaymentReason;

public class PaymentServiceImpl implements TransactionService, PaymentOption {
	PaymentReason paymentreason;	
	PaymentOption paymentoption;
	Double amount=0.0;
	Date timestamp;
}
