package com.dish.mx.dev.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

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
public class AsignacionDesarrolloTareaDTO {

    
    private int asignacionId;
    private int desarrolladorId;
    private int tareaId;

    /**
     * Constructor vacío de la clase.
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     *
     * @since 0.0.1
     */
    public AsignacionDesarrolloTareaDTO() {
    }

    /**
     * Constructor de la clase con argumentos.
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     * @param asignacionId
     * @param desarrolladorId
     * @param tareaId
     * 
     * @since 0.0.1
     */
    public AsignacionDesarrolloTareaDTO(int asignacionId, int desarrolladorId, int tareaId) {
        this.asignacionId = asignacionId;
        this.desarrolladorId = desarrolladorId;
        this.tareaId = tareaId;
    }

    /**
     * @return the asignacionId
     */
    public int getAsignacionId() {
        return asignacionId;
    }

    /**
     * @return the desarrolladorId
     */
    public int getDesarrolladorId() {
        return desarrolladorId;
    }

    /**
     * @return the tareaId
     */
    public int getTareaId() {
        return tareaId;
    }

    /**
     * @param asignacionId the asignacionId to set
     */
    public void setAsignacionId(int asignacionId) {
        this.asignacionId = asignacionId;
    }

    /**
     * @param desarrolladorId the desarrolladorId to set
     */
    public void setDesarrolladorId(int desarrolladorId) {
        this.desarrolladorId = desarrolladorId;
    }

    /**
     * @param tareaId the tareaId to set
     */
    public void setTareaId(int tareaId) {
        this.tareaId = tareaId;
    }

    @Override
    public String toString() {
        return "\tasignacionId=" + asignacionId + "\tdesarrolladorId=" + desarrolladorId + "\ttareaId=" + tareaId + "\n";
    }

}
