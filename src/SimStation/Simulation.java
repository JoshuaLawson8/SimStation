package SimStation;

import mvc.Model;
import tools.Utilities;

import java.util.*;

public class Simulation extends Model {

    private Timer timer;
    private int clock = 0;
    protected ArrayList<Agent> Agents;

    public Simulation(){
        Agents = new ArrayList<Agent>();
        populate();
    }

    public void changeState(String heading){
        if(heading.equals("Start")){
            for(Agent a : Agents){
                a.start();
            }
        }
        if(heading.equals("Suspend")){
            for(Agent a : Agents){
                a.suspend();
            }
        }
        if(heading.equals("Resume")){
            for(Agent a : Agents){
                a.resume();
            }
        }
        if(heading.equals("Stop")){
            for(Agent a : Agents){
                a.stop();
            }
        }
        if(heading.equals("Stats")){
            Utilities.inform(new String[]{"#Agents = "+Agents.size(),"clock = "+clock});
        }
    }

    public void addAgent(Agent a){ Agents.add(a); }

    public ArrayList<Agent> getAgents() {
        return Agents;
    }

    //Can these be abstract?
    public Agent getNeighbor(Agent a){return null;}

    public void populate(){}


    //Time methods

    private void startTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new ClockUpdater(), 1000, 1000);
    }

    private void stopTimer() {
        timer.cancel();
        timer.purge();
    }

    private class ClockUpdater extends TimerTask {
        public void run() {
            clock++;
            //changed();
        }
    }


}

