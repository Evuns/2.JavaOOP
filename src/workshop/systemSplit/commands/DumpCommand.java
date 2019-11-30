package workshop.systemSplit.commands;

import workshop.systemSplit.system.SystemSplit;

public class DumpCommand extends BaseCommand {

    private SystemSplit systemSplit;
    private String hardwareComponentName;

    public DumpCommand(Object... args) {
        super(args);
    }

    @Override
    protected void parseArgs(Object... args) {
        this.systemSplit = (SystemSplit) args[0];
        this.hardwareComponentName = args[1].toString();
    }

    @Override
    public void execute() {
        this.systemSplit.sendHardwareComponentToDump(this.hardwareComponentName);
    }
}
