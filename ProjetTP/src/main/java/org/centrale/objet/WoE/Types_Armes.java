package org.centrale.objet.WoE;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Enumeration des différentes armes qui existent
 */
public enum Types_Armes {
    DAGUE(6, 5, 0, 5),
    GOURDIN(6, 5, 1, 5),
    EPEE_COURTE(8, 20, 1, 5),
    EPEE_LONGUE(10, 20, 2, 15),
    POLOCHON(0, 30, 5, 30);

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
     * @param degAtt
     * @param ptPar
     * @param pageAtt
     * @param pagePar
     */
    private Types_Armes(int degAtt, int ptPar, int pageAtt, int pagePar) {
        this.degAtt = degAtt;
        this.ptPar = ptPar;
        this.pageAtt = pageAtt;
        this.pagePar = pagePar;
    }

    /**
     * Renvoie les dégats d'attaque d'une arme
     * @return DegAtt
     */
    public int getDegAtt() {
        return this.degAtt;
    }

    /**
     * Renvoie les points de parade de l'arme
     * @return ptPar
     */
    public int getPtPar() {
        return this.ptPar;
    }

    /**
     * Renvoie le pourcentage d'attaque de l'arme
     * @return pageAtt
     */
    public int getPageAtt() {
        return this.pageAtt;
    }

    /**
     * Renvoie le pourcentage de parade de l'arme
     * @return pagePar
     */
    public int getPagePar() {
        return this.pagePar;
    }

    /**
     * Donne un type d'arme aléatoire
     * @return Type d'arme aléatoire
     */
    public Types_Armes getRandom() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
