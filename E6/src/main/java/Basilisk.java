public class Basilisk extends Creature {

    public Basilisk (int posX, int posY){
        //complete constructor
        health = 200;
        power = 30;
        this.posX = posX;
        this.posY = posY;
    }

    @Override
    public boolean isInRange(int targetPosX, int targetPosY) {
        //complete this method
        int left = posX - 2;
        int right = posX + 2;
        return targetPosX >= left && targetPosX <= right && posY + 2 == targetPosY;

    }

}
