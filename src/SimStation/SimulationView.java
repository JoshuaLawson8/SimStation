package SimStation;

import mvc.View;

import java.awt.*;
import java.beans.PropertyChangeEvent;

public class SimulationView extends View {


    public SimulationView(Simulation obj){
        super(obj);
        repaint();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Color oldColor = g.getColor();

        Simulation sim = (Simulation) model;
        g.setColor(Color.red);
        for(int i = 0; i < sim.Agents.size(); i++){
            g.fillRect(sim.Agents.get(i).getX(), sim.Agents.get(i).getY(),3,3);
            //System.out.println(sim.Agents.get(i).getX());
            //System.out.println(sim.Agents.get(i).getY());

        }

        g.setColor(oldColor);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt){
        repaint();
    }

}
