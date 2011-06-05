/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package psi_3.SongContestModelCommands;

import psi_3.Command;
import psi_3.SongContestModel;

public class SCMNotifyObservers implements Command, Cloneable {

    private SongContestModel model;

    public SCMNotifyObservers(SongContestModel model) {
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
