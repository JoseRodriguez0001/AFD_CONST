package utils;

import enums.TipoEntrada;

public class ValidadorEntrada {

    public static boolean esDigito(char c) {
        return Character.isDigit(c);
    }

    public static boolean esSigno(char c) {
        return c == '+' || c == '-';
    }

    public static boolean esPunto(char c) {
        return c == '.';
    }

    public static boolean esExponente(char c) {
        return c == 'e' || c == 'E';
    }

    public static TipoEntrada clasificar(char c) {
        if (esDigito(c)) return TipoEntrada.DIG;
        if (esSigno(c)) return TipoEntrada.SIG;
        if (esPunto(c)) return TipoEntrada.PTO;
        if (esExponente(c)) return TipoEntrada.EXP;
        return TipoEntrada.OTRO;
    }
}
