package bookstore.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import bookstore.entities.Livre;
import bookstore.exception.StockException;
import bookstore.repository.StockRepository;
import bookstore.service.StockService;

public class StockImpl implements StockService {
	@Autowired
	StockRepository stockRepository;
	private static final Logger L = LogManager.getLogger(StockImpl.class);
	public StockImpl() {
		// TODO Auto-generated constructor stub
	}

	// GESTION STOCK -MOHAMED BDIOUI-

	@Override
	public boolean existeLivre(Livre l) {
		//long idL = l.getId();
		List<Livre> livres= stockRepository.afficherLivreSelonID(l.getId());
		if(livres.isEmpty())
		return false;
		else
	    return true;
	}
	@Override
	public int QuantiteLivre(Livre l) throws StockException {
		if(!existeLivre(l)){
			throw (new StockException("Livre n'existe pas"));
		}
		return stockRepository.nombreLivreSelonTitreEtAuteur(l.getAuteur(), l.getTitre());
	}
	@Override
	public int QuantiteLivres() {
		return stockRepository.nombreLivres();
	}
	@Override
	public void passerCommandeLivre(Livre l) throws Exception {	
		if(!existeLivre(l)){
			L.info("veuillez passer une commande");
		}
	}
	@Override
	public List<Livre> ListerLivres() {
		List<Livre> livres= (List<Livre>) stockRepository.findAll();
		for(Livre livre:livres){
			L.info("livre  :" +livre);
		}
		return livres;
	}
	@Override
	public List<Livre> afficherLivre(Livre l) throws StockException {
		Optional<Livre> livreOpt=stockRepository.findById(l.getId());
		Livre livre=livreOpt.get();
		List<Livre> livreAffichage = new ArrayList<>();
		livreAffichage.add(livre);
		return livreAffichage;
	}
	@Override
	public void AfficherLivres(List<Livre> livres) {
		livres=ListerLivres();
		for(Livre livre:livres){
			L.info("Livre : "+livre);
		}
	}
	
}
