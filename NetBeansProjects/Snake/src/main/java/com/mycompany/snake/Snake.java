/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snake;

import static com.mycompany.snake.Direction.DOWN;
import static com.mycompany.snake.Direction.LEFT;
import static com.mycompany.snake.Direction.RIGHT;
import static com.mycompany.snake.Direction.UP;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author saliheany
 */
public class Snake {
    
    private List<Node> nodes;
    private Direction direction;
    private DrawSquareInterface drawSquareInterface;
    private int nodesToGrow;
    
    public Snake (DrawSquareInterface drawSquareInterface) {
        direction = direction.LEFT;
        nodes = new ArrayList<Node>();
        this.drawSquareInterface = drawSquareInterface;
        int initRow = Board.NUM_ROWS /2 ;
        int initCol = Board.NUM_COLS /2;
        
        for(int i = 0; i < 4 ; i++){
            Node node = new Node(initRow, initCol + i);
            nodes.add(node);
        }    
    }
    public void paint(Graphics g) {
        boolean first = true;
        for(Node node : nodes) {
            drawSquareInterface.drawSquare(g, node.getRow(), node.getCol(), first);
            if (first) {
                first = false;
            }
        }
    }
    public void changeDirection(Direction direction){
        this.direction = direction;
    }
    public Direction getDirection(){
        return direction;
    }
    public boolean canMove(){
        switch (direction){
            case UP:
                if(nodes.getFirst().getRow()- 1 < 0){
                    return false;
                }
                break;
            case DOWN:
                if(nodes.getFirst().getRow() + 1 >= Board.NUM_ROWS){
                    return false;
                }
                break;
            case RIGHT:
                if(nodes.getFirst().getCol() + 1 >= Board.NUM_COLS){
                    return false;
                }
                break;
            case LEFT:
                if(nodes.getFirst().getCol() -1 < 0){
                    return false;
                }
                break;
        } 
        return true;
    }
    public void moveSnake(){
        int row = nodes.getFirst().getRow();
        int col = nodes.getFirst().getCol();
        Node node = null;
        
        switch (direction){
            case UP:
                node = new Node(row -1, col);
                break;
            case DOWN:
                node = new Node(row +1, col);
                break;
            case RIGHT:
                node = new Node(row, col + 1);
                break;
            case LEFT:
                node = new Node(row, col - 1);
                break;
        } 
        nodes.addFirst(node);
        if (nodesToGrow == 0) {
            nodes.removeLast();
        }
    }
}
