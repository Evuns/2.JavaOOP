package interfacesAbstraction.exercise.militaryElite.tasks;

import interfacesAbstraction.exercise.militaryElite.enums.Corps;
import interfacesAbstraction.exercise.militaryElite.enums.State;
import interfacesAbstraction.exercise.militaryElite.interfaces.*;
import interfacesAbstraction.exercise.militaryElite.soldiers.CommandoImpl;
import interfacesAbstraction.exercise.militaryElite.soldiers.EngineerImpl;
import interfacesAbstraction.exercise.militaryElite.soldiers.LieutenantGeneralImpl;
import interfacesAbstraction.exercise.militaryElite.soldiers.SpyImpl;

import java.util.List;

public class SoldierFactory {

    public static Soldier producePrivate(List<String> args) {
        return new PrivateImpl(Integer.parseInt(args.get(0)),
                args.get(1),
                args.get(2),
                Double.parseDouble(args.get(3)));
    }

    public static Soldier produceLieutenantGeneral(List<String> args, List<Soldier> soldiers) {
        LieutenantGeneral general = new LieutenantGeneralImpl(
                Integer.parseInt(args.get(0)),
                args.get(1),
                args.get(2),
                Double.parseDouble(args.get(3)));

        for (int i = 4; i < args.size(); i++) {
            int id = Integer.parseInt(args.get(i));
            for (int j = 0; j < soldiers.size(); j++) {
                if (soldiers.get(j).getId() == id) {
                    general.addPrivate((Private) soldiers.get(j));

                }
            }
        }
        return (Soldier) general;
    }

    public static Soldier produceEngineer(List<String> args) {
        if (args.get(4).equals("Airforces") || args.get(4).equals("Marines")) {
            Engineer engineer = new EngineerImpl(
                    Integer.parseInt(args.get(0)),
                    args.get(1),
                    args.get(2),
                    Double.parseDouble(args.get(3)),
                    Corps.valueOf(args.get(4).toUpperCase())
            );
            for (int i = 5; i < args.size(); i += 2) {
                Repair repair = new RepairImpl(args.get(i), Integer.parseInt(args.get(i + 1)));
                engineer.addRepair(repair);
            }
            return (Soldier) engineer;
        } else throw new IllegalArgumentException();
    }

    public static Soldier produceCommando(List<String> args) {
        if (args.get(4).equals("Airforces") || args.get(4).equals("Marines")) {

            Commando commando = new CommandoImpl(
                    Integer.parseInt(args.get(0)),
                    args.get(1),
                    args.get(2),
                    Double.parseDouble(args.get(3)),
                    Corps.valueOf(args.get(4).toUpperCase())
            );
            for (int i = 5; i < args.size(); i += 2) {
                String state = args.get(i + 1);
                if (state.equals("inProgress") || state.equals("finished")) {
                    Mission mission = new MissionImpl(args.get(i),
                            State.valueOf(state.toUpperCase()));
                    commando.addMission(mission);
                }
            }
            return (Soldier) commando;
        } else throw new IllegalArgumentException();
    }

    public static Soldier produceSpy(List<String> args) {
        return new SpyImpl(Integer.parseInt(args.get(0)),
                args.get(1),
                args.get(2),
                args.get(3));
    }
}
