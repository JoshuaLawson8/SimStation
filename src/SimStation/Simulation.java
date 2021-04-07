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
        if(heading.equals("Stats")){
            Utilities.inform(new String[]{"#Agents = "+Agents.size(),"clock = "+clock});
        }

    }

    public Agent getNeighbor(){return null;}

    public void populate(){}



}

