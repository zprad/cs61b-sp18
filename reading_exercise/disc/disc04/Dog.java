public class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);
        this.noise = "Woof";
    }

    @Override
    public void greet() {
        System.out.println("Dog " + name + " says: " + makeNoise());
    }

    public void playFetch() {
        System.out.println("Fetch, " + super.name + "!");
    }

    public static void main(String[] args) {

        Animal a = new Animal("Pluto", 10);
        Cat c = new Cat("Garfield", 6);
        Dog d = new Dog("Fido", 4);
        a.greet(); // (A) ______________________Animal Pluto says: Huh?
        c.greet(); // (B) ______________________Cat Garfield says: Meow!
        d.greet(); // (C) ______________________Dog Fido says: WOOF
        a = c;
        ((Cat) a).greet(); // (D) ______________________
        a.greet(); // (E) ______________________

        a = new Dog("Spot", 10);
        a.greet();
        d = (Dog) a;
        d.greet();
    }
}
