package psi_3;

import java.util.ArrayList;
import java.util.List;

public class UndoRedoProcessor implements CommandProcessor {

    private List<Command> undovableCommands;
    private List<Command> redovableCommands;

    public UndoRedoProcessor () {
        this.undovableCommands = new ArrayList<Command>();
        this.redovableCommands = new ArrayList<Command>();
    }

    public void executeCommand (Command c) {
        c.execute();
        if (c.canUndo())
            this.undovableCommands.add(c);
    }

    public void undoCommand() {
        System.out.println("UNDO cmd: " + this.undovableCommands.size());
        if (!this.undovableCommands.isEmpty()) {
            Command cmd = this.undovableCommands.get(this.undovableCommands.size() - 1);
            this.undovableCommands.remove(cmd);
            cmd.undo();
            this.redovableCommands.add(cmd);
            
        }
    }

    public void redoCommand() {
        System.out.println("REDO cmd: " + this.redovableCommands.size());
        if (!this.redovableCommands.isEmpty()) {
            
            Command cmd = this.redovableCommands.get(this.redovableCommands.size() - 1);
            this.redovableCommands.remove(cmd);
            cmd.redo();
            this.undovableCommands.add(cmd);   
        }
    }
}
