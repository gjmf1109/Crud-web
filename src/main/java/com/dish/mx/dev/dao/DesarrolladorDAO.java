package com.dish.mx.dev.dao;

import com.dish.mx.dev.dto.DesarrolladorDTO;
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
public interface DesarrolladorDAO {
    
    public List<DesarrolladorDTO> encontrarTodos();

    public DesarrolladorDTO encontrarPorId(int id);

    public void insertarDesarrollador(int desarrolladorId, int numEmpleado, String nombre,
            String apPaterno, String apMaterno);

    public void insertarDesarrollador(DesarrolladorDTO tarea);

    public int actualizarDesarrollador(DesarrolladorDTO tarea);

    public int eliminarTodos();

    public int eliminarPorID(int id);
    
}
