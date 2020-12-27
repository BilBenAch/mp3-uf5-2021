package Excepcions.ActivitatExceptions;

import Excepcions.ActivitatExceptions.Exceptions.BankAccountException;
import Excepcions.ActivitatExceptions.Exceptions.ClientException;
import Excepcions.ActivitatExceptions.Model.Banc;
import Excepcions.ActivitatExceptions.Model.Client;
import Excepcions.ActivitatExceptions.Model.CompteEstalvi;

import java.util.Scanner;

import static Excepcions.ActivitatExceptions.Exceptions.ExceptionMessage.ACCOUNT_ALREADY_CREATED;
import static Excepcions.ActivitatExceptions.Exceptions.ExceptionMessage.ACCOUNT_NOT_FOUND;

public class Main {
    public static void main(String[] args) throws ClientException, BankAccountException {
        Scanner sc = new Scanner(System.in);
        Banc banc = new Banc();
        String dni, nom, cognom, numeroCompte, numeroCompteDesti;
        double saldo;
        int opcio = 0;
        while (opcio != 8) {
            System.out.println("********** BENVINGUT AL BANC, QUE DESITGES FER? ***********");
            System.out.println("1-Crear un nou compte d'estalvis: ");
            System.out.println("2-Afegir clients al compte ");
            System.out.println("3-Afegir diners a un compte d'estalvis: ");
            System.out.println("4-Retirar diners d'un compte d'estalvis: ");
            System.out.println("5-Fer una transeferencia d'un compte a un altre: ");
            System.out.println("6-Esborrar un client d'un compte d'estalvis");
            System.out.println("7-Esborrar un compte d'estalvis: ");
            System.out.println("8-Sortir ");
            System.out.println();
            opcio = sc.nextInt();
            switch (opcio) {
                case 1:
                    sc.nextLine();
                    System.out.println("Creant un nou compte d'estalvis");
                    System.out.println("Introdueix el numero de compte (Bancari) ");
                    numeroCompte = sc.nextLine();
                    if (banc.existeixCompteEstalvi(numeroCompte)) {
                        throw new BankAccountException(ACCOUNT_ALREADY_CREATED);
                    } else {
                        System.out.println("Introdueix el dni del client ");
                        dni = sc.nextLine();
                        System.out.println("Introdueix el nom del client ");
                        nom = sc.nextLine();
                        System.out.println("Introdueix el cognom del client ");
                        cognom = sc.nextLine();

                        CompteEstalvi compteEstalvi = new CompteEstalvi(numeroCompte, new Client(nom, cognom, dni));
                        banc.afegirCompteEstalvi(compteEstalvi);
                    }
                    break;

                case 2:
                    sc.nextLine();
                    System.out.println("Opció 1 Afegint una compta d'estalvis");
                    System.out.println("Introdueix el numero de compte per poder afegir un nou usuari ");
                    numeroCompte = sc.nextLine();
                    if (!banc.existeixCompteEstalvi(numeroCompte)) {
                        throw new BankAccountException(ACCOUNT_NOT_FOUND);
                    } else {
                        System.out.println("Opció 2 Introdueix el nou client ");
                        nom = sc.nextLine();
                        System.out.println("Introdueix el cognom de nou client ");
                        cognom = sc.nextLine();
                        System.out.println("Introdueix el dni de nou client ");
                        dni = sc.nextLine();
                        banc.afegirClient(new Client(nom, cognom, dni), numeroCompte);
                    }
                    break;
                case 3:
                    sc.nextLine();
                    System.out.println("Opició 3 Afegir saldo");
                    System.out.println("Introdueix el numero de compte bancari on vols efectuar l'ingrés ");
                    numeroCompte = sc.nextLine();
                    if (!banc.existeixCompteEstalvi(numeroCompte)) {
                        throw new BankAccountException(ACCOUNT_NOT_FOUND);
                    } else {
                        System.out.println("Introdueix la quantitat de saldo que vols afegir: ");
                        saldo = sc.nextDouble();
                        banc.afegirSaldo(numeroCompte, saldo);
                    }
                    break;
                case 4:
                    sc.nextLine();
                    System.out.println("Opició 4 Retirar saldo");
                    System.out.println("Introdueix el numero de compte bancari on vols efectuar la retirada ");
                    numeroCompte = sc.nextLine();
                    if (!banc.existeixCompteEstalvi(numeroCompte)) {
                        throw new BankAccountException(ACCOUNT_NOT_FOUND);
                    } else {
                        System.out.println("Introdueix la quantitat de saldo que vols retirar: ");
                        saldo = sc.nextDouble();
                        banc.retirarSaldo(numeroCompte, saldo);
                    }
                    break;
                case 5:
                    sc.nextLine();
                    System.out.println("Opició 6 Fer una transferencia");
                    System.out.println("Introdueix el numero de compte del cual desde on ve la transferencia (origen) ");
                    numeroCompte = sc.nextLine();

                    System.out.println("Introdueix el compte on s'ha de fer l'ingrés (destí)");
                    numeroCompteDesti = sc.nextLine();

                    System.out.println("Introdueix la quantitat de saldo que vols transferir ");
                    saldo = sc.nextDouble();
                    banc.moureDiners(numeroCompte, numeroCompteDesti, saldo);
                    break;

                case 6:
                    sc.nextLine();
                    System.out.println("Opció 7 Esborrar un client d'un compte d'estalvis");
                    System.out.println("Introdueix el numero del compte d'estalvis");
                    numeroCompte = sc.nextLine();
                    if (!banc.existeixCompteEstalvi(numeroCompte)) {
                        throw new BankAccountException(ACCOUNT_NOT_FOUND);
                    } else {
                        System.out.println("Introdueix el dni de la persona que vols eliminar");
                        dni = sc.nextLine();
                        banc.esborrarUsuari(numeroCompte, dni);
                    }
                    break;
                case 7:
                    sc.nextLine();
                    System.out.println("Opció 8 Esborrar un compte d'estalvis");
                    System.out.println("Introdueix el numero del compte d'estalvis");
                    numeroCompte = sc.nextLine();
                    if (!banc.existeixCompteEstalvi(numeroCompte)) {
                        throw new BankAccountException(ACCOUNT_NOT_FOUND);
                    } else {
                       banc.eliminarCompteEstalvi(numeroCompte);
                    }
                    break;
            }
        }
    }
}
