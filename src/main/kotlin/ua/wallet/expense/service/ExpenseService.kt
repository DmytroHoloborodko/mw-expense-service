package ua.wallet.expense.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import ua.wallet.expense.datastore.entity.Expense
import ua.wallet.expense.datastore.repository.ExpenseRepository
import ua.wallet.expense.dto.Currency
import ua.wallet.expense.dto.ExpenseDto
import java.math.BigDecimal
import java.math.RoundingMode.HALF_UP
import java.time.ZoneId
import java.time.ZonedDateTime

@Service
class ExpenseService(
    private val expenseRepository: ExpenseRepository,
    @Value("\${app.domain.categories}") private val categories: List<String>
) {

    fun saveExpenseData(expenseDto: ExpenseDto) {
        val expense = Expense(
            id = null,
            productName = expenseDto.productName,
            price = adjustPrice(expenseDto.currency, expenseDto.price),
            storeName = expenseDto.storeName,
            date = ZonedDateTime.of(expenseDto.date, ZoneId.of("Europe/Zagreb")),
            category = validateCategory(expenseDto.category)
        )
        expenseRepository.save(expense)
        println("New entity created: $expense")
    }

    private fun validateCategory(category: String) =
        if (categories.contains(category)) category
        else throw IllegalArgumentException()

    private fun adjustPrice(currency: Currency, price: BigDecimal) = when (currency) {
        Currency.EURO -> price
        Currency.KUNA -> price.div(BigDecimal(7.53450))
    }.setScale(2, HALF_UP)
}
