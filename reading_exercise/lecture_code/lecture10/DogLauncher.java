import java.util.Comparator;

public class DogLauncher {
    public static void main(String[] args) {
        Dog[] dogs = {new Dog("Elyse", 3), new Dog("Sture", 9), new Dog("Benjamin", 15)};
        Dog maxDog = (Dog) Maximizer.max(dogs);
        maxDog.bark();

        Comparator<Dog> nc = Dog.getNameComparator();
        int cmp = nc.compare(dogs[0], dogs[2]);
        System.out.println(cmp);
    }
}
