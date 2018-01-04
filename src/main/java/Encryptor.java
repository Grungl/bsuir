public class Encryptor extends AbstractCypher {

    public String encrypt(String message, String keyPhrase) {

        int [][] matrix = createAndFillFirstRow(message, keyPhrase);

        fillMessage(matrix, message);

        return encode(matrix);
    }

    private String encode(int[][] matrix) {
        char[][] arr = new char[matrix.length - 1][matrix[0].length];

        for (int i = 1; i < matrix.length; i++) {
            arr[i - 1] = new char[matrix[i].length];

            for (int j = 0; j < matrix[i].length; j++) {
                arr[i - 1][matrix[0][j] - 1] = (char)matrix[i][j];
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            sb.append(new String(arr[i]));
        }

        return sb.toString();
    }

/*
Some_Secret_Phrase
Enter the secret message please
This work was done by corenpondence faculcy student as a lab task. (Pavel Bachilo)
 */

    private void fillMessage(int[][] matrix, String message) {
        for (int i = 1, k = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length && k < message.length(); j++, k++) {
                matrix[i][j] = message.charAt(k);
            }
        }
    }

}
