package core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EngineImpl implements Engine {

    private final ConsolePrinter printer;
    private final ConsoleReader reader;

    public EngineImpl(ConsolePrinter printer, ConsoleReader reader) {
        this.printer = printer;
        this.reader = reader;
    }

    @Override
    public void run() {
        		/*
4 6
1 1 2 2 3 3
4 4 5 5 6 6
7 7 8 8 9 9
10 10 11 11 12 12

this is the first input that I check

6 8
1 1 2 2 3 3 4 4
5 5 6 6 7 7 8 8
9 9 10 10 11 11 12 12
13 13 14 14 15 15 16 16
17 17 18 18 19 19 20 20
21 21 22 22 23 23 24 24

this is the second

		 */

        String[] line = new String[0];
        try {
            line = reader.read().split("\\s+");
        } catch (IOException e) {
            e.printStackTrace();
        }
        int rows = Integer.parseInt(line[0]);
        int cols = Integer.parseInt(line[1]);


        //checking that rows and cols are divided by 2 and in range
        if (rows % 2 == 0 && cols % 2 == 0 && rows < 100 && cols < 100) {

            int[][] firstLayer = new int[0][];
            try {
                firstLayer = readInput(reader, rows, cols);
            } catch (IOException e) {
                e.printStackTrace();
            }
            int[][] secondLayer = createEmptyLayer(rows, cols);
            int blockNumber = 0;
            int finalNumberOfBlocks = ((rows * cols) / 2) + 1;


            int[][] solution = positionBlock(firstLayer, secondLayer, blockNumber, finalNumberOfBlocks);


            printer.printMassage("-----------SOLUTION----------");
            if (solution != null) {
                printer.print(solution);
            } else {
                printer.printMassage("No solution");
            }

        } else {
            printer.printMassage("Wrong input");//print validation massage
        }
    }

    private int[][] positionBlock(int[][] firstLayer, int[][] secondLayer, int blockNumber, int finalNumberOfBlocks) {



        printer.printMassage("Step " + blockNumber);
        printer.print(secondLayer);

        blockNumber++;

        //bottom of recursion
        if (blockNumber == finalNumberOfBlocks) {
            return secondLayer;

        } else {

            List<Integer> firstFreePositionInBiDimensionalArray = findFirstFreeIndexInBidimensionalArray(secondLayer);
            int row = firstFreePositionInBiDimensionalArray.get(0);
            int col = firstFreePositionInBiDimensionalArray.get(1);

            // position horizontal block if possible
            if (isValidPosition(firstLayer[row], col)) {
                // check if first layer
                // allows us to put
                // horizontal block
                // put the block
                int[][] secondLayerWithNewHorizontalBlock = putBlock(secondLayer, blockNumber, row, col, row, col + 1);

                return positionBlock(firstLayer, secondLayerWithNewHorizontalBlock, blockNumber, finalNumberOfBlocks);
            }

            // position vertical block if possible
            if (firstLayer.length > row + 1 && firstLayer[row][col] != firstLayer[row + 1][col]) {
                // check if first layer allows
                // us to put vertical block
                // put the block
                int[][] secondLayerWithNewVerticalBlock = putBlock(secondLayer, blockNumber, row, col, row + 1, col);

                return positionBlock(firstLayer, secondLayerWithNewVerticalBlock, blockNumber, finalNumberOfBlocks);
            }
            return null;
        }
    }


    private int[][] createEmptyLayer(int rows, int cols) {

        int[][] layer = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                layer[row][col] = 0;
            }
        }

        return layer;

    }

    private boolean isValidPosition(int[] layer, int j) {
        return layer.length > j + 1 && layer[j] != layer[j + 1];
    }

    private static int[][] putBlock(int[][] secondLayer, int blockNumber, int row, int col, int nextRow, int nextCol) {
        int[][] secondLayerWithNewHorizontalBlock = secondLayer.clone();
        secondLayerWithNewHorizontalBlock[row][col] = blockNumber;
        secondLayerWithNewHorizontalBlock[nextRow][nextCol] = blockNumber;
        return secondLayerWithNewHorizontalBlock;
    }

    private List<Integer> findFirstFreeIndexInBidimensionalArray(int[][] matrix) {
        List<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    indexes.add(i);
                    indexes.add(j);
                    break;
                }
            }
        }
        return indexes;
    }

    private int[][] readInput(ConsoleReader reader, int rows, int cols) throws IOException {

        int[][] layer = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] currentLine = reader.read().split("\\s+");
            for (int col = 0; col < cols; col++) {
                layer[row][col] = Integer.parseInt(currentLine[col].trim());
            }
        }

        return layer;

    }

}
