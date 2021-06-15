package com.utn.teamA.excepciones;

public class FechaNoDisponible extends Exception {
    String msg2;
    /**
     * Constructs an {@code IllegalAccessException} without a
     * detail message.
     */
    public FechaNoDisponible () {
        super();
    }

    /**
     * Constructs an {@code IllegalAccessException} with a detail message.
     *
     * @param   s   the detail message.
     */
    public FechaNoDisponible (String s) {

        super(s);
        msg2=s;
    }

    @Override
    public String getMessage()
    {
        return super.getMessage()+msg2;
    }
}

