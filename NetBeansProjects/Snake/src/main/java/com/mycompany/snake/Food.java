/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snake;

import com.mycompany.snake.interfaces.DrawSquareInterface;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author saliheany
 */
public class Food extends Node {
    
    private DrawSquareInterface drawSquareInterface;
    
    public Food(DrawSquareInterface drawSquareInterface) {
        super(0,0);
        this.drawSquareInterface = drawSquareInterface;
        int row = (int) (Math.random() * Board.NUM_ROWS);
        int col = (int) (Math.random() * Board.NUM_COLS);

        setRow(row);
        setCol(col);
    }
    
    public void paint(Graphics g){
        Color color =  new Color(255, 255, 0);
        g.setColor(color);
        drawSquareInterface.drawSquare(g, getRow(), getCol(), SquareColor.FOOD);
    }
    
}
