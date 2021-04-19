package PrisonersDilema;

import SimStation.Agent;
import tools.Utilities;
import java.io.Serializable;

public class Prisoner extends Agent {

    private int fitness = 0;
    private boolean cheated = false;
    private Strategy strategy;

    public Prisoner(String name){
        super(name);
        heading = Heading.random();
    }

    public void setStrategy(Strategy s){
        this.strategy = s;
    }

    public Strategy getStrategy(){
        return this.strategy;
    }

    public int getFitness(){
        return this.fitness;
    }

    @Override
    public void update() {
        Prisoner p = (Prisoner)sim.getNeighbor(this, 10);
        if (p!=null){
            if (this.strategy.cooperate(cheated) && p.strategy.cooperate(cheated)){
                this.updateFitness(3);
                cheated = false;
            }
            else if (this.strategy.cooperate(cheated) && !p.strategy.cooperate(cheated)){
                cheated = true;
            }
            else if (!this.strategy.cooperate(cheated) && p.strategy.cooperate(cheated)){
                this.updateFitness(5);
            }
            else if (!this.strategy.cooperate(cheated) && !p.strategy.cooperate(cheated)){
                this.updateFitness(1);
                this.cheated = true;
            }
        }
        move(1);
    }

    public void updateFitness(int amt){
        fitness += amt;
    }

}

abstract class Strategy implements Serializable {
    public abstract boolean cooperate(boolean cheated);
}

class Cooperate extends Strategy{
    public boolean cooperate(boolean cheated){
        return true;
    }
}

class Cheat extends Strategy{
    public boolean cooperate(boolean cheated){
        return false;
    }
}

class RandomlyCooperate extends Strategy{
    public boolean cooperate(boolean cheated){
        int n = Utilities.rng.nextInt(100);
        if (n < 50) { return false;}
        else {return true;}
    }
}

class TitForTat extends Strategy{
    public boolean cooperate(boolean cheated){
        if (cheated){
            return false;
        }
        else{ return true;}
    }
}