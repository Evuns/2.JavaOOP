package motocrossWorldChampionship.core;


import motocrossWorldChampionship.core.interfaces.Engine;
import motocrossWorldChampionship.io.interfaces.InputReaderImpl;
import motocrossWorldChampionship.io.interfaces.OutputWriter;

public class EngineImpl implements Engine {
    private InputReaderImpl reader;
    private OutputWriter writer;

    public EngineImpl(InputReaderImpl reader, OutputWriter writer) {
        this.reader = reader;
        this.writer = writer;

    }

    @Override
    public void run() {
        String line = this.reader.readLine();
        ChampionshipControllerImpl commands = new ChampionshipControllerImpl();
        while ((!"End".equalsIgnoreCase(line))) {
            String[] commandsArgs = line.split("\\s+");
            String commandName = commandsArgs[0];
            try{
            if (commandName.equalsIgnoreCase("CreateRider")) {
                writer.writeLine(commands.createRider(commandsArgs[1]));
            } else if (commandName.equalsIgnoreCase("CreateMotorcycle")) {
                writer.writeLine(commands.createMotorcycle(commandsArgs[1], commandsArgs[2], Integer.parseInt(commandsArgs[3])));
            } else if (commandName.equalsIgnoreCase("CreateRace")) {
                writer.writeLine(commands.createRace(commandsArgs[1], Integer.parseInt(commandsArgs[2])));
            } else if (commandName.equalsIgnoreCase("AddMotorcycleToRider")) {
                writer.writeLine(commands.addMotorcycleToRider(commandsArgs[1], commandsArgs[2]));
            } else if (commandName.equalsIgnoreCase("StartRace")) {
                writer.writeLine(commands.startRace(commandsArgs[1]));
            } else if (commandName.equalsIgnoreCase("AddRiderToRace")){
                writer.writeLine(commands.addRiderToRace(commandsArgs[1],commandsArgs[2]));
            }
            }catch (IllegalArgumentException | NullPointerException e){
                writer.writeLine(e.getMessage());
            }
            line = reader.readLine();
        }

    }
}
