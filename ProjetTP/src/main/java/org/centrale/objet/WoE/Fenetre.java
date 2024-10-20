/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ulysse, ChatGPT
 * Pour la partie graphique, nous avons utilisé chatGPT pour aller plus vite car ce n'est pas l'objet du TP
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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Fenetre d'affichage graphique du jeu
 * Sert aussi à récupérer les clics
 * @author hanss
 */
public class Fenetre {
    /**
     * Booleen déterminent si une touche du clavier est pressée
     */
    private static volatile boolean isPressed = false;
    /**
     * Evenement qui récupère la touche du clavier pressée
     */
    private static volatile KeyEvent pressedKey = null;
    /**
     * Cadre de la fenêtre
     */
    private static JFrame frame;
    /**
     * Zone d'affichage des outputs, notamment de la carte
     */
    private static JTextArea outputArea;
    /**
     * Zone d'affichage des messages
     */
    private static JTextArea messageArea;
    /**
     * Zone d'affichage de l'inventaire
     */
    private static JTextArea inventaireArea;
    
    /**
     * Récupère la touche du clavier pressée
     * @return KeyEvent correspondant à la touche
     */
    public static KeyEvent pressedKey() {
        synchronized (Fenetre.class) {
            return pressedKey;
        }
    }
    
    /**
     * Vérifie si l'utilisateur appuie quelque part
     * @return true si l'utilisateur appuie sur une touche
     */
    public static boolean isPressed(){
         synchronized (Fenetre.class) {
            return isPressed;
        }
    }

    /**
     *  Crée une fenêtre
     * @param taille_monde taille du monde dans cette fenêtre
     */
    public static void Initialize(int taille_monde) {
        frame = new JFrame("WoE - World of ECN");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        // frame.setUndecorated(true); //Full Screen
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
        JLabel introLabel = new JLabel("<html><center>Bienvenue dans World of ECN!    "
                + "Utilisez les touches pour naviguer dans le monde :<br>"
                + "Combat à distance : Utiliser SHIFT pour sélectionner une cible avec le (+) et espace pour tirer    |    "
                + "Combat rapproché : Déplacez-vous sur la créature<br>"
                + "Utilisez les chiffres pour utiliser les éléments de l'inventaire<br>"
                + "Aidez-vous des potions de soin (S), des armes (E) et de la nourriture (o), mais attention aux nuages toxiques (x)<br>"
                +"Le système de sauvegarde n'a pas encore été implémenté</center></html>", JLabel.CENTER);
        introLabel.setForeground(Color.LIGHT_GRAY);
        introLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
        backgroundPanel.add(introLabel, BorderLayout.SOUTH);
        
        // Créer un panneau pour contenir le JTextArea
        JPanel textPanel = new JPanel();
        textPanel.setBackground(Color.DARK_GRAY);
        
        // Ajouter un JTextArea pour afficher les sorties
        outputArea = new JTextArea(taille_monde+5, taille_monde*3); // Ajustez le nombre de lignes et de colonnes
        outputArea.setEditable(false); // Rendre la zone de texte non éditable
        outputArea.setBackground(Color.DARK_GRAY);
        outputArea.setForeground(Color.LIGHT_GRAY);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 16));

        
        // Créer un deuxième JTextArea pour les messages
        messageArea = new JTextArea(taille_monde, 60); 
        messageArea.setEditable(false); // Rendre la zone de texte non éditable
        messageArea.setBackground(Color.DARK_GRAY);
        messageArea.setForeground(Color.LIGHT_GRAY);
        messageArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
        messageArea.setLineWrap(true); // Permettre le retour à la ligne automatique
        messageArea.setWrapStyleWord(true); // Envelopper le texte par mot
        
        // Créer un troisième JTextArea pour l'inventaire
        inventaireArea = new JTextArea(20, 20); 
        inventaireArea.setEditable(false); // Rendre la zone de texte non éditable
        inventaireArea.setBackground(Color.DARK_GRAY);
        inventaireArea.setForeground(Color.LIGHT_GRAY);
        inventaireArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
        inventaireArea.setLineWrap(true); // Permettre le retour à la ligne automatique
        inventaireArea.setWrapStyleWord(true); // Envelopper le texte par mot

        
        // Ajouter un JScrollPane pour faire défiler le JTextArea si nécessaire
        JScrollPane outputScrollPane = new JScrollPane(outputArea);
        outputScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // Pas de barre de défilement horizontale
        
        
        // Ajouter un JScrollPane pour le deuxième JTextArea
        JScrollPane messageScrollPane = new JScrollPane(messageArea);
        messageScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER); // Pas de barre de défilement verticale toujours visible
        messageScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // Pas de barre de défilement horizontale
        
        // Ajouter un JScrollPane pour le troisième JTextArea
        JScrollPane inventaireScrollPane = new JScrollPane(inventaireArea);
        inventaireScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER); // Pas de barre de défilement verticale toujours visible
        inventaireScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // Pas de barre de défilement horizontale

        
        // Ajouter le JScrollPane de sortie au panneau de texte
        textPanel.add(outputScrollPane, BorderLayout.NORTH); // Première zone de texte en haut
        textPanel.add(messageScrollPane, BorderLayout.SOUTH); // Deuxième zone de texte en bas
        
        // Ajouter le panneau de texte au panneau de fond
        backgroundPanel.add(textPanel);
        backgroundPanel.add(inventaireScrollPane, BorderLayout.EAST);
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
    
    /**
     *  Ferme la fenêtre
     */
    public static void close(){
        if (frame!=null){
        frame.dispose();
        frame=null;
        }
    }
    
    /**
     *  Met à jour l'affichage du monde
     * @param carte Chaine de caractères de la représentation du monde
     */
    public static void afficheMonde(String carte) {
    outputArea.setText(""); // Efface le contenu de la zone de texte
    outputArea.append(carte + "\n"); // Ajouter le carte à la zone de texte
    outputArea.setCaretPosition(outputArea.getDocument().getLength()); // Faire défiler vers le bas
    }

    /**
     * Méthode pour ajouter un message à la zone de messages
     * @param message Message à indiquer
     */
    public static void addMessage(String message) {
        messageArea.append(message + "\n"); // Ajouter le message à la zone de messages
        messageArea.setCaretPosition(messageArea.getDocument().getLength()); // Faire défiler vers le bas
    }
    
    
    /**
     * Méthode pour ajouter un message à l'inventaire
     * @param message Message à indiquer
     */
    public static void afficheInventaire(String message) {
        inventaireArea.setText("");
        inventaireArea.append(message + "\n"); // Ajouter le message à la zone de messages
    }
}
