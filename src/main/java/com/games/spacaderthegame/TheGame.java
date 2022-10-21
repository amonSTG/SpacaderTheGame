package com.games.spacaderthegame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import com.games.spacaderthegame.release.enemys.Boss;
import com.games.spacaderthegame.release.enemys.Enemy;
import com.games.spacaderthegame.release.environment.Universe;
import com.games.spacaderthegame.release.interfaces.Parameters;
import com.games.spacaderthegame.release.player.Player;
import com.games.spacaderthegame.release.player.Shot;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TheGame extends Application implements Parameters {
    public static GraphicsContext gc;
    boolean gameOver = false;


    static Player player;
    List<Shot> shots;
    List<Universe> univ;
    List<Enemy> enemies;

    List<Boss> bosses;

    double mouseX;

    private static int score;

    public static int distance(int x1, int y1, int x2, int y2) {
        return (int) Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
    }

    //start
    public void start(Stage stage) {
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        gc = canvas.getGraphicsContext2D();
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(100), e -> run(gc)));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();


        canvas.setCursor(Cursor.CROSSHAIR);
        canvas.setOnMouseMoved(e -> mouseX = e.getX());

        canvas.setOnMouseClicked(e -> {
            if (shots.size() < MAX_SHOTS) shots.add(player.shoot());
            if (gameOver) {
                gameOver = false;
                setup();
            }
        });
        setup();
        stage.setScene(new Scene(new StackPane(canvas)));
        stage.setTitle("Spacader - Rise of Omegatron");
        stage.show();

    }


    //setup the game
    private void setup() {
        univ = new ArrayList<>();
        shots = new ArrayList<>();
        enemies = new ArrayList<>();
        bosses = new ArrayList<>();
        player = new Player(WIDTH / 2, HEIGHT - PLAYER_SIZE, PLAYER_SIZE, PLAYER_IMG);

        score = 0;
        IntStream.range(0, MAX_BOSSES).mapToObj(i -> this.newBoss()).forEach(bosses::add);
        IntStream.range(0, MAX_BOMBS).mapToObj(i -> this.newEnemy()).forEach(enemies::add);
    }

    //run Graphics
    private void run(GraphicsContext gc) {
        gc.setFill(Color.grayRgb(20));
        gc.fillRect(0, 0, WIDTH, HEIGHT);
        gc.setTextAlign(TextAlignment.CENTER);
        gc.setFont(Font.font(20));
        gc.setFill(Color.WHITE);
        gc.fillText("Score: " + score, 60, 20);


        if (gameOver) {
            gc.setFont(Font.font(35));
            gc.setFill(Color.YELLOW);
            gc.fillText("Game Over \n Your Score is: " + score + " \n Click to play again", WIDTH / 2, HEIGHT / 2.5);
            //	return;
        }
        univ.forEach(Universe::draw);

        player.update();
        player.draw();
        player.posX = (int) mouseX;


        enemies.stream().peek(Player::update).peek(Player::draw).forEach(e -> {
            if (player.colide(e) && !player.exploding) {
                player.explode();
            }
        });


        for (int i = shots.size() - 1; i >= 0; i--) {
            Shot shot = shots.get(i);
            if (shot.posY < 0 || shot.toRemove) {
                shots.remove(i);
                continue;
            }
            shot.update();
            shot.draw();

            for (Enemy enemy : enemies) {
                if (shot.colide(enemy) && !enemy.exploding) {
                    score++;
                    enemy.explode();
                    shot.toRemove = true;
                }
            }

            for (Boss boss : bosses) {
                if (shot.colide(boss) && !boss.exploding) {
                    score += 5;
                    boss.explode();
                    shot.toRemove = true;
                }
            }
        }


            if (score >=20) {
                bosses.stream().peek(Player::update).peek(Player::draw).forEach(e -> {
                    if (player.colide(e) && !player.exploding) {
                        player.explode();
                    }
                });

                for (int i = bosses.size() - 1; i >= 0; i--) {
                    if (bosses.get(i).destroyed) {
                        bosses.set(i, newBoss());
                    }
                }

                for (int i = enemies.size() - 1; i >= 0; i--) {
                    if (enemies.get(i).destroyed) {
                        enemies.set(i, newEnemy());
                    }
                }
            } else {

                for (int i = enemies.size() - 1; i >= 0; i--) {
                    if (enemies.get(i).destroyed) {
                        enemies.set(i, newEnemy());
                    }
                }
            }


        gameOver = player.destroyed;
        if(RAND.nextInt(10) > 2) {
            univ.add(new Universe());
        }
        for (int i = 0; i < univ.size(); i++) {
            if(univ.get(i).posY > HEIGHT)
                univ.remove(i);
        }
    }



    Enemy newEnemy() {
        return new Enemy(50 + RAND.nextInt(WIDTH - 200), 0, PLAYER_SIZE / 2, BOMBS_IMG[RAND.nextInt(BOMBS_IMG.length)]);
    }

    Boss newBoss() {
        return new Boss(50 + RAND.nextInt(WIDTH - 200), 0, BOSS_SIZE, BOSSES_IMG[RAND.nextInt(BOSSES_IMG.length)]);
    }



    public static void main(String[] args) {
        launch();
    }

    public static int getScore() {
        return score;
    }
}