package task3;

import java.util.Arrays;
import java.util.stream.Collectors;

public class NumberArray {
    public static void main(String[] args) {
        String[] inputArray = {"1, 2, 0", "4, 5"};
        String sortedNumbers = sortAndJoinNumbers(inputArray);
        System.out.println(sortedNumbers);
    }
    public static String sortAndJoinNumbers(String[] inputArray) {

        String concatenated = String.join(",", inputArray);

        int[] numbers = Arrays.stream(concatenated.split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(numbers);

        return Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
