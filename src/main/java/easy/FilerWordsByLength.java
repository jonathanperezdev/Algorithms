package easy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilerWordsByLength {
    public static void main(String args[]){
        System.out.println(filterByLength("Hola como estas para esta prueba"));
    }

    static String filterByLength(String phrase){
        return Stream.of(phrase.split("\\s+"))
                .filter(w -> w.length() > 4)
                .map(String::toUpperCase)
                .collect(Collectors.joining(" "));
    }
}
