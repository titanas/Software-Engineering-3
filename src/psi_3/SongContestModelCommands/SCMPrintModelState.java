package psi_3.SongContestModelCommands;

import psi_3.Command;
import psi_3.SongContestModel;

public class SCMPrintModelState implements Command, Cloneable {

    private SongContestModel model;

    public SCMPrintModelState (SongContestModel model) {
        this.model = model;
    }

    public void execute() {
        this.model.printAllResult();
    }

    public void undo() {

    }

    public boolean canUndo() {
        return false;
    }

    public void redo() {
        
    }

    public Object copyOf() {
        try {
            return this.clone();
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
