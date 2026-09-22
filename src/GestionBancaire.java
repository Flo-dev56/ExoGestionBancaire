import java.util.Scanner;

public class GestionBancaire {

    static void main() {

        Scanner scanner = new Scanner(System.in);
        float[] tab = effectuerVirement(scanner);

        int choix;

        do {

            System.out.println("Veuillez choisir l'opération (renseigner le chiffre associé à l'opération");
            System.out.println("1 : effectuer un virement");
            System.out.println("2 : afficher les soldes des comptes ");
            System.out.println("3 : calculer les intérêts");
            System.out.println("4 : déconnexion");

            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    System.out.println("veuillez saisir le compte éméteur : ");
                    int emeteur = scanner.nextInt();
                    System.out.println("veuillez saisir le compte récepteur");
                    int recepteur = scanner.nextInt();
                    System.out.println("Saisir le montant du virement :");
                    float montant = scanner.nextFloat();
                    vraiVirement(tab,emeteur,recepteur,montant);
                    break;
                case 2:
                    afficheMesComptes(tab);
                    break;
                case 3:
                    System.out.println("Saisir le taux d'intérêt");
                    float taux = scanner.nextFloat();
                    calculInteretAnnuel(tab, taux);
                    break;
                case 4:
                    System.out.println("Au revoir");
                    break;
            }
        }while(choix!=4);
    }

    public static float[] effectuerVirement(Scanner scanner) {
        //fonction de l'exercice précédent
        System.out.println("entrez le nombre de solde a saisir : ");
        int nbSolde = scanner.nextInt();


        float[] tabSolde = new float[nbSolde];
        int i;

        for (i = 0; i < tabSolde.length; i++) {
            int index = i + 1;
            System.out.println("entrez le solde " + index + " :");
            float solde = scanner.nextFloat();
            tabSolde[i] = solde;
        }

        return tabSolde;

    }

    public static void vraiVirement(float[] tab,int compte1, int  compte2, float montant){


        tab[compte1] -= montant;
        tab[compte2] += montant;


    }

    public static void calculInteretAnnuel(float[] tab, float taux) {
        float res = 0;
        //TODO implémenter la logique métier
        int i;

        for (i = 0; i < tab.length; i++) {
            tab[i] = tab[i] * taux;
        }
        System.out.println("Montant des comptes après calcul des intérêts");
        afficheMesComptes(tab);
    }

    public static void afficheMesComptes(float[] tab) {
        int i;

        for (i = 0; i < tab.length; i++) {
            System.out.println("Solde " + (i + 1) + ": " + tab[i]);
        }
        ;

    }
}
