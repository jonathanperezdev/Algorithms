import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static org.junit.Assert.assertEquals;

class FirstNonRepeating {
    public String findNonRepeatingCharacterOf(String word){
        String result = null;
        List<String> letters = Arrays.asList(word.split(""))
                .stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());

        Map<String,Long> letterCount = letters.stream().collect(groupingBy(String::toLowerCase, counting()));
        List<String> firstLetters = letterCount
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(1L))
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());

        int firstIndex = letters.size()-1;
        int indexOfLetter;
        for(int index =0; index < firstLetters.size(); index++){
            indexOfLetter = letters.indexOf(firstLetters.get(index).toLowerCase());
            firstIndex = (firstIndex > indexOfLetter) ? indexOfLetter : firstIndex;
        }

        return "Letter "+letters.get(firstIndex)+" index "+firstIndex;
    }
}

class FirstNonRepeatingTest{
    private static FirstNonRepeating firstNonRepeating = new FirstNonRepeating();
    private static String letter;
    public static void main(String[] args){
        test1();
        test2();
    }

    @Test
    public static void test1(){
        letter = firstNonRepeating.findNonRepeatingCharacterOf("polca");
        System.out.println(letter);

        assertEquals("Letter p index 0", letter);
    }

    @Test
    public static void test2(){
        letter = firstNonRepeating.findNonRepeatingCharacterOf("cocolocal");
        System.out.println(letter);

        assertEquals("Letter a index 7", letter);
    }
}
