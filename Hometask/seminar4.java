import java.util.*;

class Person {
    private String fullName;
    private int age;
    private char gender;

    public Person(String fullName, int age, char gender) {
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public char getGender() {
        return gender;
    }

    public String getInitials() {
        String[] names = fullName.split(" ");
        StringBuilder initials = new StringBuilder();
        for (String name : names) {
            initials.append(name.charAt(0)).append(".");
        }
        return initials.toString();
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();

        while (true) {
            System.out.println("Select an action:");
            System.out.println("1. Add a person");
            System.out.println("2. Display the list of people");
            System.out.println("3. Display the sorted list by age");
            System.out.println("4. Display the sorted list by age and gender");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline character

            switch (choice) {
                case 1:
                    addPerson(scanner, people);
                    break;
                case 2:
                    displayPeople(people);
                    break;
                case 3:
                    sortPeopleByAge(people);
                    displayPeople(people);
                    break;
                case 4:
                    sortPeopleByAgeAndGender(people);
                    displayPeople(people);
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select an action from the list.");
            }
        }
    }

    public static void addPerson(Scanner scanner, List<Person> people) {
        System.out.println("Enter full name:");
        String fullName = scanner.nextLine();
        System.out.println("Enter age:");
        int age = scanner.nextInt();
        System.out.println("Enter gender (M/F):");
        char gender = scanner.next().charAt(0);
        scanner.nextLine(); // consume newline character

        Person person = new Person(fullName, age, gender);
        people.add(person);
        System.out.println("Person added successfully!");
    }

    public static void displayPeople(List<Person> people) {
        System.out.println("List of people:");
        for (Person person : people) {
            System.out.println(person.getFullName() + " " + person.getInitials() + " " + person.getAge() + " " + person.getGender());
        }
    }

    public static void sortPeopleByAge(List<Person> people) {
        people.sort(Comparator.comparingInt(Person::getAge));
    }

    public static void sortPeopleByAgeAndGender(List<Person> people) {
        people.sort(Comparator.comparingInt(Person::getAge).thenComparing(Person::getGender));
    }
}

