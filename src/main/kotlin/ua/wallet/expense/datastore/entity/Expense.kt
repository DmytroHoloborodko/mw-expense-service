package ua.wallet.expense.datastore.entity

import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity
import org.springframework.data.annotation.Id
import java.math.BigDecimal
import java.time.ZonedDateTime

@Entity
data class Expense(
    @Id
    val id: Long?,
    val productName: String,
    val price: BigDecimal,
    val storeName: String,
    val date: ZonedDateTime,
    val category: String
)
