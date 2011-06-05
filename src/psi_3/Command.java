package psi_3;

public interface Command {

    public void execute();
    public void undo();
    public void redo();
    public boolean canUndo();
    public Object copyOf();
}
