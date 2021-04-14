package Flocking;

import SimStation.SimulationFactory;
import mvc.*;

public class FlockingSimulationFactory extends SimulationFactory {
    public Model makeModel() { return new FlockingSimulation(); }
    public String getTitle() { return "Random Walks";}

}
