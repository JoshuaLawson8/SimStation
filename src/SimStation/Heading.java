package SimStation;

public class Heading {

    private static headingState direction;

    public Heading(headingState a){
        direction = a;
    }

    public static Heading random(){

        int random = (int)(Math.random() * 4);
        switch(random){
            case 0:
                return new Heading(headingState.NORTH);
            case 1:
                return new Heading(headingState.SOUTH);
            case 2:
                return new Heading(headingState.EAST);
            case 3:
                return new Heading(headingState.WEST);
        }
        return null;
    }

    public headingState getDirection() {
        return direction;
    }

    enum headingState {
        NORTH,
        SOUTH,
        EAST,
        WEST
    }
}