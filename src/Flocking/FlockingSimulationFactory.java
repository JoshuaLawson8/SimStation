package Flocking;

import SimStation.SimulationFactory;
import mvc.*;

public class FlockingSimulationFactory extends SimulationFactory {
    public Model makeModel() { return new FlockingSimulation(); }
    public String getTitle() { return "FlockingSim";}
    public String[] getHelp() { return new String[] {"Agents choose a neighbor's heading and speed to mimic, creating patterns."}; }
    public String about() {
        return "Built by Group 5";
    }

}
