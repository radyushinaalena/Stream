import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> someList = Arrays.asList(1, 2, 3, 4, -77, 6, 0, 9, 40);
        Stream<Integer> someList2 = someList.stream();
        findMinMax(someList2,
                Integer::compareTo,
                (x, y) -> System.out.println("Мин: " + x + " Макс: " + y));
        System.out.println(findEvenNumbers(someList));
    }

    public static <T> void findMinMax(Stream<? extends T> stream,
                                      Comparator<? super T> order,
                                      BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<T> number = stream
                .sorted(order)
                .collect(Collectors.toList());

        if (!number.isEmpty()) {
            minMaxConsumer.accept(number.get(0), number.get(number.size() - 1));
        } else {
            minMaxConsumer.accept(null, null);
        }
    }

    public static String findEvenNumbers(List<Integer> numbers) {
        List<Integer> sortedNumbers = numbers.stream()
                .filter(number -> (number % 2 == 0) && (number != 0))
                .collect(Collectors.toList());
        String list = "Количество четных чисел: " + sortedNumbers.size() + ". Список четных чисел: " + sortedNumbers;
        return list;
    }
}