/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptography;

import java.security.Security;

/**
 *
 * @author Skys
 */
public class ProviderTest {

    public static void main(String[] args) {
        String providerName = "BC";
        if (Security.getProvider(providerName) == null) {
            System.out.println(providerName + " provider not installed");
        } else {
            System.out.println(providerName + " is installed.");
        }
    }
}
