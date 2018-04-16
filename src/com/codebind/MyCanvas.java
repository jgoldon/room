package com.codebind;


import DesignProblem.ProblemSolving;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.*;

public class MyCanvas extends JComponent {
    private static Color m_tRed = new Color(255, 0, 0, 150);

    private static Color m_tGreen = new Color(0, 255, 0, 150);

    private static Color m_tBlue = new Color(0, 0, 255, 150);

    private static Font monoFont = new Font("Monospaced", Font.BOLD
            | Font.ITALIC, 36);

    private static Font sanSerifFont = new Font("SanSerif", Font.PLAIN, 12);

    private static Font serifFont = new Font("Serif", Font.BOLD, 24);

    ProblemSolving p = new ProblemSolving();
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // draw entire component white
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());



        for (int i = 0; i < p.getSettedFurnitures().size(); i++) {
            g.setColor(Color.black);
            g.drawRect(p.getSettedFurnitures().get(i).getPosition()[0],
                    p.getSettedFurnitures().get(i).getPosition()[2],
                    p.getSettedFurnitures().get(i).getWidth(),
                    p.getSettedFurnitures().get(i).getDepth());
            JLabel l = new JLabel(p.getFurnitureList().get(i).getName());

        }




    }

    public Dimension getPreferredSize() {
        return new Dimension(
                p.getRoom().getArea().length,p.getRoom().getArea()[0].length);
    }

    public static void main(String args[]) {
        JFrame mainFrame = new JFrame("Graphics demo");
        mainFrame.getContentPane().add(new MyCanvas());
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
}
