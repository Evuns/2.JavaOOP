package encapsulation.exercise.footballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private String name;
    private List<Player> players;

    public Team(String name){
        setName(name);
        this.players = new ArrayList<Player>();
    }

    private void setName(String name) {
        String validName = name.trim();
        if (validName.length() == 0) {
            throw new IllegalArgumentException("A name should not be empty.");
        } else {
            this.name = name;
        }
    }

    public String getName(){
        return this.name;
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public void removePlayer(String playersName){
        boolean exist = false;
        for (Player player:players) {
            if(player.getName().equals(playersName)){
                players.remove(player);
                exist = true;
                break;
            }
        }
        if(!exist){
            throw new IllegalArgumentException(String.format("encapsulation.exercise.footballTeamGenerator.Player %s is not in %s team.",playersName, this.name));
        }
    }

    public double getRating() {
        int numberOfPlayers = players.size();
        if (players.isEmpty()) {
            return 0;
        } else {
            double overallSkillLevel = 0;
            for (Player player : players) {
                overallSkillLevel += player.overallSkillLevel();
            }
            double skillLevel = Math.round(overallSkillLevel / numberOfPlayers);

            return skillLevel;
        }
    }
}
