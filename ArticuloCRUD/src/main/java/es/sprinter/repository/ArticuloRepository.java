package es.sprinter.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.sprinter.entity.Articulo;

@Repository
public interface ArticuloRepository extends JpaRepository<Articulo, String>{

	public List<Articulo> findAll();
	
	public Optional<Articulo> findById(String id);

	@SuppressWarnings("unchecked")
	public Articulo save(Articulo articulo);

	public void deleteById(String id);
	
	public boolean existsById(String id);
}
