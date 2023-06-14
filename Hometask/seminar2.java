import java.util.Arrays;

public class seminar2 {
    public static void main(String[] args) {
        // Задание 1
        String name = "Ivanov";
        String country = "Russia";
        String city = "Moscow";

        StringBuilder query = new StringBuilder("");
        
        if (name != null) {
            query.append("name = ").append(name).append(",");
        }
        if (country != null) {
            query.append(" country = ").append(country).append(",");
        }
        if (city != null) {
            query.append(" city = ").append(city).append(",");
        }
        
        query.deleteCharAt(query.length() - 1);

        System.out.println(query.toString());


        // Дополнительное задание
        String jsonString = "[{\"surname\":\"Ivanov\",\"estimation\":\"5\",\"object\":\"Mathematics\"}," +
                "{\"surname\":\"Petrova\",\"estimation\":\"4\",\"object\":\"Computer science\"}," +
                "{\"surname\":\"Krasnov\",\"estimation\":\"5\",\"object\":\"Physics\"}]";
                System.out.println("");

        StringBuilder result = new StringBuilder();
        Arrays.stream(jsonString.substring(1, jsonString.length() - 1).split("\\},\\{"))
                .map(entry -> entry.replace("{", "").replace("}", ""))
                .map(entry -> {
                    String[] keyValuePairs = entry.split(",");
                    String surname = keyValuePairs[0].split(":")[1].replace("\"", "");
                    String grade = keyValuePairs[1].split(":")[1].replace("\"", "");
                    String subject = keyValuePairs[2].split(":")[1].replace("\"", "");
                    return "Student " + surname + " received " + grade + " by subject " + subject + ". \n";
                })
                .forEach(result::append);

        System.out.println(result.toString());


        // Сравнение времени выполнения замены символа "а" на "А"
        String longString = generateLongString(1000);
        long startTime = System.nanoTime();
        String modifiedString = longString.replace("a", "A");
        long endTime = System.nanoTime();
        long stringExecutionTime = endTime - startTime;
        System.out.println("Execution time using String: " + stringExecutionTime + " ns");

        startTime = System.nanoTime();
        StringBuilder longStringBuilder = new StringBuilder(longString);
        for (int i = 0; i < longStringBuilder.length(); i++) {
            if (longStringBuilder.charAt(i) == 'a') {
                longStringBuilder.setCharAt(i, 'A');
            }
        }
        modifiedString = longStringBuilder.toString();
        endTime = System.nanoTime();
        long stringBuilderExecutionTime = endTime - startTime;
        System.out.println("Execution time using StringBuilder: " + stringBuilderExecutionTime + " ns");
    }

    private static String generateLongString(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append("a");
        }
        return sb.toString();
    }
}
