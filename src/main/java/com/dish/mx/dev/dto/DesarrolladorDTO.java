package com.dish.mx.dev.dto;

/**
 * Clase en la que definimos los atributos de la tabla a manipular en la base de
 * datos.
 *
 * @version 0.0.1
 *
 * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
 *
 * @since 0.0.1
 *
 */
public class DesarrolladorDTO {

    private int desarrolladorId;
    private int numEmpleado;
    private String nombre;
    private String apPaterno;
    private String apMaterno;

    /**
     * Constructor vacío de la clase.
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     *
     * @since 0.0.1
     */
    public DesarrolladorDTO() {
    }

    /**
     * Constructor de la clase con argumentos.
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     * @param desarrolladorId
     * @param numEmpleado
     * @param nombre
     * @param apPaterno
     * @param apMaterno
     * 
     * @since 0.0.1
     */
    public DesarrolladorDTO(int desarrolladorId, int numEmpleado, String nombre,
            String apPaterno, String apMaterno) {

        this.desarrolladorId = desarrolladorId;
        this.numEmpleado = numEmpleado;
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
    }

    /**
     * @return the desarrolladorId
     */
    public int getDesarrolladorId() {
        return desarrolladorId;
    }

    /**
     * @return the numEmpleado
     */
    public int getNumEmpleado() {
        return numEmpleado;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the apPaterno
     */
    public String getApPaterno() {
        return apPaterno;
    }

    /**
     * @return the apMaterno
     */
    public String getApMaterno() {
        return apMaterno;
    }

    /**
     * @param desarrolladorId the desarrolladorId to set
     */
    public void setDesarrolladorId(int desarrolladorId) {
        this.desarrolladorId = desarrolladorId;
    }

    /**
     * @param numEmpleado the numEmpleado to set
     */
    public void setNumEmpleado(int numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @param apPaterno the apPaterno to set
     */
    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    /**
     * @param apMaterno the apMaterno to set
     */
    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    @Override
    public String toString() {
        return "desarrolladorId=" + desarrolladorId + "\tnumEmpleado=" + numEmpleado + "\tnombre=" + nombre + "\tapPaterno=" + apPaterno + "\tapMaterno=" + apMaterno + "\n";
    }

}
