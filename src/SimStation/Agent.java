package SimStation;

import java.io.Serializable;

public class Agent implements Serializable, Runnable {

    private String name;
    private String heading;
    private int xc;
    private int yc;
    private Thread agentThread;

    private AgentState currentState;

    public Agent(String name){
        this.name = name;
        currentState = AgentState.READY;
    }

    @Override
    public void run() {
        agentThread = Thread.currentThread();
        while(!(currentState == AgentState.STOPPED)){
            currentState = AgentState.RUNNING;
            update();
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


