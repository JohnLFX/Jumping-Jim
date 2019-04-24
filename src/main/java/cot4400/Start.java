package cot4400;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Start {

    public static void main(String[] args) throws IOException {

        Path input = Paths.get("input.txt");
        Path output = Paths.get("output.txt");

        int[][] matrix;

        try (Scanner scanner = new Scanner(Files.newInputStream(input))) {

            int rows = scanner.nextInt();
            int columns = scanner.nextInt();

            matrix = new int[rows][columns];

            for (int i = 0; i < rows; i++) {

                for (int j = 0; j < columns; j++) {

                    matrix[i][j] = scanner.nextInt();

                }

            }

        }

        List<Direction> directions = JumpingJim.jumpPathSequence(matrix);

        try (PrintWriter writer = new PrintWriter(Files.newOutputStream(output))) {

            for(Iterator<Direction> iterator = directions.iterator(); iterator.hasNext(); ) {
                writer.print(iterator.next().symbol());
                if(iterator.hasNext())
                    writer.print(' ');
            }

            writer.println();

        }

        System.out.println("Output written to file " + output);

    }

}
