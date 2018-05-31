package com.dish.mx.dev.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
public class ProyectoDTO {


    private int proyectoId;
    private String nombreProyecto;
    private String descripcion;
    private String fechaInicio;
    private String fechaFin;

    /**
     * Constructor vacío de la clase.
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     *
     * @since 0.0.1
     */
    public ProyectoDTO() {
    }

    /**
     * Constructor de la clase con argumentos.
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     * @param proyectoId
     * @param nombreProyecto
     * @param descripcion
     * @param fechaInicio
     * @param fechaFin
     * 
     * @since 0.0.1
     */
    public ProyectoDTO(int proyectoId, String nombreProyecto, String descripcion, String fechaInicio, String fechaFin) {
        this.proyectoId = proyectoId;
        this.nombreProyecto = nombreProyecto;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    /**
     * @return the proyectoId
     */
    public int getProyectoId() {
        return proyectoId;
    }

    /**
     * @return the nombreProyecto
     */
    public String getNombreProyecto() {
        return nombreProyecto;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @return the fechaInicio
     */
    public String getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @return the fechaFin
     */
    public String getFechaFin() {
        return fechaFin;
    }

    /**
     * @param proyectoId the proyectoId to set
     */
    public void setProyectoId(int proyectoId) {
        this.proyectoId = proyectoId;
    }

    /**
     * @param nombreProyecto the nombreProyecto to set
     */
    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @param fechaFin the fechaFin to set
     */
    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public String toString() {
        return "proyectoId=" + proyectoId + "\tnombreProyecto=" + nombreProyecto + "\tdescripcion=" + descripcion + "\tfechaInicio=" + fechaInicio + "\tfechaFin=" + fechaFin + "\n";
    }

}
