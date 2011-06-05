package psi_3;

import java.util.Hashtable;
import psi_3.OlympicGameModelCommands.*;
import psi_3.SongContestModelCommands.*;

public class Main {

    public static void main(String[] args) {

        String fileName = "C:\\Users\\Lukas\\Documents\\NetBeansProjects\\PSI_3\\duom.txt";
        double[][] data = MatrixReader.readFile(fileName, 5, 5);

        SongContestModel model = new SongContestModel(data);
        //OlympicGameModel model = new OlympicGameModel(data);

        LithuaniaObserver lithuania = new LithuaniaObserver(0);
        LatviaObserver latvia = new LatviaObserver(1);
        model.Attach(lithuania);
        model.Attach(latvia);
       
        // Atrenkam kuris modelis naudojamas, sukuriam komandas    
        Hashtable commands = new Hashtable();
        if (model.getClass().isAssignableFrom(SongContestModel.class)) {
            commands.put("NotifyObservers", new SCMNotifyObservers(model));
            commands.put("AttachObserver", new SCMAttachObserver(model));
            commands.put("DetachObserver", new SCMDetachObserver(model));
            commands.put("ChangeModelState", new SCMChangeModelState(model));
            commands.put("PrintModelState", new SCMPrintModelState(model));

        } else if (model.getClass().isAssignableFrom(OlympicGameModel.class)) {
            commands.put("NotifyObservers", new OGMNotifyObservers(model));
            commands.put("AttachObserver", new OGMAttachObserver(model));
            commands.put("DetachObserver", new OGMDetachObserver(model));
            commands.put("ChangeModelState", new OGMChangeModelState(model));
            commands.put("PrintModelState", new OGMPrintModelState(model));
        }
        
        Controller controller = new Controller(commands);
        controller.run();
    }
}
