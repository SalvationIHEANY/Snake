 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.snake;

import com.mycompany.snake.interfaces.DrawSquareInterface;
import com.mycompany.snake.interfaces.GameOverInterface;
import com.mycompany.snake.interfaces.Incrementer;
import com.mycompany.snake.interfaces.InitGamer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author saliheany
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
public class Board extends javax.swing.JPanel implements DrawSquareInterface , InitGamer {

    public static final int NUM_ROWS = 20;
    public static final int NUM_COLS = 20;
    private static final int DELTA_TIME = 200;
    public static final int SPECIAL_TIME = 3500;

    private Snake snake;
    private Food food;
    private SpecialFood specialFood;
    private Timer timer;
    private Timer specialTimer;
    private SquareColor squareColor;
    private MyKeyAdapter keyAdapter;
    private Incrementer incrementer;
    
    private GameOverInterface gameOverInterface;
    
    class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if (snake.getDirection() != Direction.RIGHT){
                        snake.changeDirection(Direction.LEFT);
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (snake.getDirection() != Direction.LEFT){
                        snake.changeDirection(Direction.RIGHT);
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (snake.getDirection() != Direction.DOWN){
                        snake.changeDirection(Direction.UP);
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (snake.getDirection() != Direction.UP){
                        snake.changeDirection(Direction.DOWN);
                    }
                    break;
            }
            repaint();
        }
    }

    /**
     * Creates new form Board
     */
    public Board() {
        initComponents();
        keyAdapter = new MyKeyAdapter();
        addKeyListener(keyAdapter);
        setFocusable(true);
        specialFood = new SpecialFood(this);
        food = new Food(this);
        snake = new Snake(this);
        int specialTime = SPECIAL_TIME;
        specialTimer = new Timer(specialTime, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                specialFood = new SpecialFood(Board.this); 
            }
        });
        timer = new Timer(DELTA_TIME, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                tick();
                     
            }
        });
        initGame();
    }
    public void pause() {
        if (timer.isRunning()) {
            timer.stop();
        } else {
            timer.start();
        }
    }
    public void clear() {
        snake = null;
        food = null;
        specialFood = null;
        repaint();
    }
    public void doGameOver() {
        timer.stop();
        specialTimer.stop();
        gameOverInterface.setVisible(this);
    }
    public void setGameOver(GameOverInterface gameOverInterface) {
        this.gameOverInterface = gameOverInterface;
    }
    public void setIncrementer(Incrementer incrementer){
        this.incrementer = incrementer;
    }
    public void initGame() {
        if (incrementer != null) {
            incrementer.resetScore();
        }
        timer.start();
        specialTimer.start();
        snake = new Snake(this);
    }
    private void tick() {
        if (snake.canMove()){
            snake.moveSnake();
            if(snake.isHead(food)) {
                snake.grow(1);
                food = new Food(this);
                incrementer.incrementScore(2);
            }
            if(snake.isHead(specialFood)) {
                snake.grow(3);
                specialFood = new SpecialFood(this);
                incrementer.incrementScore(3);
            }
        } else{
            doGameOver();
        }
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintBorderBoard(g);
        snake.paint(g);
        food.paint(g);
        if (specialFood != null) {
            specialFood.paint(g);
        }
        Toolkit.getDefaultToolkit().sync();

    }
    
    private void paintBorderBoard (Graphics g){
        g.setColor(Color.black);
        int width = squareWidth() * NUM_COLS;
        int height = squareHeight() * NUM_ROWS;
        g.drawRect(0,0, width, height);
    }

    private int squareWidth() {
        return getWidth() / NUM_COLS;
    }

    private int squareHeight() {
        return getHeight() / NUM_ROWS;
    }
   
    public void drawSquare(Graphics g, int row, int col,
            SquareColor squareColor) {
        int x = col * squareWidth();
        int y = row * squareHeight();
        Color color = getSquareColor(squareColor);
        //Color color = isHead ? new Color(204, 102, 102) : new Color(102, 204, 102);
        g.setColor(color);
        g.fillRect(x + 1, y + 1, squareWidth() - 2,
                squareHeight() - 2);
        g.setColor(color.darker());
        g.drawLine(x, y + squareHeight() - 1, x, y);
        g.drawLine(x, y, x + squareWidth() - 1, y);
        g.setColor(color.darker());
        g.drawLine(x + 1, y + squareHeight() - 1,
                x + squareWidth() - 1, y + squareHeight() - 1);
        g.drawLine(x + squareWidth() - 1,
                y + squareHeight() - 1,
                x + squareWidth() - 1, y + 1);
    }
    private Color getSquareColor(SquareColor sc) {
        switch (sc) {
            case HEAD:
                return new Color(173, 235, 179);
                
            case BODY:
                return new Color(0, 112, 74);
                
            case FOOD:
                return new Color(255, 191, 0);
                
            case SPECIALFOOD:
                return new Color( 128, 0, 128);
                
            default:
                throw new AssertionError();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
