package clases;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import clases.ConocimientoBasico;
import clases.ConocimientoEspecialista;
import clases.ConocimientoExperto;
import clases.Muestra;
import clases.SistemaWeb;
import clases.Usuario;
import interfaces.NivelDeConocimiento;

import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;

class NivelDeConocimientoTest {
	Usuario usEspecialista;
	Usuario usExperto;
	Usuario usBasico;
	NivelDeConocimiento nvlEsp;
	NivelDeConocimiento nvlExp;
	NivelDeConocimiento nvlBas;
	SistemaWeb sisWeb;
	Muestra muestra;
	Insectos bicho3;
	Insectos bicho4;

	@BeforeEach
	void setUp() throws Exception {
		nvlEsp = new ConocimientoEspecialista();
		nvlExp = new ConocimientoExperto();
		nvlBas = new ConocimientoBasico();
		sisWeb = mock(SistemaWeb.class);
		usEspecialista = new Usuario("LJF",sisWeb,nvlEsp);
		usExperto = new Usuario("JLF",sisWeb,nvlExp);
		usBasico = new Usuario("FLJ",sisWeb);
		muestra = mock(Muestra.class);
		bicho3 = new Insectos("ChincheFoliada");
		bicho4 = new Insectos("chinche");
	}

	@Test
	void testUnUsuarioRecienCreadoTieneNivelDeConocimientoBasico() {
		assertEquals(nvlBas,usBasico.nivelDeConocimiento());
	}
	
	@Test
	void testUnUsuarioInicializadoConConocimientoExpertoVuelveABasicoAlRealizarUnaAccionYaQueNoParticipoEnLasSuficientesMuestras() {
		
		when(muestra.fecha()).thenReturn(LocalDate.now());
		assertEquals(nvlExp,usExperto.nivelDeConocimiento());
		usExperto.verificarMuestra(muestra, bicho3);
		assertEquals(nvlBas,usExperto.nivelDeConocimiento());

	}
	
	@Test
	void testUnUsuarioRecienCreadoRealiza20VerificacionesY10EnviosYSeVuelveExperto() {
		
		ArrayList<Muestra>lista = new ArrayList<Muestra>();
		
		for(int i=0; i<=20;i++) {
			lista.add(muestra);
		}
		
		when(sisWeb.muestrasSegun(usBasico)).thenReturn(lista);
		when(muestra.fecha()).thenReturn(LocalDate.now());
		
		for(int i=0; i<=20;i++) {
			usBasico.verificarMuestra(muestra, bicho4);
		}
	
		assertEquals(nvlExp,usBasico.nivelDeConocimiento());
	
	}

}
