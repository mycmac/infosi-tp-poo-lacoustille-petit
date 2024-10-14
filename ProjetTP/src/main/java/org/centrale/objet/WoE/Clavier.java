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

public class Clavier {
    private static volatile boolean isPressed = false;
    private static volatile KeyEvent pressedKey = null;
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

    public static void main(String[] args) {
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
}
