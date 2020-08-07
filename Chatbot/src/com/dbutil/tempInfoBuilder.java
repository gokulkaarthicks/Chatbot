package com.dbutil;

public class tempInfoBuilder {
	private String Name;
	private String AccountNumber;
	private String Reason;
	private String RepaymentDate;
	private String CurrentState;
	private String Confirmation;
	private long LoanNumber;
	private long MobileNumber;
	private String email;

	public tempInfoBuilder setName(String name) {
		Name = name;
		return this;
	}
	public tempInfoBuilder setAccountNumber(String accountNumber) {
		AccountNumber = accountNumber;
		return this;
	}
	
	public tempInfoBuilder setReason(String reason) {
		Reason = reason;
		return this;
	}
	public tempInfoBuilder setRepaymentDate(String repaymentDate) {
		RepaymentDate = repaymentDate;
		return this;
	}
	public tempInfoBuilder setCurrentState(String currentState) {
		CurrentState = currentState;
		return this;
	}
	public tempInfoBuilder getConfirmation(String con) {
		Confirmation = con;
		return this;
	}
	public tempInfoBuilder setLoanNumber(long loanNumber) {
		LoanNumber = loanNumber;
		return this;
	}
	public tempInfoBuilder setMobileNumber(long mobileNumber) {
		MobileNumber = mobileNumber;
		return this;
	}
	public tempInfoBuilder setEmail(String email) {
		this.email = email;
		return this;
	}

	public tempInfo getObj(){
		return (new tempInfo(Name,AccountNumber,Reason,RepaymentDate,CurrentState,LoanNumber,MobileNumber,email,Confirmation));
	}

}
