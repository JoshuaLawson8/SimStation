package PrisonersDilema;

import SimStation.SimulationFactory;
import mvc.*;

public class PrisonerSimulationFactory extends SimulationFactory{
    public Model makeModel() {return new PrisonerSimulation();}
    public String getTitle() {return "Prisoner's Dilemma";}
}
