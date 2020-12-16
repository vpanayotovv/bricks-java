package util;

public class ConsolePrinterImpl implements ConsolePrinter {
    @Override
    public void print(int[][] matrixToPrint) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < matrixToPrint.length; i++) {
            for (int j = 0; j < matrixToPrint[i].length; j++) {
                builder.append(matrixToPrint[i][j]).append(" ");
            }
            builder.append(System.lineSeparator());
        }
        System.out.println(builder.toString().trim());
    }

    @Override
    public void printMassage(String massage) {
        System.out.println(massage);
    }
}
