import core.ConsolePrinterImpl;
import core.ConsoleReaderImpl;
import core.Engine;
import core.EngineImpl;

public class Main {
    public static void main(String[] args) {

        Engine engine = new EngineImpl(new ConsolePrinterImpl(), new ConsoleReaderImpl());
        engine.run();

    }

}
