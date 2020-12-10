package core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReaderImpl implements ConsoleReader {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public String readLine() throws IOException {
        return reader.readLine();
    }

    @Override
    public int[][] readInput(int rows, int cols) throws IOException {
        int[][] layer = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] currentLine = reader.readLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                layer[row][col] = Integer.parseInt(currentLine[col].trim());
            }
        }

        return layer;
    }
}
