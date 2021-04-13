package Flocking;

import SimStation.Agent;
import tools.Utilities;

public class Bird extends Agent{

    private String heading;
    private int speed;

    public Bird(String name){
        super(name);
        speed = Utilities.rng.nextInt(5);
    }

    @Override
    public void update(){
        move(speed);
    }

    public int getSpeed(){
        return speed;
    }

    @Override
    public void move(int move){

    }
}

