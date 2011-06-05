package psi_3;

import java.util.ArrayList;
import java.util.List;

public class OlympicGameModel implements Observable, State {

    private double[][] state;
    private List<Observer> observers = new ArrayList<Observer>();

    public OlympicGameModel(double[][] state) {
        this.state = state;
    }

    public Memento createMemento() {
        return (new Memento(this.state));
    }

    public void setMemento(Memento m) {
        this.setState(m.getState());
    }
    
    public double[][] getState(){
        return this.state;
    }

    public void changeState(int k, List<Double> votes) {
        for (int i = 0; i < this.state.length; i++) {
            if (i < k) this.state[i][k] = votes.get(i);
            else if (i > k) this.state[i][k] = votes.get(i-1);
        }
    }

    public void printAllResult() {
        int n = this.state.length;
        System.out.println("Lietuva; Latvija; ...; ...; ...;");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(this.state[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public void setState (double[][] state) {
        this.state = state;
    }

    public void Attach(Observer observer) {
        String name = observer.getClass().getSimpleName();
        if (!isObserver(name)) {
            this.observers.add(observer);
            System.out.println("Added observer");
        }
        else {
            System.out.println("That's observer is existing");
        }

    }

    public void Detach(String name) {
        if (isObserver(name))
            for (int i = 0; i < this.observers.size(); i++) {
                if (this.observers.get(i).getClass().getSimpleName().compareTo(name) == 0) {
                    this.observers.remove(this.observers.get(i));
                    System.out.println("Removed observer");
                }
            }
        else {
            System.out.println("Isn't that observer");
        }
    }

    public boolean isObserver(String name) {
        for (int i = 0; i < this.observers.size(); i++) {
            System.out.println(this.observers.get(i).getClass().getSimpleName());
            if (this.observers.get(i).getClass().getSimpleName().compareTo(name) == 0) {
                return true;
            }
        }
        return false;
    }

    public void Notify() {
        if (this.observers.isEmpty()) {
           System.out.println("Aren't observers in the list");
        }
        else {
            for (int i = 0; i < this.observers.size(); i++) {
            this.observers.get(i).Update(this);
            }
        }
    }

    public List<Observer> getObserver() {
        return this.observers;
    }

}
