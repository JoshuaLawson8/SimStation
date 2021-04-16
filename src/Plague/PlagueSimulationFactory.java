package Plague;

import SimStation.SimulationFactory;
import mvc.*;

public class PlagueSimulationFactory extends SimulationFactory{

    public Model makeModel() { return new PlagueSimulation(); }
    public String getTitle() { return "Plague";}
    public View makeView(Model m) { return new PlagueSimulationView((PlagueSimulation) m);}

}
