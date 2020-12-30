package bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bookstore.entities.Livre;

public interface StockRepository extends JpaRepository<Livre, Long>{

	
}
