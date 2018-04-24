package pers.xiaoming.notebook.concurrent.thread.threadlocal;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ThreadLocalValueTest {

    @Test
    public void testThreadLocalInMain() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        ThreadLocal<List<Integer>> threadLocal = new ThreadLocal<>();
        threadLocal.set(list);

        list.remove(0);
        list.add(8);

        new Thread(() -> {
            list.add(3);
        });

        System.out.println(threadLocal.get());
    }

    @Test
    public void testMultiEncapValue() {
        Entity entity = new Entity("Main_Entity");
        Entity subEntity = new Entity("Sub_Entity");
        entity.getList().add(1);
        entity.getSubEntities().add(subEntity);

        new Thread(() -> updateEntity(entity)).start();

        System.out.println("entity in main thread" + entity.toString());
    }

    private void updateEntity(Entity entity) {
        entity.getList().add(2);
        entity.getSubEntities().add(new Entity("Thread_Entity"));

        System.out.println("entity in background thread" + entity.toString());
    }
}
