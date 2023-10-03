package org.ciberfarma.controller;

import org.ciberfarma.model.Producto;
import org.ciberfarma.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductoController {
	
	@Autowired /*Inyeccicon de las dependencia, que se usara en el controlador */
	private IProductoRepository repo;
	
	@GetMapping ("/listar")
	public String listadoProductos(Model model) {
		model.addAttribute("lstProductos", repo.findAll());
		return("listado");
	}
	
	@GetMapping ("/")
	public  String cargarPag(Model model) {
	model.addAttribute("producto", new Producto());
	return "crudproductos";
	}
	
	@PostMapping ("/grabar")
	public  String grabarPag(@ModelAttribute Producto producto) {
	System.out.println(producto);
	repo.save(producto);
	return "exito";
	}
}
