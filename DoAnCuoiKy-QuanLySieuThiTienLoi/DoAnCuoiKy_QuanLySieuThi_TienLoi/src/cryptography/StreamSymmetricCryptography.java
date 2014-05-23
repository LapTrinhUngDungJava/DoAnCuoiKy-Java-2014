
package cryptography;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

/**
 *
 * @author Skys
 */
public class StreamSymmetricCryptography {
/*
    public static String encryptData(String strData,String strKey) throws Exception {
        // TODO code application logic here
        
        //Tao key
        KeySpec key = new DESKeySpec(strKey.getBytes());
        SecretKey skey = SecretKeyFactory.getInstance("DES").generateSecret(key);
        //SecretKey skey = new SecretKeySpec(strKEY.getBytes(), "DES");

          //Tao Cipher
        Cipher cipher = Cipher.getInstance("ARC4","BC");     
        cipher.init(Cipher.ENCRYPT_MODE,skey);
       
        byte[] ciphertext = new byte[cipher.getOutputSize(strData.length())];
        
        int ctLength = cipher.update(strData.getBytes(),0,strData.length(),ciphertext,0);
        ctLength+=cipher.doFinal(ciphertext, ctLength);
        System.out.println(ctLength);
        return JavaCryptography.toHex(ciphertext);
    }
    public static String decryptData(String strData, String strKey) throws Exception {
        // TODO code application logic here
        
        //Tao key
        KeySpec key = new DESKeySpec(strKey.getBytes());
        SecretKey skey = SecretKeyFactory.getInstance("DES").generateSecret(key);
        //SecretKey skey = new SecretKeySpec(strKEY.getBytes(), "DES");
        
          //Tao Cipher
        Cipher cipher = Cipher.getInstance("ARC4");  
        cipher.init(Cipher.DECRYPT_MODE, skey);
        byte[] plantext = new byte[100];
        
        

        int ptLength = cipher.update(strData.getBytes(), 0, 34, plantext,0);
        ptLength+=cipher.doFinal(plantext,ptLength);
        
        return JavaCryptography.byteToString(plantext).trim();
    }
    public static void main(String[] args) throws Exception {
        String strKEY = "PasswordDemo";
       String strDATA = "Demo ma hoa doi xung Block cipher.";
       String str = encryptData(strDATA, strKEY);
       System.out.println(str);
        System.out.println(decryptData(str, strKEY));
    } 
    */
}
