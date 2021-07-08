import static org.junit.Assert.assertEquals;

class NewYearChaos {
    // Complete the minimumBribes function below.
    static int minimumBribes(int[] q) {
        int swaps, actualPosition, minimumBribes = 0;
        try{
            for(int originalPosition = q.length ; originalPosition > 0; originalPosition --){
                actualPosition = findActualPosition(originalPosition, q);
                swaps = originalPosition - actualPosition;
                if(swaps > 2)
                    throw new IllegalStateException();
                else if(swaps > 0)
                    swapElement(actualPosition, swaps, q);
                minimumBribes = minimumBribes + swaps;
            }
        }catch(IllegalStateException ex){
            System.out.println("Too chaotic");
            throw ex;
        }
        return minimumBribes;
    }

    static void swapElement(int actualPosition, int times, int[] q){
        int temp;
        for(int i = actualPosition-1; i < actualPosition-1 + times; i ++){
            temp = q[i];
            q[i] = q[i+1];
            q[i+1] = temp;
        }
    }

    static int findActualPosition(int originalPosition, int[] q){
        for(int i = q.length-1; i >= 0; i --){
            if(q[i] == originalPosition){
                return i+1;
            }
        }
        return 1;
    }
}

class NewYearChaosTest{
    private static NewYearChaos newYearChaos = new NewYearChaos();
    private static Integer minimumBribes =0;

    public static void main(String[] args){
        test1();
        test2();
    }

    public static void test1(){
        int[] q = {2,1,5,3,4};
        minimumBribes = newYearChaos.minimumBribes(q);
        System.out.println(minimumBribes);

        assertEquals(Integer.valueOf(3), minimumBribes);
    }

    public static void test2(){
        int[] q = {1,2,5,3,7,8,6,4};
        minimumBribes = newYearChaos.minimumBribes(q);
        System.out.println(minimumBribes);

        assertEquals(Integer.valueOf(7), minimumBribes);
    }
}
