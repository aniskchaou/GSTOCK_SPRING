package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


import com.example.demo.dao.ProduitRepository;
import com.example.demo.entities.Produit;

@SpringBootApplication
public class SpringMvc1Application {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(SpringMvc1Application.class, args);
		ProduitRepository produitdao= ctx.getBean(ProduitRepository.class);
		
		
		produitdao.save(new Produit("zefz",3.3,1));
		produitdao.save(new Produit("deaed",3.111,1));
		produitdao.save(new Produit("erzeed",5.3,3));
	}

}
