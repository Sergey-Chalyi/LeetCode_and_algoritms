package LeetCode_Solved.MEDIUM;
//26-05-24
public class M_IntegerToRoman_12 {
    public String intToRoman(int number) {
        String romanInteger = "";

        String numberString = number + "";
        int numberLength = numberString.length();
        int countOfIterations = numberLength;

        for (int i = 1; i <= countOfIterations; i++) {
            String figure = numberString.charAt(numberLength - i) + "";

            if (figure.equals("0")) continue;
            if (i == 1) { //еденицы
                switch (Integer.parseInt(figure)) {
                    case 1:
                        romanInteger += "I";
                        break;
                    case 2:
                        romanInteger += "II";
                        break;
                    case 3:
                        romanInteger += "III";
                        break;
                    case 4:
                        romanInteger += "IV";
                        break;
                    case 5:
                        romanInteger += "V";
                        break;
                    case 6:
                        romanInteger += "VI";
                        break;
                    case 7:
                        romanInteger += "VII";
                        break;
                    case 8:
                        romanInteger += "VIII";
                        break;
                    case 9:
                        romanInteger += "IX";
                        break;
                }
            } else if (i == 2) { //десятки
                switch (Integer.parseInt(figure)) {
                    case 1:
                        romanInteger = "X" + romanInteger;
                        break;
                    case 2:
                        romanInteger = "XX" + romanInteger;
                        break;
                    case 3:
                        romanInteger = "XXX" + romanInteger;
                        break;
                    case 4:
                        romanInteger = "XL" + romanInteger;
                        break;
                    case 5:
                        romanInteger = "L" + romanInteger;
                        break;
                    case 6:
                        romanInteger = "LX" + romanInteger;
                        break;
                    case 7:
                        romanInteger = "LXX" + romanInteger;
                        break;
                    case 8:
                        romanInteger = "LXXX" + romanInteger;
                        break;
                    case 9:
                        romanInteger = "XC" + romanInteger;
                        break;
                }
            } else if (i == 3) { // сотни
                switch (Integer.parseInt(figure)) {
                    case 1:
                        romanInteger = "C" + romanInteger;
                        break;
                    case 2:
                        romanInteger = "CC" + romanInteger;
                        break;
                    case 3:
                        romanInteger = "CCC" + romanInteger;
                        break;
                    case 4:
                        romanInteger = "CD" + romanInteger;
                        break;
                    case 5:
                        romanInteger = "D" + romanInteger;
                        break;
                    case 6:
                        romanInteger = "DC" + romanInteger;
                        break;
                    case 7:
                        romanInteger = "DCC" + romanInteger;
                        break;
                    case 8:
                        romanInteger = "DCCC" + romanInteger;
                        break;
                    case 9:
                        romanInteger = "CM" + romanInteger;
                        break;
                }
            } else if (i == 4) { // тысячи
                int countOfIterationsForThousands = Integer.parseInt(numberString.substring(0, numberString.length() - 3));
                for (/**/; countOfIterationsForThousands > 0; countOfIterationsForThousands--) {
                    romanInteger = "M" + romanInteger;
                }
                break;
            }
        }
        return romanInteger;
    }

    public static void main(String[] args) {
        System.out.println(new M_IntegerToRoman_12().intToRoman(119));
    }
}
