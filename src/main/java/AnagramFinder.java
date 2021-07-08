import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class AnagramFinder {
    public String[] findAnagramsOf(String[] words) {
        Map<Anagram, String> mapOfWords = new HashMap<>();
        Set<String> setOfAnagrams = new HashSet<>();

        Anagram anagram;
        for(int i = 0; i <words.length; i++ ) {
            anagram = new Anagram(words[i]);

            if(mapOfWords.containsKey(anagram)) {
                setOfAnagrams.add(anagram.getWord());
                setOfAnagrams.add(mapOfWords.get(anagram));
            } else {
                mapOfWords.put(anagram, anagram.getWord());
            }
        }

        return setOfAnagrams.toArray(new String[setOfAnagrams.size()]);
    }
}

class Anagram {
    private String word;

    public Anagram (String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Anagram anagram = (Anagram) o;
        return this.hashCode() == anagram.hashCode();
    }

    @Override
    public int hashCode() {
        int hash = 0;
        char[] letters = word.replaceAll("\\s","").toUpperCase().toCharArray();
        for(int i= 0; i < letters.length; i++) {
            hash = hash + (Character.hashCode(letters[i]));
        }

        return hash;
    }
}

class AnagramFinderTest{

    public static void main(String[] args){
        test1();
    }

    @Test
    public static void  test1(){
        String[] words = new String[] {"eat", "tea", "funeral", "frog", "elvis", "real fun", "lives", "dog", "ate", "ARREAR","RARE"};

        AnagramFinder anagramFinder = new AnagramFinder();
        String[] anagramsFound = anagramFinder.findAnagramsOf(words);

        Arrays.stream(anagramsFound).forEach(System.out::println);
    }
}

