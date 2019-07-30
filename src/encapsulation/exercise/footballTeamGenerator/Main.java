package encapsulation.exercise.footballTeamGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        List<Team> teams = new ArrayList<>();
        String command;

        while (!"END".equalsIgnoreCase(command = bf.readLine())) {
            String[] data = command.split(";");
            if (data[0].equalsIgnoreCase("encapsulation.exercise.footballTeamGenerator.Team")) {
                try {
                    Team team = new Team(data[1]);
                    teams.add(team);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } else if (data[0].equalsIgnoreCase("Add")) {
                if (!teams.isEmpty()) {
                    boolean exist = false;
                    for (Team team : teams) {
                        if (data[1].equalsIgnoreCase(team.getName())) {
                            exist = true;
                            try {
                                Player player = new Player(data[2], Integer.parseInt(data[3]),
                                        Integer.parseInt(data[4]), Integer.parseInt(data[5]),
                                        Integer.parseInt(data[6]), Integer.parseInt(data[7]));
                                team.addPlayer(player);
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                    if (!exist) {
                        System.out.println("encapsulation.exercise.footballTeamGenerator.Team " + data[1] + " does not exist.");
                    }
                } else {
                    System.out.println("encapsulation.exercise.footballTeamGenerator.Team " + data[1] + " does not exist.");
                }
            } else if (data[0].equalsIgnoreCase("Remove")) {
                for (Team team : teams) {
                    if (data[1].equalsIgnoreCase(team.getName())) {
                        try {
                            team.removePlayer(data[2]);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
            } else {
                boolean exist = false;
                for (Team team : teams) {
                    if (data[1].equalsIgnoreCase(team.getName())) {
                        exist = true;
                        double rating = team.getRating();
                        System.out.printf("%s - %.0f%n", team.getName(), rating);
                    }
                }
                if(!exist){
                    System.out.println("encapsulation.exercise.footballTeamGenerator.Team " + data[1] + " does not exist.");
                }
            }
        }
    }
}
