package junit5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import modelo.entidad.Videojuego;
import modelo.negocio.GestorVideojuego;
import modelo.persistencia.DaoVideojuegoFichero;

class DaoVideojuegoFicheroTest {

	private DaoVideojuegoFichero dvf;
	private static final String VIDEOJUEGO_FICHERO = "fichero_prueba.txt"; 
	
	@Test
	
	void testgetByVideojuegoNull() {
		
		
		dvf = new DaoVideojuegoFichero(VIDEOJUEGO_FICHERO);
		
		GestorVideojuego gvj = new GestorVideojuego(VIDEOJUEGO_FICHERO);
		
		
		try {
			assertEquals(null, dvf.getByVideojuego("noExiste"));
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
	@Test
	
	void testgetByVideojuegoNotNull() {
		
		
		dvf = new DaoVideojuegoFichero(VIDEOJUEGO_FICHERO);		
		
		try {
		
			 assertNotNull(dvf.getByVideojuego("primer"));
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	

	//Test para probar el bloque de exception en caso de que haya un problema con el fichero
	//le he pasado un fichero que no existe
	@Test
	
	void testgetByVideojuegoException() {
		
		
		dvf = new DaoVideojuegoFichero("fichero_no_existee.txt");		
		
		
			
			assertThrows(Exception.class, 
					 
					 () -> {dvf.getByVideojuego("primer");}
					 
					);
			
		
	}
	

	@Test 
	
	void testRegistrarVideojuegoTodoBien() throws Exception {
		
		Videojuego vtestRegistrar = new Videojuego();
		
		vtestRegistrar.setNombre("test1");
		vtestRegistrar.setCompania("Registrar");
		vtestRegistrar.setNota(2);
		
		dvf = new DaoVideojuegoFichero(VIDEOJUEGO_FICHERO);		
		
		
		dvf.registrarVideojuego(vtestRegistrar);
		
		//todo bien, porque se guarda perfectamente en el archivo
		
		
	}
	
	
	
	@Test 
	
	void testRegistrarVideojuegoException(){
		
		Videojuego vtestRegistrar = new Videojuego();
		
		vtestRegistrar.setNombre("test2");
		vtestRegistrar.setCompania("Registrar");
		vtestRegistrar.setNota(3);
		
		dvf = new DaoVideojuegoFichero("no_existeee_txt");		
		
		
		
		
		assertThrows(Exception.class, 
				 
				 () -> {dvf.registrarVideojuego(vtestRegistrar);}
				 
				);
		
		
	}
	
	
	@Test

	void testListarVideojuegoBien() {

		dvf = new DaoVideojuegoFichero(VIDEOJUEGO_FICHERO);

		List<Videojuego> videojuegos = assertDoesNotThrow(() -> dvf.listaVideojuego());

		assertNotNull(videojuegos);

		assertFalse(videojuegos.isEmpty());

		for (Videojuego v : videojuegos) {

			System.out.println(v);
		}

	}
	
	
	@Test
	void testListarVideojuegoException() {
		
		System.out.println("\nlistaVideojuego() excption");
		dvf = new DaoVideojuegoFichero("fichero_no_existe.txt");		
	
		
		
		assertThrows(Exception.class, 
				 
				 () -> dvf.listaVideojuego()
				 
				);
	}
		
}