package easy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class FindElementArray {
    // Complete the minimumBribes function below.
    static int findElement(List<Integer> ar, Integer elementToFind) {
        return ar.stream()
                .filter(e -> e.equals(elementToFind))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static void main(String args[]){
        Integer element = findElement(Stream.of(1,2,4,7,9,10,15,23,45)
                .collect(Collectors.toList()), 45);
        System.out.println("Your element "+element);
    }
}

