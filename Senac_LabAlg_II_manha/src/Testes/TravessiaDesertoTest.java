package Testes;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import app.TravessiaDeserto;



/***
 * Tentativa de fazer uma Classe de testes do jogo Travessia Deserto
 * 
 * @author Luiz Pinto Lab Alg 2 Senac 5M
 */

   @RunWith(JUnit4.class)
public class TravessiaDesertoTest {
	TravessiaDeserto td;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		td = new TravessiaDeserto();
	}

	// Teste inicio Game
	@Before
	public void setUpinitGame() {
	}
	@Test
	public void testInitGame() {
		td.initGame();
		assertTrue(td.getPos()==0);
		assertTrue(td.getFuel()==6);
		assertEquals(td.getPos(), 0);
		 
	}
	@After
	public void tearDownInitGame() {
		td = null;
	}

	
	
	// teste avancar----------------------------------------------------------
	@Before
	public void setUpAvancar() {
	}
	@Test
	public void testAvancar() {
		td.initGame(); // iniciar jogo
		assertTrue(td.getFuel()>0);
		int x = td.getPos();
		int y = td.getFuel(); // variaveis para posicao e fuel
		
			td.avancar();
			assertEquals(td.getPos(), x+1);
			assertEquals(td.getFuel(), y-1);
		}
	@After
	public void tearDownAvancar() {
		td = null;
	}
	
	
	
	// teste voltar
	// ----------------------------------------------------------------
	@Before
	public void setUpVoltar() {
	}
	@Test
	public void testVoltar() {
		td.initGame();
		td.avancar();
		
		assertTrue(td.getFuel()>0);
		assertTrue(td.getPos()>0);
		int x = td.getPos();
	
			td.voltar();
			assertEquals(td.getPos(), x-1);
	}
	@After
	public void tearDownVoltar() {
		td = null;
	}

	
	
	// teste carregar
	// -------------------------------------------------------------------------------

	@Before
	public void setUpCarregar() {
		td = new TravessiaDeserto();
	}

	@Test
	public void testCarregar() {

		td.initGame();
		td.avancar();
		td.descarregar();
		int x = td.getPos();
		
		int[] deposito = td.getMap();
		
		assertTrue(td.getFuel()<6);
		assertTrue(deposito[x] > 0);
		td.carregar();
		
		if (x == 0) { // recoloca  6 NO FUEL
			td.carregar(); // teria que dar erro pois em x=0 ele fica cheio sem carregar 
			assertEquals(td.getFuel(), 6);
		}
	}
	@After
	public void tearDownCarregar() {
		td = null;
	}
	
	
	
	// teste descarregar
	// -------------------------------------------------------------------

	@Before
	public void setUpDescarregar() {
		td = new TravessiaDeserto();
	}

	@Test
	public void testDescarregar() {

		td.initGame();
		
		assertTrue(td.getFuel()>0);
		td.descarregar();
		if (td.getFuel()==0)
		{// Não pode descarregar se não tiver combustivel e nem na posição para carregar
			td.descarregar();
		}
			}
	@After
	public void tearDownDescarregar() {
		td = null;
	}
		
	
	
	// teste IsGameOver
	// -------------------------------------------------------------------

	@Before
	public void setUpisGameOver() {
	
	}
	@Test
	public void testisGameOver() {
		td.initGame();
		td.avancar();
	 
		int[] deposito = td.getMap();
            equals(td.getFuel()==0);
		    assertEquals(deposito[td.getPos()],0);
		
	}
	@After
	public void tearDownisGameOver() {
		td = null;
	}	

	// teste IsWinner
	// -------------------------------------------------------------------

	@Before
	public void setUpisWinner() {
	}
	@Test
	public void testisWinner() {
		td.initGame();
    	td.isGameOver();
			if (td.getPos()==10)
			assertEquals(td.isWinner(), true);
			else   assertEquals(td.isWinner(),false);
	}
	@After
	public void tearDownisWinner() {
		td = null;
	}	
// metodos para terminar o jogo

   public void movimento1(){
	   td.avancar();
	   td.avancar();
	   td.descarregar();
	   td.descarregar();
	   td.voltar();
	   td.voltar();
   }
   public void movimento2(){
	   td.avancar();
	   td.avancar();
	   td.carregar();
	   td.carregar();
   }
   public void movimento3(){
	   for (int i=0; i<7;i++)
		   td.carregar();
   }
   public void movimento4(){
	   for (int i=0; i<7;i++)
		   td.avancar();
   }
   
  //________________________________________________
   //   solução do jogo
   public void solucao(){
	      movimento1();
	      movimento1();
	      movimento1();
	      movimento1();
	      movimento2();
	      movimento1();
	      movimento3();
	      movimento2();
	      movimento4();
	      
   }
}