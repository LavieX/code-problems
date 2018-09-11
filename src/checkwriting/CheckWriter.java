package checkwriting;

public class CheckWriter {

    //@formatter:off
    private static String[] ones = {"",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
            "ten",
            "eleven",
            "twelve",
            "thirdeen",
            "fourteen",
            "fifteen",
            "sixteen",
            "seventeen",
            "eighteen",
            "nineteen"};
    
    private static String[] tens = {"", "",
            "twenty",
            "thirty",
            "forty",
            "fifty",
            "sixty",
            "seventy",
            "eighty",
            "ninety",
            "hundred"};
    
    private static String[] powerStrings = {"",
            "thousand",
            "million",
            "billion"};
    //@formatter:on

    public static String convertToString(String number) {
        return convertToString(0, number);
    }
    
    public static String convertToString(int power, String number) {
        StringBuilder sb = new StringBuilder();
        if(number.contains(",")) {
            sb.append(convertToString(power + 1,number.substring(0 , number.length() - 4))).append(" ");
            number = number.substring(number.length() - 3);
        }
                
        int part = Integer.parseInt(number);
        
        if (part / 100 > 0) {
            sb.append(ones[part / 100]).append(" ").append(tens[10]).append(" ");
        }

        part = part % 100;
        
        if (part < 20) {
            sb.append(ones[part]).append(" ");
        } else {
            sb.append(tens[part / 10]).append(" ").append(ones[part % 10]).append(" ");
        }
        
        sb.append(powerStrings[power]);

        String s = sb.toString().replace("  ", " ").trim();
        System.out.println("Result for " + number + " is \"" + s + "\"");
        return s;
    }
}