package bookstore.service.Impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bookstore.entities.Reclamation;
import bookstore.entities.StatutReclamation;
import bookstore.entities.TypeReclamation;
import bookstore.exception.ReclamationException;
import bookstore.repository.ReclamationRepository;
import bookstore.service.ReclamationAdminService;
import bookstore.service.ReclamationClientService;
@Service
public class ReclamationImpl implements ReclamationAdminService,ReclamationClientService{
	@Autowired
	ReclamationRepository reclamationRepository;
	private static final Logger L = LogManager.getLogger(ReclamationImpl.class);
	public ReclamationImpl() {
		// TODO Auto-generated constructor stub
	}
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
			return(r.getStatutReclamation().equals(StatutReclamation.VALIDEE)||
					r.getStatutReclamation().equals(StatutReclamation.ANNULEE));
			
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

		@Override
		public Reclamation afficherReclamation(Reclamation rec)  {
			Optional<Reclamation> rOpt=reclamationRepository.findById(rec.getId());
			Reclamation r=rOpt.get();
			return r;
		}
		
}
