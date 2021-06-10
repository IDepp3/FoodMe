package com.utn.teamA.clases;



import java.util.List;



/**
 * Clase Cliente
 *
 * @marco
 */

public class Cliente extends Persona {

    private List<Reserva> reservas;

    //region Constructores

    /**
     * Constructor vacio
     *
     */
    public Cliente(){
    super();
    }

    /**
     * Constructor Cliente
     * @param lasReservas
     */
    public Cliente(List<Reserva> lasReservas){
        reservas = lasReservas;
    }

    public Cliente(String nombreUsuario, String password){
        super(nombreUsuario, password);
    }

    /**
     * Constructor Cliente + Persona
     * @param nombre
     * @param apellido
     * @param fechaNacimiento
     * @param telefono
     * @param direccion
     * @param dni
     * @param email
     */

     public Cliente(String nombre, String apellido, String fechaNacimiento, String telefono, String direccion,
                    String dni,String email,Boolean estado,List<Reserva> lasReservas){
        super(nombre,apellido,fechaNacimiento,telefono,direccion,dni,email,estado );
        reservas = lasReservas;
    }
    // constructor usado para el registro
    
    public Cliente(String id, String username, String password, String email, String fechaRegistro, String tipoUsuario, boolean estado){
        super(id, username, password, email, fechaRegistro, tipoUsuario, estado);
        this.reservas = null;
    }

    /**
     * Constructor Cliente + Persona + Usuario para el Loguin
     * @param username
     * @param password
     * @param fechaRegistro
     * @param nombre
     * @param apellido
     * @param fechaNacimiento
     * @param telefono
     * @param direccion
     * @param dni
     * @param email
     * @param lasReservas
     */
    public Cliente(String username, String password, String fechaRegistro,String nombre, String apellido, String fechaNacimiento,
                   String telefono, String direccion, String dni, String email,boolean estado,List<Reserva> lasReservas){
        super(username, password, fechaRegistro, nombre,  apellido,  fechaNacimiento, telefono, direccion,  dni, email,estado );
        reservas = lasReservas;
    }
    //endregion

    //endregion

    // region Getters && Setters

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    // endregion

    //region To String

    @Override
    public String toString() {
        return super.toString();
    }
    //endregion

    //region Equals
    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        
        if(obj instanceof Cliente){
            Cliente c = (Cliente)obj;
            if(this.getId().equals(c.getId()))
                return true;
        }

        return false;
    }


    public boolean existeCliente(Cliente cliente){
        if(this == cliente)
            return true;
        
        if(this.getUsername().equals(cliente.getUsername()) && this.getPassword().equals(cliente.getPassword()))
            return true;

        return false;
    }
    //endregion

    public void listarReservas(){
        if(this.reservas != null){
            for(Reserva r : this.reservas){
                System.out.println(r);
            }
        }else{
            System.out.println("Todavia no hay reservas realizadas");
        }
    }


}

