package com.fz.ExpenseTracker.dashboard;

import java.util.Map;

public class DashboardData {
	private double overallIncomeAmount;
    private double overallExpenseAmount;
    private double totalAmountInAccount;
    private Map<String, Double> accountTypeBalances;
    
	public DashboardData(double overallIncomeAmount2, double overallExpenseAmount2, double totalAmountInAccount2
			) {
		overallIncomeAmount=overallIncomeAmount2;
		overallExpenseAmount=overallExpenseAmount2;
		totalAmountInAccount=totalAmountInAccount2;
	}
	public DashboardData(double overallIncomeAmount, double overallExpenseAmount, double totalAmountInAccount, Map<String, Double> accountTypeBalances) {
        this.overallIncomeAmount = overallIncomeAmount;
        this.overallExpenseAmount = overallExpenseAmount;
        this.totalAmountInAccount = totalAmountInAccount;
        this.accountTypeBalances = accountTypeBalances;
    }
	public double getOverallIncomeAmount() {
		return overallIncomeAmount;
	}
	public void setOverallIncomeAmount(double overallIncomeAmount) {
		this.overallIncomeAmount = overallIncomeAmount;
	}
	public double getOverallExpenseAmount() {
		return overallExpenseAmount;
	}
	public void setOverallExpenseAmount(double overallExpenseAmount) {
		this.overallExpenseAmount = overallExpenseAmount;
	}
	public double getTotalAmountInAccount() {
		return totalAmountInAccount;
	}
	public void setTotalAmountInAccount(double totalAmountInAccount) {
		this.totalAmountInAccount = totalAmountInAccount;
	}
	
	public Map<String, Double> getAccountTypeBalances() {
		return accountTypeBalances;
	}
	public void setAccountTypeBalances(Map<String, Double> accountTypeBalances) {
		this.accountTypeBalances = accountTypeBalances;
	}
	@Override
	public String toString() {
		return "DashboardData [overallIncomeAmount=" + overallIncomeAmount + ", overallExpenseAmount="
				+ overallExpenseAmount + ", totalAmountInAccount=" + totalAmountInAccount + ", accountTypeBalances="
				+ accountTypeBalances + "]";
	}
	
	
	
    
}
