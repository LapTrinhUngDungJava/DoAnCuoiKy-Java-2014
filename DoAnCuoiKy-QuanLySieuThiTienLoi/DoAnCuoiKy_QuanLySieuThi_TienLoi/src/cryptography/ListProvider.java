/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptography;

import java.security.Provider;
import java.security.Security;

/**
 *
 * @author Skys
 */
public class ListProvider {

    public static void main(String[] args) {
        Provider[] providers = Security.getProviders();

        for (int i = 0; i != providers.length; i++) {
            System.out.println("Name: " + providers[i].getName() + makeBlankString(15 - providers[i].getName().length()) + " Version: " + providers[i].getVersion());
        }
    }

    public static String makeBlankString(int len) {
        char[] buf = new char[len];

        for (int i = 0; i != buf.length; i++) {
            buf[i] = ' ';
        }

        return new String(buf);
    }
}
