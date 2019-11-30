package workshop.systemSplit.components;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public abstract class Hardware extends ComponentType {
    private List<Software> softwareComponents;
    private int usedCapacity;
    private int usedMemory;

    protected Hardware(String name, Enum type, int maximumCapacity, int maximumMemory) {
        super(name, type, maximumCapacity, maximumMemory);
        this.softwareComponents = new ArrayList<>();
        this.usedCapacity = 0;
        this.usedMemory = 0;
    }

    public List<Software> getSoftwareComponents() {
        return softwareComponents;
    }

    public void setSoftwareComponents(List<Software> softwareComponents) {
        this.softwareComponents = softwareComponents;
    }

    public int getSoftwareCount() {
        return this.softwareComponents.size();
    }

    public void addSoftware(Software software) {
        if (software.getSomeMemory() <= this.getSomeMemory() && software.getSomeCapacity() <= this.getSomeCapacity()) {
            this.softwareComponents.add(software);
            setSomeCapacity(super.getSomeCapacity());
            setSomeMemory(super.getSomeMemory());
            this.setUsedResources(software);
        }
    }

    public int getUsedCapacity() {
        return usedCapacity;
    }

    public int getUsedMemory() {
        return usedMemory;
    }

    private void setUsedResources(Software software) {
        this.usedCapacity += software.getSomeCapacity();
        this.usedMemory += software.getSomeMemory();
    }

    public void removeSoftware(String softwareName) {
        Software software = this.softwareComponents.stream().filter((s -> s.getName().equalsIgnoreCase(softwareName)))
                .findFirst().orElse(null);
        if (software != null) {
            this.usedCapacity -= software.getSomeCapacity();
            this.usedMemory -= software.getSomeMemory();
            this.softwareComponents.remove(software);
        }
    }

    @Override
    public String toString() {
        long expressSoftwareCont = this.softwareComponents.stream().filter(s -> s.getClass()
                .getSimpleName().equals("ExpressSoftware")).count();

        return String.format("Hardware Component - %s%n" +
                        "Express Software Components - %d%n" +
                        "Light Software Components - %d%n" +
                        "Memory Usage: %d / %d%n" +
                        "Capacity Usage: %d / %d%n" +
                        "Type: %s%n" +
                        "Software Components: %s",
                this.getName(),expressSoftwareCont, this.softwareComponents.size() - expressSoftwareCont,
                this.usedMemory, this.getSomeMemory() + this.usedMemory,
                this.usedCapacity,this.getSomeCapacity() + this.usedCapacity,
                super.getType().equalsIgnoreCase("Heavy") ? "Heavy" : "Power",
                this.softwareComponents.size() == 0 ? "None" :
                this.softwareComponents.stream().map(ComponentType::getName)
                        .collect(Collectors.joining(", ")));

    }

    protected enum Type {
        POWER,
        HEAVY
    }
}
