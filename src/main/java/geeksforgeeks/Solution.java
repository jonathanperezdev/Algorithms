package geeksforgeeks;

class Solution{

    public static void main(String[] args){
        System.out.println(round((float) 1/3, 6));
    }

    private static Float round(Float number, int decimlas) {
        double roundFactor = Math.pow(10, decimlas);
        return Double.valueOf
                        (Math.round((double) number * roundFactor) / roundFactor)
                .floatValue();
    }

}