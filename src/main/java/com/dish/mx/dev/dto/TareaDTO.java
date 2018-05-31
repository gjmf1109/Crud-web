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
public class TareaDTO {

    private int tareaId;
    private String nombreTarea;
    private String descripcion;
    private int proyectoId;

    /**
     * Constructor vacío de la clase.
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     *
     * @since 0.0.1
     */
    public TareaDTO() {
    }

    /**
     * Constructor de la clase con argumentos.
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     * @param tareaId
     * @param nombreTarea
     * @param descripcion
     * @param proyectoId
     * 
     * @since 0.0.1
     */
    public TareaDTO(int tareaId, String nombreTarea, String descripcion, int proyectoId) {
        this.tareaId = tareaId;
        this.nombreTarea = nombreTarea;
        this.descripcion = descripcion;
        this.proyectoId = proyectoId;
    }

    /**
     * @return the tareaId
     */
    public int getTareaId() {
        return tareaId;
    }

    /**
     * @return the nombreTarea
     */
    public String getNombreTarea() {
        return nombreTarea;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @return the proyectoId
     */
    public int getProyectoId() {
        return proyectoId;
    }

    /**
     * @param tareaId the tareaId to set
     */
    public void setTareaId(int tareaId) {
        this.tareaId = tareaId;
    }

    /**
     * @param nombreTarea the nombreTarea to set
     */
    public void setNombreTarea(String nombreTarea) {
        this.nombreTarea = nombreTarea;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @param proyectoId the proyectoId to set
     */
    public void setProyectoId(int proyectoId) {
        this.proyectoId = proyectoId;
    }

    @Override
    public String toString() {
        return "tareaId=" + tareaId + "\tnombreTarea=" + nombreTarea + "\tdescripcion=" + descripcion + "\tproyectoId=" + proyectoId + "\n";
    }

}
