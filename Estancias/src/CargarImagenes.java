/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Raul
 */
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class CargarImagenes extends javax.swing.JPanel{
    int x,y;
    public CargarImagenes(JPanel FotoLogin) {
        this.x = FotoLogin.getWidth();
        this.y = FotoLogin.getHeight();
        this.setSize(x, y);
    }
    
    @Override
    public void paint(Graphics g) {
        ImageIcon Img = new ImageIcon(getClass().getResource("/ArchivosExternos/Login/imglogin.jpg"));
        System.out.println(""+Img);
        if (g.drawImage(Img.getImage(), 0, 0, x, y, null)){
            System.out.println("Si existe");
            super.paintComponent(g);
        }
        
    }    
    
}
