import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Stop_Word_Filtered_Frequency {

    static void printFilteredWordFrequency(String feedback) {

        // Convert to lowercase
        feedback = feedback.toLowerCase();

        // Remove punctuation
        feedback = feedback.replace(".", "");
        feedback = feedback.replace(",", "");

        // Stop words
        HashSet<String> stopWords = new HashSet<>();

        stopWords.add("the");
        stopWords.add("was");
        stopWords.add("and");
        stopWords.add("a");
        stopWords.add("is");
        stopWords.add("of");
        stopWords.add("in");

        // Split into words
        String[] words = feedback.split("\\s+");

        // Store frequency
        HashMap<String, Integer> frequency = new HashMap<>();

        for (String word : words) {

            if (!stopWords.contains(word) && !word.isEmpty()) {

                if (frequency.containsKey(word)) {
                    frequency.put(word, frequency.get(word) + 1);
                } else {
                    frequency.put(word, 1);
                }
            }
        }

        // Convert map entries into a list
        List<Map.Entry<String, Integer>> list =
                new ArrayList<>(frequency.entrySet());

        // Sort by frequency in descending order
        Collections.sort(list,
            new Comparator<Map.Entry<String, Integer>>() {

                public int compare(
                        Map.Entry<String, Integer> a,
                        Map.Entry<String, Integer> b) {

                    return b.getValue().compareTo(a.getValue());
                }
            });

        // Print results
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(
                entry.getKey() + ": " + entry.getValue()
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter feedback paragraph:");
        String feedback = sc.nextLine();

        printFilteredWordFrequency(feedback);

        sc.close();
    }
}