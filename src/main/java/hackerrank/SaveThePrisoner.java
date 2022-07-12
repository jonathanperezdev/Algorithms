package hackerrank;

import org.junit.Test;

class Result {
    public static int saveThePrisoner(int n, int m, int s) {
        return (((s - 1 + m - 1) % n) + 1);
    }
}

class TestResult{

    public static void main(String[] args){
        test1();
    }

    @Test
    public static void  test1(){
        System.out.println(Result.saveThePrisoner(8, 863472675, 5));
    }
}

