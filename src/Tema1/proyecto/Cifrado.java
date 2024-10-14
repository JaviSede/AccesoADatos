package Tema1.proyecto;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class Cifrado {
    public static void encriptar(String contra, File inputFile, File outputFile){
        hacerCrypto(Cipher.ENCRYPT_MODE, contra, inputFile, outputFile);
    }

    public static void desencriptar(String contra, File inputFile, File outputFile){
        hacerCrypto(Cipher.DECRYPT_MODE, contra, inputFile, outputFile);
    }

    private static void hacerCrypto(int cipherMode, String key, File inputFile, File outputFile)  {
        try {
            Key secretKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(cipherMode, secretKey);

            FileInputStream inputStream = new FileInputStream(inputFile);

            byte[] inputBytes = new byte[(int) inputFile.length()];

            inputStream.read(inputBytes);

            byte[] outputBytes = cipher.doFinal(inputBytes);

            FileOutputStream outputStream = new FileOutputStream(outputFile);
            outputStream.write(outputBytes);

            inputStream.close();
            outputStream.close();

        } catch (NoSuchAlgorithmException | InvalidKeyException | BadPaddingException |
                 IllegalBlockSizeException | IOException | NoSuchPaddingException ex) {
            System.out.println("Error encrypting/decrypting file.txt: " + ex.getMessage());
        }
    }

}