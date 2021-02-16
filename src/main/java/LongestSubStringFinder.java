package main.java;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

class LongestSubStringFinder {
    public String findLongestSubStringOf(String word) {
        LinkedList<Character> characters = word.chars().mapToObj(c -> (char) c).collect(Collectors.toCollection(LinkedList::new));
        List<String> subStrings = new ArrayList<>();

        StringBuilder wordFound = new StringBuilder(characters.removeFirst().toString());
        while (!characters.isEmpty()) {
            Character letter = characters.removeFirst();

            if(wordFound.toString().contains(letter.toString())) {
                subStrings.add(wordFound.toString());
                wordFound.setLength(0);
            }

            wordFound.append(letter);
        }

        subStrings.add(wordFound.toString());

        return subStrings.stream().max(Comparator.comparing(String::length)).get();
    }
}

class LongestSubStringFinderTest{
    private static LongestSubStringFinder finder = new LongestSubStringFinder();
    private static String found;

    public static void main(String[] args){
        test1();
        test2();
    }

    public static void test1(){
        found = finder.findLongestSubStringOf("pwwkew");
        System.out.println(found);
        assertEquals("wke", found);
    }

    public static void test2(){
        found = finder.findLongestSubStringOf("abcabcbb");
        System.out.println(found);
        assertEquals("abc", found);
    }
}