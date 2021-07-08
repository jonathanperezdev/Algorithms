import java.util.ArrayList;
import java.util.Arrays;

class SubArraySum {
    static ArrayList<Integer> subArraySum(int[] arr, int n, int s){
        int initPos = 1;
        int endPos = 2;
        int sum= arr[initPos-1];

        while(initPos <= endPos){

            if(sum < s){
                if(endPos >= arr.length+1){
                    return new ArrayList<Integer>(Arrays.asList(-1));
                }
                sum = sum + arr[endPos-1];
                endPos ++;
            }else if(sum > s){
                sum = sum - arr[initPos-1];
                initPos++;
            }else{
                return new ArrayList<Integer>(Arrays.asList(initPos, endPos-1));
            }
        }
        return new ArrayList<Integer>(Arrays.asList(-1));
    }
}





