package clases;

import java.util.List;

import interfaces.NivelDeConocimiento;

public class ConocimientoEspecialista implements NivelDeConocimiento {

	@Override
	public NivelDeConocimiento verificarNivelDeConocimiento(List<Muestra> muestrasVerificadas,
			List<Muestra> muestrasEnviadas) {
		return this;
	}

	public boolean equals(Object o) {
		if (o == null) return false;
		if (o == this) return true;
		if (o instanceof ConocimientoEspecialista)return true;
		return false;
	}
	
	public boolean esDefinitorio() {
		return true;
	}
}
