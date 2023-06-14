import java.util.Arrays;
import java.util.Random;

public class seminar1 {
    public static void main(String[] args) {
        Random random = new Random();
        int i = random.nextInt(2001);
        System.out.println("\nRandom number i = " + i);

        int n = findMostSignificantBit(i);
        System.out.println("\nThe number of the most significant bit n = " + n);

        int[] m1 = findMultiples(i, n);
        System.out.println("\nArray m1 (multiples ranging from " + i + " to " + Short.MAX_VALUE + "):");
        printArray(m1, 5);

        int[] m2 = findNonMultiples(Short.MIN_VALUE, i, n);
        System.out.println("Array m2 (non-multiple numbers in the range from " + Short.MIN_VALUE + " to " + i + "):");
        printArray(m2, 5);
    }

    public static int findMostSignificantBit(int num) {
        int n = 0;
        while (num != 0) {
            num = num >> 1;
            n++;
        }
        return n - 1;
    }

    public static int[] findMultiples(int i, int n) {
        int count = 0;
        for (int j = i; j <= Short.MAX_VALUE; j++) {
            if (j % n == 0) {
                count++;
            }
        }

        int[] m1 = new int[count];
        int index = 0;
        for (int j = i; j <= Short.MAX_VALUE; j++) {
            if (j % n == 0) {
                m1[index] = j;
                index++;
            }
        }

        return m1;
    }

    public static int[] findNonMultiples(int start, int i, int n) {
        int count = 0;
        for (int j = start; j < i; j++) {
            if (j % n != 0) {
                count++;
            }
        }

        int[] m2 = new int[count];
        int index = 0;
        for (int j = start; j < i; j++) {
            if (j % n != 0) {
                m2[index] = j;
                index++;
            }
        }

        return m2;
    }

    public static void printArray(int[] arr, int splitSize) {
        int[] firstValues = Arrays.copyOfRange(arr, 0, splitSize);
        int[] lastValues = Arrays.copyOfRange(arr, arr.length - splitSize, arr.length);

        System.out.println("The first " + splitSize + " values of the array: " + Arrays.toString(firstValues));
        System.out.println("The last " + splitSize + " values of the array: " + Arrays.toString(lastValues));
        System.out.println("");
    }
}
