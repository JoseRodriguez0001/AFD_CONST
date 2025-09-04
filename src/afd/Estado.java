package afd;

import enums.TipoEstado;

import java.util.ArrayList;
import java.util.List;

public class Estado {
    private final TipoEstado tipoEstado;
    private final List<Transicion> transiciones;

    public Estado(TipoEstado tipoEstado) {
        this.tipoEstado = tipoEstado;
        this.transiciones = new ArrayList<>();
    }

    public TipoEstado getTipoEstado() {
        return tipoEstado;
    }

    public List<Transicion> getTransiciones() {
        return transiciones;
    }

    public void agregarTransicion(Transicion transicion) {
        transiciones.add(transicion);
    }

    public Estado moverA(Character c){
        for(Transicion transicion : transiciones){
            if (transicion.aplica(c)){
                return transicion.getDestino();
            }
        }
        return null;
    }

    public boolean esAceptacion(){
        return tipoEstado.esAceptacion();
    }

}
