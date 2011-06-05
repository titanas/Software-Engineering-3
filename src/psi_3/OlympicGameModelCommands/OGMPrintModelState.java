package psi_3.OlympicGameModelCommands;

import psi_3.Command;
import psi_3.OlympicGameModel;

public class OGMPrintModelState implements Command, Cloneable {

    private OlympicGameModel model;

    public OGMPrintModelState (OlympicGameModel model) {
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
