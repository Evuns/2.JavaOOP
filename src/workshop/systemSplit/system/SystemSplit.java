package workshop.systemSplit.system;

import workshop.systemSplit.components.ComponentType;
import workshop.systemSplit.components.Hardware;
import workshop.systemSplit.components.Software;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;


public class SystemSplit {

    private Map<String, Hardware> hardwareComponents;
    private Map<String, Hardware> dump;

    public SystemSplit() {
        this.hardwareComponents = new LinkedHashMap<>();
        this.dump = new LinkedHashMap<>();
    }

    public void addHardwareComponent(Hardware hardware) {
        this.hardwareComponents.put(hardware.getName(), hardware);
    }

    public void sendHardwareComponentToDump(String hardwareName) {
        if (this.hardwareComponents.containsKey(hardwareName)) {
            this.dump.put(hardwareName, hardwareComponents.get(hardwareName));
            this.hardwareComponents.remove(hardwareName, hardwareComponents.get(hardwareName));

        }
    }

    public void restoreHardwareFromDump(String hardwareName) {
        if (this.dump.containsKey(hardwareName)) {
            this.hardwareComponents.put(hardwareName, dump.get(hardwareName));
            this.dump.remove(hardwareName);
        }
    }

    public void destroyHardwareFromDump(String hardwareComponentName) {
        if (this.dump.containsKey(hardwareComponentName)) {
            this.dump.remove(hardwareComponentName);
        }
    }

    public void addSoftwareToHardware(String hardwareName, Software software) {
        if (this.hardwareComponents.containsKey(hardwareName)) {
            Hardware hardware = this.hardwareComponents.get(hardwareName);
            hardware.addSoftware(software);
        }
    }

    public void releaseSoftware(String hardwareName, String softwareName) {
        if (this.hardwareComponents.containsKey(hardwareName)) {
            Hardware hardware = this.hardwareComponents.get(hardwareName);
            hardware.removeSoftware(softwareName);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        this.hardwareComponents.values().stream().sorted((h1, h2) -> {
            if (h1.getType().equalsIgnoreCase("Power")) {
                return -1;
            }
            return 1;
        }).forEach(h -> {
            sb.append(h.toString());
            sb.append(System.lineSeparator());
        });
        return sb.toString().trim();
    }

    public int getHardwareComponentsSize() {
        return this.hardwareComponents.size();
    }

    public int getSoftwareComponentCount() {
        return this.hardwareComponents.values().stream()
                .mapToInt(Hardware::getSoftwareCount).sum();
    }

    public int getTotalOperationalMemoryInUse() {
        return this.getValue(Hardware::getUsedMemory);
    }

    public int getTotalCapacityTaken() {
        return this.getValue(Hardware::getUsedCapacity);
    }

    public int getMaximumMemory() {
        return this.getValue(ComponentType::getSomeMemory);
    }

    public int getMaximumCapacity() {
        return this.getValue(ComponentType::getSomeCapacity);
    }

    private int getValue(ToIntFunction<Hardware> func) {
        return this.hardwareComponents.values()
                .stream().mapToInt(func).sum();
    }

    public int getDumpHardwareCount(String name) {
       int hardwareCount = 0;
        for (Hardware hardware : this.dump.values()) {
                if (hardware.getType().equalsIgnoreCase(name)) {
                   hardwareCount++;
                }
            }
        return hardwareCount;
    }

    public int getDumpSoftwareCount(String name) {
        int sum = 0;
        for (Hardware hardware : this.dump.values()) {
            for (Software software : hardware.getSoftwareComponents()) {
                if (software.getType().equalsIgnoreCase(name)) {
                    sum++;
                }
            }
        }
        return sum;
    }

    public int getDumpMemory() {
        int sum = 0;
        for (Hardware hardware : this.dump.values()) {
            for (Software software : hardware.getSoftwareComponents()) {
                sum += software.getSomeMemory();
            }
        }
        return sum;
    }

    public int getDumpCapacity() {
        int sum = 0;
        for (Hardware hardware : this.dump.values()) {
            for (Software software : hardware.getSoftwareComponents()) {
                sum += software.getSomeCapacity();
            }
        }
        return sum;
    }
}
