package ua.wallet.expense.datastore.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ua.wallet.expense.datastore.entity.Expense

@Repository
interface ExpenseRepository : CrudRepository<Expense, Long>
