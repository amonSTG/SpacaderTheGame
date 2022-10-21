package com.games.spacaderthegame.release.player;

import com.games.spacaderthegame.TheGame;
import com.games.spacaderthegame.release.interfaces.Parameters;

import static com.games.spacaderthegame.TheGame.distance;
import static com.games.spacaderthegame.TheGame.gc;

public class Shot implements Parameters {
    public boolean toRemove;

    int posX;
    public int posY;
    int speed = 10;
    public static final int size = 35;

    public Shot(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }


    public void update() {

            posY -= speed;

    }
    public void draw() {
        if (TheGame.getScore() >=20 && TheGame.getScore()<=50 || TheGame.getScore()>=70) {
            speed = 50;
            gc.drawImage(SUPER_MISSILE_IMG, posX-15, posY-15, size+30, size+30);
        } else {
            gc.drawImage(MISSILE_IMG, posX, posY, size, size);
        }
    }

    public boolean colide(Player Player) {
        int distance = distance(this.posX + size / 2, this.posY + size / 2,
                Player.posX + Player.size / 2, Player.posY + Player.size / 2);
        return distance  < Player.size / 2 + size / 2;
    }



}

