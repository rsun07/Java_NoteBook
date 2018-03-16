package JavaBasicTest.util.GenericType;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class typesafeHeterogeneousContainers {
    private class Favorite {
        Map<Class<?>, Object> favorites = new HashMap<>();

        <T> void addFavorite(Class<T> key, T value) {
            favorites.put(Objects.requireNonNull(key),
                    // Achieving runtime type safety with a dynamic cast
                    // if favorites Map is in raw format (example, Map rather than Map<K, V>)
                    key.cast(value));
        }

        <T> T getFavorite(Class<T> key) {
            return key.cast(favorites.get(key));
        }
    }

    private class BoundedFavorite extends Favorite {
        Map<Class<? extends Favorite>, Object> boundedFavorites = new HashMap<>();

        <T extends Favorite> void addboundedFavorite(Class<T> key, T value) {
            favorites.put(Objects.requireNonNull(key),
                    // Achieving runtime type safety with a dynamic cast
                    // if favorites Map is in raw format (example, Map rather than Map<K, V>)
                    key.cast(value));
        }

        <T extends Favorite> T getboundedFavorite(Class<T> key) {
            return key.cast(favorites.get(key));
        }
    }

    @Test
    public void testFavorite() {
        Favorite myFavorite = new Favorite();
        myFavorite.addFavorite(String.class, "Java ");
        myFavorite.addFavorite(Integer.class, 8);

        // this will cause error
//        myFavorite.addFavorite(Integer.class, "Java");

        myFavorite.addFavorite(Class.class, Favorite.class);

        //example from the book
        // Note that, the key is the class String, Integer and Favorite,
        // so the following line will cover the previous added (Integer.class, 8)
        myFavorite.addFavorite(Integer.class, 0xcafebabe);


        System.out.printf("%s %x %s %n",
                myFavorite.getFavorite(String.class),
                myFavorite.getFavorite(Integer.class),
                myFavorite.getFavorite(Class.class)
        );
    }

    @Test
    public void testErrorFavorite() {
        Favorite myFavorite = new Favorite();
        // Error
//        myFavorite.addFavorite("Abc", "abc");
//        myFavorite.addFavorite("Abc".getClass(), "abc");

    }

    @Test
    public void testBoundedFavorite() {
        BoundedFavorite boundedFavorite = new BoundedFavorite();
        boundedFavorite.addboundedFavorite(Favorite.class, new Favorite());
        boundedFavorite.addboundedFavorite(BoundedFavorite.class, boundedFavorite);

        // the next line throw error
        // boundedFavorite.addboundedFavorite(String.class, "ABC");
    }
}
