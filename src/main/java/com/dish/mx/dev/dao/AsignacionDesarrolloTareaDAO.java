package com.dish.mx.dev.dao;

import com.dish.mx.dev.dto.AsignacionDesarrolloTareaDTO;
import java.util.List;

/**
 * Interface que tiene algunos métodos para que se puedan implementar
 * en alguna clase a su conveniencia.
 *
 * @version 0.0.1
 *
 * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx%gt;
 *
 * @since 0.0.1
 *
 */
public interface AsignacionDesarrolloTareaDAO {

    public List<AsignacionDesarrolloTareaDTO> encontrarTodos();

    public AsignacionDesarrolloTareaDTO encontrarPorId(int id);

    public void insertarAsignacionDesarrolloTarea(int asignacionId, int desarrolladorId, int tareaId);

    public void insertarAsignacionDesarrolloTarea(AsignacionDesarrolloTareaDTO asignacion);

    public int actualizarAsignacionDesarrolloTarea(AsignacionDesarrolloTareaDTO asignacion);

    public int eliminarTodos();

    public int eliminarPorID(int id);
    
    public int eliminarPorID2(int id);
    
    public int eliminarPorID3(int id);

}
