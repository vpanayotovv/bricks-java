package core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReaderImpl implements ConsoleReader {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public String read() throws IOException {
        return reader.readLine();
    }
}
