package tn.esprit.rh.achat;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Reglement;
import tn.esprit.rh.achat.services.IReglementService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class ReglementServiceTestJunit {

	@Autowired
	IReglementService reglementService;
	
	@Test
	@Order(1)
	public void testRetrieveAllReglements() {
		List<Reglement> allReglements = reglementService.retrieveAllReglements();
		assertEquals(1, allReglements.size());
	}
}
