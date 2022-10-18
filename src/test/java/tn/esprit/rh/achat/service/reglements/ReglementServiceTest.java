package tn.esprit.rh.achat.service.reglements;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Reglement;
import tn.esprit.rh.achat.repositories.ReglementRepository;
import tn.esprit.rh.achat.services.ReglementServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ReglementServiceTest {
	
	@Mock
	ReglementRepository reglementRepositoy;
	
	@InjectMocks
	ReglementServiceImpl reglementService;

@Test	
public void testRetrieveReglement() {
		
	Reglement r = new Reglement(1L, 1200, 400, null, null, null);
	r.setIdReglement(1L);
		
	Mockito.when(reglementRepositoy.findById(1L)).thenReturn(Optional.of(r));
	reglementRepositoy.retrieveReglementByFacture(1L);
	Assertions.assertNotNull(r);
	System.out.println(r); 
	System.out.println(" Test of retrieve is working correctly");  
	
	}


@Test
public void createReglementTest()
{

	Reglement r2 = new Reglement(1L, 1300, 300,null, null, null);
	r2.setIdReglement(2L);
	reglementService.addReglement(r2);
	verify(reglementRepositoy, times(1)).save(r2);
	System.out.println(r2); 
	System.out.println(" add reglement test is working");  
}

@Test
public void TestDelete(){

	Reglement reglement = new Reglement(1L, 1200, 200, null, null, null);
    reglement.setIdReglement(3L);

    Mockito.lenient().when(reglementRepositoy.findById(reglement.getIdReglement())).thenReturn(Optional.of(reglement));

    reglementService.deleteById(reglement.getIdReglement());
    verify(reglementRepositoy).deleteById(reglement.getIdReglement());

    System.out.println(reglement);
    System.out.println(" Delete test is working ");  
}



}