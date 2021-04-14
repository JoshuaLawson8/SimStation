//package Flocking;
//
//import SimStation.Agent;
//import tools.Utilities;
//
//public class Bird extends Agent{
//
//    private String heading;
//    private int speed;
//
//    public Bird(String name){
//        super(name);
//        speed = Utilities.rng.nextInt(5);
//    }
//
//    @Override
//    public void update(){
//        Bird b = getNeighbor(10);
//        if (b != null){
//            this.speed = b.getSpeed();
//            this.heading = b.heading;
//        }
//        move(speed);
//    }
//
//    public int getSpeed(){
//        return speed;
//    }
//
//    public Bird getNeighbor(int range){
//        ArrayList<Agent> a = world.getAgents();
//        int searches = 0;
//        int ind = Utilities.rng.nextInt(a.size());
//        while (searches < a.size()){
//            Bird b = (Bird)a.get(ind);
//            if (distance(this, b) < range){
//                return b;
//            }
//            searches++;
//            if (ind == (a.size()-1)) {
//                ind = 0;
//            }
//            else { ind ++; }
//        }
//        return null;
//    }
//
//    public double distance(Bird a, Bird b){
//        int j, k;
//        j = (a.xc-b.xc)*(a.xc-b.xc);
//        k = (a.yc-b.yc)*(a.yc-b.yc);
//        return Math.sqrt(j+k);
//    }
//
//    @Override
//    public void move(int move){
//
//    }
//}
//
