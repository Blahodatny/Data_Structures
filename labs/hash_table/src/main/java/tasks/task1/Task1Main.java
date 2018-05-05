package tasks.task1;

import hashtable.HashTable;
import interfaces.FigureSet;
import rectangle.Rectangle;
import tasks.ArrayOfFigures;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;

import static tasks.CSV.readCSV;

class Task1Main {
    private static final String fileName = "figures.csv";
    private static final String currentDir = System.getProperty("user.dir")
            + File.separatorChar + "hash_table/src/main/resources/";
    private static final int NUM = 11;

    public static void main(String[] args) {
        List<String[]> lines = readCSV(Paths.get(currentDir, fileName).toString());

        if (!lines.isEmpty()) {
            Rectangle[] array = ArrayOfFigures.create(lines);
            for (Rectangle f : array)
                System.out.println(f.toString() + "\t" + Math.abs(f.hashCode() % NUM));
            System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            FigureSet figures = new HashTable();
            for (Rectangle f : array)
                figures.add(f);
            figures.print();

        } else {
            System.out.println("Error: file  " + fileName + "   is empty");
            System.exit(0);
        }
    }
}