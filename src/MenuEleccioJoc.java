import java.util.InputMismatchException;
import java.util.Scanner;
public class MenuEleccioJoc {
    MenuEleccioJoc(){

    }
    public void MenuJoc(){
                Scanner sc = new Scanner(System.in);
                int opcion = 0;
                int opcioMenu = 0;
                while (opcion != 4) {
                    System.out.println("Benvingut al menú de la elecció del joc, tria a quin joc vols jugar ");
                    System.out.println("1. Joc 1");
                    System.out.println("2. Joc 2");
                    System.out.println("3. Joc 3");
                    System.out.println("4. Sortir");
                    try {
                        System.out.println("Introdueix el numero del joc al que vols jugar: ");
                        opcion = sc.nextInt();

                        switch (opcion) {
                            case 1:
                                System.out.println("has entrado al Joc 1");
                                opcioMenu = 0;
                                while(opcioMenu != 3) {
                                    System.out.println("----Has triat el joc 1, que vols fer----");
                                    System.out.println("1. Saber les regles");
                                    System.out.println("2. Jugar al joc 1 ");
                                    System.out.println("3. Sortir ");
                                    try {
                                        opcioMenu = sc.nextInt();

                                        switch (opcioMenu) {
                                            case 1:
                                                ReglesJoc reglas = new ReglesJoc();
                                                reglas.Joc1Descripcio();
                                                break;

                                            case 2:
                                                break;

                                            case 3:
                                                break;
                                        }
                                    }catch (InputMismatchException e) {
                                        System.out.println("Has d'introduir un número(no lletres ni altre digit) : ");
                                        sc.next();
                                    }
                                }

                                break;
                            case 2:
                                System.out.println("has entrado al Joc 2");
                                opcioMenu = 0;
                                while(opcioMenu != 3) {
                                    System.out.println("----Has triat el joc 2, que vols fer----");
                                    System.out.println("1. Saber les regles");
                                    System.out.println("2. Jugar al joc 2 ");
                                    System.out.println("3. Sortir ");
                                    try {
                                        opcioMenu = sc.nextInt();

                                        switch (opcioMenu) {
                                            case 1:
                                                ReglesJoc reglas = new ReglesJoc();
                                                reglas.Joc2Descripcio();
                                                break;

                                            case 2:
                                                break;

                                            case 3:
                                                break;
                                        }
                                    }catch (InputMismatchException e) {
                                        System.out.println("Has d'introduir un número(no lletres ni altre digit) : ");
                                        sc.next();
                                    }
                                }

                                break;
                            case 3:
                                System.out.println("Joc 3");
                                break;
                            case 4:
                                System.out.println("Adeu, que tinguis un bon dia");
                                break;
                            default:
                                System.out.println("només numeros entre 1 i 4 ");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Has d'introduir un número(no lletres ni altre digit) : ");
                        sc.next();
                    }
                }

            }
}

