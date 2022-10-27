package mygame;

import mygame.modelo.Fase;

import javax.swing.*;

public class Container extends JFrame {

    public Container(){
        add(new Fase());
        setTitle("My Game");  //nome do jogo
        setSize(1024,728); //tamanho da tela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //possiblita o jogo fechar quando pressionar "X"
        setLocationRelativeTo(null);  //ponto da tela onde iniciar o personagem
        this.setResizable(true);  //possiblita modificar resolução do game
        setVisible(true); //Comandos visiveis
    }

    public static void main(String[] args) {
        new Container();
    }

}
