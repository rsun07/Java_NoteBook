package pers.xiaoming.notebook.lang.keywords;

public class StaticPractice {
    public static void main(String[] args) {
        new Person2().showName();
        new Person2("ACB").showName();
    }


}

class Person2 {


    static int id = 0;
    private String name;

    /*
     * Java static Code Block:
     *  Configure the Class every time when class is loaded.
     *  The benefit is to construct the class not the object
      *  This will run only once when class is loaded into memory
     */
    static
    {
        System.out.println("Initialize Ganzhou's Citizen ID");
        id += 360702 * 1000;
    }

    /*
     * Java Code Block:
     *  Configure the Object every time when object is initialized.
     *  The benefit is to construct the same setting/config for all
     *  object (instance of this class)
     *
     *
     *  Compare with Constructor:
     *  Constructor is to initialize customized object,
      *   For example, encapsulate object variables
     *  Code block can do the same initialize for all objects
     */
    {
        System.out.println("Get ID for new Citizen:  " + ++id);
    }

    Person2() {
        this("baby");
    }

    Person2(String name) {
        this.name = name;
    }

    void showName() {
        System.out.println(name);
    }
}
