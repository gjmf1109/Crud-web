package com.dish.mx.dev.mapper;

import com.dish.mx.dev.dto.TareaDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 * Clase en la que se obtienen los datos de la clase Tarea y los retorna para
 * poder utilizarlos en donde sean requeridos.
 *
 * @version 0.0.1
 *
 * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx%gt;
 *
 * @since 0.0.1
 *
 */
public class TareaRowMapper implements RowMapper<TareaDTO> {

    /**
     * El método recibe una variable del tipo ResultSet y un int, con estos
     * argumentos recorre la tabla de la base de datos y va recogiendo los datos.
     *
     * @param rs
     * @param rowNum
     *
     * @return Regresa un objeto del tipo TareaDTO con los registros
     * obtenidos de la base de datos.
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     *
     * @throws java.sql.SQLException
     *
     * @since 0.0.1
     */
    @Override
    public TareaDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new TareaDTO(rs.getInt("tarea_id"), rs.getString("nombre_tarea"),
                rs.getString("descripcion"), rs.getInt("proyecto_id"));
    }
}
