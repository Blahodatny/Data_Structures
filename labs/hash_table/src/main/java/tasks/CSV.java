package tasks;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CSV {
    public static List<String[]> readCSV(String path) {
        CSVReader reader;
        List<String[]> list = null;
        try {
            reader = new CSVReader(new FileReader(path));
            list = reader.readAll();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}