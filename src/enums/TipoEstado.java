package enums;

public enum TipoEstado {
    INI(false),
    DIG(true),
    SIG(false),
    PTO(false),
    DIGPTO(true),
    DIGEXP(false),
    DEXS(false),
    DEXD(true),
    ERR(false);

    private final boolean esAceptacion;
    private TipoEstado(boolean esAceptacion) {
        this.esAceptacion = esAceptacion;
    }
    public boolean esAceptacion() {
        return esAceptacion;
    }

}
