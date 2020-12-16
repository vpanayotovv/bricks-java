package util;

import java.io.IOException;

public interface ConsoleReader {

    //read line from console
    String readLine() throws IOException;

    //read matrix from console
    int[][] readInput(int rows, int cols) throws IOException;
}
