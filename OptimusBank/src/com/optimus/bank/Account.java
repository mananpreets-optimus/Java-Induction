package com.optimus.bank;

public class Account {
	private int customerID;
	private String accountNo;
	private TypeOfAccount typeOfAccount;
	private double balance;
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public enum TypeOfAccount {
		SAVING("Saving"),CURRENT("Current");
		
		private String typeOfAccount;
		public String getTypeOfAccount() {
			return typeOfAccount;
		}
		public void setTypeOfAccount(String typeOfAccount) {
			this.typeOfAccount = typeOfAccount;
		}
		private TypeOfAccount(String typeOfAccount) {
			this.typeOfAccount=typeOfAccount;
		}
	}
}
