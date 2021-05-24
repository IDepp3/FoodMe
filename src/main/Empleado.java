import java.time.LocalDate;

import com.utn.teamA.Persona;

public class Empleado extends Persona {
    
    private TipoEmpleado tipoEmpleado;
    private double sueldo;

    public Empleado(int id, String nombre, String apellido, LocalDate fechaNacimiento, String telefono,
            String direccion, String dni, String email, TipoEmpleado tipoEmpleado, double sueldo) {
        super(id, nombre, apellido, fechaNacimiento, telefono, direccion, dni, email);
        this.tipoEmpleado = tipoEmpleado;
        this.sueldo = sueldo;
    }
    
    public Empleado(){

    }

    public TipoEmpleado getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(TipoEmpleado tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return " Empleado | Sueldo: " + sueldo + " Tipo empleado: " + tipoEmpleado;
    }

    

    


}
