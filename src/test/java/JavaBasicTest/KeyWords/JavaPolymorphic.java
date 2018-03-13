package JavaBasicTest.KeyWords;

public class JavaPolymorphic {
    public static void main(String args[]) {
        Animal cat = new Cat();
        Animal dog = new Dog();
        showAnimal(cat);
        showAnimal(dog);
    }

    private static void showAnimal(Animal animal) {
        animal.eat();

        if (animal instanceof Cat) {
            Cat cat = (Cat) animal;
            cat.play();
        } else if (animal instanceof Dog) {
            Dog dog = (Dog) animal;
            dog.shout();
        } else {
            throw new RuntimeException("Animal not in list");
        }
    }
}




abstract class Animal {
    abstract void eat();
}

class Dog extends Animal {

    @Override
    void eat() {
        System.out.println("Eat Bones");
    }

    void shout() {
        System.out.println("Wang Wang");
    }
}

class Cat extends Animal {

    @Override
    void eat() {
        System.out.println("Eat Fish");
    }

    void play() {
        System.out.println("Play mouse");
    }
}
