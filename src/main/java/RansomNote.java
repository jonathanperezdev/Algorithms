import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static org.junit.Assert.*;

class RansomNote {
    Map<String, Long> noteWords = new HashMap<>();
    Map<String, Long> magazineWords = new HashMap<>();

    boolean isRansomNote(String note, String magazine){
        boolean result = true;
        noteWords = Stream.of(note.split("\\s+"))
                .collect(groupingBy(Function.identity(), counting()));

        magazineWords = Stream.of(magazine.split("\\s+"))
                .collect(groupingBy(Function.identity(), counting()));

        Long timesOfWord;
        for (Map.Entry<String,Long> entry : noteWords.entrySet()){

            timesOfWord = magazineWords.get(entry.getKey());
            if( timesOfWord != null && timesOfWord < entry.getValue()){
                result = false;
                break;
            }
        }

        return result;
    }
}

class RansomNoteTest{
    public static void main(String[] args){
        test1();
        test2();
    }

    @Test
    public static void test1(){
        RansomNote ransomNote = new RansomNote();
        boolean result = ransomNote.isRansomNote("perro es muy perro asi","perro es gatos loco muy perros perro perro asi");
        assertTrue(result);
    }

    @Test
    public static void test2(){
        RansomNote ransomNote = new RansomNote();
        boolean result = ransomNote.isRansomNote("el gato esta gato como gato que es","gato que es loco el como esta gato");
        assertFalse(result);
    }
}
