package ua.wallet.expense.service

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
class ExpenseService(private val expenseRepository: ExpenseRepository) {

//    @EventListener(ApplicationStartedEvent::class)
//    fun onStart() {
//        val expense = Expense(
//            null,
//            "Test",
//            BigDecimal(1),
//            Units.L,
//            BigDecimal(1 / 7.53450),
//            BigDecimal(1 / 7.53450),
//            "TEST",
//            ZonedDateTime.of(2022, 7, 27, 14, 13, 0, 0, ZoneId.of("Europe/Zagreb"))
//        )
//        expenseRepository.save(expense)
//        expenseRepository.findAll().forEach(::println)
//    }

    fun saveExpenseData(expenseDto: ExpenseDto) {
        val expense = Expense(
            id = null,
            productName = expenseDto.productName,
            price = adjustPrice(expenseDto.currency, expenseDto.price),
            storeName = expenseDto.storeName,
            date = ZonedDateTime.of(expenseDto.date, ZoneId.of("Europe/Zagreb")),
            category = expenseDto.category
        )
        expenseRepository.save(expense)
        println("New entity created: $expense")
    }

    private fun adjustPrice(currency: Currency, price: BigDecimal) = when (currency) {
        Currency.EURO -> price
        Currency.KUNA -> price.div(BigDecimal(7.53450))
    }.setScale(2, HALF_UP)
}
