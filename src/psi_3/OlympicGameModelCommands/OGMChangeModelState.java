package psi_3.OlympicGameModelCommands;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import psi_3.Command;
import psi_3.Memento;
import psi_3.OlympicGameModel;

public class OGMChangeModelState implements Command, Cloneable {

    private OlympicGameModel model;
    private Memento menento;
    private Integer number;
    private List<Double> votes;

    public OGMChangeModelState (OlympicGameModel model) {
        this.model = model;
    }

    public void execute() {
        this.number = getCountryNumber() - 1;
        this.votes = new ArrayList<Double>();
        System.out.println("Įveskite balsus: ");
        for (int i = 0; i < 5-1; i++) {
            System.out.println(i+1 + ". ");
            votes.add(readDouble());
        }

        this.menento = this.model.createMemento();
        this.model.changeState(number, votes);
    }

    public void undo() {
        this.model.setState(this.menento.getState());
    }

    public void redo() {
        this.menento = this.model.createMemento();
        this.model.changeState(this.number, this.votes);
    }

    public boolean canUndo() {
        return true;
    }

    public Integer getCountryNumber() {
        System.out.println("Pasirinkite šalį: ");
        System.out.println("1 - Lietuva");
        System.out.println("2 - Latvija");
        return readInt();
    }

    public static int readInt() {
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

    public static Double readDouble() {
        Double num = 0.0;
        //System.out.println("Įveskite savo pasirinkimą");
        Scanner in = new Scanner(System.in);
        try {
            num = in.nextDouble();

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
