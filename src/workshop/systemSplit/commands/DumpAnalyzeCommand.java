package workshop.systemSplit.commands;

import workshop.systemSplit.system.SystemSplit;

public class DumpAnalyzeCommand extends BaseCommand {

    private SystemSplit systemSplit;

    public DumpAnalyzeCommand(Object... args) {
        super(args);
    }

    @Override
    protected void parseArgs(Object... args) {
        this.systemSplit = (SystemSplit) args[0];
    }

    @Override
    public void execute() {
        StringBuilder stringBuilder = new StringBuilder();
        int powerHardwareCount = this.systemSplit.getDumpHardwareCount("Power");
        int heavyHardwareCount = this.systemSplit.getDumpHardwareCount("Heavy");
        int expressSoftwareCount = this.systemSplit.getDumpSoftwareCount("Express");
        int lightSoftwareCount = this.systemSplit.getDumpSoftwareCount("Light");

        int dumpMemory = this.systemSplit.getDumpMemory();
        int dumpCapacity = this.systemSplit.getDumpCapacity();

        stringBuilder.append("Dump Analysis");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append(String.format("Power Hardware Components: %d%n", powerHardwareCount));
        stringBuilder.append(String.format("Heavy Hardware Components: %d%n", heavyHardwareCount));
        stringBuilder.append(String.format("Express Software Components: %d%n", expressSoftwareCount));
        stringBuilder.append(String.format("Light Software Components: %d%n", lightSoftwareCount));
        stringBuilder.append(String.format("Total Dumped Memory: %d%n", dumpMemory));
        stringBuilder.append(String.format("Total Dumped Capacity: %d", dumpCapacity));
        System.out.println(stringBuilder.toString());
    }
}