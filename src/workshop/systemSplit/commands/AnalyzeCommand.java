package workshop.systemSplit.commands;

import workshop.systemSplit.system.SystemSplit;

public class AnalyzeCommand extends BaseCommand {

    private SystemSplit systemSplit;

    public AnalyzeCommand(Object... args) {
        super(args);
    }

    @Override
    protected void parseArgs(Object... args) {
        this.systemSplit = (SystemSplit) args[0];
    }

    @Override
    public void execute() {
        StringBuilder stringBuilder = new StringBuilder();
        int hardwareComponentCount = this.systemSplit.getHardwareComponentsSize();
        int softwareComponentCount = this.systemSplit.getSoftwareComponentCount();

        int totalMemoryInUsed = this.systemSplit.getTotalOperationalMemoryInUse();
        int totalCapacityTaken = this.systemSplit.getTotalCapacityTaken();

        int maxMemory = this.systemSplit.getMaximumMemory() + totalMemoryInUsed;
        int maxCapacity = this.systemSplit.getMaximumCapacity() + totalCapacityTaken;

        stringBuilder.append("System Analysis");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append(String.format("Hardware Components: %d%n",hardwareComponentCount));
        stringBuilder.append(String.format("Software Components: %d%n",softwareComponentCount));
        stringBuilder.append(String.format("Total Operational Memory: %d / %d%n", totalMemoryInUsed,maxMemory));
        stringBuilder.append(String.format("Total Capacity Taken: %d / %d",totalCapacityTaken,maxCapacity));
        System.out.println(stringBuilder.toString());
    }
}
