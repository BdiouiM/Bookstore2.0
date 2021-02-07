package bookstore.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import bookstore.entities.Livre;

public interface StockRepository extends JpaRepository<Livre, Long>{
	// REPOSITORY STOCK -MOHAMED BDIOUI-
	//sans JPQL
    @Query(value="SELECT * FROM T_Livre l WHERE l.id=:id ", nativeQuery = true)
	List<Livre> afficherLivreSelonID(@Param("id") Long id);
    @Query("SELECT count(*) FROM Livre l WHERE l.titre=:titre")
   	int nombreLivreSelonTitre(@Param("titre")String titre);
    @Query(value="SELECT count(*) FROM T_Livre", nativeQuery = true)
   	int nombreLivres();
}
