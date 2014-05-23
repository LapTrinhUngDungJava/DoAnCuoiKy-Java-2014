/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptography;

/**
 *
 * @author Skys
 */
public class JavaCryptography {

    private static String digits = "0123456789abcdef";

    /**
     * @param args the command line arguments
     */
    public static String toHex(byte[] data, int length) {
        StringBuffer buf = new StringBuffer();

        for (int i = 0; i != length; i++) {
            int v = data[i] & 0xff;

            buf.append(digits.charAt(v >> 4));
            buf.append(digits.charAt(v & 0xf));
        }

        return buf.toString();
    }
    public static String byteToString(byte[] byteArray) {
        String result = "";
        for (int i = 0; i < byteArray.length; i++) {
            result += (char) byteArray[i];
        }
        return result;
    }

    /**
     * Return the passed in byte array as a hex string.
     *
     * @param data the bytes to be converted.
     * @return a hex representation of data.
     */
    public static String toHex(byte[] data) {
        return toHex(data, data.length);
    }
}
