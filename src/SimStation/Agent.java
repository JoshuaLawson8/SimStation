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
        while(currentState.equals(AgentState.RUNNING)){
            update();
        }
    }

    public void start(){

    }

    public void suspend(){

    }

    public void resume(){

    }
    public void stop(){

    }

    public void update(){

    }

    public void move(int move){

    }
    public enum AgentState {
        READY,
        RUNNING,
        SUSPENDED,
        STOPPED
    }
}


