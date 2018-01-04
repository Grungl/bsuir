import java.util.Arrays;

public class Decryptor extends AbstractCypher {

    public String decrypt(String encryptedMessage, String keyPhrase) {
        String [] blocks = textToBlocks(encryptedMessage, keyPhrase);

        int[][] matrix = super.createAndFillFirstRow(encryptedMessage, keyPhrase);
        char [][] decryptedBlocks = new char[blocks.length][keyPhrase.length()];

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                decryptedBlocks[i - 1][j] =  blocks[i - 1].charAt(matrix[0][j] - 1);
            }
        }

        return tailorOriginalText(decryptedBlocks);
    }

    private String tailorOriginalText(char[][] decryptedBlocks) {
        StringBuilder sb = new StringBuilder();

        for (char[] decryptedBlock : decryptedBlocks) {
            sb.append(new String(decryptedBlock));
        }

        return sb.toString();
    }

    private String[] textToBlocks(String message, String key) {
        String [] res = new String[calcHeight(message, key) - 1];

        int from = 0;
        int to = key.length();
        for (int i = 0; i < calcHeight(message, key) - 1; i++){
            res[i] = message.substring(from, to);
            from += key.length();
            to += key.length();
        }

        System.out.println("Blocks:");
        Arrays.stream(res).forEach(System.out::println);
        System.out.println();

        return res;
    }

}
