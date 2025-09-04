package afd;

import enums.TipoEntrada;
import enums.TipoEstado;
import utils.ValidadorEntrada;

import java.util.concurrent.ThreadPoolExecutor;

public class AutomataFloat {

    private Estado estadoActual;
    private final Estado estadoError;

    // estdo principales
    private final Estado ini;
    private final Estado dig;
    private final Estado sig;
    private final Estado pto;
    private final Estado digpto;
    private final Estado digExp;
    private final Estado digExptedig;
    private final Estado digExpSig;

    public AutomataFloat(){
        ini = new Estado(TipoEstado.INI);
        dig = new Estado(TipoEstado.DIG);
        sig = new Estado(TipoEstado.SIG);
        pto = new Estado(TipoEstado.PTO);
        digpto = new Estado(TipoEstado.DIGPTO);
        digExp = new Estado(TipoEstado.DIGEXP);
        digExptedig= new Estado(TipoEstado.DEXD);
        digExpSig = new Estado(TipoEstado.DEXS);
        estadoError = new Estado(TipoEstado.ERR);

        configurarTransiciones();
        estadoActual= ini;
    }

    private void configurarTransiciones() {
        // Desde INICIAL
        ini.agregarTransicion(new Transicion(TipoEntrada.DIG, dig, ValidadorEntrada::esDigito));
        ini.agregarTransicion(new Transicion(TipoEntrada.SIG, sig, ValidadorEntrada::esSigno));
        ini.agregarTransicion(new Transicion(TipoEntrada.PTO, pto, ValidadorEntrada::esPunto));

        // Desde SIGNO_INICIAL
        sig.agregarTransicion(new Transicion(TipoEntrada.DIG, dig, ValidadorEntrada::esDigito));
        sig.agregarTransicion(new Transicion(TipoEntrada.PTO, pto, ValidadorEntrada::esPunto));

        // Desde ENTERO
        dig.agregarTransicion(new Transicion(TipoEntrada.DIG, dig, ValidadorEntrada::esDigito));
        dig.agregarTransicion(new Transicion(TipoEntrada.PTO, digpto, ValidadorEntrada::esPunto));
        dig.agregarTransicion(new Transicion(TipoEntrada.EXP, digExp, ValidadorEntrada::esExponente));

        // Desde PUNTO
        pto.agregarTransicion(new Transicion(TipoEntrada.DIG, digpto, ValidadorEntrada::esDigito));

        //
        digpto.agregarTransicion(new Transicion(TipoEntrada.DIG, digpto, ValidadorEntrada::esDigito));
        digpto.agregarTransicion(new Transicion(TipoEntrada.EXP, digExp, ValidadorEntrada::esExponente));

        //
        digExp.agregarTransicion(new Transicion(TipoEntrada.SIG, digExpSig, ValidadorEntrada::esSigno));
        digExp.agregarTransicion(new Transicion(TipoEntrada.DIG, digExptedig, ValidadorEntrada::esDigito));

        //
        digExpSig.agregarTransicion(new Transicion(TipoEntrada.DIG, digExptedig, ValidadorEntrada::esDigito));


        digExptedig.agregarTransicion(new Transicion(TipoEntrada.DIG, digExptedig, ValidadorEntrada::esDigito));

    }

    public boolean procesarCadena(String cadena){
        estadoActual = ini;

        for (char c : cadena.toCharArray()){
            boolean transicionValida = false;

            for (Transicion t : estadoActual.getTransiciones()){
                if (t.getCondicion().test(c)){   // aplica la condición (ej: es dígito, es punto, etc.)
                    estadoActual = t.getDestino();
                    transicionValida = true;
                    break;
                }
            }

            if (!transicionValida){
                estadoActual = estadoError ; // o un estado de error que tengas definido
                return false;
            }
        }

        return estadoActual.esAceptacion();
    }


}
