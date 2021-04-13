package SimStation;

import RandomWalk.RandomWalkSimulation;
import mvc.*;

public class SimulationFactory implements AppFactory {

    public Model makeModel() { return new RandomWalkSimulation(); }

    public View makeView(Model m) { return new SimulationView((RandomWalkSimulation)m); }

    public String[] getEditCommands() { return new String[]{"Start","Suspend","Resume","Stop","Stats"}; }

    public Command makeEditCommand(Model model, String type,Object Source) {
        for( String s : getEditCommands()){
            if (type.equals(s)){ return new SimCommand(model,s); }
        }
        return null;
    }

    public String getTitle() { return "SimStation"; }

    public String[] getHelp() {
        return new String[] {"Help"};
    }

    public String about() {
        return "About";
    }
}
