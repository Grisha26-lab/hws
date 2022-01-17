package first_task;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamMain {
    public static void main(String[] args) {

        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        intList.stream()
                .filter(s -> s > 0 && s % 2 == 0)
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::print);
    }
}
