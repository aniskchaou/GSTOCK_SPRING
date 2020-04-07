package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.dao.ProduitRepository;
import com.example.demo.entities.Produit;

@SpringBootApplication
public class SpringMvc1Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringMvc1Application.class, args);
		
		//ajouter des produits
		ProduitRepository produitdao = ctx.getBean(ProduitRepository.class);
		produitdao.save(new Produit("Cahier", 3.3, 1));
		produitdao.save(new Produit("Livre", 3.11, 1));
		produitdao.save(new Produit("Stylo", 5.3, 3));
	}

}
