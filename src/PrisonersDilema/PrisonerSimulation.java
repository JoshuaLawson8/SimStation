package PrisonersDilema;

import SimStation.Simulation;
import SimStation.SimulationPanel;
import SimStation.Agent;
import mvc.AppPanel;
import tools.Utilities;
import java.util.*;

public class PrisonerSimulation extends Simulation{

    private static int population = 40;

    @Override
    public void populate() {
        for (int i = 0; i < population/4; i++){
            Prisoner p = new Prisoner("Cooperate "+ i);
            p.setStrategy(new Cooperate());
            p.setSim(this);
            addAgent(p);
        }
        for (int i = 0; i < population/4; i++){
            Prisoner p = new Prisoner("Cheat "+ i);
            p.setStrategy(new Cheat());
            p.setSim(this);
            addAgent(p);
        }
        for (int i = 0; i < population/4; i++){
            Prisoner p = new Prisoner("RandomCooperate "+ i);
            p.setStrategy(new RandomlyCooperate());
            p.setSim(this);
            addAgent(p);
        }
        for (int i = 0; i < population/4; i++) {
            Prisoner p = new Prisoner("Tit4Tat " + i);
            p.setStrategy(new TitForTat());
            p.setSim(this);
            addAgent(p);
        }
    }

    @Override
    public void getStats(){
        double cooperateAvg, cheatAvg, randomAvg, titAvg;
        int cooperate = 0;
        int cheat = 0;
        int random = 0;
        int tit = 0;
        for (Agent a : Agents){
            if(a instanceof Prisoner){
                Prisoner p = (Prisoner)a;
                if (p.getStrategy() instanceof Cooperate){
                    cooperate += p.getFitness();
                }
                else if (p.getStrategy() instanceof Cheat){
                    cheat += p.getFitness();
                }
                else if (p.getStrategy() instanceof RandomlyCooperate){
                    random += p.getFitness();
                }
                else {
                    tit += p.getFitness();
                }
            }
        }

        cooperateAvg = (double)cooperate/(population/4);
        cheatAvg = (double)cheat/(population/4);
        randomAvg = (double)random/(population/4);
        titAvg = (double)tit/(population/4);

        Utilities.inform(new String[] {"Cooperate Average: " + cooperateAvg, "Cheat Average: " + cheatAvg,
                                        "Randomly Cooperate Average: " + randomAvg,
                                        "Tit for Tat Average: " + titAvg});
    }

    public static void main(String[] args){
        AppPanel panel = new SimulationPanel(new PrisonerSimulationFactory());
        panel.display();
    }
}
