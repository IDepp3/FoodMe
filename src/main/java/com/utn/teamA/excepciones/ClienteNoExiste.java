package com.utn.teamA.excepciones;

public class ClienteNoExiste extends Exception {
    String msg2;
    /**
     * Constructs an {@code IllegalAccessException} without a
     * detail message.
     */
    public ClienteNoExiste() {
        super();
        this.msg2 = "No tiene reservas";
    }

    /**
     * Constructs an {@code IllegalAccessException} with a detail message.
     *
     * @param   s   the detail message.
     */
    public ClienteNoExiste(String s) {

        super(s);
        msg2=s;
    }

    @Override
    public String getMessage()
    {
        return super.getMessage()+ " " + msg2;
    }
}


