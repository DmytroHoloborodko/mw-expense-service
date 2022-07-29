package ua.wallet.expense.datastore.converter

import org.springframework.core.convert.converter.Converter
import java.math.BigDecimal

class StringToBigDecimalConverter : Converter<String, BigDecimal> {
    override fun convert(source: String): BigDecimal = BigDecimal(source)
}
