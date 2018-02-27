package JavaTest.JavaBasicTest.Collections.ArrayList;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ArrayListBasic {

    @Test
    public void ArrayListBasic() {
        List<String> list = Arrays.asList("aa", "bb", "cc");
        System.out.println("Print List: ");
        System.out.println(list.toString());

        System.out.println("\n");
        System.out.println("Print Array: ");
        String[] str = (String[]) list.toArray();
        System.out.println(Arrays.toString(str));
    }

    @Test
    // fail to remove
    public void IteratorTest() {
        List<String> list = new ArrayList<>(Arrays.asList("aa", "bb", "cc"));

        Iterator<String> it = list.iterator();
        try {
            int count = 0;
            // be careful, everytime you call it.next(),
            // the cursor inside will increase by 1
            while (it.hasNext()) {
                System.out.println(count++ + it.next());
                list.remove(it.next());
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("ConcurrentModificationException first time");
        }

        try {
            it.next();
        } catch (ConcurrentModificationException e) {
            System.out.println("It fails again because the 'expectedModCount' already changed");
        }
        System.out.println("\n");


        // Get a new iterator instance in which the cursor is 0 again
        // Be careful, "bb" already been deleted
        it = list.iterator();
        System.out.println("it has next? " + it.next());
        System.out.println("it has next again? " + it.next());
        System.out.println("\n");
    }

    @Test
    // remove from iterator not the object
    public void IteratorTest2() {
        List<String> list = new ArrayList<>(Arrays.asList("aa", "bb", "cc"));
        Iterator<String> it = list.iterator();
        try {
            int count = 0;
            while (it.hasNext()) {
                String str = it.next();
                System.out.println(count++ + str);
                // this will remove the current element safely
                if (str.equals("aa"))
                    it.remove();
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("ConcurrentModificationException first time");
        }

        System.out.println("\n");
        System.out.println("List after delete");
        System.out.println(list.toString());
    }

    @Test
    // test List Iterator
    public void ListIteratorTest() {
        List<String> list = new ArrayList<>(Arrays.asList("aa", "bb", "cc"));

        // get a list iterator with cursor in 0
        ListIterator<String> it = list.listIterator();
        System.out.println("List elements with List Iterator:");
        while (it.hasNext()) {
            System.out.print(it.next() + "\t");
        }
        System.out.println("\n");


        it = list.listIterator(list.size());
        System.out.println("has next? " + it.hasNext());

        System.out.println("List elements with invert order List Iterator:");
        while (it.hasPrevious()) {
            System.out.print(it.previous() + "\t");
        }
        System.out.println("\n");


        // set and add through list iterator
        System.out.println("Set and add through List Iterator:");
        it = list.listIterator(list.size());
        while (it.hasPrevious()) {
            String str = it.previous();
            if (str.equals("bb")) {
                it.set("dd");
                it.add("ee");
                it.add("ff");
            }
        }
        System.out.println("List after set and add");
        System.out.println(list.toString());
        System.out.println("\n");
    }
}
