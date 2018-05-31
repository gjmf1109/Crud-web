package com.dish.mx.dev.casos;

import com.dish.mx.dev.daoimpl.AsignacionDesarrolloTareaDAOImpl;
import com.dish.mx.dev.daoimpl.DesarrolladorDAOImpl;
import com.dish.mx.dev.dto.DesarrolladorDTO;
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
public class CasosMenuDesarrollador {

    private DesarrolladorDTO desa;
    private List<DesarrolladorDTO> imprimir;
    private DesarrolladorDTO imprimir2;

    @Autowired
    @Qualifier("asignacionDesarrolloTareaDAOImpl")
    private AsignacionDesarrolloTareaDAOImpl asignaDAO;

    @Autowired
    @Qualifier("desarrolladorDAOImpl")
    private DesarrolladorDAOImpl desaDAO;

    private Scanner leer = new Scanner(System.in);

    /**
     * Constructor vacío de la clase
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     *
     * @since 0.0.1
     */
    public CasosMenuDesarrollador() {
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
    public List<DesarrolladorDTO> consultar1() {

        setImprimir(getDesaDAO().encontrarTodos());
        return getImprimir();
    }

    public DesarrolladorDTO consultar2(int id) {

        setImprimir2(getDesaDAO().encontrarPorId(id));
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
    public void insertar(int desaNum, int numEmp, String nom, String apPat, String apMat) {
        DesarrolladorDTO desaInsertar;
        desaInsertar = new DesarrolladorDTO();

        desaInsertar.setDesarrolladorId(desaNum);
        desaInsertar.setNumEmpleado(numEmp);
        desaInsertar.setNombre(nom);
        desaInsertar.setApPaterno(apPat);
        desaInsertar.setApMaterno(apMat);
        getDesaDAO().insertarDesarrollador(desaInsertar);

    }

    /**
     * Método en el que se le piden al usuario datos para actualizar todos o
     * algunos campos del registro.
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     *
     * @since 0.0.1
     */
    public void actualizar(int numDesa, int numEmp, String nom, String apPat, String apMat) {

        setDesa(getDesaDAO().encontrarPorId(numDesa));
        getDesa().setNumEmpleado(numEmp);
        getDesa().setNombre(nom);
        getDesa().setApPaterno(apPat);
        getDesa().setApMaterno(apMat);

        getDesaDAO().actualizarDesarrollador(getDesa());

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
    public List<DesarrolladorDTO> eliminar1() {

        getAsignaDAO().eliminarTodos();
        getDesaDAO().eliminarTodos();
        setImprimir(getDesaDAO().encontrarTodos());
        return getImprimir();
    }

    public List<DesarrolladorDTO> eliminar2(int desa1) {

        getAsignaDAO().eliminarPorID2(desa1);
        getDesaDAO().eliminarPorID(desa1);
        setImprimir(getDesaDAO().encontrarTodos());
        return getImprimir();
    }

    /**
     * @return the desa
     */
    public DesarrolladorDTO getDesa() {
        return desa;
    }

    /**
     * @return the imprimir
     */
    public List<DesarrolladorDTO> getImprimir() {
        return imprimir;
    }

    /**
     * @return the imprimir2
     */
    public DesarrolladorDTO getImprimir2() {
        return imprimir2;
    }

    /**
     * @return the desaDAO
     */
    public DesarrolladorDAOImpl getDesaDAO() {
        return desaDAO;
    }

    /**
     * @return the leer
     */
    public Scanner getLeer() {
        return leer;
    }

    /**
     * @param desa the desa to set
     */
    public void setDesa(DesarrolladorDTO desa) {
        this.desa = desa;
    }

    /**
     * @param imprimir the imprimir to set
     */
    public void setImprimir(List<DesarrolladorDTO> imprimir) {
        this.imprimir = imprimir;
    }

    /**
     * @param imprimir2 the imprimir2 to set
     */
    public void setImprimir2(DesarrolladorDTO imprimir2) {
        this.imprimir2 = imprimir2;
    }

    /**
     * @param desaDAO the desaDAO to set
     */
    public void setDesaDAO(DesarrolladorDAOImpl desaDAO) {
        this.desaDAO = desaDAO;
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
