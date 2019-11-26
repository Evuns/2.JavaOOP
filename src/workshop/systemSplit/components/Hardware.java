package workshop.systemSplit.components;

import java.util.ArrayList;
import java.util.List;


public abstract class Hardware extends ComponentType {
    private List<Software> softwareComponents;

    protected Hardware(String name, Enum type, int maximumCapacity, int maximumMemory) {
        super(name, type, maximumCapacity, maximumMemory);
        this.softwareComponents = new ArrayList<>();
    }

    public List<Software> getSoftwareComponents() {
        return softwareComponents;
    }

    public void setSoftwareComponents(List<Software> softwareComponents) {
        this.softwareComponents = softwareComponents;
    }

    protected enum Type{
        POWER,
        HEAVY
    }
}
