package psi_3;

public interface CommandProcessor {

    public void executeCommand(Command c);
    public void undoCommand();
    public void redoCommand();
}
