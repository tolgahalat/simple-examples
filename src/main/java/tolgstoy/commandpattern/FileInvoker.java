package tolgstoy.commandpattern;

public class FileInvoker {
    private Command command;

    public FileInvoker(Command cmd) {
        this.command = cmd;
    }

    public void execute() {
        this.command.execute();
    }

}
