/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hanss
 */

package org.centrale.objet.WoE;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Fenetre {
    private static volatile boolean isPressed = false;
    private static volatile KeyEvent pressedKey = null;
    private static JFrame frame;
    public static KeyEvent pressedKey() {
        synchronized (Fenetre.class) {
            return pressedKey;
        }
    }
    
    public static boolean isPressed(){
         synchronized (Fenetre.class) {
            return isPressed;
        }
    }

    public static void Initialize() {
        frame = new JFrame("WoE - World of ECN");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Créer un panneau de fond pour le style
        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setBackground(Color.BLACK); // Fond noir pour un effet dramatique
        backgroundPanel.setLayout(new BorderLayout());
        
        // Ajouter une étiquette de titre pour le jeu
        JLabel titleLabel = new JLabel("World of ECN", JLabel.CENTER);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 36));
        backgroundPanel.add(titleLabel, BorderLayout.NORTH);
        
        // Ajouter un texte d'introduction ou des instructions au centre
        JLabel introLabel = new JLabel("<html><center>Bienvenue dans World of ECN!<br>"
                + "Utilisez les touches pour naviguer dans le monde.<br>"
                +"</center></html>", JLabel.CENTER);
        introLabel.setForeground(Color.LIGHT_GRAY);
        introLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
        backgroundPanel.add(introLabel, BorderLayout.CENTER);
        
        // Ajouter le panneau à la fenêtre
        frame.add(backgroundPanel);
        
        // Rendre la fenêtre visible
        frame.setVisible(true);
        
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {

            @Override
            public boolean dispatchKeyEvent(KeyEvent ke) {
                synchronized (Fenetre.class) {
                    switch (ke.getID()) {
                    case KeyEvent.KEY_PRESSED:
                        isPressed = true;
                        pressedKey = ke;
                        break;

                    case KeyEvent.KEY_RELEASED:
                        isPressed = false;
                        pressedKey = ke;
                    }
                    return false;
                }
            }
        });
    }
    
    public static void close(){
        if (frame!=null){
        frame.dispose();
        frame=null;
        }
    }
}
