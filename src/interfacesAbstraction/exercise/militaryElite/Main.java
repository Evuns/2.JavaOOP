package interfacesAbstraction.exercise.militaryElite;

import interfacesAbstraction.exercise.militaryElite.commands.*;
import interfacesAbstraction.exercise.militaryElite.interfaces.Command;
import interfacesAbstraction.exercise.militaryElite.interfaces.Soldier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String input;
        Map<String, Command> commands = new HashMap<>();

        List<Soldier> soldiers = new ArrayList<>();

        commands.put("Private", new PrivateCommand(soldiers));
        commands.put("LeutenantGeneral", new LieutenantGeneralCommand(soldiers));
        commands.put("Engineer", new EngineerCommand(soldiers));
        commands.put("Commando", new CommandoCommand(soldiers));
        commands.put("Spy", new SpyCommand(soldiers));


        while ( !"END".equalsIgnoreCase(input = bf.readLine())){
            String command = input.substring(0, input.indexOf(" "));
            try {
                commands.get(command).execute(
                        Arrays.stream(input.split("\\s+"))
                                .skip(1)
                                .collect(Collectors.toList())
                );
            }catch (Exception ex){

            }
        }

        for (Soldier soldier : soldiers) {
            System.out.println(soldier.toString());

        }
    }
}
