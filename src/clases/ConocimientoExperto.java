package clases;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import interfaces.NivelDeConocimiento;

public class ConocimientoExperto implements NivelDeConocimiento {
	
	@Override
	public NivelDeConocimiento verificarNivelDeConocimiento(List<Muestra> muestrasVerificadas,
															List<Muestra> muestrasEnviadas) {
		LocalDate hoy = LocalDate.now();

		Integer cantMuestrasEnviadasEnElMes = 
				calcularCantMuestrasDelMes(muestrasEnviadas, hoy);
		
		Integer cantMuestrasVerificadasEnElMes = calcularCantMuestrasDelMes(muestrasVerificadas, hoy);
		
		if (cantMuestrasEnviadasEnElMes >= 10 && cantMuestrasVerificadasEnElMes >= 20) {
			return this;
		} else {
			return new ConocimientoBasico();
		}
	}

	private Integer calcularCantMuestrasDelMes(List<Muestra> muestras, LocalDate hoy) {
		return muestras.stream().filter(muestra -> muestra.fecha().getMonthValue() == hoy.getMonthValue() ||
				(muestra.fecha().getMonthValue() == hoy.getMonthValue()-1 && muestra.fecha().getDayOfMonth() >= hoy.getDayOfMonth())).collect(Collectors.toList()).size();
	}
	
	
	public boolean equals(Object o) {
		if (o == null) return false;
		if (o == this) return true;
		if (o instanceof ConocimientoExperto)return true;
		return false;
	}
	
	public boolean esDefinitorio() {
		return true;
	}
	
}
