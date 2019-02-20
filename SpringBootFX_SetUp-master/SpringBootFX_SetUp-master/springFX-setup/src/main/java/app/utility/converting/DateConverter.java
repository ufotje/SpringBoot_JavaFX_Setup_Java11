package app.utility.converting;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by Demesmaecker Daniel on 26/10/2017.
 * Auto converter for Dates
 */

@Converter(autoApply = true)
public class DateConverter implements AttributeConverter<LocalDate, Date> {

    /**
     * Converts LocalDate to SQLDate
     * @param locDate LocalDate
     * @return Date
     */
    @Override
    public Date convertToDatabaseColumn(LocalDate locDate) {
        return (locDate == null ? null : Date.valueOf(locDate));
    }

    /**
     * Converts SQLDate to LocalDate
     * @param sqlDate Date
     * @return LocalDate
     */
    @Override
    public LocalDate convertToEntityAttribute(Date sqlDate) {
        LocalDate date = null;
        if (sqlDate != null) {
            LocalDate d = sqlDate.toLocalDate();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
            String text = d.format(formatter);
            date = LocalDate.parse(text, formatter);
        }
        return date;
    }
}
