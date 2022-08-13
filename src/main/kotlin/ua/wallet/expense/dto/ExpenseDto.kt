package ua.wallet.expense.dto

import ua.wallet.expense.datastore.entity.Category
import java.math.BigDecimal
import java.time.LocalDateTime

data class ExpenseDto(
    val productName: String,
    val price: BigDecimal,
    val currency: Currency,
    val storeName: String,
    val date: LocalDateTime,
    val category: Category
)
