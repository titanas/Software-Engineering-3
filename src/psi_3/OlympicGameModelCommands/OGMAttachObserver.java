package psi_3.OlympicGameModelCommands;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import psi_3.Command;
import psi_3.LatviaObserver;
import psi_3.LithuaniaObserver;
import psi_3.OlympicGameModel;

public class OGMAttachObserver implements Command, Cloneable{

    private OlympicGameModel model;

    public OGMAttachObserver (OlympicGameModel model) {
        this.model = model;
    }

    public void execute() {

        Integer number = getCountryNumber();
        if (number == 1) {
            this.model.Attach(new LithuaniaObserver(0));
        } else {
            this.model.Attach(new LatviaObserver(1));
        }
    }

    public Integer getCountryNumber() {
        System.out.println("Pasirinkite šalį: ");
        System.out.println("1 - Lietuva");
        System.out.println("2 - Latvija");
        return readInt();
    }

    public int readInt() {
        int num = 0;
        System.out.println("Įveskite savo pasirinkimą");
        Scanner in = new Scanner(System.in);
        try {
            num = (int) in.nextInt();

        } catch (InputMismatchException e) {
            System.out.println("Įvedėte ne skaičių.");
            System.exit(0);
        } catch(NoSuchElementException e) {
            System.out.println("Įvedėte ne skaičių.");
            System.exit(0);
        }
        System.out.println();
        return num;
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
