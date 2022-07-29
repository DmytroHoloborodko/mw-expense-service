package ua.wallet.expense.datastore.converter

import org.springframework.core.convert.converter.Converter
import java.time.ZonedDateTime

class ZonedDateTimeToStringConverter : Converter<ZonedDateTime, String> {
    override fun convert(source: ZonedDateTime): String = source.toString()
}
