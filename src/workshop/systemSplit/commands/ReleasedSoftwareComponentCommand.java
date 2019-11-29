package workshop.systemSplit.commands;

import workshop.systemSplit.system.SystemSplit;

public class ReleasedSoftwareComponentCommand extends BaseCommand {

    private SystemSplit systemSplit;
    private String hardwareName;
    private String softwareName;

    public ReleasedSoftwareComponentCommand(Object... args) {
        super(args);
    }

    @Override
    protected void parseArgs(Object... args) {
        this.systemSplit = (SystemSplit) args[0];
        this.hardwareName = args[1].toString();
        this.softwareName = args[2].toString();
    }

    @Override
    public void execute() {

    }
}
