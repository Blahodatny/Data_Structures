package tasks.task1;

import hashtable.HashTable;
import interfaces.FigureSet;
import tasks.ArrayOfFigures;

import java.io.File;
import java.nio.file.Paths;
import java.util.Arrays;

import static tasks.CSV.readCSV;

class Task1Main {
    private static final String fileName = "figures.csv";
    private static final String currentDir = System.getProperty("user.dir")
            + File.separatorChar + "hash_table/src/main/resources/";
    private static final int NUM = 11;

    public static void main(String[] args) {
        var lines = readCSV(Paths.get(currentDir, fileName).toString());

        if (!lines.isEmpty()) {
            var array = ArrayOfFigures.create(lines);
            Arrays.stream(array).map(f -> f.toString() + "\t" + Math.abs(f.hashCode() % NUM)).forEach(System.out::println);
            System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            FigureSet figures = new HashTable();
            Arrays.stream(array).forEach(figures::add);
            figures.print();
        } else {
            System.out.println("Error: file  " + fileName + "   is empty");
            System.exit(0);
        }
    }
}