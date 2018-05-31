package com.dish.mx.dev.dao;

import com.dish.mx.dev.dto.ProyectoDTO;
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
public interface ProyectoDAO {

    public List<ProyectoDTO> encontrarTodos();

    public ProyectoDTO encontrarPorId(int id);

    public void insertarProyecto(int proyectoId, String nombreProyecto, String descripcion, String fechaInicio, String fechaFin);

    public void insertarProyecto(ProyectoDTO proyecto);

    public int actualizarProyecto(ProyectoDTO proyecto);

    public int eliminarTodos();

    public int eliminarPorID(int id);
    
    public int eliminarPorID2(int id);
    
    public int eliminarPorID3(int id);
}
