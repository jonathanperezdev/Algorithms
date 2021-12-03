import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.*;


public class SockMerchant {
    public static int sockMerchant(int n, List<Integer> ar) {
        Map<Integer, Long> socksTimes = ar.stream()
                .collect(groupingBy(Function.identity(), counting()));

        return socksTimes.values().stream()
                .map(v -> v/2).collect(summingInt(Math::toIntExact));
    }
}
