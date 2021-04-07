package SimStation;

import mvc.AppFactory;
import mvc.AppPanel;

import java.awt.*;
import javax.swing.*;

public class SimulationPanel extends AppPanel{

        public SimulationPanel(AppFactory factory) {
            super(factory);
            String[] buttonNames = af.getEditCommands();
            for(int i = 0; i < buttonNames.length; i++) {
                JButton current = new JButton(buttonNames[i]);
                current.addActionListener(this);
                controlPanel.add(current);
            }
            controlPanel.setLayout(new FlowLayout());
        }

        public static void main(String[] args) {
            AppFactory factory = new SimulationFactory();
            AppPanel panel = new SimulationPanel(factory);
            panel.display();
        }
}
