package com.fz.ExpenseTracker.income;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fz.ExpenseTracker.Account_Type.AccountTypeRepository;
import com.fz.ExpenseTracker.Account_Type.Account_Type;
import com.fz.ExpenseTracker.account.Account;
import com.fz.ExpenseTracker.account.AccountRepository;
import com.fz.ExpenseTracker.category.Category;
import com.fz.ExpenseTracker.category.CategoryRepository;
import com.fz.ExpenseTracker.service.ServiceRepository;
import com.fz.ExpenseTracker.service.Services;

@Service
public class IncomeService {

    @Autowired
    private IncomeRepository incomeRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private AccountTypeRepository accountTypeRepo;

    @Autowired
    private AccountRepository accountRepo;

    @Autowired
    private ServiceRepository serviceRepo;

    public List<Income> getAllIncomes() {
        return incomeRepository.findAll();
    }
    

    public Income getIncomeById(int id) throws IncomeNotFoundException {
        Optional<Income> optionalExpense = incomeRepository.findById(id);
        if (optionalExpense.isPresent()) {
            return optionalExpense.get();
        } else {
            throw new IncomeNotFoundException("The entered id: " + id + " is not present");
        }
    }

    public void createIncome(IncomeDTO expenseRequest) {
        Income Income = new Income();
        Optional<Category> c = categoryRepository.findById(expenseRequest.getCategory());
        Optional<Services> s = serviceRepo.findById(expenseRequest.getService());
        Optional<Account_Type> ac = accountTypeRepo.findById(expenseRequest.getAccount_type());
        Optional<Account> a = accountRepo.findById(expenseRequest.getPaid_account());
        if (c.isPresent()) {
            Income.setCategoryEntity(c.get());
            if (s.isPresent()) {
                Income.setServiceEntity(s.get());
            }
        }
        if (ac.isPresent() && a.isPresent()) {
            Account_Type accountType = ac.get();
            Income.setAccountTypeEntity(accountType);

            Account account = a.get();
                account.setAmount(account.getAmount() + expenseRequest.getAmount());
                accountRepo.save(account);
                Income.setAccount(account);
        }

        Income.setAmount(expenseRequest.getAmount());
        Income.setDate_time(LocalDateTime.now());
        Income.setDescription(expenseRequest.getDescription());
        Income.setReference(expenseRequest.getReference());
        incomeRepository.save(Income);
    }

    

    public boolean deleteIncome(int id) {
        Optional<Income> optionalExpense = incomeRepository.findById(id);
        if (optionalExpense.isPresent()) {
        	incomeRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
