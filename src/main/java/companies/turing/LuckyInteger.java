package companies.turing;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.function.Function;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class LuckyInteger {
    public static void main(String args[]){
        System.out.println(findLuckyNumbers(new Integer[]{2,2,3,4}));
        System.out.println(findLuckyNumbers(new Integer[]{1,2,2,3,3,3}));
        System.out.println(findLuckyNumbers(new Integer[]{2,2,2,3,3}));

        System.out.println(findLuckyNumbersNoStreams(new Integer[]{2,2,3,4}));
        System.out.println(findLuckyNumbersNoStreams(new Integer[]{1,2,2,3,3,3}));
        System.out.println(findLuckyNumbersNoStreams(new Integer[]{2,2,2,3,3}));

    }

    public static Integer findLuckyNumbers(Integer[] numbers){
        Map<Integer, Long> numberTimes = Arrays.stream(numbers).collect(groupingBy(Function.identity(), counting()));

        Integer result = numberTimes.entrySet().stream()
                .filter(entry -> entry.getValue().intValue() == entry.getKey())
                .map(Map.Entry::getKey).collect(collectingAndThen(counting(), Long::intValue));

        return (result==0)? -1:result;
    }

    public static Integer findLuckyNumbersNoStreams(Integer[] numbers){
        TreeMap<Integer, Integer> numberTimes = new TreeMap<>(Comparator.reverseOrder());

        Integer result = -1;
        for(Integer number : numbers){
            if(Objects.nonNull(numberTimes.get(number))){
                numberTimes.put(number, numberTimes.get(number)+1);
            }else{
                numberTimes.put(number, 1);
            }
        }


        Map.Entry<Integer, Integer> entry = numberTimes.pollFirstEntry();
        while(Objects.nonNull(entry)){
            if(entry.getKey().equals(entry.getValue())){
                result = entry.getValue();
                break;
            }
            entry = numberTimes.pollFirstEntry();
        }

        return result;
    }
}
