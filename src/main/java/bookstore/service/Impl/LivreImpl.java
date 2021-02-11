package bookstore.service.Impl;

import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bookstore.entities.GenreLivre;
import bookstore.entities.Livre;
import bookstore.exception.LivreException;
import bookstore.repository.LivreRepository;
import bookstore.service.LivreAdminService;
import bookstore.service.LivreClientService;
@Service
public class LivreImpl implements LivreAdminService,LivreClientService{
	@Autowired
	LivreRepository livreRepository;
	private static final Logger L = LogManager.getLogger(LivreImpl.class);
	public LivreImpl() {
		// TODO Auto-generated constructor stub
	}
	// GESTION Livres -MOHAMED HEDI BEN ATIG-
		@Override
		public Iterable<Livre> findAll() {
			return livreRepository.findAll();
		}	

		
		
		
		@Override
		public List<Livre> ListLivres() {
			List<Livre> livres= (List<Livre>) livreRepository.findAll();
			for(Livre livre:livres){
				L.info("livre +++ :" +livre);
			}
			return livres;
		}
		@Override
		public void ajouterLivre(Livre L) throws LivreException {
			if(existeLivre(L))
				throw (new LivreException("livre existe"));
			else 
				 {livreRepository.save(L);
				 }
		}
		@Override
		public void supprimerLivre(Long id) throws LivreException {
							
				livreRepository.supprimerLivre(id);
				System.out.println("leeeeee!");
			
				}
		@Override
		public void modifierLivre(Livre L, String c_auteur, GenreLivre c_genre, int c_nbr_pages, float c_prix, String c_titre) throws LivreException {
			if(!existeLivre(L))
				throw (new LivreException("Le livre n'existe pas"));
			else
			{
				System.out.println("le livre existe!");
				long idL=L.getId();
				L.setAuteur(c_auteur);
				L.setGenre(c_genre);;
				L.setNbrPages(c_nbr_pages);
				L.setPrix(c_prix);
				L.setTitre(c_titre);

				livreRepository.modifierLivre(idL, L.getAuteur(), L.getGenre(), L.getNbrPages(), L.getPrix(), L.getTitre());
				System.out.println("leeeeee!");
				livreRepository.save(L);
			}
		}
		@Override
		public void AfficherLivre(List<Livre> livres) {
			livres=ListLivres();
			for (Livre livre:livres){
				System.out.println("livre out: "+livre);
				L.info("livre : "+livre);
				}			
		}
		@Override
		public Livre afficherLivre(Livre L) {
			Optional<Livre> lOpt=livreRepository.findById(L.getId());
			Livre l=lOpt.get();
			return l;
		}
		@Override
		public boolean existeLivre(Livre L) {
			// TODO Auto-generated method stub
			//long idR = r.getId();
			List<Livre> livre= livreRepository.afficherLivresSelonID(L.getId());
			if(livre.isEmpty())
			return false;
			else
		    return true;
			
		}
		
		
}
