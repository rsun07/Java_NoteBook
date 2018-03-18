package practice.InputStream;

import java.util.Map;

public class EvnVariableReader {
    public static void main(String[] args) {
        getEnv();
//        getEnvs();
        for (String arg : args)
            System.out.println(arg);
    }

    private static void getEnv() {
        // 系统变量
        String env = System.getenv("env");
        System.out.println(env);

        // Java进程变量
        String property = System.getProperty("property");
        System.out.println(property);
    }

    private static void getEnvs() {
        Map<String, String> env = System.getenv();
        for (String envName : env.keySet()) {
            System.out.format("%s   =   %s%n",
                envName,
                env.get(envName));
        }
    }
}
