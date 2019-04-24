import cot4400.Direction;
import cot4400.JumpingJim;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class TestJumpingJimAlgorithm {

    @Test
    public void test() throws IOException {

        Scanner scanner = new Scanner(this.getClass().getResourceAsStream("/jim-input.txt"));

        int[][] matrix = TestUtils.read2DMatrix(scanner);

        scanner.close();

        Assert.assertEquals("End goal should be 0", 0, matrix[matrix.length - 1][matrix[0].length - 1]);

        List<Direction> directions = JumpingJim.jumpPathSequence(matrix);

        scanner = new Scanner(this.getClass().getResourceAsStream("/jim-output.txt"));

        List<Direction> expected = TestUtils.readOutput(scanner);

        scanner.close();

        Assert.assertEquals("Directions do not match", expected, directions);

    }

}
