package Plague;

import SimStation.Agent;
import tools.Utilities;

public class Host extends Agent {

    private boolean infected;
    private int speed = 3;

    public Host(String name) {
        super(name);
        heading = Heading.random();
        int luck = Utilities.rng.nextInt(100);
        infected = luck < PlagueSimulation.PERCENT_INITIAL_INFECTED;
    }

    public boolean getInfected(){
        return infected;
    }

    public void update() {
        Host h = (Host) sim.getNeighbor(this, 10);
        if (h != null) {
            if (h.getInfected() == true) {
                int r = Utilities.rng.nextInt(100);
                if (r < PlagueSimulation.VIRULENCE) {
                    r = Utilities.rng.nextInt(100);
                    if (r > PlagueSimulation.RESISTANCE) {
                        this.infected = true;
                    }
                }
            }
        }
        move(speed);
    }

}
