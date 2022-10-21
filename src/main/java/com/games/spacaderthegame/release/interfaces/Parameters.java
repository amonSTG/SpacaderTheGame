package com.games.spacaderthegame.release.interfaces;

import javafx.scene.image.Image;

import java.util.Random;

public interface Parameters {

    //variables
    static final Random RAND = new Random();
    static final int WIDTH = 1024 / 2;
    static final int HEIGHT = 768;
    static final int PLAYER_SIZE = 100;
    static final int BOSS_SIZE = 100;
    static final Image PLAYER_IMG = new Image("file:src/main/resources/com/games/spacaderthegame/images/spaceShip_final_animated.gif");
    static final Image EXPLOSION_IMG = new Image("file:src/main/resources/com/games/spacaderthegame/images/explosion.png");
    static final Image MISSILE_IMG = new Image("file:src/main/resources/com/games/spacaderthegame/images/newMissie_final_animated.gif");
    static final Image SUPER_MISSILE_IMG = new Image("file:src/main/resources/com/games/spacaderthegame/images/superMissile_C_final_animated.gif");
    static final int EXPLOSION_W = 128;
    static final int EXPLOSION_ROWS = 3;
    static final int EXPLOSION_COL = 3;
    static final int EXPLOSION_H = 128;
    static final int EXPLOSION_STEPS = 15;

    static final Image ENEMIES_IMG[] = {
            new Image("file: src/main/resources/com/games/spacaderthegame/images/enemy_final_animated.gif"),
            new Image("file:src/main/resources/com/games/spacaderthegame/images/enemy_final_animated.gif"),
            new Image("file:src/main/resources/com/games/spacaderthegame/images/enemy_final_animated.gif"),
            new Image("file:src/main/resources/com/games/spacaderthegame/images/enemy_final_animated.gif"),
            new Image("file:src/main/resources/com/games/spacaderthegame/images/enemy_final_animated.gif"),
            new Image("file:src/main/resources/com/games/spacaderthegame/images/enemy_final_animated.gif"),
            new Image("file:src/main/resources/com/games/spacaderthegame/images/enemy_final_animated.gif"),
            new Image("file:src/main/resources/com/games/spacaderthegame/images/enemy_final_animated.gif"),
            new Image("file:src/main/resources/com/games/spacaderthegame/images/enemy_final_animated.gif"),
            new Image("file:src/main/resources/com/games/spacaderthegame/images/enemy_final_animated.gif"),
    };


    static final Image BOSSES_IMG[] = {
            new Image("file:src/main/resources/com/games/spacaderthegame/images/boss.gif"),
    };


    final int MAX_ENEMIES = 10,  MAX_SHOTS = MAX_ENEMIES * 2;

    final int MAX_BOSSES = 1, MAX_BOSS_SHOTS = MAX_BOSSES * 4;



}
