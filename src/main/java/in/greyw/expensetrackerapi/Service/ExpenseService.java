package in.greyw.expensetrackerapi.Service;

import in.greyw.expensetrackerapi.Entity.Expense;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ExpenseService {
    List<Expense> getAllExpenses();

    Expense getExpenseById(Long id);

    String deleteExpenseById(Long id);

    Expense saveExpenseDetails(Expense expense);

    Expense updateExpenseDetails(Long id, Expense expense);
}
