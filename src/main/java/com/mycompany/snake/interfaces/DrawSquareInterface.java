/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.snake.interfaces;

import java.awt.Color;
import java.awt.Graphics;
import com.mycompany.snake.SquareColor;

/**
 *
 * @author saliheany
 */
public interface DrawSquareInterface {
    public void drawSquare(Graphics g, int row, int col,
            SquareColor sc);
}
