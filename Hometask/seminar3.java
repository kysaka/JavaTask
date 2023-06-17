import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class seminar3 {
    public static void main(String[] args) {
        // Генерация случайного списка целых чисел
        List<Integer> numbers = generateRandomNumbers(10);
        System.out.println("The original list of numbers: " + numbers);

        // Удаление четных чисел
        removeEvenNumbers(numbers);
        System.out.println("List after removing even numbers: " + numbers);

        // Нахождение минимального значения
        int minValue = findMinValue(numbers);
        System.out.println("Minimum value: " + minValue);

        // Нахождение максимального значения
        int maxValue = findMaxValue(numbers);
        System.out.println("Maximum value: " + maxValue);

        // Нахождение среднего значения
        double averageValue = findAverageValue(numbers);
        System.out.println("Average value: " + averageValue);
    }

    private static List<Integer> generateRandomNumbers(int count) {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            numbers.add(random.nextInt(100));
        }
        return numbers;
    }

    private static void removeEvenNumbers(List<Integer> numbers) {
        numbers.removeIf(num -> num % 2 == 0);
    }

    private static int findMinValue(List<Integer> numbers) {
        int minValue = Integer.MAX_VALUE;
        for (int num : numbers) {
            if (num < minValue) {
                minValue = num;
            }
        }
        return minValue;
    }

    private static int findMaxValue(List<Integer> numbers) {
        int maxValue = Integer.MIN_VALUE;
        for (int num : numbers) {
            if (num > maxValue) {
                maxValue = num;
            }
        }
        return maxValue;
    }

    private static double findAverageValue(List<Integer> numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return (double) sum / numbers.size();
    }
}

