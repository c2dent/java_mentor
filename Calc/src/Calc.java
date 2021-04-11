public class Calc {
    private int fArgument;
    private int sArgument;
    private String operation;
    private Boolean isRomeNumber = false;

    private void checkAndInitData(String str) throws IncorrectDataException {
        String[] arrStr = str.trim().split("[-+*/]");
        arrStr[0] = arrStr[0].trim();
        arrStr[1] = arrStr[1].trim();

        if (arrStr.length == 2) {
            if (Utils.isNumeric(arrStr[0]) && Utils.isNumeric(arrStr[1])) {
                if (Integer.parseInt(arrStr[0]) > 0 && Integer.parseInt(arrStr[0]) < 11 && Integer.parseInt(arrStr[1]) > 0 && Integer.parseInt(arrStr[1]) < 11) {
                    fArgument = Integer.parseInt(arrStr[0]);
                    sArgument = Integer.parseInt(arrStr[1]);
                } else {
                    throw new IncorrectDataException();
                }
            } else if (Utils.isRomeNumeric(arrStr[0]) && Utils.isRomeNumeric(arrStr[1])){
                isRomeNumber = true;
                fArgument = Utils.convertNumRomeToArab(arrStr[0]);
                sArgument = Utils.convertNumRomeToArab(arrStr[1]);
            } else {
                throw new IncorrectDataException();
            }
        } else {
            throw new IncorrectDataException();
        }
        operation = Utils.getOperation(str);
    }


    public String calc(String str) throws IncorrectDataException {
        checkAndInitData(str);
        int result = 0;

        switch (operation) {
            case "+":
                result = fArgument + sArgument;
                break;
            case "-":
                result = fArgument - sArgument;
                break;
            case "*":
                result = fArgument * sArgument;
                break;
            case "/":
                result = fArgument / sArgument;
                break;
        }

        if (!isRomeNumber) {
            return String.valueOf(result);
        }
        return Utils.convertNumArabToRome(result);
    }




}
