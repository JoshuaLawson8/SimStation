package Flocking;

import SimStation.Agent;
import tools.Utilities;
import java.util.*;

public class Bird extends Agent{

    private int speed;

    public Bird(String name){
        super(name);
        speed = (int)(Math.random() * 5 + 1);
        heading = Heading.random();
    }

    @Override
    public void update(){
        Bird b = (Bird)sim.getNeighbor(this, 10);
        if (b != null){
            this.speed = b.speed;
            this.heading = b.heading;
        }
        move(speed);
    }

    public int getSpeed(){
        return speed;
    }

    /*
    public Bird getNeighbor(int range){
        ArrayList<Agent> a = sim.getAgents();
        int searches = 0;
        int ind = Utilities.rng.nextInt(a.size());
        while (searches < a.size()){
            Bird b = (Bird)a.get(ind);
            if (distance(this, b) < range){
                return b;
            }
            searches++;
            if (ind == (a.size()-1)) {
                ind = 0;
            }
            else { ind ++; }
        }
        return null;
    }

    public double distance(Bird a, Bird b){
        int j, k;
        j = (a.x-b.x)*(a.x-b.x);
        k = (a.y-b.y)*(a.y-b.y);
        return Math.sqrt(j+k);
    }

     */


}

