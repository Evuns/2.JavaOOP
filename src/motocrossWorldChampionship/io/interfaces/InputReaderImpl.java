package motocrossWorldChampionship.io.interfaces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReaderImpl implements InputReader {
    private static final BufferedReader READER;

    static {
        READER = new BufferedReader(new InputStreamReader(System.in));
    }
    @Override
    public String readLine() {
        try {
            return READER.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
