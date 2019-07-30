package encapsulation.exercise.footballTeamGenerator;

public class Player {

    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble,
                  int passing, int shooting) {
        setName(name);
        setEndurance(endurance);
        setSprint(sprint);
        setDribble(dribble);
        setPassing(passing);
        setShooting(shooting);
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private void setEndurance(int endurance) {
        if (endurance >= 0 && endurance < 101) {
            this.endurance = endurance;
        } else {
            verifyStat("Endurance");
        }
    }

    private void setSprint(int sprint) {
        if (sprint >= 0 && sprint < 101) {
            this.sprint = sprint;
        } else {
            verifyStat("Sprint");
        }
    }

    private void setDribble(int dribble) {
        if (dribble >= 0 && dribble < 101) {
            this.dribble = dribble;
        } else {
            verifyStat("Dribble");
        }
    }

    private void setPassing(int passing) {
        if (passing >= 0 && passing < 101) {
            this.passing = passing;
        } else {
            verifyStat("Passing");
        }
    }

    private void setShooting(int shooting) {
        if (shooting >= 0 && shooting < 101) {
            this.shooting = shooting;
        } else {
            verifyStat("Dribble");
        }
    }

    public double overallSkillLevel() {
        int skill = this.dribble + this.endurance + this.passing +
                this.shooting + this.sprint;
        return Math.round(skill / 5.0);
    }

    protected String verifyStat(String statName) {
        throw new IllegalArgumentException(statName + " should be between 0 and 100.");
    }
}
