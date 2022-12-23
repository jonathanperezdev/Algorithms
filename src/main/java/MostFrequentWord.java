import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static org.junit.Assert.assertEquals;

class MostFrequentWord {
    public String getMostFrequentWord(String sentence) {
        Stream<String> words = Arrays.stream(sentence.split(" "));

        String mostFrequentWord;

        Map<String, Long> wordTimes = words.collect(groupingBy(Function.identity(), counting()));
        wordTimes.entrySet().stream().filter(entry -> entry.getValue().equals(entry.getKey())).findAny().get().getValue();

        return wordTimes.entrySet().stream().max(Comparator.comparingLong(Map.Entry::getValue)).map(Map.Entry::getKey).get();

    }
}

class MostFrequentWordTest {

    public static void main(String[] args){
        test1();
    }

    @Test
    public static void test1(){
        String sentence = "El papa de mi papa no es mi papa mi";
        MostFrequentWord numberOfWords = new MostFrequentWord();

        String word = numberOfWords.getMostFrequentWord(sentence);

        assertEquals("papa", word);
    }

}
