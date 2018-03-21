package basic.lang.system_and_runtime;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RuntimeTest {
    @Test
    @Ignore("time costing test")
    public void test() {
        // Runtime is a System maintained instance using singleton pattern
        Runtime runtime = Runtime.getRuntime();

        printMemoryInfo(runtime);

        garbageCreation();

        printMemoryInfo(runtime);

        runtime.gc();

        printMemoryInfo(runtime);
    }

    private void printMemoryInfo(Runtime runtime) {
        System.out.printf(
                "Max memory is : \t%d \n"
                + "Total memory is : \t%d \n"
                + "Free memory is : \t%d\n\n",
                runtime.maxMemory(),
                runtime.totalMemory(),
                runtime.freeMemory()
        );
    }

    private void garbageCreation() {
        List<String> list = new ArrayList<>();
        String s = "";
        for (int i = 0; i < 8000; i++) {
            list.add(s+=i);
        }
    }
}
