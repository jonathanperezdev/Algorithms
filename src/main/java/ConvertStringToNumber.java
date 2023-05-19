import java.util.ArrayList;
import java.util.List;

public class ConvertStringToNumber {
    private List<Integer> convertFrom(String stringNumber){
        String[] numberSplitted = stringNumber.split(",");
        List<Integer> result = new ArrayList<>();
        String[] range;
        for(String number: numberSplitted){
            number = number.trim();
            try {
                result.add(Integer.parseInt(number));
            }catch (NumberFormatException ex){
                range = number.split("-");
                for(int i = numberOf(range[0]); i <= numberOf(range[1]); i++){
                    result.add(i);
                }
            }
        }

        return result;
    }

    private Integer numberOf(String number){
        return Integer.parseInt(number);
    }

    public static void main(String[] args){
        ConvertStringToNumber convert = new ConvertStringToNumber();
        convert.testCase1();
    }

    private void testCase1(){
        List<Integer> result = convertFrom("1, 3-5, 9");
        result.stream().forEach(System.out::println);
    }
}
