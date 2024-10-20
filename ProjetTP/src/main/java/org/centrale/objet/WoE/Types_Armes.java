package org.centrale.objet.WoE;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Enumeration des différentes armes qui existent
 *
 * @author Timothée
 */
public enum Types_Armes {
    DAGUE("dague", 6, 5, 0, 5),
    GOURDIN("gourdin", 6, 5, 1, 5),
    EPEE_COURTE("épée courte", 8, 20, 1, 5),
    EPEE_LONGUE("épée longue", 10, 20, 2, 15),
    POLOCHON("polochon", 0, 30, 5, 30);

    /**
     * Liste non modifiable des types d'arme
     */
    private static final List<Types_Armes> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    /**
     * Taille de la liste des types d'arme
     */
    private static final int SIZE = VALUES.size();
    /**
     * Générateur de nombres aléatoires
     */
    private static final Random RANDOM = new Random();

    /**
     * Nom de type d'arme
     */
    private String nom;
    /**
     * Dégâts d'attaque
     */
    private int degAtt;
    /**
     * Points de parade
     */
    private int ptPar;
    /**
     * Pourcentage d'attaque
     */
    private int pageAtt;
    /**
     * Pourcentage de parade
     */
    private int pagePar;

    /**
     * Constructeur de Types_Armes avec tous les attributs
     *
     * @param nom nom de l'arme
     * @param degAtt dégats d'attaque
     * @param ptPar points de parade
     * @param pageAtt pourcentage d'attaque
     * @param pagePar pourcentage de parade
     */
    private Types_Armes(String nom, int degAtt, int ptPar, int pageAtt, int pagePar) {
        this.nom = nom;
        this.degAtt = degAtt;
        this.ptPar = ptPar;
        this.pageAtt = pageAtt;
        this.pagePar = pagePar;
    }

    /**
     * Renvoie les dégats d'attaque d'une arme
     *
     * @return DegAtt
     */
    public int getDegAtt() {
        return this.degAtt;
    }

    /**
     * Renvoie les points de parade de l'arme
     *
     * @return ptPar
     */
    public int getPtPar() {
        return this.ptPar;
    }

    /**
     * Renvoie le pourcentage d'attaque de l'arme
     *
     * @return pageAtt
     */
    public int getPageAtt() {
        return this.pageAtt;
    }

    /**
     * Renvoie le pourcentage de parade de l'arme
     *
     * @return pagePar
     */
    public int getPagePar() {
        return this.pagePar;
    }

    /**
     * Renvoie le nom de l'arme
     *
     * @return nom
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Donne un type d'arme aléatoire
     *
     * @return Type d'arme aléatoire
     */
    public static Types_Armes getRandom() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
