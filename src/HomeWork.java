import java.util.List;
import java.util.stream.Collectors;

public class HomeWork {

    public static <T> List<T> deleteDuplicates(List<T> list) {
        List<T> res = list.stream()
                .distinct()
                .collect(Collectors.toList());
        return res;
    }

    public static long count(List<String> list, char c) {
        long res = list.stream()
                .filter(s -> s.charAt(0) == c)
                .count();
        return res;
    }

    public static int secondGrand(List<Integer> list) {
        int res = list.stream()
                .sorted((i1, i2) -> i2 - i1)
                .skip(1)
                .findFirst().get();
        return res;
    }

    public static void main(String[] args) {
        System.out.println(deleteDuplicates(List.of(1, 2, 3, 3, 4, 1, 5)));
        System.out.println(count(List.of("apple", "bat", "circle", "ball"), 'b'));
        System.out.println(secondGrand(List.of(1, 2, 8, 9, 6)));
    }

}

