import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FileAssistant {
    private String inputFile = null;
    private int posIterator = -1;
    private ArrayList<String> tokens;
    static final int ERROR_CODE = 404;

    FileAssistant() {
        tokens = new ArrayList<>();
    }

    void setFileName(String dirName, String fileName) {
        if (checkString(fileName) || checkString(dirName))
            return;
        inputFile = Paths.get(dirName, fileName).toString();
    }

    private boolean checkString(String inputFile) {
        if (inputFile == null || isEmpty(inputFile)) {
            System.err.println("ERROR: name of file undefined");
            return true;
        }
        return false;
    }

    boolean readFile() {
        Path path = Paths.get(inputFile);
        if (Files.exists(path) && Files.isReadable(path)) {
            try {
                List<String> contents = Files.readAllLines(path, StandardCharsets.UTF_8);
                for (String line : contents)
                    tokens.addAll(Arrays.asList(line.split("[ ]+")));

            } catch (IOException e) {
                System.err.println("ERROR: read file error ");
                return false;
            }
            moveToBegin();
            return tokens.size() != 0;
        }
        return false;
    }

    private void moveToBegin() {
        if (tokens.size() != 0)
            posIterator = 0;
    }

    private String getNextWord() {
        String emptyString = "";
        if (tokens.size() == 0) {
            System.err.println("ERROR: File  " + Paths.get(inputFile).getFileName() + "  is empty");
            return emptyString;
        }

        if (posIterator < tokens.size())
            return tokens.get(posIterator++);
        else {
            moveToBegin();
            return emptyString;
        }
    }

    int readNextInt() {
        int errorCode = 404;
        if (tokens.size() == 0) {
            System.err.println("ERROR:File  " + Paths.get(inputFile).getFileName() + "  is empty");
            return errorCode;
        }
        String token = getNextWord();
        while (!isEmpty(token)) {
            try {
                return Integer.parseInt(token);
            } catch (NumberFormatException e) {
                System.err.println(e);
            }
            token = getNextWord();
        }
        return errorCode;
    }

    private boolean isEmpty(String str) {
        return str.length() == 0;
    }
}