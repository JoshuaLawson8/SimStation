package RandomWalk;

import SimStation.SimulationFactory;
import mvc.*;

class RandomWalkFactory extends SimulationFactory {
    public Model makeModel() { return new RandomWalkSimulation(); }
    public String getTitle() { return "Random Walks";}
    public String[] getHelp() { return new String[] {"Every 50ms, each agent chooses a random direction and distance to move. "}; }
    public String about() { return "Built by Group 5"; }
}