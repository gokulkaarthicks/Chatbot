package com.dbutil;

public class TempInfoBuilder {
	private String Name;
	private String AccountNumber;
	private String Reason;
	private String RepaymentDate;
	private String CurrentState;
	private String Confirmation;
	private long LoanNumber;
	private long MobileNumber;
	private String email;

	public TempInfoBuilder setName(String name) {
		Name = name;
		return this;
	}
	public TempInfoBuilder setAccountNumber(String accountNumber) {
		AccountNumber = accountNumber;
		return this;
	}
	
	public TempInfoBuilder setReason(String reason) {
		Reason = reason;
		return this;
	}
	public TempInfoBuilder setRepaymentDate(String repaymentDate) {
		RepaymentDate = repaymentDate;
		return this;
	}
	public TempInfoBuilder setCurrentState(String currentState) {
		CurrentState = currentState;
		return this;
	}
	public TempInfoBuilder getConfirmation(String con) {
		Confirmation = con;
		return this;
	}
	public TempInfoBuilder setLoanNumber(long loanNumber) {
		LoanNumber = loanNumber;
		return this;
	}
	public TempInfoBuilder setMobileNumber(long mobileNumber) {
		MobileNumber = mobileNumber;
		return this;
	}
	public TempInfoBuilder setEmail(String email) {
		this.email = email;
		return this;
	}

	public TempInfo getObj(){
		return (new TempInfo(Name,AccountNumber,Reason,RepaymentDate,CurrentState,LoanNumber,MobileNumber,email,Confirmation));
	}

}
