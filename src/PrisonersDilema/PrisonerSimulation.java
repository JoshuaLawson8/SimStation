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
        ArrayList<Integer> cooperate = new ArrayList<Integer>();
        ArrayList<Integer> cheat = new ArrayList<Integer>();
        ArrayList<Integer> random = new ArrayList<Integer>();
        ArrayList<Integer> tit  = new ArrayList<Integer>();
        for (Agent a : Agents){
            if(a instanceof Prisoner){
                Prisoner p = (Prisoner)a;
                if (p.getStrategy() instanceof Cooperate){
                    cooperate.add(p.getFitness());
                }
                else if (p.getStrategy() instanceof Cheat){
                    cheat.add(p.getFitness());
                }
                else if (p.getStrategy() instanceof RandomlyCooperate){
                    random.add(p.getFitness());
                }
                else {
                    tit.add(p.getFitness());
                }
            }
        }

        cooperateAvg = averageList(cooperate);
        cheatAvg = averageList(cheat);
        randomAvg = averageList(random);
        titAvg = averageList(tit);

        Utilities.inform(new String[] {"Cooperate Average: " + cooperateAvg, "Cheat Average: " + cheatAvg,
                                        "Randomly Cooperate Average: " + randomAvg,
                                        "Tit for Tat Average: " + titAvg});
    }

    public double averageList(ArrayList<Integer> list){
        int total = 0;
        for (Integer i : list){
            total+=i;
        }
        return (double)total/list.size();
    }

    public static void main(String[] args){
        AppPanel panel = new SimulationPanel(new PrisonerSimulationFactory());
        panel.display();
    }
}
