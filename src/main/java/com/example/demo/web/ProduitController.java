package com.example.demo.web;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.demo.dao.ProduitRepository;
import com.example.demo.entities.Produit;

@Controller
public class ProduitController {
    
	
	@Autowired
	private ProduitRepository produitr;
    
	//afficher la liste des produits
	@RequestMapping(value = "/")
	public String index(Model model) {
		List<Produit> listeP = produitr.findAll();
		model.addAttribute("listProduits", listeP);
		return "produits";
	}
   
	//afficher la formulaire 'ajouter un produit' 
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addP(Model model) {
		model.addAttribute("produit", new Produit());
		return "FromProduit";
	}

	//enregisrer
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Model model, Produit p) {
		produitr.save(p);
		return "redirect:/";

	}
    
	//supprimer
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(Long id) {
		produitr.deleteById(id);
		return "redirect:/";

	}

	//rechercher
	@RequestMapping(value = "/chercher")
	public String chercher(Model model) {
		return "produits";
	}
}
