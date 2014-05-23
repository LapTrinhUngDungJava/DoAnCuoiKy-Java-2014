/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptography;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JOptionPane;

/**
 *
 * @author Skys
 */
public class RSAAsymmetricCryptography {

    public static KeyPair generateKeyPair(int keySize){
      try {
	  KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");				
	  kpg.initialize(keySize);				
	  return kpg.generateKeyPair();
	} catch (NoSuchAlgorithmException e) {
	// TODO Auto-generated catch block
            return null;
	}
    }
    //"key.public"
    public static PublicKey savePublicKey(String strFileName,KeyPair keyPair){
        PublicKey publicKey = keyPair.getPublic();
        File f = new File(strFileName);
        try{
            if(f.exists()) f.delete();
        }catch(Exception e){
            
        }
        // Store Public Key.
	X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(publicKey.getEncoded());
	FileOutputStream fos;
	try {
		fos = new FileOutputStream(f);
		fos.write(x509EncodedKeySpec.getEncoded());
						
		fos.close();

	} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	}catch (IOException e) {
	} 
        return publicKey;
    }
    //"key.private"
    public static PrivateKey savePrivateKey(String strFileName, KeyPair keyPair){
        PrivateKey privateKey = keyPair.getPrivate();
        File f = new File(strFileName);
        try{
            if(f.exists()) f.delete();
        }catch(Exception e){
            
        }
        // Store Public Key.
	PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(privateKey.getEncoded());
	FileOutputStream fos;
	try {
		fos = new FileOutputStream(f);
		fos.write(pkcs8EncodedKeySpec.getEncoded());
		fos.close();
	} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	}catch (IOException e) {
	}   
        return privateKey;
    }
    public static PublicKey getPublicKey(String pubKeyFile){
        try{
         FileInputStream fisp = new FileInputStream(pubKeyFile);
	 byte[] encodedPublicKey = new byte[(int) pubKeyFile.length()];
	 fisp.read(encodedPublicKey);
	 fisp.close();
			
	 KeyFactory keyFactory = KeyFactory.getInstance("RSA");
	 X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(encodedPublicKey);
	 PublicKey pubKey = keyFactory.generatePublic(publicKeySpec);
         return pubKey;
         
        }catch(Exception e){
            return null;
        }
     }

    public static PrivateKey getPrivateKey(String privateKeyFileName){
        try{
         File privateKeyFile = new File(privateKeyFileName);
         FileInputStream fisp = new FileInputStream(privateKeyFile);
	 byte[] encodedPrivateKey = new byte[(int) privateKeyFile.length()];
	 fisp.read(encodedPrivateKey);
	 fisp.close();

	 KeyFactory keyFactory = KeyFactory.getInstance("RSA","BC");
	 PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(encodedPrivateKey);
	 PrivateKey privateKey = keyFactory.generatePrivate(privateKeySpec);
         
         return privateKey;
         
        }catch(Exception e){
            return null;
        }
     }
    public static String decryptData(PrivateKey privateKey,String fileNameInput){
        // TODO code application logic here
        
        try{
        Cipher  cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding","BC");
	cipher.init(Cipher.DECRYPT_MODE, privateKey);

        File inputFile = new File(fileNameInput);
        byte[] inputByteArray = new byte[(int)inputFile.length()];
	
	FileInputStream fis = new FileInputStream(inputFile);
	fis.read(inputByteArray);
	fis.close();
        
	byte[] plainText = cipher.doFinal(inputByteArray);
        /*
        FileOutputStream fos = new FileOutputStream(new File("abc.de"));
	fos.write(plainText);
	fos.close();
        */ 
        return JavaCryptography.byteToString(plainText);
        
        }catch(Exception e){
            return null;
        }
    }
    //key.account
    public static void encryptData(String strData,PublicKey pubKey,String fileNameOutput){
        // TODO code application logic here
        try{
        Cipher  cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding","BC");		
	cipher.init(Cipher.ENCRYPT_MODE, pubKey);
					
	byte[] cipherText = cipher.doFinal(strData.getBytes());
        
        FileOutputStream fos = new FileOutputStream(new File(fileNameOutput));
	fos.write(cipherText);
	fos.close();
        
        }catch(Exception e){
            
        }
    }
    public static void main(String[] args) throws Exception {
    } 
}
