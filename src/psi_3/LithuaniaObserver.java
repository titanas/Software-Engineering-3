package psi_3;

public class LithuaniaObserver implements Observer {

    private double[][] state;
    private int number;

    public LithuaniaObserver(int number) {
        this.number = number;
    }

    public void Update(Observable subject) {
        State sState = (State) subject;
        this.state = (double[][]) sState.getState();
        
        double sum = 0.0;
        for (int i = 0; i < this.state[this.number].length; i++) {
            sum += this.state[number][i];
        }
        System.out.println("Lithuania points: " + sum);
    }
}
