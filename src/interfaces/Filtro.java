package interfaces;

import java.util.List;
import java.util.function.Predicate;

import clases.Muestra;
import interfaces.Filtro;
import interfaces.Operador;

public interface Filtro {
	public Filtro componer(Filtro f,Operador op);
	public List<Muestra> filtrar(Predicate<Muestra> algo);
}
