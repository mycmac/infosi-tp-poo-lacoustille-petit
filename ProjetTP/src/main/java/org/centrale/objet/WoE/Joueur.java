package org.centrale.objet.WoE;

import java.awt.event.KeyEvent;
import java.util.Scanner;

/**
 *
 * @author Ulysse
 */
public class Joueur {

    private Personnage perso;

    public void Joueur(Personnage p) {
        perso = p;
    }

    public void deplacePerso() {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter username");

        String userName = myObj.nextLine();  // Read user input
        System.out.println("Username is: " + userName);
    }

    public int[] keyTyped(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_UP) {
            return(new int[] {0,1});
        }
        if (event.getKeyCode() == KeyEvent.VK_DOWN) {
            return(new int[] {0,-1});
        }
        if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
            return(new int[] {1,0});
        }
        if (event.getKeyCode() == KeyEvent.VK_LEFT) {
            return(new int[] {-1,0});
        }
        else{
            return(new int[] {0,0});
        }
    }
}
