package es.sprinter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import es.sprinter.entity.Articulo;

@Service
public interface ArticuloService {

	// saca todo el listado de artículos
	public List<Articulo> findAll();
	
	// saca un artículo por id
	public Optional<Articulo> findById(String id);

	// crear un artículo
	public Articulo save(Articulo articulo);
	
	// eliminar artículo mediante id
	public void deleteById(String id);
	
	public boolean existsById(String id);
}
