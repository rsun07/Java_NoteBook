package JavaTest.JavaBasicTest.KeyWords;

public class InnerClass {
    public static void main(String args[]) {

        // initialize inner class
        Outer.packageWildInner inner1 = new Outer().new packageWildInner();
        inner1.show();
        inner1.showLocal();
        inner1.showInnerClassNum();

        // private inner class cannot be called outside
//    Outer.privateInner inner2 = new Outer().new privateInner();

        // static inner class can be called directly like static function,
        // without Outer class's instance
        // it is the same as a outer class
        Outer.staticInner inner3 = new Outer.staticInner();
        inner3.show();

        // call the static function directly
        Outer.staticInner.staticShow();


        // Anonymous inner class:
        new Outer().outerMethodWithAnonymousInnerClass();
    }

}

class Outer {

    private int outerNum = 0;

    void outerShow() {

        // must add final to be called by inner class
        int x = 9;

        class methodInner {
            void show() {
                System.out.println("show inner class inside method : " + x);
            }
        }
    }


    class packageWildInner {

        private int num = 1;
        public int innerNum2 = 1;


        void show() {
            System.out.println("show outer number : " + outerNum);
        }

        void showLocal() {
            int num = 2;
            System.out.println("show local variable number : " + num);
        }

        // inner class has the reference of outer class
        void showInnerClassNum() {
            int num = 2;
            System.out.println("show showInnerClassNum variable number : " + this.num);
        }
    }

    // Outer class cannot visit packageWildInner class's member variable (even if it's public)
    // int i = innerNum;
//     int i = innerNum2;



    private class privateInner {

    }

    static class staticInner {
        void show() {
            System.out.println("show static inner : ");
        }

        static void staticShow() {
            System.out.println("show static inner static function : ");
        }
    }




    abstract class Anonymous {
        abstract void show();
    }

    public void outerMethodWithAnonymousInnerClass() {

        // forgot to call the show method, here is only define the show method
        new Anonymous() {
          @Override
          void show() {
              System.out.println("show Anonymous inner static function : ");
          }
        };


        // need to call the show method
        new Anonymous() {
            @Override
            void show() {
                System.out.println("show Anonymous inner static function : ");
            }
        }.show();
    }
}
