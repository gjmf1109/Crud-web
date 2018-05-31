package com.dish.mx.dev.daoimpl;

import com.dish.mx.dev.dao.ProyectoDAO;
import com.dish.mx.dev.dto.ProyectoDTO;
import com.dish.mx.dev.mapper.ProyectoRowMapper;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Clase en la que se implementan la interface ProyectoDAO con todos los métodos
 * que ejecutan los querys para el manejo de los datos de la base.
 *
 * @version 0.0.1
 *
 * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx%gt;
 *
 * @since 0.0.1
 *
 */
@Repository("proyectoDAOImpl")
public class ProyectoDAOImpl implements ProyectoDAO {

    private static final Logger logger = LogManager.getLogger(DesarrolladorDAOImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Constructor vacío de la clase.
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     *
     * @since 0.0.1
     */
    public ProyectoDAOImpl() {
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
    public List<ProyectoDTO> encontrarTodos() {
        return getJdbcTemplate().query("SELECT * FROM proyecto", new ProyectoRowMapper());
    }

    /**
     * El método ejecuta un query para poder obtener todos los registros de la
     * tabla de la base de datos según el id introducido
     *
     * @param id
     * @return Regresa un objeto del tipo Proyecto con los registros obtenidos
     * por el query
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     *
     * @since 0.0.1
     */
    @Override
    public ProyectoDTO encontrarPorId(int id) {
        //Ejecuta la consulta y nos regresa un objeto del tipo indicad
        //En este caso del tipo de nuestra clase EmpleadoRowMapper
        return getJdbcTemplate().queryForObject("SELECT * FROM proyecto WHERE proyecto_id = ? ", new Object[]{id},
                new ProyectoRowMapper());
    }

    /**
     * El método ejecuta un query para poder insertar registros en la tabla de la base de
     * datos de acuerdo a los datos que se le pasan en los argumentos del mismo.
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
    @Override
    public void insertarProyecto(int proyectoId, String nombreProyecto, String descripcion, String fechaInicio, String fechaFin) {
        getJdbcTemplate().update("INSERT INTO proyecto (proyecto_id, nombre_proyecto, descripcion, fecha_inicio, fecha_fin) "
                + "VALUES(?,?,?,?,?)", proyectoId, nombreProyecto, descripcion, fechaInicio, fechaFin);
    }

    /**
     * El método ejecuta un query para poder insertar registros en la base de
     * datos, se le pasa una variable de tipo ProyectoDTO, para después obtener 
     * los datos de esta variable con los métodos getters y setters.
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     * @param proyecto
     *
     * @since 0.0.1
     */
    @Override
    public void insertarProyecto(ProyectoDTO proyecto) {
        getJdbcTemplate().update("INSERT INTO proyecto (proyecto_id, nombre_proyecto, descripcion, fecha_inicio, fecha_fin) "
                + "VALUES(?,?,?,?,?)", proyecto.getProyectoId(), proyecto.getNombreProyecto(), 
                proyecto.getDescripcion(), proyecto.getFechaInicio(), proyecto.getFechaFin());
    }

    /**
     * El método ejecuta un query para poder actualizar todos los registros de
     * la tabla de la base de datos de acuerdo a los datos que el usuario proporcione
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     * @param proyecto
     * 
     * @return Regresa el número de filas actualizadas.
     *
     * @since 0.0.1
     */
    @Override
    public int actualizarProyecto(ProyectoDTO proyecto) {
        int resp = 0;

        //Un update me regresa el número de filas actualizadas, es por eso
        //que el resultado es asignado a una variable de tipo int.
        return resp = getJdbcTemplate().update("UPDATE proyecto SET nombre_proyecto = ?, "
                + "descripcion = ?, fecha_inicio = ?, fecha_fin = ? "
                + "WHERE  proyecto_id = ?", new Object[]{proyecto.getNombreProyecto(), proyecto.getDescripcion(),
                    proyecto.getFechaInicio(), proyecto.getFechaFin(), proyecto.getProyectoId()});
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
        return getJdbcTemplate().update("DELETE from proyecto");
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
        return getJdbcTemplate().update("DELETE FROM proyecto WHERE proyecto_id = ?", id);
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
        return getJdbcTemplate().update("DELETE FROM asignacion_desarrollador_tarea WHERE tarea_id in(" +
            "SELECT t.tarea_id FROM tarea t, proyecto p WHERE p.proyecto_id = ? " +
            "AND p.proyecto_id = t.proyecto_id)", id);
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
        return getJdbcTemplate().update("DELETE FROM tarea WHERE proyecto_id = ?", id);
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
