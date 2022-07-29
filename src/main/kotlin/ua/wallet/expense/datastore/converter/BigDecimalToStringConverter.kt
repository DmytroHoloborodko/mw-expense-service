package ua.wallet.expense.datastore.converter

import org.springframework.core.convert.converter.Converter
import java.math.BigDecimal
import java.math.RoundingMode.HALF_UP

class BigDecimalToStringConverter : Converter<BigDecimal, String> {
    override fun convert(source: BigDecimal): String = source.setScale(2, HALF_UP).toString()
}
