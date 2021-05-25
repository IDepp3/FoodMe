package com.utn.teamA;

import java.time.LocalDate;
import java.util.List;

import com.utn.teamA.Usuario;

public class Cliente extends Usuario {

    private List<Reserva> reservas;

    public Cliente(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public Cliente(int id, String nombre, String apellido, LocalDate Nacimiento, String telefono, String direccion,
            String dni, String email, int idUsuario, String nombreUsuario, String contraseña, LocalDate fechaRegistro,
            List<Reserva> reservas) {
        super(id, nombre, apellido, Nacimiento, telefono, direccion, dni, email, idUsuario, nombreUsuario, contraseña,
                fechaRegistro);
        this.reservas = reservas;
    }

    public Cliente() {

    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    @Override
    public String toString() {
        return " Cliente | Reservas: " + reservas;
    }

    


}
