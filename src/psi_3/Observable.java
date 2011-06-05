package psi_3;

public interface Observable {
    
    public void Attach(Observer observer);
    public void Detach(String name);
    public void Notify() ;
}
