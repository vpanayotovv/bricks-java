package core;

public class ConsolePrinterImpl implements ConsolePrinter {
    @Override
    public void print(int[][] matrixToPrint) {
        for (int i = 0; i < matrixToPrint.length; i++) {
            for (int j = 0; j < matrixToPrint[i].length; j++) {
                System.out.print(matrixToPrint[i][j] + " ");
            }
            System.out.println();
        }
    }
}
