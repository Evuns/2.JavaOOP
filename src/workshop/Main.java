package workshop;

import workshop.systemSplit.engine.Engine;
import workshop.systemSplit.inputOutput.ConsoleReader;
import workshop.systemSplit.inputOutput.Reader;
import workshop.systemSplit.system.SystemSplit;

public class Main {
    public static void main(String[] args) {
        Reader reader = new ConsoleReader();
        SystemSplit systemSplit = new SystemSplit();
        Engine engine = new Engine(systemSplit,reader);
        engine.run();

    }
}
