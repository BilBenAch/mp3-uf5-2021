package Excepcions.ActivitatExceptions.Model;

import Excepcions.ActivitatExceptions.Exceptions.BankAccountException;

import java.util.ArrayList;
import java.util.List;

import static Excepcions.ActivitatExceptions.Exceptions.ExceptionMessage.*;

public class CompteEstalvi {
    private String numCompte;
    private double saldo;
    private List<Client> llista_usuaris = new ArrayList<>();

    public CompteEstalvi(String numCompte,Client client) {
        this.numCompte = numCompte;
        saldo = 0;
        llista_usuaris.add(client);
    }

    /**
        Afegeix un usuari d'aquest compte
        @param client
        @return quantitat d'usuaris que té el compte

     **/
    public int addUser(Client client) {
        llista_usuaris.add(client);
        return llista_usuaris.size();
    }

    /**
     Elimina un usuari d'aquest compte,
     Com que no pot quedar un compte sense usuari, si és l'ùltim és llança una excepció
     @param dni
     @return quantitat d'usuaris que té el compte
     @throws BankAccountException
     **/
    public int removeUser(String dni) throws BankAccountException {
        if(llista_usuaris.isEmpty()){
            throw  new BankAccountException(ACCOUNT_NOT_FOUND);
        } else {
           if(!llista_usuaris.removeIf(u -> dni.equals(u.getDNI()))){
               throw new BankAccountException(ACCOUNT_ZERO_USER);
           }
       }

        return llista_usuaris.size();
    }

    /**
     * Afegeix m diners al saldo
     * @param m
     */
    public void ingressar(double m) {
            saldo += m;
    }

    /**
     * Treu m diners del compte si n'hi han suficient sinó es llança l'excepció
     * @param m
     * @throws BankAccountException
     */
    public void treure(double m) throws BankAccountException {
        double temp = m - saldo;
        if(saldo > 0 && temp > 0){
            saldo -= m;
        }
        else{
            throw new BankAccountException(ACCOUNT_OVERDRAFT);
        }
    }

    public String getNumCompte() {
        return numCompte;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Client> getLlista_usuaris() {
        return llista_usuaris;
    }
}
