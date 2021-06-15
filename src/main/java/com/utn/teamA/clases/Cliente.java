package com.utn.teamA.clases;



import java.util.List;



/**
 * Clase Cliente
 *
 * @marco
 */

public class Cliente extends Persona {

    private List<String> reservas;


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
    public Cliente(List<String> lasReservas){
        reservas = lasReservas;
    }

    public Cliente(String dni){
        super(dni);
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
                    String dni,String email,Boolean estado,List<String> lasReservas){
        super(nombre,apellido,fechaNacimiento,telefono,direccion,dni,email,estado );
        reservas = lasReservas;
    }
    // constructor usado para el registro
    
    public Cliente(String id, String username, String password, String email, String fechaRegistro, String tipoUsuario, boolean estado){
        super(id, username, password, email, fechaRegistro, tipoUsuario, estado);
        this.reservas = null;
    }


    //constructor completo para traer el json (Anto)

    public Cliente(String username, String password, String email, String fechaRegistro, String tipoUsuario, String id, String nombre, String apellido, String fechaNacimiento, String telefono, String direccion, String dni, boolean estado, List<String> reservas) {
        super(username, password, email, fechaRegistro, tipoUsuario, id, nombre, apellido, fechaNacimiento, telefono, direccion, dni, estado);
        this.reservas = reservas;
    }


    //constructor para dar el el alta como admin (Anto)
    public Cliente(String username, String password, String email, String nombre, String apellido, String fechaNacimiento, String telefono, String direccion, String dni) {
        super(username, password, email,TipoUsuario.CLIENTE.tipo, nombre, apellido, fechaNacimiento, telefono, direccion, dni);
        this.reservas = null;
    }



//endregion

    //endregion

    // region Getters && Setters

    public List<String> getReservas() {
        return reservas;
    }

    public void setReservas(List<String> reservas) {
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

    //endregion

    public void listarReservas(){
        if(this.reservas != null){
			for(String r : this.reservas){
                System.out.println(r);
            }
        }else{
            System.out.println("Todavia no hay reservas realizadas");
        }
    }


}

