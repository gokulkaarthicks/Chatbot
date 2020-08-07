package com.dbutil;

public class tempInfo {
	private String Name;
	private String AccountNumber;
	private String Reason;
	private String RepaymentDate;
	private String CurrentState;
	private long LoanNumber;
	private long MobileNumber;
	private String email;
	private String Confirmation;
	
	public long getLoanNumber() {
		return LoanNumber;
	}

	public long getMobileNumber() {
		return MobileNumber;
	}

	public String getEmail() {
		return email;
	}	
	public String getName() {
		return Name;
	}

	public String getAccountNumber() {
		return AccountNumber;
	}

	public String getReason() {
		return Reason;
	}

	public String getRepaymentDate() {
		return RepaymentDate;
	}

	public String getCurrentState() {
		return CurrentState;
	}

	public String getConfirmation() {
		return Confirmation;
	}

	public tempInfo(String name, String accountNumber, String reason, String repaymentDate, String currentState,
			long loanNumber, long mobileNumber, String email, String confirmation) {
		super();
		Name = name;
		AccountNumber = accountNumber;
		Reason = reason;
		RepaymentDate = repaymentDate;
		CurrentState = currentState;
		LoanNumber = loanNumber;
		MobileNumber = mobileNumber;
		this.email = email;
		Confirmation = confirmation;
	}



}
