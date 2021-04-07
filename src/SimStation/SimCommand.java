package SimStation;

import mvc.Command;
import mvc.Model;


public class SimCommand extends Command{

    private String heading;

    public SimCommand(Model model, String s){super(model);heading = s;}

    public void execute(){
        Simulation sim = (Simulation) model;
        sim.changeState(heading);
    }
}

