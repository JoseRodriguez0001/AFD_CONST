package afd;

import enums.TipoEntrada;

import java.util.function.Predicate;

public class Transicion {
    private final TipoEntrada tipoEntrada;
    private final Estado destino;
    private final Predicate<Character> condicion;

    public Transicion(TipoEntrada tipoEntrada, Estado destino, Predicate<Character> condicion){
        this.tipoEntrada = tipoEntrada;
        this.destino = destino;
        this.condicion = condicion;
    }

    public boolean aplica(Character c){
        return condicion.test(c);
    }

    public Estado getDestino() {
        return destino;
    }
    public TipoEntrada getTipoEntrada() {
        return tipoEntrada;
    }

    public Predicate<Character> getCondicion() {
        return condicion;
    }
}
