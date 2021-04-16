package Plague;

import SimStation.SimulationView;
import java.awt.*;

public class PlagueSimulationView extends SimulationView{

    public PlagueSimulationView(PlagueSimulation ps){
        super(ps);
        repaint();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Color oldColor = g.getColor();


        PlagueSimulation ps = (PlagueSimulation) model;
        for (int i = 0; i < ps.getAgents().size(); i++){
            Host h = (Host)ps.getAgents().get(i);
            if (h.getInfected()){
                g.setColor(Color.red);
            }
            else {g.setColor(Color.green);}
            g.fillRect(h.getX(), h.getY(),3, 3);
        }

        g.setColor(oldColor);
    }
}
