package easy;

import java.util.stream.Stream;

public class FindLastElement {
    public static void main(String[] args){
        Stream.of("Time to drink a cup of coffee".split("\\s+"))
                .reduce((first,second) -> second)
                .ifPresent(System.out::println);
    }
}
