package com.games.spacaderthegame.release.enemys;
import com.games.spacaderthegame.TheGame;
import com.games.spacaderthegame.release.interfaces.Parameters;
import com.games.spacaderthegame.release.player.Player;
import javafx.scene.image.Image;

public class Enemy extends Player implements Parameters {


    int SPEED = (TheGame.getScore() /5)+2;

    public Enemy(int posX, int posY, int size, Image image) {
        super(posX, posY, size, image);
    }

    public void update() {
        super.update();
        if(!exploding && !destroyed) posY += SPEED;
        if(posY > HEIGHT) destroyed = true;
    }
}
