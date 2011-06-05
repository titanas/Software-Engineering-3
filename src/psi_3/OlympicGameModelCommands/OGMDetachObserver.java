package psi_3.OlympicGameModelCommands;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import psi_3.Command;
import psi_3.OlympicGameModel;

public class OGMDetachObserver implements Command, Cloneable {

    private OlympicGameModel model;

    public OGMDetachObserver (OlympicGameModel model) {
        this.model = model;
    }
  
   
    public void execute() {
        Integer number = getCountryNumber();
        if (number == 1) {
            this.model.Detach("LithuaniaObserver");
        } else {
            this.model.Detach("LatviaObserver");
        }
    }

    public void undo() {

    }

    public void redo() {

    }

    public boolean canUndo() {
        return false;
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

    public Object copyOf() {
        try {
            return this.clone();
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}