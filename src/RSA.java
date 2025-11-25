import javax.crypto.Cipher;
import java.security.*;
import java.util.Base64;

public class RSA {
    public static void main(String[] args) {
        KeyPair keys = generateRSAKeyPair();
        String enckey = encrypt(keys.getPublic(),"Asela".getBytes());
        System.out.println(enckey);
        System.out.println(decrypt(keys.getPrivate(),enckey));
    }

    public static KeyPair generateRSAKeyPair() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(1024, new SecureRandom());
            return keyPairGenerator.generateKeyPair();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String encrypt(PublicKey publicKey, byte[] plainText) {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] ciperBytes = cipher.doFinal(plainText);
            return Base64.getEncoder().encodeToString(ciperBytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String decrypt(PrivateKey privateKey, String cipherText) {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] decodedBytes = Base64.getDecoder().decode(cipherText);
            return new String(cipher.doFinal(decodedBytes));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
