package RandomWalk;

import SimStation.*;
import tools.*;

class Drunk extends Agent {

    public Drunk() {
        super("Drunk");
        heading = Heading.random();
    }

    public void update() {
        heading = Heading.random();
        int steps = Utilities.rng.nextInt(10) + 1;
        move(steps);
    }

}