package clases;
import java.util.List;

import interfaces.Operador;

public class OR implements Operador {

	@Override
	public List<Muestra> resolver(List<Muestra> m1, List<Muestra> m2) {
		
		List<Muestra> lista = m1;
		lista.addAll(m2);
		return lista;
	}

}
