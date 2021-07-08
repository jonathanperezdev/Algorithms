import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertEquals;

class GroupsOfKnown {
    public int findNumGroups(List<int[]> knownArrays){
        List<Set<Integer>> groups = new ArrayList<>();
        Optional<Set<Integer>> optGroup;
        for(int[] knownArray : knownArrays){
            Set<Integer> group = getKnownPeopleOf(knownArray);
            optGroup = groups.stream().filter(g -> !Collections.disjoint(g, group)).findFirst();
            if(optGroup.isPresent()){
                optGroup.get().addAll(group);
            }else{
                groups.add(group);
            }
        }
        return groups.size();
    }

    private Set<Integer> getKnownPeopleOf(int[] knownArray){
        Set<Integer> knowPeople = new HashSet<>();
        for(int i=0; i < knownArray.length; i++){
            if(knownArray[i] == 1){
                knowPeople.add(i);
            }
        }

        return knowPeople;
    }
}

class GroupsOfKnownTest{

    public static void main(String[] args){
        test1();
        test2();
    }

    public static void test1(){
        List<int[]> input = new ArrayList<>();
        input.add(new int[]{1,1,0,0});
        input.add(new int[]{1,1,1,0});
        input.add(new int[]{0,1,1,0});
        input.add(new int[]{0,0,0,1});

        GroupsOfKnown groupsOfKnown = new GroupsOfKnown();
        Integer groups = groupsOfKnown.findNumGroups(input);

        assertEquals(Integer.valueOf(2), groups);
    }

    public static void test2(){
        List<int[]> input = new ArrayList<>();
        input.add(new int[]{1,0,0,0,0,0,1,0,0,0});
        input.add(new int[]{0,1,0,0,0,1,0,0,0,1});
        input.add(new int[]{0,0,1,0,1,0,0,0,0,0});
        input.add(new int[]{0,0,0,1,0,0,0,0,0,0});
        input.add(new int[]{0,0,1,0,1,0,0,0,0,0});
        input.add(new int[]{0,1,0,0,0,1,0,0,0,0});
        input.add(new int[]{1,0,0,0,0,0,1,0,0,0});
        input.add(new int[]{0,0,0,0,0,0,0,1,0,0});
        input.add(new int[]{0,0,0,0,0,0,0,0,1,0});
        input.add(new int[]{0,1,0,0,0,0,0,0,0,1});

        GroupsOfKnown groupsOfKnown = new GroupsOfKnown();
        Integer groups = groupsOfKnown.findNumGroups(input);

        assertEquals(Integer.valueOf(6), groups);
    }
}





