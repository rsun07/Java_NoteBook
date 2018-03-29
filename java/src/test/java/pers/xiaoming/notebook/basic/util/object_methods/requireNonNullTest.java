package pers.xiaoming.notebook.basic.util.object_methods;

import org.junit.Test;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class requireNonNullTest {
    @Test(expected = NullPointerException.class)
    public void testRequireNonNull() {
        String str = null;
        Objects.requireNonNull(str);
    }

    @Test(expected = NullPointerException.class)
    public void testRequireNonNullWithMessage() {
        String str = null;
        try {
            Objects.requireNonNull(str, "String str is null");
        } catch (NullPointerException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Test(expected = NullPointerException.class)
    public void testRequireNonNullWithMessageFunction() {
        ConcurrentHashMap<String, Integer> map = null;
        try {
            Objects.requireNonNull(map, this::getMessage);
        } catch (NullPointerException e) {
            e.printStackTrace();
            throw e;
        }
    }

    // must be a Supplier<String> method.
    // Don't allow parameter in method. must return String.
    private String getMessage() {
        return "input is null in " + this.getClass().getName();
    }
}
