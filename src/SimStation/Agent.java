package SimStation;

import SimStation.Heading.headingState;

import java.io.Serializable;

public class Agent implements Serializable, Runnable {

    private String name;
    protected Heading heading;
    protected int x = 0;
    protected int y = 0;
    private Thread agentThread;
    protected Simulation world;

    private AgentState currentState;

    public Agent(){
        currentState = AgentState.READY;
    }

    public void setWorld(Simulation world) {
        this.world = world;
    }

    @Override
    public synchronized void run() {
        agentThread = Thread.currentThread();
        while(!(currentState == AgentState.STOPPED)){
            currentState = AgentState.RUNNING;
            update();
            //currentState = AgentState.STOPPED;
            try{
                Thread.sleep(100);
                synchronized (this){
                    while(currentState == AgentState.SUSPENDED){wait();}
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public synchronized void start(){currentState = AgentState.READY;run();}
    public synchronized void suspend(){ if(currentState == AgentState.RUNNING){ currentState = AgentState.SUSPENDED; }}
    public synchronized void resume(){ if(!(currentState == AgentState.STOPPED)) notify(); }
    public synchronized void stop(){ currentState = AgentState.STOPPED; }
    public synchronized AgentState getState(){return currentState;}
    public String getName(){return name;}

    public synchronized void join() throws InterruptedException{
        if(agentThread != null){
            agentThread.join();
        }
    }

    public void update(){}

    public void move(int move){
        switch(heading.getDirection()){
            case NORTH:
                y-=move;
                break;
            case WEST:
                x-=move;
                break;
            case EAST:
                x+=move;
                break;
            case SOUTH:
                y+=move;
                break;
        }
        if(x < 0){
            x = 200-x;
        }
        if(y < 0){
            y = 200-y;
        }
        if(x > 250){
            x = x-200;
        }
        if(y > 250){
            y = y-200;
        }
        world.changed();
    }

    public enum AgentState {
        READY,
        RUNNING,
        SUSPENDED,
        STOPPED
    }

}


