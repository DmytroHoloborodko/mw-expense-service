package ua.wallet.expense.dto

import ua.wallet.expense.datastore.entity.Category
import ua.wallet.expense.datastore.entity.Units
import java.math.BigDecimal
import java.time.LocalDateTime

data class ExpenseDto(
    val productName: String,
    val amount: BigDecimal,
    val units: Units,
    val price: BigDecimal,
    val payed: BigDecimal,
    val currency: Currency,
    val storeName: String,
    val date: LocalDateTime,
    val category: Category
)
