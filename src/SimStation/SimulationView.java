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
        System.out.println("repainting");
        super.paintComponent(g);
        Color oldColor = g.getColor();

        Simulation sim = (Simulation) model;
        g.setColor(Color.red);
        for(int i = 0; i < sim.Agents.size(); i++){
            System.out.println("repainting: " + i);
            //System.out.println("printing agent: " + sim.Agents.get(i).getY());
            g.fillRect(sim.Agents.get(i).getX(), sim.Agents.get(i).getY(),3,3);
        }

        g.setColor(oldColor);


    }

    @Override
    public void propertyChange(PropertyChangeEvent evt){
        System.out.println("received change");
        repaint();
        System.out.println("changed");
    }

}
