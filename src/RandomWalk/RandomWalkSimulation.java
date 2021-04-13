package RandomWalk;

import SimStation.*;
import mvc.*;

import java.awt.*;
import java.util.Iterator;

public class RandomWalkSimulation extends Simulation {

    public void populate() {
        for(int i = 0; i < 15; i++){
            Agent a = new Drunk();
            a.setWorld(this);
            addAgent(a);
        }

    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new RandomWalkFactory());
        panel.display();
    }

}