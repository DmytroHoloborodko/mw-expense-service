package ua.wallet.expense.service

import org.springframework.boot.context.event.ApplicationStartedEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Service
import ua.wallet.expense.datastore.entity.Expense
import ua.wallet.expense.datastore.entity.Units
import ua.wallet.expense.datastore.repository.ExpenseRepository
import java.math.BigDecimal
import java.time.ZoneId
import java.time.ZonedDateTime

@Service
class ExpenseService(private val expenseRepository: ExpenseRepository) {

    @EventListener(ApplicationStartedEvent::class)
    fun onStart() {
        val expense = Expense(
            null,
            "Test",
            BigDecimal(1),
            Units.L,
            BigDecimal(1 / 7.53450),
            BigDecimal(1 / 7.53450),
            "TEST",
            ZonedDateTime.of(2022, 7, 27, 14, 13, 0, 0, ZoneId.of("Europe/Zagreb"))
        )
        expenseRepository.save(expense)
        expenseRepository.findAll().forEach(::println)
    }
}
