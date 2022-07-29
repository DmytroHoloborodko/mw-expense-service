package ua.wallet.expense.controller

import org.springframework.http.HttpStatus.NO_CONTENT
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import ua.wallet.expense.dto.ExpenseDto
import ua.wallet.expense.service.ExpenseService

@RestController
@RequestMapping("/expense")
class ExpenseController(val expenseService: ExpenseService) {

    @PostMapping
    @ResponseStatus(NO_CONTENT)
    @CrossOrigin(origins = ["http://localhost:63342"]) // todo 29.07.2022 remove asap
    fun saveExpenseData(@RequestBody expenseDto: ExpenseDto) {
        expenseService.saveExpenseData(expenseDto)
    }
}
