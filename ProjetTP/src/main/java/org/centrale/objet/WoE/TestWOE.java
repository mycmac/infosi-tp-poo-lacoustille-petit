package org.centrale.objet.WoE;

/**
 * Test de tout le package {@link org.centrale.objet.WoE} et plus spécifiquement
 * de {@link org.centrale.objet.WoE.World}
 *
 * @author Ulysse
 */
public class TestWOE {

    public static void main(String[] args) {
        World WoE;

 /*
        WoE = new World(50);
        long debut = System.nanoTime();
        WoE.creeMondeAlea();
        long fin = System.nanoTime();
        System.out.println("Temps de création : "+(fin-debut)+" ns");
        //Creature[][] creature = new Creature[12][12];
        //System.out.println(creature[5][5]);
        //creature[6][3].affiche();
        
        WoE.afficheWorld();
         */
        WoE = new World(5);
        System.out.println("Ajout d'un Archer, d'un Lapin, d'une Epee et d'une PotionSoin :");
        Guerrier Gros = new Guerrier();
        WoE.getJoueur().setPerso(Gros);
        WoE.addCreature(Gros, 3, 3);
        WoE.addCreature(new Archer(), 0, 0);
        WoE.addCreature(new Lapin(), 0, 1);
        WoE.addObjet(new Epee(), 1, 0);
        WoE.addObjet(new PotionSoin(), 1, 1);
        WoE.afficheWorld();

        System.out.println("Ajout d'un Guerrier sur la case de l'Archer :");
        WoE.addCreature(new Guerrier(), 0, 0);
        WoE.afficheWorld();

        System.out.println("Ajout d'un Guerrier sur la case de l'Epee :");
        WoE.addCreature(new Guerrier(), 1, 0);
        WoE.afficheWorld();

        System.out.println("Ajout d'un Loup sur la case du Lapin :");
        WoE.addCreature(new Loup(), 0, 1);
        WoE.afficheWorld();

        System.out.println("Ajout d'un Loup sur la case de la PotionSoin :");
        WoE.addCreature(new Loup(), 1, 1);
        WoE.afficheWorld();

        System.out.println("Déplacement du Loup :");
        WoE.deplace(1, 1, 1, 0);
        WoE.afficheWorld();

        System.out.println("Ajout d'une Epee sur la case de la PotionSoin :");
        WoE.addObjet(new Epee(), 1, 1);
        WoE.afficheWorld();

        System.out.println("Ajout d'une Epee sur la case de l'Archer :");
        WoE.addObjet(new Epee(), 0, 0);
        WoE.afficheWorld();

        System.out.println("Ajout d'une Epee sur la case du Loup et déplacement du Loup :");
        WoE.addObjet(new Epee(), 2, 1);
        WoE.afficheWorld();
        WoE.deplace(2, 1, 0, 1);
        WoE.afficheWorld();

        System.out.println("Test déplacement joueur :");
        Clavier.Initialize();
        for (int i = 1; i < 50; i++) {
            WoE.getJoueur().actionDeplacement(WoE.getGrille_creatures(), WoE.getGrille_objets());
            WoE.afficheWorld();
        }

        /*
        // Test de la génération aléatoire d'entites
        Iterator<Creature> creatureP = WoE.getCreatures().iterator();
        int[] crea_crees = {0, 0, 0, 0, 0};
        Creature c;
        while (creatureP.hasNext()){
            c = creatureP.next();
            if (c instanceof Archer) {
                crea_crees[0] ++;
            } else if (c instanceof Guerrier) {
                crea_crees[1] ++;
            } else if (c instanceof Paysan) {
                crea_crees[2] ++;
            } else if (c instanceof Lapin) {
                crea_crees[3] ++;
            } else {
                crea_crees[4] ++;
            }
        }
        System.out.print("Le monde aléatoire a été créé avec "
                +crea_crees[0]+" Archers, "
                +crea_crees[1]+" Guerriers, "
                +crea_crees[2]+" Paysans, "
                +crea_crees[3]+" Lapins et "
                +crea_crees[4]+" Loups !\n");
        
        Iterator<Objet> objetP = WoE.getObjets().iterator();
        int[] obj_crees = {0, 0};
        Objet o;
        while (objetP.hasNext()){
            o = objetP.next();
            if (o instanceof Epee) {
                obj_crees[0] ++;
            } else {
                obj_crees[1] ++;
            }
        }
        System.out.print("Il contient aussi "
                +obj_crees[0]+" Epees et "
                +obj_crees[1]+" PotionSoins !\n");
         */
 /*
        
        
        System.out.println("Nombre de créatures : "+WoE.getCreatures().size());
        
        // Parcours par itérateurs
        int totalPV2 = 0;
        long debutIt = System.nanoTime();
        creatureP = WoE.getCreatures().iterator();
        while (creatureP.hasNext()){
            totalPV2 += creatureP.next().getPtVie();
        }
        long finIt = System.nanoTime();
        System.out.println("Total de PV "+totalPV2+" en "+(finIt-debutIt)+" nanosecondes par itérateur");
        // Parcours de la liste de creatures par index
        int totalPV = 0;
        long debutIn = System.nanoTime();
        for (int i = 0;i<WoE.getCreatures().size();i++){
            totalPV += WoE.getCreatures().get(i).getPtVie();
        }
        long finIn = System.nanoTime();
        System.out.println("Total de PV "+totalPV+" en "+(finIn-debutIn)+" nanosecondes par index");
         */
    }
}
