package bookstore.service;

import java.util.*;

import bookstore.entities.GenreLivre;
import bookstore.entities.Livre;
import bookstore.exception.LivreException;

public interface LivreAdminService {
	// SERVICE LIVRE -MOHAMED HEDI BEN ATIG-
	 List<Livre> ListLivres();
	 void ajouterLivre(Livre L) throws LivreException;
     void supprimerLivre(Livre L) throws LivreException;
     void AfficherLivre(List<Livre> livres);
     Livre afficherLivre(Livre L);
     boolean existeLivre(Livre L);
     Iterable<Livre> findAll();
	void modifierLivre(Livre L, String auteur, GenreLivre genre, int nbrPages, float prix, String titre)
			throws LivreException;
}
