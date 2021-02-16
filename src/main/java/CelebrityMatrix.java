package main.java;

import org.junit.Test;

import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

class CelebrityMatrix{

    public String findCelebrity(int[][] partyMatrix) {
        Queue<Integer> possibleCelebrities = new PriorityQueue<>();

        int rows = partyMatrix.length;
        Integer personA;
        Integer personB;
        Integer celebrity = null;

        //Fill the queue with all possible celebrities
        for(int row = 0; row < rows; row ++){
            possibleCelebrities.add(row);
        }

        //Ask if personA knows personB, means personB could be a celebrity, personA is discarded, cause everybody know to a celebrity
        //if personA does not know personB, means personA could be a celebrity, personB is discarded, cause celebrity does not know anybody
        while(!possibleCelebrities.isEmpty()){
            personA = possibleCelebrities.poll();
            personB = possibleCelebrities.poll();

            if(personB == null){
                celebrity = personA;
                break;
            }

            if(isKnown(personA, personB, partyMatrix)){
                possibleCelebrities.add(personB);
            } else {
                possibleCelebrities.add(personA);
            }
        }

        //The only thing to validate is, celebrity is known by everybody and does not know anybody
        for (int row =0; row < rows; row ++){
            if(celebrity != row
                    && (isKnown(celebrity, row, partyMatrix)
                    || !isKnown(row,celebrity, partyMatrix))){
                celebrity = null;
                break;
            }
        }

        return Optional.ofNullable(celebrity).isPresent() ? "your celebrity is "+ celebrity : "No celebrity found";
    }

    private boolean isKnown(int personA, int personB, int[][] partyMatrix){
        return partyMatrix[personA][personB] == 1 ? true : false;
    }
}

class CelebrityMatrixTest{
    private static CelebrityMatrix celeb = new CelebrityMatrix();
    private static String celebResult;

    public static void main(String[] args){
        celebrityExist();
        celebrityNotExist();
    }

    @Test
    public static void  celebrityExist() {
        int[][] partyMatrix =
                {{0, 0, 1, 0},
                 {0, 0, 1, 0},
                 {0, 0, 1, 0},
                 {0, 0, 1, 0}};

        String celebResult = celeb.findCelebrity(partyMatrix);
        System.out.println(celebResult);

        assertEquals("your celebrity is 2", celebResult);

    }

     public static void celebrityNotExist() {
            int[][] partyMatrix =
                    { {0, 0, 1, 0},
                      {0, 0, 1, 0},
                      {0, 1, 0, 0},
                      {0, 0, 1, 0} };
         String celebResult = celeb.findCelebrity(partyMatrix);
         System.out.println(celebResult);
    }
}