package tn.esprit.rh.achat.tests.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.services.IProduitService;


@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
public class ProduitServiceImplTest {
	@Autowired
	IProduitService ProduitService;

	@Test
	@Order(1)
	public void testRetrieveAllProduits() {
		List<Produit> allProduits = ProduitService.retrieveAllProduits();
		assertEquals(3, allProduits.size());
	}

	@Test
	@Order(2)
	public void testAddProduit() throws ParseException {
		DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
		Date d1 =  df.parse("12-10-2022"); 
		Date d2 =  df.parse("14-10-2022");
		Produit p = new Produit("00708", "libPorduit", 10, d1 , d2);
		Produit savedProduit = ProduitService.addProduit(p);
		assertEquals(p.getLibelleProduit(), savedProduit.getLibelleProduit());

	}
	
//
	@Test
	@Order(3)
	public void testRetrieveProduit() {
		Produit produit = ProduitService.retrieveProduit(1L);
		assertEquals(1L, produit.getIdProduit().longValue());
	}

	@Test
	@Order(4)
	public void testDeleteProduit() {
		ProduitService.deleteProduit(4L);
		assertNull(ProduitService.retrieveProduit(4L));
	}

}