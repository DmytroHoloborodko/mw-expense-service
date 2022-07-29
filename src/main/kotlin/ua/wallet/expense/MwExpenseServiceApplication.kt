package ua.wallet.expense

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MwExpenseServiceApplication

fun main(args: Array<String>) {
	runApplication<MwExpenseServiceApplication>(*args)
}
