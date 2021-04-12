package RandomWalk;

import SimStation.Simulation;
import SimStation.SimulationPanel;
import mvc.AppPanel;

public class RandomWalk extends Simulation {

    public static final int POP = 50;

    @Override
    public void populate() {
        for(int i = 0; i < POP;){
            Agents.add(new Drunk("Drunk" + i));
        }


    }
    public static void main(String[]args){


    }
}
