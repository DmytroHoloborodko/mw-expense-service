package ua.wallet.expense.datastore.converter

import org.springframework.core.convert.converter.Converter
import java.time.ZonedDateTime

class StringToZonedDateTimeConverter : Converter<String, ZonedDateTime> {
    override fun convert(source: String): ZonedDateTime = ZonedDateTime.parse(source)
}
