package com.dish.mx.dev.daoimpl;

import com.dish.mx.dev.dao.DesarrolladorDAO;
import com.dish.mx.dev.dto.DesarrolladorDTO;
import com.dish.mx.dev.mapper.DesarrolladorRowMapper;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Clase en la que se implementan la interface DesarrolladorDAO con todos los métodos
 * que ejecutan los querys para el manejo de los datos de la base.
 *
 * @version 0.0.1
 *
 * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx%gt;
 *
 * @since 0.0.1
 *
 */
@Repository("desarrolladorDAOImpl")
public class DesarrolladorDAOImpl implements DesarrolladorDAO {

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
    public DesarrolladorDAOImpl() {
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
    public List<DesarrolladorDTO> encontrarTodos() {
        return getJdbcTemplate().query("SELECT * FROM desarrollador", new DesarrolladorRowMapper());
    }

    /**
     * El método ejecuta un query para poder obtener todos los registros de la
     * tabla de la base de datos según el id introducido
     *
     * @param id
     * @return Regresa un objeto del tipo Desarrollador con los registros obtenidos
     * por el query
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     *
     * @since 0.0.1
     */
    @Override
    public DesarrolladorDTO encontrarPorId(int id) {
        //Ejecuta la consulta y nos regresa un objeto del tipo indicad
        //En este caso del tipo de nuestra clase EmpleadoRowMapper
        return getJdbcTemplate().queryForObject("SELECT * FROM desarrollador WHERE desarrollador_id = ?", new Object[]{id},
                new DesarrolladorRowMapper());
    }

    /**
     * El método ejecuta un query para poder insertar registros en la tabla de la base de
     * datos de acuerdo a los datos que se le pasan en los argumentos del mismo.
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     * 
     * @param desarrolladorId
     * @param numEmpleado
     * @param nombre
     * @param apPaterno
     * @param apMaterno
     * 
     * @since 0.0.1
     */
    @Override
    public void insertarDesarrollador(int desarrolladorId, int numEmpleado, String nombre, String apPaterno,
            String apMaterno) {
        getJdbcTemplate().update("INSERT INTO desarrollador (desarrollador_id, num_empleado, nombre, ap_paterno, "
                + "ap_materno) "
                + "VALUES(?,?,?,?,?)", desarrolladorId, numEmpleado, nombre, apPaterno, apMaterno);
    }

    /**
     * El método ejecuta un query para poder insertar registros en la base de
     * datos, se le pasa una variable de tipo DesarrolladorDTO, para después obtener 
     * los datos de esta variable con los métodos getters y setters.
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     * 
     * @param tarea
     *
     * @since 0.0.1
     */
    @Override
    public void insertarDesarrollador(DesarrolladorDTO tarea) {
        getJdbcTemplate().update("INSERT INTO desarrollador (desarrollador_id, num_empleado, nombre, ap_paterno, "
                + "ap_materno) "
                + "VALUES(?,?,?,?,?)", tarea.getDesarrolladorId(), tarea.getNumEmpleado(), tarea.getNombre(),
                tarea.getApPaterno(), tarea.getApMaterno());
    }

    /**
     * El método ejecuta un query para poder actualizar todos los registros de
     * la tabla de la base de datos de acuerdo a los datos que el usuario proporcione
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     * 
     * @param tarea
     * 
     * @return Regresa el número de filas actualizadas.
     *
     * @since 0.0.1
     */
    @Override
    public int actualizarDesarrollador(DesarrolladorDTO tarea) {
        int resp = 0;

        //Un update me regresa el número de filas actualizadas, es por eso
        //que el resultado es asignado a una variable de tipo int.
        return resp = getJdbcTemplate().update("UPDATE desarrollador SET num_empleado = ?, "
                + "nombre = ?, ap_paterno = ?, ap_materno = ? "
                + "WHERE  desarrollador_id = ?", new Object[]{tarea.getNumEmpleado(), tarea.getNombre(), 
                    tarea.getApPaterno(), tarea.getApMaterno(), tarea.getDesarrolladorId()});
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
        return getJdbcTemplate().update("DELETE from desarrollador");
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
        return getJdbcTemplate().update("DELETE FROM desarrollador WHERE desarrollador_id = ?", id);
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
