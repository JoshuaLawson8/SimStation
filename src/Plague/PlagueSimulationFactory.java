package Plague;

import SimStation.SimulationFactory;
import mvc.*;

public class PlagueSimulationFactory extends SimulationFactory{

    public Model makeModel() { return new PlagueSimulation(); }
    public String getTitle() { return "Plague";}
    public View makeView(Model m) { return new PlagueSimulationView((PlagueSimulation) m);}
    public String[] getHelp() { return new String[] {"Agents start out with a percentage population infected, and the infection spreads between nearby agents.  "}; }
    public String about() {
        return "Built by Group 5";
    }


}
