package Flocking;

import SimStation.Simulation;
import SimStation.SimulationPanel;
import mvc.AppPanel;
import tools.Utilities;

import java.util.*;

public class FlockingSimulation extends Simulation {

    @Override
    public void populate(){
        for (int i = 0; i < 100; i++){
            Bird a = new Bird("bird "+ i+1);
            a.setSim(this);
            Agents.add(a);
        }
    }

    @Override
    public void getStats(){
        Map<Integer, Integer> sp = new HashMap<Integer, Integer>();
        for (Object a : Agents){
            if (a instanceof Bird){
                Bird b = (Bird)a;
                int i = b.getSpeed();
                Integer j = sp.get(i);
                if (j == null) { j = 0;}
                sp.put(i, j+1);
            }
        }
        String[] result = new String[sp.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> val : sp.entrySet()) {
            result[i] = ("#birds @ speed " + val.getKey() + " = "  + val.getValue());
            i++;
        }
        Utilities.inform(result);
    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new FlockingSimulationFactory());
        panel.display();
    }

}
