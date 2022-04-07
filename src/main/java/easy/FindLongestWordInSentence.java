package easy;

import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingLong;

public class FindLongestWordInSentence {
    public static void main(String[] args){
        /* This is solved cause groupingBy return Map<String, List<String>>, so if you want have Map<String,Long>, you should apply any reduce over that list
           counting does not work, cause it count the word's times, so, you have to use summingLong to reduce*/
        Map<String, Long> wordsByLength = Stream.of("Time Time to drink a cup of coffee".split("\\s+"))
                .distinct()
                .collect(groupingBy(Function.identity(), summingLong(w -> w.length())));

        wordsByLength.entrySet().stream().max((Comparator.comparingLong(e -> e.getValue()))).ifPresent(System.out::println);
    }
}
