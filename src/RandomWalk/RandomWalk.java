package RandomWalk;

import SimStation.Simulation;

public class RandomWalk extends Simulation {

    public static final int POP = 50;

    @Override
    public void populate() {
        for(int i = 0; i < POP;){
            Agents.add(new Drunk("Drunk" + i));
        }

    }
}
