package hackerrank;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

class MaxTrailingOpt {
    public static int maxTrailing(List<Integer> levels){
        int max, min, maximumTrailing = -1, difference;
        List<Integer> subLevels;

        while(levels.size() > 1){
            max = Collections.max(levels);
            subLevels = new ArrayList<>(levels.subList(0, levels.indexOf(max)+1));
            levels.subList(0, levels.indexOf(max)+1).clear();
            if(subLevels.size() == 1){
                break;
            }

            min = Collections.min(subLevels);
            difference = (max==min) ? -1 : max - min;
            if(difference > maximumTrailing) {
                maximumTrailing = difference;
            }
        }

        return maximumTrailing;
    }
}

class MaxTrailingoptTest{

    public static void main(String[] args){
        test1();
    }

    @Test
    public static void  test1() {
        assertEquals(4, MaxTrailingOpt.maxTrailing(new ArrayList<>(Arrays.asList(5, 3, 6, 7, 4))));
        assertEquals(-1, MaxTrailingOpt.maxTrailing(new ArrayList<>(Arrays.asList(4,3,2,1))));
        assertEquals(8, MaxTrailingOpt.maxTrailing(new ArrayList<>(Arrays.asList(2,3,10,2,4,8,1))));
        assertEquals(2, MaxTrailingOpt.maxTrailing(new ArrayList<>(Arrays.asList(7,9,5,6,3,2))));
        assertEquals(3, MaxTrailingOpt.maxTrailing(new ArrayList<>(Arrays.asList(-5,-3,-2))));
        assertEquals(14, MaxTrailingOpt.maxTrailing(new ArrayList<>(Arrays.asList(20,25,10,15,24))));
        assertEquals(-1, MaxTrailingOpt.maxTrailing(new ArrayList<>(Arrays.asList(10,8,7,6,5))));
    }
}
