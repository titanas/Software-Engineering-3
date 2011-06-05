package psi_3;

import java.util.Hashtable;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Controller {

    private Hashtable commands;
    private CommandProcessor processor;

    public Controller(Hashtable commands) {
        this.processor = new UndoRedoProcessor();
        this.commands = commands;
    }

    public void run() {

        while(true) {
            switch(Meniu()) {

                case 1: {
                    this.processor.executeCommand((Command) this.commands.get("NotifyObservers"));
                    break;
                }

                case 2: {
                    this.processor.executeCommand((Command) this.commands.get("AttachObserver"));
                    break;
                }

                case 3: {
                    this.processor.executeCommand((Command) this.commands.get("DetachObserver"));
                    break;
                }

                case 4: {
                    Command cmd = (Command) this.commands.get("ChangeModelState");
                    this.processor.executeCommand((Command) cmd.copyOf());
                    break;
                }

                case 5: {
                    this.processor.executeCommand((Command) this.commands.get("PrintModelState"));
                    break;
                }

                case 6: {
                    this.processor.undoCommand();
                    System.out.println("Po UNDO modelio būsena: ");
                    this.processor.executeCommand((Command) this.commands.get("PrintModelState"));
                    break;
                }

                case 7: {
                    this.processor.redoCommand();
                    System.out.println("Po REDO modelio būsena: ");
                    this.processor.executeCommand((Command) this.commands.get("PrintModelState"));
                    break;
                }

                case 0: {
                    System.out.println("Programos pabaiga.");
                    System.exit(0);
                }
            }
        }
    }

    public int Meniu() {
        System.out.println("\nMENIU");
        System.out.println("1 - Parodyti stebėtojų rezultatus.");
        System.out.println("2 - Pridėti naują stebėtoją.");
        System.out.println("3 - Pašalinti stebėtoją");
        System.out.println("4 - Koreguoti modelio duomenis");
        System.out.println("5 - Parodyti modelio rezultatus");
        System.out.println("6 - UNDO paskutiniam veiksmui");
        System.out.println("7 - REDO paskutiniam veiksmui");
        System.out.println("0 - Baigti darbą");
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
}
