package workshop.systemSplit.commands;

import workshop.systemSplit.system.SystemSplit;

public class DestroyCommand extends BaseCommand {

    private SystemSplit systemSplit;
    private String hardwareComponentName;

    public DestroyCommand(Object... args) {
        super(args);
    }

    @Override
    protected void parseArgs(Object... args) {
        this.systemSplit = (SystemSplit) args[0];
        this.hardwareComponentName = args[1].toString();
    }

    @Override
    public void execute() {
        this.systemSplit.destroyHardwareFromDump(this.hardwareComponentName);
    }
}
