/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snake;

import java.awt.Graphics;

/**
 *
 * @author saliheany
 */
public class SpecialFood extends Food {
    
    private DrawSquareInterface drawSquareInterface;
    
    public SpecialFood(DrawSquareInterface drawSquareInterface) {
        super(drawSquareInterface);
       
        this.drawSquareInterface = drawSquareInterface;
        int row = (int) (Math.random() * Board.NUM_ROWS);
        int col = (int) (Math.random() * Board.NUM_COLS);

        setRow(row);
        setCol(col);
    }
    
    public void paint(Graphics g){
        drawSquareInterface.drawSquare(g, getRow(), getCol(), false);
    }
    
}
