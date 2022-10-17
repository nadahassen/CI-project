package tn.esprit.rh.achat.tests.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

import tn.esprit.rh.achat.entities.Reglement;
import tn.esprit.rh.achat.services.IReglementService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class ReglementServiceImplTest {

	@Autowired
	IReglementService ReglementService;
	
	@Test
	@Order(1)
	public void testretrieveAllReglements() {
		List<Reglement> allReglements = ReglementService.retrieveAllReglements();
		assertEquals(1, allReglements.size());
	}
	
	@Test
	@Order(2)
	public void testaddReglement() throws ParseException {
		DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
		Date date =  df.parse("12-10-2022"); 
		Reglement r = new Reglement((long) 1, 1000, 100, null, date, null);
		Reglement savedReglement= ReglementService.addReglement(r);
		assertEquals(r.getMontantPaye(), savedReglement.getMontantRestant());

	}
}
