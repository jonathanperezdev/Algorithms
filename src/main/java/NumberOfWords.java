package main.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.reducing;
import static org.junit.Assert.assertEquals;

class NumberOfWords {
    public Map<String, Long> getNumberOfWords(String sentence) {
        Stream<String> words = Arrays.stream(sentence.split(" "));

        Map<String, Long> freq = words.collect(
                //GroupBy is a function that allow you create a map grouping by a value that is the first parameter
                groupingBy(String::toUpperCase,
                        //Once the groups are formed, reduce allow apply a reducer operation in this case is count the times of a word
                        reducing(0L,//Defines the initial value of the count an the default value to return
                                w -> 1L,//Function receive a String and return one long
                                Long::sum)//BinaryOperator receive two values and return one all of them of the same type
                ));
        //You can replace reduce to Collector.counting();
        return freq;
    }
}

class NumberOfWordsTest {

    public static void main(String[] args){
        test1();
    }

    @Test
    public static void test1(){
        String sentence = "El papa de mi papa no es mi papa";
        NumberOfWords numberOfWords = new NumberOfWords();

        Map<String, Long> words = numberOfWords.getNumberOfWords(sentence);

        words.entrySet().forEach(entry -> System.out.println(entry.getKey()+": "+entry.getValue()));

        assertEquals(Long.valueOf(3), words.get("PAPA"));
    }

}
