package hackerrank;

import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;
import static org.junit.Assert.assertEquals;

class SherlockValidString {
    public static String isValid(String s) {
        //get by letter how many times are present
        Map<String, Integer> timesOfLetters =  Stream.of(s.split(""))
                .collect(groupingBy(Function.identity(), collectingAndThen(counting(), Long::intValue)));

        List<Integer> times = timesOfLetters
                .values()
                .stream()
                .collect(toList());

        //Get the most repeated value and remove it to leave just the letters repeated less
        int mostRepeatedValue = getMostRepeatedValue(times);
        times.removeIf(t -> t.equals(mostRepeatedValue));

        //all letters are repeated same times
        if(times.isEmpty())
            return "YES";
        //Exist more than one letter repeated different of the most repeated letter, so, you have to delete more than one letter
        else if(times.size() > 1)
            return "NO";
        //If exist just one letter I can delete and get valid string
        else if(times.get(0)==1)
            return "YES";
        //Exist just one letter if, I delete une time that letter and is equals to the most repeated is valid
        else if (times.get(0)-mostRepeatedValue == 1)
            return "YES";
        else
            return "NO";
    }

    private static Integer getMostRepeatedValue(List<Integer> times){
        Map<Integer, Integer> repeatedTimes =
                times
                        .stream()
                        .collect(groupingBy(Function.identity(), collectingAndThen(counting(), Long::intValue)));

        return Collections.max(repeatedTimes.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
    }
}

class SherlockValidStringTest{

    public static void main(String[] args){
        test1();
    }

    @Test
    public static void  test1(){
        assertEquals("YES", SherlockValidString.isValid("abc"));
        assertEquals("YES", SherlockValidString.isValid("abcc"));
        assertEquals("NO", SherlockValidString.isValid("abccc"));
        assertEquals("NO", SherlockValidString.isValid("aabbcd"));
        assertEquals("NO", SherlockValidString.isValid("aabbccddeefghi"));
        assertEquals("YES", SherlockValidString.isValid("abcdefghhgfedecba"));
        assertEquals("YES", SherlockValidString.isValid("aabbc"));
        assertEquals("YES", SherlockValidString.isValid("a"));
        assertEquals("YES", SherlockValidString.isValid("ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd"));
    }
}
