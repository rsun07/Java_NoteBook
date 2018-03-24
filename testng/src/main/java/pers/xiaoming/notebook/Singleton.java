package pers.xiaoming.notebook;

public class Singleton {
    private static String singleton;

    public static String getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                singleton = "singleton_instance";
            }
        }
        return singleton;
    }
}
