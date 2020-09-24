package calculator.util;

public class CharToASCII {

    public int getValueASCII(String element) {
        int elementValue = element.charAt(0);
        return elementValue;
    }

    /*
        Numbers: DEC  ASCII
                  48  =  0
                  49  =  1
                  50  =  2
                  51  =  3
                  52  =  4
                  53  =  5
                  54  =  6
                  55  =  7
                  56  =  8
                  57  =  9
     */
    //TODO Error from this method, try int-Value of String
    public double returnDecimal(int elementValue) {
        double returnValue = 999.0;
        if (elementValue == 48) {
            returnValue = 0.0;
        } else if (elementValue == 49) {
            returnValue = 1.0;
        } else if (elementValue == 50) {
            returnValue = 2.0;
        } else if (elementValue == 51) {
            returnValue = 3.0;
        } else if (elementValue == 52) {
            returnValue = 4.0;
        } else if (elementValue == 53) {
            returnValue = 5.0;
        } else if (elementValue == 54) {
            returnValue = 6.0;
        } else if (elementValue == 55) {
            returnValue = 7.0;
        } else if (elementValue == 56) {
            returnValue = 8.0;
        } else if (elementValue == 57) {
            returnValue = 9.0;
        } else {
            System.out.print("CharToASCII.returnDecimal - ");
            System.out.println("ERROR in getting decimal from ASCII");
        }
        return returnValue;
    }

}
