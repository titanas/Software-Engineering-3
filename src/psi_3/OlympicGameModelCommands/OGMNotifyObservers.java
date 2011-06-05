package psi_3.OlympicGameModelCommands;

import psi_3.Command;
import psi_3.OlympicGameModel;

public class OGMNotifyObservers implements Command, Cloneable {

    private OlympicGameModel model;

    public OGMNotifyObservers(OlympicGameModel model) {
        this.model = model;
    }

    public void execute() {
        this.model.Notify();
    }

    public void undo() {
    }

    public void redo() {
    }

    public boolean canUndo() {
        return false;
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
