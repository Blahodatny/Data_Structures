import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class FileWorker {
    private static final String DIR =
            System.getProperty("user.dir") + "/src/test/resources/";

    private File getFile(String file) {
        return new File(DIR + file);
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
            Files.write(
                    Paths.get(file.getPath()), (csv + array[array.length - 1]).getBytes()
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    int[] readFile(String file, int size) {
        BufferedReader reader = null;
        var array = new int[size];
        try {
            reader = new BufferedReader(new FileReader(DIR + file));
            var line = reader.readLine().split("\\s*,\\s*");
            IntStream
                    .range(0, line.length)
                    .forEach(i -> array[i] = Integer.parseInt(line[i]));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                Objects.requireNonNull(reader).close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return array;
    }
}