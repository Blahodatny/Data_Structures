import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class FileWorker {
    private File getFile(String file) {
        return new File(System.getProperty("user.dir") + "/src/test/resources/" + file);
    }

    void write(String fileName, int[] array) {
        try {
            var file = getFile(fileName);
            if (!file.exists())
                System.out.println(file.createNewFile());
            var csv = IntStream
                    .range(0, array.length - 1)
                    .mapToObj(i -> array[i] + ", ")
                    .collect(Collectors.joining());
            csv += array[array.length - 1];
            Files.write(Paths.get(file.getPath()), csv.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}