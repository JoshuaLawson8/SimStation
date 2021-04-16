package Plague;

import SimStation.Simulation;
import SimStation.SimulationPanel;
import SimStation.Agent;
import mvc.AppPanel;
import tools.Utilities;

public class PlagueSimulation extends Simulation {
    public static int VIRULENCE = 50;
    public static int RESISTANCE = 2;
    public static int PERCENT_INITIAL_INFECTED = 10;


    @Override
    public void populate(){
        for (int i = 0; i < 50; i++){
            Host a = new Host("Host " + (i+1));
            a.setSim(this);
            addAgent(a);
        }
    }

    @Override
    public void getStats(){
        double percentInfected;
        int infected = 0;
        for (Agent a : Agents){
            if (a instanceof Host){
                Host h = (Host)a;
                if (h.getInfected()){infected++;}
            }
        }
        percentInfected = (double)infected/Agents.size()*100;
        Utilities.inform(new String[]{"#Agents = "+Agents.size(),"clock = "+getClock(), "% infected = " + percentInfected});
    }

    public static void main(String[] args){
        AppPanel panel = new SimulationPanel(new PlagueSimulationFactory());
        panel.display();
    }
}
