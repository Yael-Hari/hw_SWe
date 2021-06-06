import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    /**
     * Prints a message according to a given grade.
     *
     * It is guaranteed that the grade is within the range [0, 100].
     *
     * @param grade The grade
     */
    public static void gradeMessage(int grade) {
        switch (grade) {
            case 100:
                System.out.println("Excellent");
                break;
            case 90: case 91: case 92: case 93: case 94: case 95: case 96: case 97: case 98: case 99:
                System.out.println("Great");
                break;
            case 80: case 81: case 82: case 83: case 84: case 85: case 86: case 87: case 88: case 89:
                System.out.println("Very Good");
                break;
            case 70: case 71: case 72: case 73: case 74: case 75: case 76: case 77: case 78: case 79:
                System.out.println("Good");
                break;
            default:
                System.out.println("OK");
        }
    }

    /**
     * Compresses a given string.
     *
     * The compression process is done by replacing a sequence of identical consecutive characters
     * with that same character followed by the length of sequence.
     *
     * It is guaranteed that the string contains only letters (lowercase and uppercase).
     *
     * @param stringToCompress The string to compress
     * @return The compressed version of the string
     */
    public static String compressString(String stringToCompress) {
        String compressedString = "";
        int letterCount = 1;
        int stringLen = stringToCompress.length();

        for (int i = 0; i < stringLen - 1; i++) {
            if (stringToCompress.charAt(i) == stringToCompress.charAt(i+1)) {
                letterCount++;
            } else {
                compressedString += stringToCompress.charAt(i) + Integer.toString(letterCount);
                letterCount = 1;
            }
        }
        compressedString += stringToCompress.charAt(stringLen - 1) + Integer.toString(letterCount);

        return compressedString;
    }

    /**
     * Decompresses a given string.
     *
     * The decompression process is done by duplicating each sequence of characters
     * according to the number which appears after the sequence.
     *
     * It is guaranteed that the string is a legal compressed string.
     *
     * @param compressedString The string to decompress
     * @return The decompressed string
     */
    public static String decompressString(String compressedString) {
        String decompressedString = "";
        int stringLen = compressedString.length();
        String subString = "";
        String subNum = "";

        int i = 0;
        while (i < stringLen) {
            while (compressedString.charAt(i) > '9') {
                subString += compressedString.charAt(i);
                i++;
            }
            while (i < stringLen && compressedString.charAt(i) >= '0' && compressedString.charAt(i) <= '9') {
                subNum += compressedString.charAt(i);
                i++;
            }
            decompressedString += repeat(subString, Integer.parseInt(subNum));
            subString = "";
            subNum = "";
        }
        return decompressedString;
    }

    public static String repeat(String subStringToRepeat, int timesRepeated) {
        String repeatedString = "";
        for (int i = 0; i < timesRepeated; i++) {
            repeatedString += subStringToRepeat;
        }
        return repeatedString;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String filePath = args[0];
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        // Tests for part A
        int numberOfGrades = scanner.nextInt();
        for (int i = 0; i < numberOfGrades; i++) {
            int grade = scanner.nextInt();
            gradeMessage(grade);
        }

        // Tests for part B1
        int numberOfStringsToCompress = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numberOfStringsToCompress; i++) {
            String stringToCompress = scanner.nextLine();
            String compressedString = compressString(stringToCompress);
            System.out.println("The compressed version of " + stringToCompress + " is " + compressedString);
        }

        // Tests for part B2
        int numberOfDecompressedStrings = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numberOfDecompressedStrings; i++) {
            String compressedString = scanner.nextLine();
            String decompressedString = decompressString(compressedString);
            System.out.println("The decompressed version of " + compressedString + " is " + decompressedString);
        }

        // Tests for both part B1 and B2
        int numberOfCombinedTests = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numberOfCombinedTests; i++) {
            String stringToCompress = scanner.nextLine();
            String compressedString = compressString(stringToCompress);
            String decompressedString = decompressString(compressedString);
            System.out.println("decompress(compress(" + stringToCompress + ")) == " + stringToCompress + "? " + stringToCompress.equals(decompressedString));
        }
    }
}
