package SimStation;

import SimStation.Agent.AgentState;
import mvc.View;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;

public class SimulationView extends View {


    public SimulationView(Simulation obj){
        super(obj);
        repaint();
    }

    @Override
    public void paintComponent(Graphics g){
        //System.out.println("painting");
        super.paintComponent(g);
        Color oldColor = g.getColor();

        Simulation sim = (Simulation) model;
        g.setColor(Color.red);
        for(int i = 0; i < sim.Agents.size(); i++){
            //System.out.println("printing agent: " + sim.Agents.get(i).getY());
            g.fillRect(sim.Agents.get(i).getX(), sim.Agents.get(i).getY(),3,3);
        }

        g.setColor(oldColor);


    }

    @Override
    public void propertyChange(PropertyChangeEvent evt){

    }

}
