import java.util.*;

class seminar5 {
    public static void main(String[] args) {
        Map<String, List<String>> phoneBook = new HashMap<>();

        // Генерация случайной телефонной книги с 10 человеками
        generateRandomPhoneBook(phoneBook, 10);

        // Вывод телефонной книги до сортировки
        System.out.println("Phone Book (Before sorting):");
        displayPhoneBook(phoneBook);

        // Сортировка телефонной книги по убыванию числа телефонов
        List<Map.Entry<String, List<String>>> sortedPhoneBook = sortPhoneBookByNumberOfPhoneNumbers(phoneBook);

        // Вывод отсортированной телефонной книги
        System.out.println("\nPhone book (Sorted by the number of phones - In descending order):");
        displayPhoneBook(sortedPhoneBook);
    }
    public static void displayPhoneBook(List<Map.Entry<String, List<String>>> phoneBook) {
        for (Map.Entry<String, List<String>> entry : phoneBook) {
            String fullName = entry.getKey();
            List<String> phoneNumbers = entry.getValue();
            System.out.println(fullName + ": " + phoneNumbers);
        }
    }
    

    public static void generateRandomPhoneBook(Map<String, List<String>> phoneBook, int numPeople) {
        Random random = new Random();
        for (int i = 0; i < numPeople; i++) {
            String fullName = generateRandomFullName();
            String phoneNumber = generateRandomPhoneNumber();
            phoneBook.computeIfAbsent(fullName, k -> new ArrayList<>()).add(phoneNumber);
        }
    }

    public static String generateRandomFullName() {
        String[] firstNames = { "John", "Jane", "David", "Emma", "Michael", "Olivia", "James", "Sophia", "Robert", "Isabella" };
        String[] lastNames = { "Smith", "Johnson", "Williams", "Brown", "Jones", "Miller", "Davis", "Garcia", "Wilson", "Taylor" };
        Random random = new Random();
        String firstName = firstNames[random.nextInt(firstNames.length)];
        String lastName = lastNames[random.nextInt(lastNames.length)];
        return firstName + " " + lastName;
    }

    public static String generateRandomPhoneNumber() {
        Random random = new Random();
        StringBuilder phoneNumber = new StringBuilder();
        phoneNumber.append("+7");
        for (int i = 0; i < 8; i++) {
            int digit = random.nextInt(10);
            phoneNumber.append(digit);
        }
        return phoneNumber.toString();
    }

    public static void displayPhoneBook(Map<String, List<String>> phoneBook) {
        for (Map.Entry<String, List<String>> entry : phoneBook.entrySet()) {
            String fullName = entry.getKey();
            List<String> phoneNumbers = entry.getValue();
            System.out.println(fullName + ": " + phoneNumbers);
        }
    }

    public static List<Map.Entry<String, List<String>>> sortPhoneBookByNumberOfPhoneNumbers(Map<String, List<String>> phoneBook) {
        List<Map.Entry<String, List<String>>> sortedPhoneBook = new ArrayList<>(phoneBook.entrySet());
        sortedPhoneBook.sort(Comparator.comparingInt(entry -> entry.getValue().size()));
        Collections.reverse(sortedPhoneBook);
        return sortedPhoneBook;
    }
}


