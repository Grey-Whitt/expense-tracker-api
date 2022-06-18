package in.greyw.expensetrackerapi.Service;

import in.greyw.expensetrackerapi.Entity.Expense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ExpenseService {
    Page<Expense> getAllExpenses(Pageable page);

    Expense getExpenseById(Long id);

    String deleteExpenseById(Long id);

    Expense saveExpenseDetails(Expense expense);

    Expense updateExpenseDetails(Long id, Expense expense);
}
