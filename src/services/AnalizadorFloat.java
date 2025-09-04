package services;

import afd.AutomataFloat;

import java.util.Locale;

public class AnalizadorFloat {
    private final AutomataFloat automata;

    public AnalizadorFloat() {
        this.automata = new AutomataFloat();
    }

    public String verificar(String entrada){
        if (entrada== null || entrada.isBlank()){
            return "Cadena vacía o nula: no es un número flotante válido.";

        }
        String cadena = entrada.trim();
        boolean valido= automata.procesarCadena(cadena);
        if (valido){
            return "'" + entrada + "' es un número flotante válido ✅";

        }else {
            return "'" + entrada + "' NO es un número flotante válido ❌";

        }
    }
}
