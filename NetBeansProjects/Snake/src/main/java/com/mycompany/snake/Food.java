/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snake;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author saliheany
 */
public class Food extends Node {
    
    private DrawSquareInterface drawSquareInterface;
    
    public Food() {
        super(0,0);
        int row = (int) (Math.random() * Board.NUM_ROWS);
        int col = (int) (Math.random() * Board.NUM_COLS);

        setRow(row);
        setCol(col);
    }
    
    public void paint(Graphics g){
        drawSquareInterface.drawSquare(g, getRow(), getCol(), true);
    }
    
}
