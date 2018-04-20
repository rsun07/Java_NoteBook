package pers.xiaoming.notebook.util.property_read;

import org.junit.Assert;
import org.junit.Test;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocalePropertyTest {

    /**
     *
     * Only Run this in US and when system default language is English
     *
     */
    @Test
    public void testDefaultLocaleProperty() {
        ResourceBundle rb = ResourceBundle.getBundle("property_read/message");

        Assert.assertEquals("en_US", rb.getLocale().toString());
        System.out.println(rb.getLocale());

        String message = rb.getString("wel.msg");
        Assert.assertEquals("Welcome <{0}>, current time is <{1}>!", message);
        System.out.println(
                MessageFormat.format(message, "John",
                        DateTimeFormatter.ofPattern("MM/dd/yyyy -= HH:mm").format(LocalDateTime.now())));
    }

    @Test
    public void testExistLocaleProperty() {
        // the bundle name is still message!!
        // no need to add "_zh_CN"
        Locale locale = new Locale("zh", "CN");
        ResourceBundle rb = ResourceBundle.getBundle("property_read/message", locale);

        Assert.assertEquals("zh_CN", rb.getLocale().toString());
        Assert.assertEquals("Chinese (China)", rb.getLocale().getDisplayName());
        Assert.assertEquals("zh", rb.getLocale().getLanguage());
        Assert.assertEquals("CN", rb.getLocale().getCountry());

        System.out.println(rb.getString("wel.msg"));
    }

    @Test
    public void testNonExistLocalProperty() {
        Locale locale = new Locale("it_IT");
        ResourceBundle rb = ResourceBundle.getBundle("property_read/message", locale);

        // Will use the default language first rather than default
        Assert.assertEquals("en_US", rb.getLocale().toString());

        String message = rb.getString("wel.msg");
        System.out.println(
                MessageFormat.format(message, "John",
                        DateTimeFormatter.ofPattern("MM/dd/yyyy -= HH:mm").format(LocalDateTime.now())));
    }
}
