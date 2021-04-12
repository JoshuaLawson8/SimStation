package RandomWalk;

import SimStation.Agent;

public class Drunk extends Agent {

    public Drunk(String name){
        super(name);
    }

    @Override
    public void update() {

        //heading = Math.random();
        xc = (int)(Math.random() * 10 + 1);
        yc = (int)(Math.random() * 10 + 1);
    }

    @Override
    public void move(int move) {

    }
}
