package com.dish.mx.dev.daoimpl;

import com.dish.mx.dev.dao.AsignacionDesarrolloTareaDAO;
import com.dish.mx.dev.dto.AsignacionDesarrolloTareaDTO;
import com.dish.mx.dev.mapper.AsignacionDesarrolloTareaRowMapper;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Clase en la que se implementan la interface AsignacionDesarrolloTareaDAO con todos los métodos
 * que ejecutan los querys para el manejo de los datos de la base.
 *
 * @version 0.0.1
 *
 * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx%gt;
 *
 * @since 0.0.1
 *
 */
@Repository("asignacionDesarrolloTareaDAOImpl")
public class AsignacionDesarrolloTareaDAOImpl implements AsignacionDesarrolloTareaDAO{
    
    private static final Logger logger = LogManager.getLogger(AsignacionDesarrolloTareaDAOImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Constructor vacío de la clase.
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     *
     * @since 0.0.1
     */
    public AsignacionDesarrolloTareaDAOImpl() {
    }

    /**
     * El método ejecuta un query para poder obtener todos los registros de la
     * tabla de la base de datos
     *
     * @return Regresa una lista con los registros obtenidos por el query
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     *
     * @since 0.0.1
     */
    @Override
    public List<AsignacionDesarrolloTareaDTO> encontrarTodos() {
        return getJdbcTemplate().query("SELECT * FROM asignacion_desarrollador_tarea", new AsignacionDesarrolloTareaRowMapper());
    }

    /**
     * El método ejecuta un query para poder obtener todos los registros de la
     * tabla de la base de datos según el id introducido
     *
     * @param id
     * @return Regresa un objeto del tipo AsignacionDesarrolloTarea con los registros obtenidos
     * por el query
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     *
     * @since 0.0.1
     */
    @Override
    public AsignacionDesarrolloTareaDTO encontrarPorId(int id) {
        //Ejecuta la consulta y nos regresa un objeto del tipo indicado
        //En este caso del tipo de nuestra clase TareaRowMapper
        return getJdbcTemplate().queryForObject("SELECT * FROM asignacion_desarrollador_tarea WHERE asignacion_id = ?", 
                new Object[]{id},
                new AsignacionDesarrolloTareaRowMapper());
    }

    /**
     * El método ejecuta un query para poder insertar registros en la tabla de la base de
     * datos de acuerdo a los datos que se le pasan en los argumentos del mismo.
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     * @param asignacionId
     * @param desarrolladorId
     * @param tareaId
     * 
     * @since 0.0.1
     */
    @Override
    public void insertarAsignacionDesarrolloTarea(int asignacionId, int desarrolladorId, int tareaId) {
        getJdbcTemplate().update("INSERT INTO asignacion_desarrollador_tarea (asignacion_id, desarrollador_id, tarea_id) "
                + "VALUES(?,?,?)", asignacionId, desarrolladorId, tareaId);
    }

    /**
     * El método ejecuta un query para poder insertar registros en la base de
     * datos, se le pasa una variable de tipo AsignacionDesarrolloTareaDTO, para después obtener 
     * los datos de esta variable con los métodos getters y setters.
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     * 
     * @param asignacion
     *
     * @since 0.0.1
     */
    @Override
    public void insertarAsignacionDesarrolloTarea(AsignacionDesarrolloTareaDTO asignacion) {
        getJdbcTemplate().update("INSERT INTO asignacion_desarrollador_tarea (asignacion_id, desarrollador_id, tarea_id) "
                + "VALUES(?,?,?)", asignacion.getAsignacionId(), asignacion.getDesarrolladorId(), asignacion.getTareaId());
    }

    /**
     * El método ejecuta un query para poder actualizar todos los registros de
     * la tabla de la base de datos de acuerdo a los datos que el usuario proporcione
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     * 
     * @param asignacion
     * 
     * @return Regresa el número de filas actualizadas.
     *
     * @since 0.0.1
     */
    @Override
    public int actualizarAsignacionDesarrolloTarea(AsignacionDesarrolloTareaDTO asignacion) {
        int resp = 0;

        //Un update me regresa el número de filas actualizadas, es por eso
        //que el resultado es asignado a una variable de tipo int.
        return resp = getJdbcTemplate().update("UPDATE asignacion_desarrollador_tarea SET desarrollador_id = ?, tarea_id = ? "
                + "WHERE  asignacion_id = ?", new Object[]{asignacion.getDesarrolladorId(),asignacion.getTareaId(),
                    asignacion.getAsignacionId()});
    }

    /**
     * El método ejecuta un query para poder eliminar todos los registros de la
     * tabla de la base de datos
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     * @return Regresa el número de filas eliminadas.
     *
     * @since 0.0.1
     */
    @Override
    public int eliminarTodos() {
        return getJdbcTemplate().update("DELETE from asignacion_desarrollador_tarea");
    }

    /**
     * El método ejecuta un query para poder obtener todos los registros de la
     * tabla de la base de datos de acuerdo al id introducido.
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     * @param id
     * @return Regresa el número de filas eliminadas.
     *
     * @since 0.0.1
     */
    @Override
    public int eliminarPorID(int id) {
        return getJdbcTemplate().update("DELETE FROM asignacion_desarrollador_tarea WHERE asignacion_id = ?", id);
    }
    
    
    /**
     * El método ejecuta un query para poder obtener todos los registros de la
     * tabla de la base de datos de acuerdo al id introducido.
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     * @param id
     * @return Regresa el número de filas eliminadas.
     *
     * @since 0.0.1
     */
    @Override
    public int eliminarPorID2(int id) {
        return getJdbcTemplate().update("DELETE FROM asignacion_desarrollador_tarea WHERE desarrollador_id = ?", id);
    }
    
    /**
     * El método ejecuta un query para poder obtener todos los registros de la
     * tabla de la base de datos de acuerdo al id introducido.
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     * @param id
     * @return Regresa el número de filas eliminadas.
     *
     * @since 0.0.1
     */
    @Override
    public int eliminarPorID3(int id) {
        return getJdbcTemplate().update("DELETE FROM asignacion_desarrollador_tarea WHERE tarea_id = ?", id);
    }

    /**
     * @return the jdbcTemplate
     */
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    /**
     * @param jdbcTemplate the jdbcTemplate to set
     */
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    
}
