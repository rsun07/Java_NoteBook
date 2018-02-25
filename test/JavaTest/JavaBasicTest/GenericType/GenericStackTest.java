package JavaTest.JavaBasicTest.GenericType;

import org.junit.Test;

import java.util.*;

public class GenericStackTest {


    @Test
    public void test() {
        MyStack<Object> stack = new MyStack<>();

        // Because of Liskov Substitution Principal
        // String and Integer are subtype of Object
        // So in add() and pop(), subtype can substitute supertype
        stack.add("Abc");
        System.out.println(stack.pop());

        stack.add(123);
        System.out.println(stack.pop());
    }

    @Test
    public void test2() {
        // But, because generic type is invariant
        // So List<String> is not a subtype of List<Object>
        MyStack<List<Object>> listStack = new MyStack<>();
        List<String> strList = Arrays.asList("Abc", "bbc", "abc");

        // the next line has compiler error
//        listStack.add(strList);
//        System.out.println(listStack.pop().toString());
    }


    private static class MyStack<E> extends Stack<E> {
        public void pushAll(Iterable<? extends E> it) {
            for (E e : it) {
                push(e);
            }
        }

        public Collection<? super E> popAll() {
            Collection<? super E> collection = new ArrayList<>();
            Iterator<E> it = super.iterator();
            while (it.hasNext()) {
                collection.add(it.next());
            }

//            collection.addAll(super.iterator());
            return collection;
        }
    }
}
