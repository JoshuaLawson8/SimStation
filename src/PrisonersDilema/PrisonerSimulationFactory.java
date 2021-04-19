package PrisonersDilema;

import SimStation.SimulationFactory;
import mvc.*;

public class PrisonerSimulationFactory extends SimulationFactory{
    public Model makeModel() {return new PrisonerSimulation();}
    public String getTitle() {return "Prisoner's Dilemma";}
    public String[] getHelp() { return new String[] {"Agents communicate and make decisions with each other, gaining a fitness score."}; }
    public String about() {
        return "Built by Group 5";
    }
}
