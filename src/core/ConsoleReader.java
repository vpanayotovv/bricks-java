package core;

import java.io.IOException;

public interface ConsoleReader {

    String readLine() throws IOException;

    int[][] readInput(int rows, int cols) throws IOException;
}
