import java.util.Comparator;

public class Dog implements Comparable<Dog> {
    private String name;
    private int size;

    public Dog(String n, int s) {
        name = n;
        size = s;
    }

    public void bark() {
        System.out.println(name + " bark");
    }

    public static Dog maxDog(Dog[] dogs) {
        if (dogs == null || dogs.length == 0) {
            return null;
        }
        Dog maxDog = dogs[0];
        for (Dog d : dogs) {
            if (d.size > maxDog.size) {
                maxDog = d;
            }
        }
        return maxDog;
    }

    @Override
    public int compareTo(Dog other) {
        return size - other.size;
    }

    private static class NameComparator implements Comparator<Dog> {
        @Override
        public int compare(Dog o1, Dog o2) {
            return o1.name.compareTo(o2.name);
        }
    }

    public static Comparator<Dog> getNameComparator() {
        return new NameComparator();
    }
}
