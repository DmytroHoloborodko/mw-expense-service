package ua.wallet.expense.datastore.configuration

import org.springframework.cloud.gcp.data.datastore.core.convert.DatastoreCustomConversions
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import ua.wallet.expense.datastore.converter.BigDecimalToStringConverter
import ua.wallet.expense.datastore.converter.StringToBigDecimalConverter
import ua.wallet.expense.datastore.converter.StringToZonedDateTimeConverter
import ua.wallet.expense.datastore.converter.ZonedDateTimeToStringConverter

@Configuration
class DatastoreConfiguration {

    @Bean
    fun datastoreCustomConversions() = DatastoreCustomConversions(
        listOf(
            ZonedDateTimeToStringConverter(), StringToZonedDateTimeConverter(),
            BigDecimalToStringConverter(), StringToBigDecimalConverter()
        )
    )
}
