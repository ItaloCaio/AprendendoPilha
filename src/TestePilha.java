import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestePilha {

	private static final Class<? extends Throwable> PilhaVaziaException = null;
	Pilha p;

	@Before
	public void inicializaPilha() {

		p = new Pilha(10);
	}

	@Test
	public void pilhaVazia() {

		assertTrue(p.estaVazia());

		assertEquals(0, p.tamanho());
	}

	@Test
	public void empilhaUmElemento() {

		p.empinha("primeiro");

		assertFalse(p.estaVazia());

		assertEquals(1, p.tamanho());

		assertEquals("primeiro", p.topo());
	}

	@Test
	public void empilhaEDesempilha() {

		p.empinha("primeiro");
		p.empinha("segundo");

		assertEquals(2, p.tamanho());

		assertEquals("segundo", p.topo());

		Object desempilhado = p.desempilha();

		assertEquals(1, p.tamanho());
		assertEquals("primeiro", p.topo());
		assertEquals("segundo", desempilhado);

	}
	
	@Test (expected = PilhaVaziaException.class)
	public void removeDaPilhaVazia(){
		
		p.desempilha();
	}
	
	@Test //(expected = PilhaCheiaException.class)
	public void adicionaNaPilhaCheia(){
		
		for( int i = 0; i < 10; i++){
			p.empinha("elemento " +i);
			
		}
		
		try{
		p.empinha("Boom");
		fail();
		}
		catch(PilhaCheiaException e){
			
		}
	}

}
