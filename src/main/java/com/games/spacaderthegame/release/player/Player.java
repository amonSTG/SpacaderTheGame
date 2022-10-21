package com.games.spacaderthegame.release.player;
import com.games.spacaderthegame.TheGame;
import com.games.spacaderthegame.release.interfaces.Parameters;
import javafx.scene.image.Image;

import static com.games.spacaderthegame.TheGame.gc;

public class Player implements Parameters {

    public int posX;
    public int posY;
    int size;
    public boolean exploding;
    public boolean destroyed;
    Image img;
    int explosionStep = 0;




    public Player(int posX, int posY, int size,  Image image) {
        this.posX = posX;
        this.posY = posY;
        this.size = size;
        img = image;
    }

    public Shot shoot() {
        return new Shot(posX + size / 2 - Shot.size / 2, posY - Shot.size);
    }

    public void update() {
        if(exploding) explosionStep++;
        destroyed = explosionStep > EXPLOSION_STEPS;
    }

    public void draw() {
        if(exploding) {
            gc.drawImage(EXPLOSION_IMG, explosionStep % EXPLOSION_COL * EXPLOSION_W, (explosionStep / EXPLOSION_ROWS) * EXPLOSION_H + 1,
                    EXPLOSION_W, EXPLOSION_H,
                    posX, posY, size, size);
        }
        else {
            gc.drawImage(img, posX, posY, size, size);
        }
    }


    public boolean colide(Player other) {
        int d = TheGame.distance(this.posX + size / 2, this.posY + size /2,
                other.posX + other.size / 2, other.posY + other.size / 2);
        return d < other.size / 2 + this.size / 2 ;
    }

    public void explode() {
        exploding = true;
        explosionStep = -1;
    }




}
