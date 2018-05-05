package tasks;

import rectangle.Rectangle;

import java.awt.geom.Point2D;
import java.util.Arrays;
import java.util.List;

public class ArrayOfFigures {
    private static final int QUANTITY = 4;

    public static Rectangle[] create(List<String[]> list) {
        int num = 0;
        Rectangle[] arr = new Rectangle[list.size()];
        for (String[] line : list)
            if (writeRectangleInfo(line) != null) {
                arr[num] = writeRectangleInfo(line);
                num++;
            }

        if (num != list.size()) arr = copyOf(arr, num);
        return arr;
    }

    private static Rectangle writeRectangleInfo(String[] line) {
        if (line.length != QUANTITY) {
            if (line.length < QUANTITY)
                System.err.println("Error: the line  \"" + Arrays.toString(line)
                        + "\" not completed.");
            else
                System.err.println("Error: the line  \"" + Arrays.toString(line)
                        + "\" is overcrowded.");
            return null;
        }

        try {
            try {
                return new Rectangle(new Point2D.Double(Double.parseDouble(line[0]), Double.parseDouble(line[1])),
                        new Point2D.Double(Double.parseDouble(line[2]), Double.parseDouble(line[3])));
            } catch (NumberFormatException e) {
                System.err.println("Error: the line \"" + Arrays.toString(line) + "\" contains unparsable double value.");
                return null;
            }
        } catch (Error error) {
            System.err.println("Error: the line \"" + Arrays.toString(line) + "\" contains invalid values: " + error);
            return null;
        }
    }

    private static Rectangle[] copyOf(Rectangle[] array, int num) {
        Rectangle[] rec = new Rectangle[num];
        System.arraycopy(array, 0, rec, 0, num);
        return rec;
    }
}