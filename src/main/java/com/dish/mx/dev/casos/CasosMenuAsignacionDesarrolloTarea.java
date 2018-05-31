package com.dish.mx.dev.casos;

import com.dish.mx.dev.daoimpl.AsignacionDesarrolloTareaDAOImpl;
import com.dish.mx.dev.dto.AsignacionDesarrolloTareaDTO;
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
public class CasosMenuAsignacionDesarrolloTarea {

    private AsignacionDesarrolloTareaDTO asignacion;
    private List<AsignacionDesarrolloTareaDTO> imprimir;
    private AsignacionDesarrolloTareaDTO imprimir2;

    @Autowired
    @Qualifier("asignacionDesarrolloTareaDAOImpl")
    private AsignacionDesarrolloTareaDAOImpl asignaDAO;

    private Scanner leer = new Scanner(System.in);

    /**
     * Constructor vacío de la clase
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     *
     * @since 0.0.1
     */
    public CasosMenuAsignacionDesarrolloTarea() {
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
    public List<AsignacionDesarrolloTareaDTO> consultar1() {

        setImprimir(getAsignaDAO().encontrarTodos());
        return getImprimir();
    }

    public AsignacionDesarrolloTareaDTO consultar2(int id) {

        setImprimir2(getAsignaDAO().encontrarPorId(id));
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
    public void insertar(int asigna, int desarrollador, int tarea) {
        AsignacionDesarrolloTareaDTO asignacionInsertar;
        asignacionInsertar = new AsignacionDesarrolloTareaDTO();

        asignacionInsertar.setAsignacionId(asigna);
        asignacionInsertar.setDesarrolladorId(desarrollador);
        asignacionInsertar.setTareaId(tarea);
        getAsignaDAO().insertarAsignacionDesarrolloTarea(asignacionInsertar);
    }

    /**
     * Método en el que se le piden al usuario datos para actualizar todos o
     * algunos campos del registro.
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     *
     * @since 0.0.1
     */
    public void actualizar(int numAsigna, int desa, int tarea) {

        setAsignacion(getAsignaDAO().encontrarPorId(numAsigna));
        getAsignacion().setDesarrolladorId(desa);
        getAsignacion().setTareaId(tarea);

        getAsignaDAO().actualizarAsignacionDesarrolloTarea(getAsignacion());
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
    public List<AsignacionDesarrolloTareaDTO> eliminar1() {

        getAsignaDAO().eliminarTodos();
        setImprimir(getAsignaDAO().encontrarTodos());
        return getImprimir();
    }

    public List<AsignacionDesarrolloTareaDTO> eliminar2(int emp) {

        getAsignaDAO().eliminarPorID(emp);
        setImprimir(getAsignaDAO().encontrarTodos());

        return getImprimir();
    }

    /**
     * @return the asignacion
     */
    public AsignacionDesarrolloTareaDTO getAsignacion() {
        return asignacion;
    }

    /**
     * @return the imprimir
     */
    public List<AsignacionDesarrolloTareaDTO> getImprimir() {
        return imprimir;
    }

    /**
     * @return the imprimir2
     */
    public AsignacionDesarrolloTareaDTO getImprimir2() {
        return imprimir2;
    }

    /**
     * @return the asignaDAO
     */
    public AsignacionDesarrolloTareaDAOImpl getAsignaDAO() {
        return asignaDAO;
    }

    /**
     * @return the leer
     */
    public Scanner getLeer() {
        return leer;
    }

    /**
     * @param asignacion the asignacion to set
     */
    public void setAsignacion(AsignacionDesarrolloTareaDTO asignacion) {
        this.asignacion = asignacion;
    }

    /**
     * @param imprimir the imprimir to set
     */
    public void setImprimir(List<AsignacionDesarrolloTareaDTO> imprimir) {
        this.imprimir = imprimir;
    }

    /**
     * @param imprimir2 the imprimir2 to set
     */
    public void setImprimir2(AsignacionDesarrolloTareaDTO imprimir2) {
        this.imprimir2 = imprimir2;
    }

    /**
     * @param asignaDAO the asignaDAO to set
     */
    public void setAsignaDAO(AsignacionDesarrolloTareaDAOImpl asignaDAO) {
        this.asignaDAO = asignaDAO;
    }

    /**
     * @param leer the leer to set
     */
    public void setLeer(Scanner leer) {
        this.leer = leer;
    }

}
