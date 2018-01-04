import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {

    public static void main(String[] args) {

        String keyPhrase = read("Enter the secret key please");
        String message = read("Enter the secret message please");

        Encryptor encryptor = new Encryptor();
        Decryptor decryptor = new Decryptor();

//        String encryptedMessage = encryptor.encrypt("ЭТО–_ЛЕКЦИЯ_ПО_АЛГОРИТМАМ_ШИФРОВАНИЯ", "КРИПТОГРАФИЯ");
        String encryptedMessage = encryptor.encrypt(message, keyPhrase);

        System.out.println("Encrypted message is: " + encryptedMessage);

        String decryptedMessage = decryptor.decrypt(encryptedMessage, keyPhrase);
//        String decryptedMessage = decryptor.decrypt(encryptedMessage, "КРИПТОГРАФИЯ");
        System.out.println("Decrypted message is: " + decryptedMessage);
    }

    private static String read(String title) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println(title);
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException("Cant read line from console.");
        }
    }

}
