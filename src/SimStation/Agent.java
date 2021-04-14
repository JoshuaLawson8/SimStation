package SimStation;

import java.io.Serializable;

public class Agent implements Serializable, Runnable {

    protected String name;
    protected int x = 0;
    protected int y = 0;
    protected Heading heading;

    private Thread agentThread;
    private boolean suspended, stopped;
    protected Simulation sim;

    public Agent(String name) {
        this.name = name;
        suspended = false;
        stopped = false;
        agentThread = null;
    }

    public void setSim(Simulation sim) { this.sim = sim; }
    public String getName() { return name; }
    public int getX() { return x; }
    public int getY() { return y; }

    public synchronized void stop() { stopped = true; }
    public synchronized boolean isStopped() { return stopped; }
    public synchronized void suspend() { suspended = true; }
    public synchronized boolean isSuspended() { return suspended;  }
    public synchronized void resume() { notify(); }

    private synchronized void checkSuspended() {
        try {
            while(!stopped && suspended) {
                wait();
                suspended = false;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        agentThread = Thread.currentThread();
        while (!isStopped()) {
            try {
                update();
                Thread.sleep(10);
                checkSuspended();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name + " stopped");
    }


    public synchronized void join() {
        try {
            if (agentThread != null) agentThread.join();
        } catch(InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("joined");
    }


    public void update(){}

    public void move(int move){
        switch(heading){
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
        if(x < 0){ x = 250+x;}
        if(y < 0){ y = 250+y;}
        if(x > 250){x = x-250;}
        if(y > 250){ y = y-250;}
        sim.changed();
    }

    public enum Heading {
        NORTH,
        SOUTH,
        EAST,
        WEST;

        public static Heading random() {
            int random = (int) (Math.random() * 4);
            switch (random) {
                case 0:
                    return NORTH;
                case 1:
                    return SOUTH;
                case 2:
                    return EAST;
                case 3:
                    return WEST;
            }
            return null;
        }
    }

}


