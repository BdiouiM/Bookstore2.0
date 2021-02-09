package bookstore.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import bookstore.entities.GenreLivre;
import bookstore.entities.Livre;

@Repository
public interface LivreRepository extends JpaRepository<Livre, Long>{
	// REPOSITORY LIVRES -MOHAMED HEDI BEN ATIG-
	//sans JPQL
     @Query(value="SELECT * FROM T_Livre L WHERE L.id=:id ", nativeQuery = true)
	List<Livre> afficherLivresSelonID(@Param("id") Long id);
  //sans JPQL
     @Query(value="UPDATE T_Livre L SET L.c_auteur=:auteur,"
     		                                + "L.c_genre=:genre"
     		                                + "L.c_nbr_pages=:nbrPages"
     		                                +"L.c_prix=:prix"
     		                                +"L.c_titre=:titre"
     		                                +" WHERE L.id=:id ", nativeQuery = true)
	
    
	Livre modifierLivre(@Param("id") long idL, @Param("auteur") String auteur, @Param("genre") GenreLivre genre, @Param("nbrPages") int nbrPages, @Param("prix") float prix, @Param("titre") String titre);

   //sans JPQL
     @Query(value="INSERT INTO T_livre L   (L.c_auteur,L.c_genre,L.c_nbr_pages,L.c_prix,L.c_titre) VALUES (?,?,?,?,?,?)"
    		 , nativeQuery = true)
	
    
	Livre ajouterLivre(Livre L);
 
     
      
}
