package in.greyw.expensetrackerapi.Service;

import in.greyw.expensetrackerapi.Entity.Expense;
import in.greyw.expensetrackerapi.Exceptions.ResourceNotFoundException;
import in.greyw.expensetrackerapi.Repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepo;

    @Override
    public Page<Expense> getAllExpenses(Pageable page) {

        return expenseRepo.findAll(page);
    }

    @Override
    public Expense getExpenseById(Long id) {
       Optional<Expense> expense = expenseRepo.findById(id);

       if (expense.isPresent()) {
           return expense.get();
       }
       throw new ResourceNotFoundException("No expense found with id " + id);
    }

    @Override
    public String deleteExpenseById(Long id) {

        Optional<Expense> expense = expenseRepo.findById(id);

        if (expense.isPresent()) {
            expenseRepo.deleteById(id);
            return "successfully deleted expense " + id;
        }
        throw new RuntimeException("No expense found with id " + id);
    }

    @Override
    public Expense saveExpenseDetails(Expense expense) {
        return expenseRepo.save(expense);
    }

    @Override
    public Expense updateExpenseDetails(Long id, Expense expense) {
        Expense existingExpense = getExpenseById(id);

        existingExpense.setName(expense.getName() != null ? expense.getName() : existingExpense.getName());
        existingExpense.setAmount(expense.getAmount() != null ? expense.getAmount() : existingExpense.getAmount());
        existingExpense.setDate(expense.getDate() != null ? expense.getDate() : existingExpense.getDate());
        existingExpense.setDescription(expense.getDescription() != null ? expense.getDescription() : existingExpense.getDescription());
        existingExpense.setCategory(expense.getCategory() != null ? expense.getCategory() : existingExpense.getCategory());

        return expenseRepo.save(existingExpense);
    }

    @Override
    public List<Expense> readByCategory(String category, Pageable page) {
        return expenseRepo.findByCategory(category, page).toList();
    }

    @Override
    public List<Expense> readByName(String keyword, Pageable page) {
        return expenseRepo.findByNameContaining(keyword, page).toList();
    }

    @Override
    public List<Expense> readByDate(Date startDate, Date endDate, Pageable page) {

        if (startDate == null) {
            startDate = new Date(0);
        }

        if (endDate == null) {
            endDate = new Date(System.currentTimeMillis());
        }

        return expenseRepo.findByDateBetween(startDate, endDate, page).toList();
    }
}
