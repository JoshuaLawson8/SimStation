package SimStation;

import mvc.Model;
import tools.Utilities;

import java.util.ArrayList;

public class Simulation extends Model {

    private int clock = 0;
    private ArrayList<Agent> Agents;

    public Simulation(){
        Agents = new ArrayList<Agent>();
    }

    public void changeState(String heading){
        if(heading.equals("Start")){
            populate();
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

    public Agent getNeighbor(Agent a){return null;}

    public void populate(){}



}

