package Excepcions.ActivitatExceptions.Model;

import Excepcions.ActivitatExceptions.Control.OperacionsBanc;
import Excepcions.ActivitatExceptions.Exceptions.BankAccountException;

import java.util.ArrayList;
import java.util.List;

import static Excepcions.ActivitatExceptions.Exceptions.ExceptionMessage.ACCOUNT_NOT_FOUND;
import static Excepcions.ActivitatExceptions.Exceptions.ExceptionMessage.ACCOUNT_ZERO_USER;

public class Banc {
    private List<CompteEstalvi> compteEstalvis;

    public Banc() {
        this.compteEstalvis = new ArrayList<>();
    }

    public void afegirCompteEstalvi(CompteEstalvi compteEstalvi) {
        compteEstalvis.add(compteEstalvi);
    }

    public CompteEstalvi obtenirCompteEstalvi(String numCompte) throws BankAccountException {
        if (!existeixCompteEstalvi(numCompte)) throw new BankAccountException(ACCOUNT_NOT_FOUND);
        else {
            return compteEstalvis.stream().filter(t -> t.getNumCompte().equals(numCompte)).findFirst().get();
        }
    }

    public boolean existeixCompteEstalvi(String numCompte) {
        return compteEstalvis.stream()
                .anyMatch(t -> t.getNumCompte().equals(numCompte));
    }

    public void eliminarCompteEstalvi(String numeroCompte) throws BankAccountException {
        if (compteEstalvis.isEmpty()) {
            throw new BankAccountException(ACCOUNT_NOT_FOUND);
        } else {
            if (!compteEstalvis.removeIf(u -> numeroCompte.equals(u.getNumCompte()))) {
                throw new BankAccountException(ACCOUNT_ZERO_USER);
            }
        }
    }

    public void moureDiners(String numCompteOrigen,
                            String numCompteDesti,
                            double quantitat) throws BankAccountException {
        CompteEstalvi origen = obtenirCompteEstalvi(numCompteOrigen);
        CompteEstalvi desti = obtenirCompteEstalvi(numCompteDesti);
        OperacionsBanc.moureDiners(origen, desti, quantitat);
    }

    public void afegirClient(Client client, String numCompte) {
        for (CompteEstalvi comptes : compteEstalvis) {
            if (comptes.getNumCompte().equals(numCompte)) {
                comptes.addUser(client);
            }
        }
    }

    public void afegirSaldo(String numCompte, double sou) {
        for (CompteEstalvi comptes : compteEstalvis) {
            if (comptes.getNumCompte().equals(numCompte)) {
                comptes.ingressar(sou);
            }
        }
    }

    public void retirarSaldo(String numCompte, double sou) throws BankAccountException {
        for (CompteEstalvi comptes : compteEstalvis) {
            if (comptes.getNumCompte().equals(numCompte)) {
                comptes.treure(sou);
            }
        }
    }

    public void esborrarUsuari(String numCompte, String dni) throws BankAccountException {
        for (CompteEstalvi comptes : compteEstalvis) {
            if (comptes.getNumCompte().equals(numCompte)) {
                comptes.removeUser(dni);
            }
        }
    }
}
