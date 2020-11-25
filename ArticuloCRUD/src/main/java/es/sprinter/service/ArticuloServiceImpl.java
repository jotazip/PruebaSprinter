package es.sprinter.service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.sprinter.entity.Articulo;
import es.sprinter.repository.ArticuloRepository;

@Service
public class ArticuloServiceImpl implements ArticuloService {

	@Autowired
	ArticuloRepository articuloRepository;

	// saca todo el listado de artículos
	public List<Articulo> findAll() {
		return articuloRepository.findAll();
	}

	// saca un artículo por id
	public Optional<Articulo> findById(String id) {
		return articuloRepository.findById(id);
	}

	// crear un artículo
	public Articulo save(Articulo articulo) {
		return articuloRepository.save(articulo);
	}

	// elimina un artículo mediante id
	public void deleteById(String id) {
		articuloRepository.deleteById(id);
	}

	// validar la existencia de esa id
	public boolean existsById(String id) {
		return articuloRepository.existsById(id);
	}
}
