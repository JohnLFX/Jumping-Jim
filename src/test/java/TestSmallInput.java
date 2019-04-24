import cot4400.Direction;
import cot4400.JumpingJim;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Scanner;

public class TestSmallInput {

    @Test
    public void test() throws Exception {

        Scanner scanner = new Scanner(this.getClass().getResourceAsStream("/small-input.txt"));

        int[][] matrix = TestUtils.read2DMatrix(scanner);

        scanner.close();

        Assert.assertEquals("End goal should be 0", 0, matrix[matrix.length - 1][matrix[0].length - 1]);

        List<Direction> directions = JumpingJim.jumpPathSequence(matrix);

        scanner = new Scanner(this.getClass().getResourceAsStream("/small-output.txt"));

        List<Direction> expected = TestUtils.readOutput(scanner);

        scanner.close();

        Assert.assertEquals("Directions do not match", expected, directions);

    }

}
