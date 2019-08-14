package interfacesAbstraction.exercise.militaryElite.tasks;

import interfacesAbstraction.exercise.militaryElite.interfaces.Private;

public class PrivateImpl extends SolderImpl implements Private {

    private double salary;

    public PrivateImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" Salary: %.2f", this.getSalary());
    }
}
