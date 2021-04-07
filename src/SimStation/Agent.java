package SimStation;

import java.io.Serializable;

public class Agent implements Serializable, Runnable {

    private String name;
    //Heading is currentState?
    private String heading;
    private int xc;
    private int yc;

    private AgentState currentState;


    @Override
    public void run() {

    }

    public enum AgentState {
        READY,
        RUNNING,
        SUSPENDED,
        STOPPED
    }
}


