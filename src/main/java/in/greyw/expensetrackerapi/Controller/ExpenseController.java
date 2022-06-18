package in.greyw.expensetrackerapi.Controller;


import in.greyw.expensetrackerapi.Entity.Expense;
import in.greyw.expensetrackerapi.Service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/expenses")
    public List<Expense> getAllExpenses(Pageable page) {

        return expenseService.getAllExpenses(page).toList();
    }

    @GetMapping("/expenses/{id}")
    public Expense getExpenseById(@PathVariable Long id) {

        return expenseService.getExpenseById(id);
    }

    @DeleteMapping("/expenses")
    public String deleteExpenseById(@RequestParam Long id) {

       return expenseService.deleteExpenseById(id);
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/expenses")
    public Expense saveExpenseDetails(@RequestBody Expense expense) {

        return expenseService.saveExpenseDetails((expense));
    }

    @PutMapping("expenses/{id}")
    public Expense updateExpenseDetails(@RequestBody Expense expense, @PathVariable Long id) {

        return expenseService.updateExpenseDetails(id, expense);
    }
}
