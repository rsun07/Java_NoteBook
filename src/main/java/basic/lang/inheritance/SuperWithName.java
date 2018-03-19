package basic.lang.inheritance;

/* When construct subclass, the superclass will be construct first.
 *  But the superclass is not a single object in memory heap, it is inside the subclass object.
 *  When running the superclass's constructor, the superclass's stack reference has a 'this' field/parameter.
 *  The 'this' parameter point to the subclass object, so it will call the subclass's function.
 *  Because at this stage, subclass has not been initialized, so the num is 0 in heap.
 *
 *
 *  Constructor Sequence:
 *
 *  1. Subclass functions
 *  2. Superclass fields
 *  3. Subclass fields
 *
 *  Out put:
 *    {
 *    Super  show Super in Sub Class, number:  8
 *    Super constructor : num = 8
 *    null  show Super number:  0
 *    Sub constructor : num = 888
 *    Sub  show Super number:  888
 *    }
 */
class SuperWithName {
    int num = 8;
    String name = "Super";

    SuperWithName() {
        showSuper();
        System.out.println("Super constructor : num = " + num);
        show();
    }

    void show() {
        System.out.println(this.name + "  show Super number:  " + num);
    }

    void showSuper() {

    }
}
