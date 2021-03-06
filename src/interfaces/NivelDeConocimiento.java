package interfaces;

import java.util.List;

import clases.Muestra;

public interface NivelDeConocimiento {

	public NivelDeConocimiento verificarNivelDeConocimiento(List<Muestra> muestrasVerificadas, List<Muestra> muestrasEnviadas);
	
	public boolean equals(Object o);

	public boolean esDefinitorio();

}