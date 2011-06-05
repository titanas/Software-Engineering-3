package psi_3;

public class Memento {

    private double[][] state;

    public Memento (double[][] state) {
        this.state = new double[state.length][state.length];
        for (int i = 0; i < this.state.length; i++) {
            System.arraycopy(state[i], 0, this.state[i], 0, this.state[0].length);
        }
        //this.state = state;
    }

    public double[][] getState() {
        return this.state;
    }

    public void setState(double[][] state) {
        this.state = state;
    }
}
