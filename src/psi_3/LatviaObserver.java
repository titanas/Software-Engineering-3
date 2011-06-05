package psi_3;

public class LatviaObserver implements Observer {

    private double[][] state;
    private int number;

    public LatviaObserver(int number) {
        this.number = number;
    }

    public void Update(Observable subject) {
        State sState = (State) subject;
        this.state = (double[][]) sState.getState();

        double sum = 0.0;
        for (int i = 0; i < this.state[this.number].length; i++) {
            sum += this.state[number][i];
        }
        System.out.println("Latvia points: " + sum);
    }
}
