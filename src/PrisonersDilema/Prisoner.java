package PrisonersDilema;

import SimStation.Agent;
import tools.Utilities;

import SimStation.Agent;

public class Prisoner extends Agent {
    private int fitness = 0;
    public boolean cooperate() {
      if(fitness > 0){
          return true;
      }
      return false;
    }


    public Prisoner(String name){
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
