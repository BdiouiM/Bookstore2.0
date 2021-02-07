package bookstore.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
<<<<<<< HEAD
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
=======
import java.util.stream.Collectors;
>>>>>>> develop
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bookstore.entities.Livre;
import bookstore.entities.Reclamation;
import bookstore.entities.StatutReclamation;
import bookstore.entities.TypeReclamation;
import bookstore.exception.ReclamationException;
import bookstore.exception.StockException;
import bookstore.repository.ReclamationRepository;
import bookstore.repository.StockRepository;
import bookstore.service.ReclamationAdminService;
import bookstore.service.ReclamationClientService;
import bookstore.service.StockService;

import org.apache.logging.log4j.*;
@Service
public class UserServiceImpl implements ReclamationAdminService,ReclamationClientService,StockService {

	@Autowired
	ReclamationRepository reclamationRepository;
	@Autowired
	StockRepository stockRepository;
<<<<<<< HEAD
	private static final Logger L =  LogManager.getLogger(UserServiceImpl.class);
=======
	private static final Logger L = LogManager.getLogger(UserServiceImpl.class);
>>>>>>> develop
	// GESTION RECLAMATION -MOHAMED BDIOUI-
	@Override
	public Iterable<Reclamation> findAll() {
		return reclamationRepository.findAll();
	}	

	@Override
	public boolean existeReclamation(Reclamation r) {
		//long idR = r.getId();
		List<Reclamation> reclamation= reclamationRepository.afficherReclamationsSelonID(r.getId());
		if(reclamation.isEmpty())
		return false;
		else
	    return true;
	}
	@Override
	public void envoyerReclamation(Reclamation r) throws ReclamationException {
		if(existeReclamation(r))
			throw (new ReclamationException("reclamation existe"));
		else 
			 {reclamationRepository.save(r);
			  L.info("reclamation envoyée");
			 }
	}

	@Override
	public void modifierReclamation(Reclamation r,Date date,String description,TypeReclamation type) throws ReclamationException {
		if(!existeReclamation(r))
			throw (new ReclamationException("reclamation n'existe pas"));
		else
		{
			long idR=r.getId();
			r.setType(type);
			r.setDescription(description);
			r.setDateReclamation(date);
			r=reclamationRepository.modifierReclamation(idR, r.getDateReclamation(), r.getDescription(), r.getType());
			reclamationRepository.save(r);
			L.info("reclamation modifiée");
		}
	}
	
	@Override
	public boolean validerReclamations(Reclamation r) throws ReclamationException {
		if(!existeReclamation(r))
			throw (new ReclamationException("reclamation n'existe pas"));
		else
		{
			long idR=r.getId();
			r.setStatutReclamation(StatutReclamation.VALIDEE);
			StatutReclamation statutR=r.getStatutReclamation();
			r=reclamationRepository.changerReclamationSelonStatut(statutR, idR);
			reclamationRepository.save(r);
			L.info("Reclamation annulée");
			return true;
		}
	}
	
	@Override
	public boolean annulerReclamation(Reclamation r) throws ReclamationException {
		if(!existeReclamation(r))
			throw (new ReclamationException("reclamation n'existe pas"));
		else
		{
			long idR=r.getId();
			r.setStatutReclamation(StatutReclamation.ANNULEE);
			StatutReclamation statutR=r.getStatutReclamation();
			r=reclamationRepository.changerReclamationSelonStatut(statutR, idR);
			reclamationRepository.save(r);
			L.info("Reclamation annulée");
			return true;
		}
	}

	@Override
	public List<Reclamation> ListReclamations() {
		List<Reclamation> reclamations= (List<Reclamation>) reclamationRepository.findAll();
		for(Reclamation reclamation:reclamations){
			L.info("reclamation +++ :" +reclamation);
		}
		return reclamations;
	}

	@Override
	public void annulerReclamationsClient(Reclamation r) throws ReclamationException {
		if(!existeReclamation(r))
			throw (new ReclamationException("reclamation n'existe pas"));
		else
		{
		long idR=r.getId();
		reclamationRepository.deleteById(idR);
		L.info("reclamation supprimée");
		}
	}

	

	@Override
	public boolean TraiterReclamation(Reclamation r) throws ReclamationException {
		return annulerReclamation(r)||validerReclamations(r);
		}
		

	@Override
	public int NombreReclamations() {
		return reclamationRepository.nombreReclamations();
	}

	@Override
	public void AfficherReclamations(List<Reclamation> reclamations) {
		reclamations=ListReclamations();
		for (Reclamation reclamation:reclamations){
			System.out.println("reclamation out: "+reclamation);
			L.info("reclamation : "+reclamation);
		}
	}

	/*@Override
	public Reclamation afficherReclamation(Long idr)  {
		Optional<Reclamation> rOpt=reclamationRepository.findById(idr);
		Reclamation r=rOpt.get();
		return r;
	}*/
	
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
	public Livre afficherLivre(Livre l) throws StockException {
		Optional<Livre> livreOpt=stockRepository.findById(l.getId());
		Livre livre=livreOpt.get();
		return livre;
	}
	@Override
	public void AfficherLivres(List<Livre> livres) {
		livres=ListerLivres();
		for(Livre livre:livres){
			L.info("Livre : "+livre);
		}
	}

	@Override
	public Reclamation afficherReclamation(Reclamation r) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
