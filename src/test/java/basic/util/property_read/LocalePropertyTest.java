package basic.util.property_read;

import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocalePropertyTest {
    @Test
    public void testLocaleProperty() {
        Locale locale = new Locale("zh", "CN");
        ResourceBundle resourceBundle = ResourceBundle.getBundle("locale_message/message");

        System.out.println(resourceBundle.keySet());
    }
}
