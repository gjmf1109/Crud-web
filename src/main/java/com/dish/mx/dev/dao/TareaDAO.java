package com.dish.mx.dev.dao;

import com.dish.mx.dev.dto.TareaDTO;
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
public interface TareaDAO {
    
    public List<TareaDTO> encontrarTodos();

    public TareaDTO encontrarPorId(int id);

    public void insertarTarea(int tareaId, String nombreTarea, String descripcion, int proyectoId);

    public void insertarTarea(TareaDTO tarea);

    public int actualizarTarea(TareaDTO tarea);

    public int eliminarTodos();

    public int eliminarPorID(int id);
}
