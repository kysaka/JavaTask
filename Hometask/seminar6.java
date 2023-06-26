import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class MyHashSet {
    private List<Integer> elements;

    public MyHashSet() {
        elements = new ArrayList<>();
    }

    public void add(Integer element) {
        if (!contains(element)) {
            elements.add(element);
        }
    }

    public String toString() {
        return elements.toString();
    }

    public Integer get(int index) {
        validateIndex(index);
        return elements.get(index);
    }

    private boolean contains(Integer element) {
        return elements.contains(element);
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= elements.size()) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }
    }
}

class Main {
    public static void main(String[] args) {
        MyHashSet mySet = new MyHashSet();

        mySet.add(1);
        mySet.add(2);
        mySet.add(3);
        mySet.add(2); // Duplicate element, won't be added

        System.out.println("Elements: " + mySet);

        System.out.println("Element at index 0: " + mySet.get(0));
        System.out.println("Element at index 1: " + mySet.get(1));
        System.out.println("Element at index 2: " + mySet.get(2));
    }
}