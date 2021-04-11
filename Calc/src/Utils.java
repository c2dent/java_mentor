enum RomeNumbers {
    I(1), II(2), III(3), IV(4), V(5), VI(6), VII(7), VIII(8), IX(9), X(10), XX(20), XXX(30), XL(40), L(50), LX(60),
    LXX(70), LXXX(80), XC(90), C(100);
    private Integer num;
    RomeNumbers(Integer num) { this.num = num; }
    public Integer getNum() { return num;}
}

public class Utils {

    public static boolean isNumeric(String str)
    {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    public static boolean isRomeNumeric(String str) {
        return "I II III IIV IV V VI VII VIII IX X".contains(str);
    }

    public static String getOperation(String str) {
        char[] chars = str.toCharArray();
        for (char c: chars) {
            if (c == "+".charAt(0) || c == "-".charAt(0) || c == "/".charAt(0) || c == "*".charAt(0))
                return String.valueOf(c);
        }
        return null;
    }

    public static Integer convertNumRomeToArab(String str) throws IncorrectDataException {
        switch (str) {
            case "I":
                return 1;
            case "II":
                return 2;
            case "III":
                return 3;
            case "IV":
                return 4;
            case "V":
                return 5;
            case "VI":
                return 6;
            case "VII":
                return 7;
            case "VIII":
                return 8;
            case "IX":
                return 9;
            case "X":
                return 10;
            default:
                throw new IncorrectDataException();
        }
    }

    public static String getRomeNumber(int n) {
        RomeNumbers[] arrNum = RomeNumbers.values();
        for(RomeNumbers rm: arrNum) {
            if (n == rm.getNum()) {
                return rm.toString();
            }
        }
        return null;
    }


    public static String convertNumArabToRome(int n) {
        if (n > 10 && (n % 10) != 0) {
            return getRomeNumber((n/10) * 10) + "" + getRomeNumber(n%10);
        }
        return getRomeNumber(n);
    }
}
