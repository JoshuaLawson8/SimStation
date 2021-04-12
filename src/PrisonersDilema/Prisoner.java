package PrisonersDilema;

public class Prisoner {
    private int fitness = 0;

    public boolean cooperate(){
       if(fitness > 0){
           return true;
       }
       return false;
    }

}
