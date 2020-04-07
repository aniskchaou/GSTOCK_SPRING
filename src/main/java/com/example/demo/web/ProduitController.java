package com.example.demo.web;

import java.net.Authenticator.RequestorType;
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
	
	@RequestMapping(value="/index")
	public String index(Model model)
	{
		List<Produit> listeP=produitr.findAll();
		model.addAttribute("listProduits",listeP);
		return "produits";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String addP(Model model)
	{
		model.addAttribute("produit", new Produit());
		
		return "FromProduit";
		
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(Model model,Produit p)
	{
		produitr.save(p);
		return "redirect:/index";
		
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete(Long id)
	{
		produitr.deleteById(id);
		
		return "redirect:/index";
		
	}
	
	@RequestMapping(value="/chercher")
	public String chercher(Model model)
	{
		
		return "produits";
	}
}
