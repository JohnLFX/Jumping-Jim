import cot4400.Direction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestUtils {

    public static int[][] read2DMatrix(Scanner scanner) {

        int rows = scanner.nextInt();
        int columns = scanner.nextInt();

        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {

                matrix[i][j] = scanner.nextInt();

            }

        }

        return matrix;

    }

    public static List<Direction> readOutput(Scanner scanner) throws IOException  {

        List<Direction> directions = new ArrayList<>();

        while (scanner.hasNext()){

            switch (scanner.next()){

                case "N":
                    directions.add(Direction.NORTH);
                    break;
                case "S":
                    directions.add(Direction.SOUTH);
                    break;
                case "E":
                    directions.add(Direction.EAST);
                    break;
                case "W":
                    directions.add(Direction.WEST);
                    break;
                default:
                    System.out.println("Unknown value detected");
                    break;
            }

        }

        return directions;

    }

}
