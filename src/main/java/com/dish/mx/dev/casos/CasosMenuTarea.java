package com.dish.mx.dev.casos;

import com.dish.mx.dev.daoimpl.AsignacionDesarrolloTareaDAOImpl;
import com.dish.mx.dev.daoimpl.TareaDAOImpl;
import com.dish.mx.dev.dto.TareaDTO;
import java.util.List;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Clase en la que definimos métodos para la obtención de datos introducidos por
 * consola por el usuario.
 *
 * @version 0.0.1
 *
 * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
 *
 * @since 0.0.1
 *
 */
@Component
public class CasosMenuTarea {

    private TareaDTO tarea;
    private List<TareaDTO> imprimir;
    private TareaDTO imprimir2;

    @Autowired
    @Qualifier("asignacionDesarrolloTareaDAOImpl")
    private AsignacionDesarrolloTareaDAOImpl asignaDAO;

    @Autowired
    @Qualifier("tareaDAOImpl")
    private TareaDAOImpl tareaDAO;

    private Scanner leer = new Scanner(System.in);

    /**
     * Constructor vacío de la clase
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     *
     * @since 0.0.1
     */
    public CasosMenuTarea() {
    }

    /**
     * Método en el que se le da al usuario la opción de consultar todos los
     * elementos de la tabla de la base de datos o consultar alguno de acuerdo a
     * un id
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     *
     * @since 0.0.1
     */
    public List<TareaDTO> consultar1() {

        setImprimir(getTareaDAO().encontrarTodos());
        return getImprimir();
    }

    public TareaDTO consultar2(int id) {

        setImprimir2(getTareaDAO().encontrarPorId(id));
        return getImprimir2();
    }

    /**
     * Método en el que se le piden al usuario datos para insertar un registro
     * en la tabla
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     *
     * @since 0.0.1
     */
    public void insertar(int tareaNum, String nombre, String des, int proy) {
        TareaDTO tareaInsertar;
        tareaInsertar = new TareaDTO();

        tareaInsertar.setTareaId(tareaNum);
        tareaInsertar.setNombreTarea(nombre);
        tareaInsertar.setDescripcion(des);
        tareaInsertar.setProyectoId(proy);
        getTareaDAO().insertarTarea(tareaInsertar);
    }

    /**
     * Método en el que se le piden al usuario datos para actualizar todos o
     * algunos campos del registro.
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     *
     * @since 0.0.1
     */
    public void actualizar(int numTarea, String nomTarea, String descrip, int proyec) {

        setTarea(getTareaDAO().encontrarPorId(numTarea));
        getTarea().setNombreTarea(nomTarea);
        getTarea().setProyectoId(proyec);
        getTarea().setDescripcion(descrip);

        getTareaDAO().actualizarTarea(getTarea());
    }

    /**
     * Método en el que se le da al usuario la opción de eliminar todos los
     * elementos de la tabla de la base de datos o eliminar alguno de acuerdo a
     * un id
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     *
     * @since 0.0.1
     */
    public List<TareaDTO> eliminar1() {

        getAsignaDAO().eliminarTodos();
        getTareaDAO().eliminarTodos();
        setImprimir(getTareaDAO().encontrarTodos());
        return getImprimir();
    }

    public List<TareaDTO> eliminar2(int tarea1) {

        getAsignaDAO().eliminarPorID3(tarea1);
        getTareaDAO().eliminarPorID(tarea1);
        setImprimir(getTareaDAO().encontrarTodos());
        return getImprimir();
    }

    /**
     * @return the tarea
     */
    public TareaDTO getTarea() {
        return tarea;
    }

    /**
     * @return the imprimir
     */
    public List<TareaDTO> getImprimir() {
        return imprimir;
    }

    /**
     * @return the imprimir2
     */
    public TareaDTO getImprimir2() {
        return imprimir2;
    }

    /**
     * @return the tareaDAO
     */
    public TareaDAOImpl getTareaDAO() {
        return tareaDAO;
    }

    /**
     * @return the leer
     */
    public Scanner getLeer() {
        return leer;
    }

    /**
     * @param tarea the tarea to set
     */
    public void setTarea(TareaDTO tarea) {
        this.tarea = tarea;
    }

    /**
     * @param imprimir the imprimir to set
     */
    public void setImprimir(List<TareaDTO> imprimir) {
        this.imprimir = imprimir;
    }

    /**
     * @param imprimir2 the imprimir2 to set
     */
    public void setImprimir2(TareaDTO imprimir2) {
        this.imprimir2 = imprimir2;
    }

    /**
     * @param tareaDAO the tareaDAO to set
     */
    public void setTareaDAO(TareaDAOImpl tareaDAO) {
        this.tareaDAO = tareaDAO;
    }

    /**
     * @param leer the leer to set
     */
    public void setLeer(Scanner leer) {
        this.leer = leer;
    }

    /**
     * @return the asignaDAO
     */
    public AsignacionDesarrolloTareaDAOImpl getAsignaDAO() {
        return asignaDAO;
    }

    /**
     * @param asignaDAO the asignaDAO to set
     */
    public void setAsignaDAO(AsignacionDesarrolloTareaDAOImpl asignaDAO) {
        this.asignaDAO = asignaDAO;
    }

}
