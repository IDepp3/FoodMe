public enum TipoEmpleado {
    MOZO(1500),
    BARTENDER(2200),
    SUSHIMAN(3610);

    protected final int sueldo;

    private TipoEmpleado(int sueldo) {
        this.sueldo = sueldo;
    }

    
}
