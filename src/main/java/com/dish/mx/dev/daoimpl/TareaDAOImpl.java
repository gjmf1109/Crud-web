package com.dish.mx.dev.daoimpl;

import com.dish.mx.dev.dao.TareaDAO;
import com.dish.mx.dev.dto.TareaDTO;
import com.dish.mx.dev.mapper.TareaRowMapper;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Clase en la que se implementan la interface TareaDAO con todos los métodos
 * que ejecutan los querys para el manejo de los datos de la base.
 *
 * @version 0.0.1
 *
 * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx%gt;
 *
 * @since 0.0.1
 *
 */
@Repository("tareaDAOImpl")
public class TareaDAOImpl implements TareaDAO {
    
    private static final Logger logger = LogManager.getLogger(TareaDAOImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Constructor vacío de la clase.
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     *
     * @since 0.0.1
     */
    public TareaDAOImpl() {
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
    public List<TareaDTO> encontrarTodos() {
        return getJdbcTemplate().query("SELECT * FROM tarea", new TareaRowMapper());
    }

    /**
     * El método ejecuta un query para poder obtener todos los registros de la
     * tabla de la base de datos según el id introducido
     *
     * @param id
     * @return Regresa un objeto del tipo Tarea con los registros obtenidos
     * por el query
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     *
     * @since 0.0.1
     */
    @Override
    public TareaDTO encontrarPorId(int id) {
        //Ejecuta la consulta y nos regresa un objeto del tipo indicad
        //En este caso del tipo de nuestra clase EmpleadoRowMapper
        return getJdbcTemplate().queryForObject("SELECT * FROM tarea WHERE tarea_id = ?", new Object[]{id},
                new TareaRowMapper());
    }

    /**
     * El método ejecuta un query para poder insertar registros en la tabla de la base de
     * datos de acuerdo a los datos que se le pasan en los argumentos del mismo.
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     * @param tareaId
     * @param nombreTarea
     * @param descripcion
     * @param proyectoId
     * 
     * @since 0.0.1
     */
    @Override
    public void insertarTarea(int tareaId, String nombreTarea, String descripcion, int proyectoId) {
        getJdbcTemplate().update("INSERT INTO tarea (tarea_id, nombre_tarea, descripcion, proyecto_id) "
                + "VALUES(?,?,?,?)", tareaId, nombreTarea, descripcion, proyectoId);
    }

    /**
     * El método ejecuta un query para poder insertar registros en la base de
     * datos, se le pasa una variable de tipo ProyectoDTO, para después obtener 
     * los datos de esta variable con los métodos getters y setters.
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     * @param tarea
     *
     * @since 0.0.1
     */
    @Override
    public void insertarTarea(TareaDTO tarea) {
        getJdbcTemplate().update("INSERT INTO tarea (tarea_id, nombre_tarea, descripcion, proyecto_id) "
                + "VALUES(?,?,?,?)", tarea.getTareaId(), tarea.getNombreTarea(), tarea.getDescripcion(), tarea.getProyectoId());
    }

    /**
     * El método ejecuta un query para poder actualizar todos los registros de
     * la tabla de la base de datos de acuerdo a los datos que el usuario proporcione
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     * @param tarea
     * 
     * @return Regresa el número de filas actualizadas.
     *
     * @since 0.0.1
     */
    @Override
    public int actualizarTarea(TareaDTO tarea) {
        int resp = 0;

        //Un update me regresa el número de filas actualizadas, es por eso
        //que el resultado es asignado a una variable de tipo int.
        return resp = getJdbcTemplate().update("UPDATE tarea SET nombre_tarea = ?, "
                + "descripcion = ?, proyecto_id = ? "
                + "WHERE  tarea_id = ?", new Object[]{tarea.getNombreTarea(), tarea.getDescripcion(),
                    tarea.getProyectoId(), tarea.getTareaId()});
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
        return getJdbcTemplate().update("DELETE from tarea");
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
        return getJdbcTemplate().update("DELETE FROM tarea WHERE tarea_id = ?", id);
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
