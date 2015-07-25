package com.optimus.bank;

import java.sql.Date;

public class BankTransactions {
	private String transactionID;
	private String customerID;
	private String accountNo;
	private double amount;
	private char typeOfTransation;
	private Date dateOfTransaction;
	public String getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}
	
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public char getTypeOfTransation() {
		return typeOfTransation;
	}
	public void setTypeOfTransation(char typeOfTransation) {
		this.typeOfTransation = typeOfTransation;
	}
	public Date getDateOfTransaction() {
		return dateOfTransaction;
	}
	public void setDateOfTransaction(Date dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}
}
