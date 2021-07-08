import static org.junit.Assert.assertEquals;

class MinimumSwap {
    public int minimumSwaps(int[] q) {
        int j, swaps = 0;

        //Start iterating thought the array, in the firs position should be the number 1, so, get the index of number 1 and swap to the actual position
        for(int i = 0; i < q.length; i++){
            if(i+1 != q[i]){
                j = find(i+1, q);
                swap(i,j,q);
                swaps ++;
            }
        }

        return swaps;
    }

    private int find(int number, int[] q){
        for(int i = 0; i < q.length; i ++){
            if(number == q[i]){
                return i;
            }
        }

        return 0;
    }

    private void swap(int i, int j, int[] q){
        int temp = q[i];
        q[i] = q[j];
        q[j] = temp;
    }
}

class MinimumSwapTest{
    private static MinimumSwap swap = new MinimumSwap();
    private static Integer minimumSwaps;

    public static void main(String[] args){
        test1();
    }

    public static void test1(){
        int[] arr = {7,1,3,2,4,5,6};
        minimumSwaps = swap.minimumSwaps(arr);
        System.out.println(minimumSwaps);

        assertEquals(Integer.valueOf(5), minimumSwaps);
    }
}
