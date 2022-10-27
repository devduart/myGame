package mygame.modelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

public class Fase extends  JPanel implements ActionListener {

    private Image fundo;
    private Player player;
    private Timer timer;


    public Fase(){
        setFocusable(true);
        setDoubleBuffered(true);

        ImageIcon referencia = new ImageIcon("res\\Blackground.png");
        fundo = referencia.getImage();

        player = new Player();
        player.load();

        addKeyListener(new TecladoAdapter());

        timer = new Timer(5, this);
        timer.start();


    }

    public void paint(Graphics g){
        Graphics2D graficos = (Graphics2D) g;
        graficos.drawImage(fundo,0,0,null);
        graficos.drawImage(player.getImagem(), player.getX(), player.getY(), this);

        List<Tiro> tiros = player.getTiros();
        for (int i = 0; i < tiros.size(); i++){
            Tiro m = tiros.get(i);
            m.load();
            graficos.drawImage(m.getImagem(), m.getX(), m.getY(), this);
        }

        g.dispose();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        player.update();
        List<Tiro> tiros = player.getTiros();
        for (int i = 0; i < tiros.size(); i++){
            Tiro m = tiros.get(i);
                if (m.isVisivel()){
                    m.upadte();
                }else {
                    tiros.remove(i);
                }
        }
        repaint();
    }

    private class TecladoAdapter extends KeyAdapter{

        @Override
        public void keyPressed(KeyEvent e){
            player.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e){
            player.keyRelease(e);
        }
    }
}
