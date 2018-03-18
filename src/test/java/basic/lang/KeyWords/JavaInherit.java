package basic.lang.KeyWords;


import org.junit.Test;

public class JavaInherit {
    public static void main(String[] args) {
//        Child c = new Child();
//        Child4 c4 = new Child4(4);
//        Child5 c5 = new Child5(5);
//        Child6 c6 = new Child6(6);
//        Child7 c7 = new Child7();
        Child8 c8 = new Child8();

    }

    @Test
    public void test9() {
        Child9 child = new Child9();
        child.function();
    }
}

class Father {
    public Father() {
        System.out.println("Father constructor");
    }
}

class Child extends Father {
    public Child() {

        // In child class, there is a hidden super consturctor
        // super();
        System.out.println("Child constructor");
    }
}



// wrong because father doesn't has a default constructor which can be called by child
//class Father2 {
//    public Father2(int i) {
//        System.out.println("Father constructor");
//    }
//}
//
//class Child2 extends Father2 {
//    public Child2() {
//        // In child class, there is a hidden super consturctor
//        // super();
//        System.out.println("Child constructor");
//    }
//}


// improvement of Father2
class Father3 {
    public Father3(int i) {
        System.out.println("Father constructor");
    }
}

class Child3 extends Father3 {
    public Child3() {
        // In child class, there is a hidden super consturctor
        super(3);
        System.out.println("Child constructor");
    }
}




class Father4 {
    public Father4() {
        System.out.println("Father constructor");
    }

    public Father4(int i) {
        System.out.println("Father constructor with int");
    }
}

class Child4 extends Father4 {
    public Child4(int i) {
        // This will still call the empty parameter constructor of Father class
        // super();
        System.out.println("Child constructor");
    }
}


class Father5 {
    public Father5() {
        System.out.println("Father constructor");
    }

    public Father5(int i) {
        System.out.println("Father constructor with int");
    }
}

class Child5 extends Father5 {
    public Child5(int i) {
        // If specify the super constructor, it will stop visit Father's non-parameter constructor
        super(i);
        System.out.println("Child constructor");
    }
}



class Father6 {
    public Father6() {
        System.out.println("1. Father constructor");
    }

    public Father6(int i) {
        System.out.println("Father constructor with int");
    }
}

class Child6 extends Father6 {
    public Child6() {
        System.out.println("2. Father constructor");
    }

    public Child6(int i) {
        // If specify the super constructor, it will stop visit Father's non-parameter constructor
        this();
        System.out.println("3. Child constructor with int");
    }
}


// all class extends from Object class
class Child7  /* extends Object */ {
    public Child7() {

        super();
        System.out.println("Child constructor");
    }
}



/* Same explanation, when construct child, the father will be construct first.
 *  But the father is not a single object in memory heap, it is inside the child object.
 *  When running the father's constructor, the father's stack reference has a this field/parameter.
 *  The this parameter point to the child object, so it will call the child's function.
 *  Because at this stage, child has not been initialized, so the num is 0 in heap.
 *
 *  Out put:
 *    {
 *    Father constructor
 *    null  show child number:  0
 *    child  show child number:  9
 *    }
  */
class Father8 {
    int num = 8;
    String name = "father";

    public Father8() {
        showFather();
        System.out.println("Father constructor : num = " + num);
        show();
    }

    public void show() {
        System.out.println(this.name + "  show father number:  " + num);
    }

    public void showFather() {
    }
}

class Child8 extends Father8 {
    int num = 9;
    String name = "child";

    public Child8() {
        //super();
        // initialize num and name
        num = 100;
        show();

    }


    public void show() {
        System.out.println(name + "  show child number:  " + num);
    }

    public void showFather() {
        System.out.println(super.name + "  show showFather in child number:  " + super.num);
    }
}


class Father9 {
    void print() {
        System.out.println("Father's function");
    }

    void function() {
        print();
    }
}

class Child9 extends Father9 {
    @Override
    void print() {
        System.out.println("Children's function");
    }

    @Override
    void function() {
        super.function();
    }
}