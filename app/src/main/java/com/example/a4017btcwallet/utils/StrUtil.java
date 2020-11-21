package com.example.a4017btcwallet.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StrUtil {

    public static boolean isEmpty(String str) {
        return str == null || str.equals("");
    }
    //Determine whether the ip is valid
    public static boolean isIP(String addr)
    {
        if(addr.length() < 7 || addr.length() > 15 || "".equals(addr))
        {
            return false;
        }
        /**
         * Determine the IP format and range
         */
        String rexp = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";

        Pattern pat = Pattern.compile(rexp);

        Matcher mat = pat.matcher(addr);

        boolean ipAddress = mat.find();

        return ipAddress;
    }
    //Splicing the correct URL address

    public static String setRightUrl(String url) {
        String tempStr = "";
        if (!StrUtil.isEmpty(url))
            if (url.startsWith("http")) {
                tempStr = url;
            } else {
                tempStr = "http://" + url;
            }
        return tempStr;
    }

    //Check the correct password format
    public static boolean CheckPassword(String input) {
        //6-16 digits, letters, numbers, characters
        String regStr = "^([A-Z]|[a-z]|[0-9]|[`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>~！@#￥%……&*（）——+|{}【】‘；：”“'。，、？]){6,16}$";
        return input.matches(regStr);
    }

    //Mobile phone number format verification rules: beginning with 1; 11 pure numbers
    public static boolean checkPhone(String string) {
        String regex = "^1\\d{10}$";
        return string.matches(regex);
    }

    //Convert 0, 1, 2, 3 to 00, 01, 02, 03
    public static String toStringTwo(int val) {
        String temp;
        if (val < 10) {
            temp = "0" + val;
        } else {
            temp = val + "";
        }
        return temp;
    }

    //Null byte
    public static boolean isEmptyByte(byte[] result) {
        if (result != null) {
            return (result.length == 0);
        }
        return false;
    }

    //Determine whether two strings are equal, if one string is empty, return false
    public static boolean isEqualsTwoStrs(String string1, String string2) {
        if (isEmpty(string1)){
            return false;
        }
        if (isEmpty(string2)){
            return false;
        }
        if (!string1.equals(string2)){
            return false;
        }
        return true;
    }


    /**
     * Convert byte[] array to String type
     *
     * @param arg byte[] array to be converted
     * @param length The length of the array to be converted
     * @return String formation after conversion
     */
    public static String byteToStr(byte[] arg, int length) {
        String result = "";
        if (arg != null) {
            for (int i = 0; i < length; i++) {
                result = result
                        + (Integer.toHexString(
                        arg[i] < 0 ? arg[i] + 256 : arg[i]).length() == 1 ? "0"
                        + Integer.toHexString(arg[i] < 0 ? arg[i] + 256
                        : arg[i])
                        : Integer.toHexString(arg[i] < 0 ? arg[i] + 256
                        : arg[i])) + " ";
            }
            return result;
        }
        return "";
    }

    /**
     * Convert String to byte[] array
     *
     * @param arg String object to be converted
     * @return converted byte[] array
     */
    public static byte[] strToByteArray(String arg) {
        if (arg != null) {
            /* 1.remove the '' in the String, and then convert the String to a char array */
            char[] NewArray = new char[1000];
            char[] array = arg.toCharArray();
            int length = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] != ' ') {
                    NewArray[length] = array[i];
                    length++;
                }
            }
            /* Convert the value in the char array into an actual decimal array */
            int EvenLength = (length % 2 == 0) ? length : length + 1;
            if (EvenLength != 0) {
                int[] data = new int[EvenLength];
                data[EvenLength - 1] = 0;
                for (int i = 0; i < length; i++) {
                    if (NewArray[i] >= '0' && NewArray[i] <= '9') {
                        data[i] = NewArray[i] - '0';
                    } else if (NewArray[i] >= 'a' && NewArray[i] <= 'f') {
                        data[i] = NewArray[i] - 'a' + 10;
                    } else if (NewArray[i] >= 'A' && NewArray[i] <= 'F') {
                        data[i] = NewArray[i] - 'A' + 10;
                    }
                }
                /* The value of each char is composed of two hexadecimal data */
                byte[] byteArray = new byte[EvenLength / 2];
                for (int i = 0; i < EvenLength / 2; i++) {
                    byteArray[i] = (byte) (data[i * 2] * 16 + data[i * 2 + 1]);
                }
                return byteArray;
            }
        }
        return new byte[]{};
    }

    /**
     * Convert int to byte[] array
     * <p>
     * Convert int into a byte array with low byte first and high byte first
     * For example: 0 -> 00 00; 1 -> 00 01;
     */
    public static byte[] intToByteArray(int value) {
        byte[] src = new byte[2];
//        src[0] = (byte) ((value >> 24) & 0xFF);
//        src[1] = (byte) ((value >> 16) & 0xFF);
        src[0] = (byte) ((value >> 8) & 0xFF);
        src[1] = (byte) (value & 0xFF);
        return src;
    }

    /**
     * Convert int to byte[] array
     * <p>
     * Convert int into a byte array with low byte first and high byte first
     * For example: 0 -> 00; 1 -> 01;
     */
    public static byte[] intToByteArray2(int value) {
        byte[] src = new byte[1];
//        src[0] = (byte) ((value >> 24) & 0xFF);
//        src[1] = (byte) ((value >> 16) & 0xFF);
//        src[0] = (byte) ((value >> 8) & 0xFF);
        src[0] = (byte) (value & 0xFF);
        return src;
    }

    /**
     * Convert hexadecimal String to int
     * <p>
     * Convert the high byte in the front to int, and the low byte in the byte array (to correspond to intToByteArray)
     * For example: 0000 -> 0; 0001 -> 1;
     */
    public static int str16ToInt(String str) {
        return Integer.parseInt(str, 16);
    }

    /**
     * @param data1
     * @param data2
     * @return The result of splicing data1 and data2
     */
    public static byte[] addBytes(byte[] data1, byte[] data2) {
        byte[] data3 = new byte[data1.length + data2.length];
        System.arraycopy(data1, 0, data3, 0, data1.length);
        System.arraycopy(data2, 0, data3, data1.length, data2.length);
        return data3;

    }

    /**
     * CRC16 calculation to generate check code
     *
     * @param data The data to be verified
     * @return check code
     */
    public static String Make_CRC(byte[] data) {
        byte[] buf = new byte[data.length];// Store the data that needs to generate a check code
        for (int i = 0; i < data.length; i++) {
            buf[i] = data[i];
        }
        int len = buf.length;
        int crc = 0xFFFF;//16位
        for (int pos = 0; pos < len; pos++) {
            if (buf[pos] < 0) {
                crc ^= (int) buf[pos] + 256; // XOR byte into least sig. byte of
                // crc
            } else {
                crc ^= (int) buf[pos]; // XOR byte into least sig. byte of crc
            }
            for (int i = 8; i != 0; i--) { // Loop over each bit
                if ((crc & 0x0001) != 0) { // If the LSB is set
                    crc >>= 1; // Shift right and XOR 0xA001
                    crc ^= 0xA001;
                } else
                    // Else LSB is not set
                    crc >>= 1; // Just shift right
            }
        }
        String c = Integer.toHexString(crc);
        if (c.length() == 4) {
            c = c.substring(2, 4) + c.substring(0, 2);
        } else if (c.length() == 3) {
            c = "0" + c;
            c = c.substring(2, 4) + c.substring(0, 2);
        } else if (c.length() == 2) {
            c = "0" + c.substring(1, 2) + "0" + c.substring(0, 1);
        } else {
            c = "00 00";
        }
        return c;
    }
    public static String getNumeric(String str) {
        String regEx="[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("").trim();
    }
    public  static String getnowtime()
    {
        SimpleDateFormat formatter   =   new SimpleDateFormat("yyyy/MM/dd   HH:mm:ss");
        Date curDate =  new Date(System.currentTimeMillis());

        return formatter.format(curDate);
    }


}

