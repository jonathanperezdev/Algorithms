package hackerrank;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toCollection;
import static org.junit.Assert.assertEquals;

class MaxTrailing {
    public static int maxTrailing(List<Integer> levels){

        int maximumTrailingRecord = -1;
        Integer lastReading = 0;
        Integer difference;
        List<Integer> levelsIterate;

        while(levels.size() > 1) {

            lastReading = levels.remove(levels.size()-1);
            Integer finalLastReading = lastReading;
            levelsIterate = levels.stream().filter(l-> l < finalLastReading).collect(Collectors.toList());
            for (Integer reading : levelsIterate) {
                difference = lastReading - reading;
                if (difference > maximumTrailingRecord) {
                    maximumTrailingRecord = difference;
                }
            }
        }

        return maximumTrailingRecord;
    }
}

class MaxTrailingTest{

    public static void main(String[] args){
        test1();
    }

    @Test
    public static void  test1() {
        assertEquals(4, MaxTrailing.maxTrailing(new ArrayList<>(Arrays.asList(5, 3, 6, 7, 4))));
        assertEquals(-1, MaxTrailing.maxTrailing(new ArrayList<>(Arrays.asList(4,3,2,1))));
        assertEquals(8, MaxTrailing.maxTrailing(new ArrayList<>(Arrays.asList(2,3,10,2,4,8,1))));
        assertEquals(2, MaxTrailing.maxTrailing(new ArrayList<>(Arrays.asList(7,9,5,6,3,2))));
        assertEquals(3, MaxTrailing.maxTrailing(new ArrayList<>(Arrays.asList(-5,-3,-2))));
    }
}
