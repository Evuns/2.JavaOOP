package motocrossWorldChampionship;

import motocrossWorldChampionship.core.EngineImpl;
import motocrossWorldChampionship.core.interfaces.Engine;
import motocrossWorldChampionship.io.interfaces.InputReaderImpl;
import motocrossWorldChampionship.io.interfaces.OutputWriter;
import motocrossWorldChampionship.io.interfaces.OutputWriterImpl;

public class Main {
    public static void main(String[] args) {
        InputReaderImpl reader = new InputReaderImpl();
        OutputWriter writer = new OutputWriterImpl();
        Engine engine = new EngineImpl(reader,writer);
        engine.run();
        System.out.println();
    }
}
