package es.commerce.controller;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.commerce.entity.Articulo;
import es.commerce.service.ArticuloService;

@RestController
@RequestMapping(value = "api")
public class ArticuloController {

	@Autowired
	private ArticuloService articuloService;
	Logger logger = Logger.getLogger("Logger commerce"); 

	@GetMapping(value = "/articulos")
	public ResponseEntity<Articulo> list() {
		List<Articulo> articulos = articuloService.findAll();;
		try {
			logger.log(Level.INFO, "Se han obtenido todos los artículos");
			return new ResponseEntity(articulos, HttpStatus.OK);
		}catch (Exception e) {
			logger.warning("Exception: " + e);
			return new ResponseEntity(articulos, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(value = "/articulo/{id}")
	public ResponseEntity<Articulo> articuloById(@PathVariable("id") String id) {
		Optional<Articulo> optionalArticulo = articuloService.findById(id);
		if(optionalArticulo.isPresent()) {
			logger.log(Level.INFO, "Se ha obtenido el artículo " + id);
			return new ResponseEntity(optionalArticulo, HttpStatus.OK);
		}
		else
			logger.log(Level.INFO, "No hay un artículo con esa ID");
			return new ResponseEntity(optionalArticulo, HttpStatus.NOT_FOUND);
	}

	@PostMapping(value = "/articulo")
	public ResponseEntity<Articulo> createArticulo(@RequestBody Articulo articulo) {
		Articulo createArticulo = articuloService.save(articulo);
		if(createArticulo != null) {
			logger.log(Level.INFO, "Se ha insertado un nuevo artículo");
			return new ResponseEntity(createArticulo, HttpStatus.CREATED);
		}else {
			logger.log(Level.INFO, "No se ha podido insertar el artículo");
			return new ResponseEntity(createArticulo, HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value = "/articulo/{id}")
	public ResponseEntity<Articulo> updateArticulo(@RequestBody Articulo articulo) {
		Optional<Articulo> optionalArticulo = articuloService.findById(articulo.getId());
		if(optionalArticulo.isPresent()) {
			Articulo updateArticulo = optionalArticulo.get();
			updateArticulo.setNombre(articulo.getNombre());
			updateArticulo.setSeccion(articulo.getSeccion());
			updateArticulo.setPrecio(articulo.getPrecio());
			
			articuloService.save(updateArticulo);
			logger.log(Level.INFO, "Se ha actualizado el artículo");
			return new ResponseEntity(optionalArticulo, HttpStatus.OK);
		}
		else {
			logger.log(Level.INFO, "No se ha podido actualizar el artículo");
			return new ResponseEntity(optionalArticulo, HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(value = "/articulo/{id}")
	public ResponseEntity<Void> deleteArticulo(@PathVariable("id") String id) {
		Optional<Articulo> optionalArticulo = articuloService.findById(id);
		if(articuloService.existsById(id)) {
			logger.log(Level.INFO, "Se ha eliminado el artículo correctamente");
			articuloService.deleteById(id);
			return new ResponseEntity(articuloService, HttpStatus.OK);
		}else {
			logger.log(Level.INFO, "No hay un artículo con esa ID");
			return new ResponseEntity(articuloService, HttpStatus.NOT_FOUND);
		}
	}
}
