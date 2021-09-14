package easy;

import java.util.List;

class SumNumbersArray {
    // Complete the minimumBribes function below.
    static int simpleArraySum(List<Integer> ar) {
        return ar.stream().reduce(Integer::sum).orElse(0);
    }
}

