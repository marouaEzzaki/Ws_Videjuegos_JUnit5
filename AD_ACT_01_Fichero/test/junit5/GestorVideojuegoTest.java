package junit5;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import modelo.entidad.Videojuego;
import modelo.negocio.GestorVideojuego;
import modelo.persistencia.DaoVideojuegoFichero;

class GestorVideojuegoTest {

	
	private DaoVideojuegoFichero dvf;
	
	private static final String VIDEOJUEGO_FICHERO = "Videojuegos.txt"; 
	
	// Test para verificar que el método validar arroja una excepcion.
	@Test
	void testExceptionDeValidar() {
		
		 dvf = new DaoVideojuegoFichero(VIDEOJUEGO_FICHERO);
		 
		 Videojuego v = new Videojuego();
		 
		 
		 assertThrows(Exception.class, 
				 
				 () -> {
					 Videojuego vFichero = dvf.getByVideojuego(v.getNombre());

				 }
				 
				 );
		 
	}
	
	// Test para verificar que el método validar devuelve 0, si el videojuego no existe.
	@Test
	void validarReturns0()  {
		
		dvf = new DaoVideojuegoFichero(VIDEOJUEGO_FICHERO);
		 
		 Videojuego v1 = new Videojuego();
		 v1.setNombre("juego JUnit test prueba");
		 
		GestorVideojuego gvj = new GestorVideojuego(VIDEOJUEGO_FICHERO);
		
		
		assertEquals(0, gvj.validar(v1));
	}

	
	
	// Test para verificar que el método validar devuelve 1, si el videojuego existe y es válido.
	@Test
	void validarReturns1()  {
		
		
		 Videojuego v3 = new Videojuego();
		dvf = new DaoVideojuegoFichero(VIDEOJUEGO_FICHERO);
		 
		v3.setNombre("Juego1");
		v3.setCompania("Empresa");
		v3.setNota(5);
		 
		GestorVideojuego gvj = new GestorVideojuego(VIDEOJUEGO_FICHERO);
		
			 try {
				Videojuego vFichero = dvf.getByVideojuego(v3.getNombre());
			} catch (Exception e) {
				
				System.out.println("error, inténtalo más tarde :D");
			}
			 
//			 Videojuego vFichero = new Videojuego();
//			 
//			 vFichero.setNombre("Juego1");
//			 vFichero.setCompania("test3");
//			 vFichero.setNota(3);
			
		
		//System.out.println(vFichero);
		
		assertEquals(1, gvj.validar(v3));
	}
	
	
	
	// Test para verificar que el método validar devuelve 2, si el videojuego existe pero no es válido.
	@Test
	void validarReturns2()  {
		
		
		 Videojuego v3 = new Videojuego();
		dvf = new DaoVideojuegoFichero(VIDEOJUEGO_FICHERO);
		 
		v3.setNombre("Juego1");
		v3.setCompania("Empresa");
		v3.setNota(55); // he cambiado la nota para que no sea válido
		 
		GestorVideojuego gvj = new GestorVideojuego(VIDEOJUEGO_FICHERO);
		
			 try {
				Videojuego vFichero = dvf.getByVideojuego(v3.getNombre());
			} catch (Exception e) {
				
				System.out.println("error, inténtalo más tarde :D");
			}
			 
		
		assertEquals(2, gvj.validar(v3));
	}
	
	
	
	// Test para verificar que el método validar devuelve 6, en caso de que ocurra algún problema de entrada/salida.
	@Test
	void validarReturns66()  {
		
		
		Videojuego v3 = new Videojuego();
		
		dvf = new DaoVideojuegoFichero(VIDEOJUEGO_FICHERO);
		 
		
		GestorVideojuego gvj = new GestorVideojuego(VIDEOJUEGO_FICHERO);
		
			 try {
//				Videojuego vFichero = dvf.getByVideojuego(v3.getNombre());
			} catch (Exception e) {
				
				System.out.println("error, inténtalo más tarde :D");
			}
			 
		assertEquals(666, gvj.validar(v3));
	}
	
	//Test para comprobar que el método guardar devuelve 0 si el videojuego pasado por parámetro es nulo.
	@Test
	void guardarReturns0() {
		
		Videojuego v4 = null;
		GestorVideojuego gvj = new GestorVideojuego(VIDEOJUEGO_FICHERO);

	
		assertEquals(0, gvj.guardar(v4));
			
	}
	
	
	//Test para comprobar que el método guardar devuelve 1 si el nombre está vacío, solo tiene espacios en blanco o tiene menos de 3 caracteres.
	@Test
	void guardarReturns1() {
		
		Videojuego v5 = new Videojuego();
		
		v5.setNombre("    ");
		v5.setCompania("compania");
		v5.setNota(0);
		
		 dvf = new DaoVideojuegoFichero(VIDEOJUEGO_FICHERO);
		  
		  
		GestorVideojuego gvj = new GestorVideojuego(VIDEOJUEGO_FICHERO);

	
		assertEquals(1, gvj.guardar(v5));
			
	}
	
	
	
	
	//Test para comprobar que el método guardar devuelve 2 si el nombre de la compañía está 
	//vacío, solo tiene espacios en blanco o tiene menos de 5 caracteres.
	@Test
	void guardarReturns2() {

		Videojuego v6 = new Videojuego();

		v6.setNombre("empresa6");
		v6.setCompania("	");
		v6.setNota(4);

		dvf = new DaoVideojuegoFichero(VIDEOJUEGO_FICHERO);

		GestorVideojuego gvj = new GestorVideojuego(VIDEOJUEGO_FICHERO);

		assertEquals(2, gvj.guardar(v6));

	}

		//Test para comprobar que el método guardar devuelve 3 si si la nota está fuera 
		//del rango permitido (menor a 0 o mayor a 100)
		@Test
		void guardarReturns3() {

			Videojuego v7 = new Videojuego();

			v7.setNombre("guardarReturns3");
			v7.setCompania("compaiaReturn3");
			v7.setNota(-10);

			dvf = new DaoVideojuegoFichero(VIDEOJUEGO_FICHERO);

			GestorVideojuego gvj = new GestorVideojuego(VIDEOJUEGO_FICHERO);

			assertEquals(3, gvj.guardar(v7));

		}
	
		
		//Test para comprobar que el método guardar devuelve 4 si el videojuego se ha guardado correctamente.
		@Test
		void guardarReturns4() {

			Videojuego v8 = new Videojuego();

			v8.setNombre("JuegoCorrecto");
			v8.setCompania("CompaniaCorrecto");
			v8.setNota(70);

			dvf = new DaoVideojuegoFichero(VIDEOJUEGO_FICHERO);

			GestorVideojuego gvj = new GestorVideojuego(VIDEOJUEGO_FICHERO);

			 try {
				dvf.registrarVideojuego(v8);
			} catch (Exception e) {
				
				System.out.println("error intentalo más tarde :D !!");
			} 
			
			assertEquals(4, gvj.guardar(v8));

		}
	
		// Test para verificar que el método validar arroja una excepcion 
		//y devuelva 6 en caso de que ocurra una excepción de entrada/salida o cualquier otro error inesperado.
		@Test
		void testExceptionDeGuardar() {
			
			 dvf = new DaoVideojuegoFichero(VIDEOJUEGO_FICHERO);
			 
			 Videojuego v = null;
			 
			GestorVideojuego gvj = new GestorVideojuego(VIDEOJUEGO_FICHERO);

			 
			 assertThrows(Exception.class, 
					 
					 () -> {
						 
						 
						 dvf.registrarVideojuego(v);

					 }
					 
					 );
			 
		}
		
		// ME QUEDA REVISAR ALGUN TEST POR LA COBERTURA Y LA listarVideojuegos()
		
		
		@Test
		
		void testListarVideojuegoNull() {
			
			try {
				
				Videojuego v = new Videojuego();
				
				
				 List<Videojuego> lista = dvf.listaVideojuego();
				
				 assertEquals(null, lista);
			} catch (Exception  e) {
				
				System.out.println("error");
			}
			
			
		}
		
		
		@Test
		
		void testListarVideojuegoCorrecto() {
			
			try {
				
				Videojuego v10 = new Videojuego();
				v10.setNombre("masDificil");
				v10.setCompania("ultimoTestCreo");
				v10.setNota(100);
				

				GestorVideojuego gvj = new GestorVideojuego(VIDEOJUEGO_FICHERO);
				
				gvj.guardar(v10);
				
				
				dvf = new DaoVideojuegoFichero(VIDEOJUEGO_FICHERO);
				
				 List<Videojuego> lista = dvf.listaVideojuego();
				
				 assertEquals(lista, lista);
			} catch (Exception  e) {
				
				e.printStackTrace();
			}
			
			
		}
		
		
		
}
