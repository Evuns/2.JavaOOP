package WorkingWithAbstraction.Lab.StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> repo;

    public StudentSystem() {
        this.repo = new HashMap<>();
    }

    public void ParseCommand(String[] args) {
        if (args[0].equals("Create")) {
            Student student = new Student(args[1],
                    Integer.parseInt(args[2]), Double.parseDouble(args[3]));
            if (!repo.containsKey(student.getName())) {
                repo.put(student.getName(), student);
            }
        } else if (args[0].equals("WorkingWithAbstraction.Lab.StudentSystem.Show")) {
            if (repo.containsKey(args[1])) {
                System.out.println(Show.print(repo.get(args[1])));
            }
        }
    }
}
