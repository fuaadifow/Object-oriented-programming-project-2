public class Goblin extends Creature {
// distance of attack

    // additional final attribute of distance
    public static  final  int DISTANCE = 3;
    public Goblin(int posX, int posY){
        //complete constructor
        health = 80;
        power = 15;
        this.posX = posX;
        this.posY = posY;
    }

    @Override
    public boolean isInRange(int targetPosX, int targetPosY) {
        //complete this method
        if (targetPosX == posX) {
            for (int y = posY - DISTANCE; y < posY + DISTANCE;  y++) {
                if (targetPosY == y) {
                    return true;
                }
            }
        }
        if (targetPosY == posY) {
            for (int x = posX - DISTANCE; x < posX + DISTANCE;  x++) {
                if (targetPosX == x) {
                    return true;
                }
            }
        }
        for (int i = posX - 2; i <= posX + 2; i++) {
            for (int j = posY - 2; j <= posY + 2; j++) {
                if (i == targetPosX && j == targetPosY) {
                    return true;
                }
            }
        }
        return false;
    }
}
