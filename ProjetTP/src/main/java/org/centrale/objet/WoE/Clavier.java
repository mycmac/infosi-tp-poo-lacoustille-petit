/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hanss
 */

package org.centrale.objet.WoE;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

public class Clavier {
    private static volatile boolean isPressed = false;
    private static volatile KeyEvent pressedKey = null;
    private static JFrame frame;
    public static KeyEvent pressedKey() {
        synchronized (Clavier.class) {
            return pressedKey;
        }
    }
    
    public static boolean isPressed(){
         synchronized (Clavier.class) {
            return isPressed;
        }
    }

    public static void Initialize() {
        frame = new JFrame("Keyboard Listener");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {

            @Override
            public boolean dispatchKeyEvent(KeyEvent ke) {
                synchronized (Clavier.class) {
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
    
    public static void Close(){
        if (frame!=null){
        frame.dispose();
        frame=null;
        }
    }
}
