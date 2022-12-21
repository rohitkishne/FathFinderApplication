/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mazerunner;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author dell
 */
public class NewClass extends JFrame implements ActionListener{
    private int[][] maze = {
        {1,1,1,1,1,1,1,1,1,1,1,1,1},
          {1,0,1,0,1,0,1,0,0,0,0,0,1},
          {1,0,1,0,0,0,1,0,1,1,1,0,1},
          {1,0,0,0,1,1,1,0,0,0,0,0,1},
          {1,0,1,0,0,0,0,0,1,1,1,0,1},
          {1,0,1,0,1,1,1,0,1,0,0,0,1},
          {1,0,1,0,1,0,0,0,1,1,1,0,1},
          {1,0,1,0,1,1,1,0,1,0,1,0,1},
          {1,0,0,0,0,0,0,0,0,0,0,9,1},
          {1,1,1,1,1,1,1,1,1,1,1,1,1}
    };
    private List<Integer> path;
    JButton changeBack;
    NewClass(){
        this.path = new ArrayList<>();
        this.setTitle("Maze Runner");
        
        changeBack = new JButton("Change Background");
        changeBack.addActionListener(this);
        changeBack.setBounds(350, 550, 200, 30);
        this.setLayout(null);
       
        Image icon = Toolkit.getDefaultToolkit().getImage("D:\\Java project\\MazeRunner\\maze.jpg");
        this.setIconImage(icon);
        this.setSize(1000, 1000);
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(changeBack);
        MazeRunner.searchpath(maze, 1,1, path);
        System.out.println(path);  
        
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==changeBack)
        {
            Color initialcolor = Color.DARK_GRAY;
            Color color = JColorChooser.showDialog(this,"Select a Background Color", initialcolor);
            this.getContentPane().setBackground(color);
            JOptionPane.showMessageDialog(null, "Changed has been Successfully Done");
        }
    }
    
    public void paint(Graphics g)
    {
        super.paint(g);
        
        Toolkit t=Toolkit.getDefaultToolkit();  
        Image img=t.getImage("mazelogo.jpeg");
        g.drawImage(img, 120,50,this);  
        
//        g.setColor(Color.BLUE);
//        g.setFont(g.getFont().deriveFont(30f));
//        g.drawString("Maze Runner", 350, 120); 
         
        g.translate(250,200);
        
        for(int rows=0; rows<maze.length; rows++)
        {
            for(int col=0; col<maze[0].length; col++)
            {
                Color color;
                switch(maze[rows][col])
                {
                    case 1: color = Color.BLACK; break;
                    case 9: color = Color.RED; break;
                    default :
                        color = Color.white; break;
                }
                
                g.setColor(color);
                g.fillRect(30*col, 30*rows, 30,30);
                g.setColor(Color.red);
                g.drawRect(30*col, 30*rows, 30, 30);
                
            }
        }
        
        for(int i=0; i<path.size(); i+=2)
        {
            int pathx = path.get(i);
            int pathy = path.get(i+1);
            
            System.out.println("Path of X Coordinate "+pathx);
            System.out.println("Path of Y Coordinate "+pathy);
            
            g.setColor(Color.blue);
            g.fillRect(pathx*30, pathy*30, 30, 30);
            
        }
        
    }
    public static void main(String[] args)
    {
        NewClass view = new NewClass();
        view.setVisible(true);
        
    }
    
    
}
