package com.dish.mx.dev.casos;

import com.dish.mx.dev.daoimpl.AsignacionDesarrolloTareaDAOImpl;
import com.dish.mx.dev.daoimpl.DesarrolladorDAOImpl;
import com.dish.mx.dev.daoimpl.ProyectoDAOImpl;
import com.dish.mx.dev.daoimpl.TareaDAOImpl;
import com.dish.mx.dev.dto.ProyectoDTO;
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
public class CasosMenuProyecto {

    private ProyectoDTO proyecto;
    private List<ProyectoDTO> imprimir;
    private ProyectoDTO imprimir2;

    @Autowired
    @Qualifier("proyectoDAOImpl")
    private ProyectoDAOImpl proyDAO;

    @Autowired
    @Qualifier("asignacionDesarrolloTareaDAOImpl")
    private AsignacionDesarrolloTareaDAOImpl asignaDAO;

    @Autowired
    @Qualifier("tareaDAOImpl")
    private TareaDAOImpl tareaDAO;

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
    public CasosMenuProyecto() {
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
    public List<ProyectoDTO> consultar1() {

        setImprimir(getProyDAO().encontrarTodos());
        return getImprimir();
    }

    public ProyectoDTO consultar2(int id) {

        setImprimir2(getProyDAO().encontrarPorId(id));
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
    public void insertar(int proyNum, String nomProy, String des, String fechIni, String fechFin) {
        ProyectoDTO proyInsertar;
        proyInsertar = new ProyectoDTO();
        int x = 0;
        int y = 0;

        do {
            x = 0;
            String[] separa = fechIni.split("-");
            int anio = Integer.parseInt(separa[0]);
            int mes = Integer.parseInt(separa[1]);
            int dia = Integer.parseInt(separa[2]);
            if (anio < 2030 && anio > 1990 && mes < 13 && mes > 0 && dia < 32 && dia > 0) {
                proyInsertar.setFechaInicio(fechIni);
                x = 1;
            } else {
                System.out.println("Formato incorrecto, ingresa de nuevo la fecha");
                x = 0;
            }
        } while (x == 0);

        do {
            y = 0;
            String[] separa1 = fechFin.split("-");
            int anio1 = Integer.parseInt(separa1[0]);
            int mes1 = Integer.parseInt(separa1[1]);
            int dia1 = Integer.parseInt(separa1[2]);
            if (anio1 < 2030 && anio1 > 1990 && mes1 < 13 && mes1 > 0 && dia1 < 32 && dia1 > 0) {
                proyInsertar.setFechaFin(fechFin);
                y = 1;
            } else {
                System.out.println("Formato incorrecto, ingresa de nuevo la fecha");
                y = 0;
            }
        } while (y == 0);

        proyInsertar.setProyectoId(proyNum);
        proyInsertar.setNombreProyecto(nomProy);
        proyInsertar.setDescripcion(des);
        getProyDAO().insertarProyecto(proyInsertar);

    }

    /**
     * Método en el que se le piden al usuario datos para actualizar todos o
     * algunos campos del registro.
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     *
     * @since 0.0.1
     */
    public void actualizar(int numProy, String proyNom, String descripcion, String fechIni, String fechFin) {
        int z = 0;
        int w = 0;

        setProyecto(getProyDAO().encontrarPorId(numProy));
        getProyecto().setNombreProyecto(proyNom);
        getProyecto().setDescripcion(descripcion);

        do {
            z = 0;
            String[] separa2 = fechIni.split("-");
            int anio = Integer.parseInt(separa2[0]);
            int mes = Integer.parseInt(separa2[1]);
            int dia = Integer.parseInt(separa2[2]);
            if (anio < 2020 && anio > 1990 && mes < 13 && mes > 0 && dia < 32 && dia > 0) {
                getProyecto().setFechaInicio(fechIni);
                z = 1;
            } else {
                System.out.println("Formato incorrecto, ingresa de nuevo la fecha");
                z = 0;
            }
        } while (z == 0);

        do {
            w = 0;
            String[] separa3 = fechFin.split("-");
            int anio1 = Integer.parseInt(separa3[0]);
            int mes1 = Integer.parseInt(separa3[1]);
            int dia1 = Integer.parseInt(separa3[2]);
            if (anio1 < 2020 && anio1 > 1990 && mes1 < 13 && mes1 > 0 && dia1 < 32 && dia1 > 0) {
                getProyecto().setFechaFin(fechFin);
                w = 1;
            } else {
                System.out.println("Formato incorrecto, ingresa de nuevo la fecha");
                w = 0;
            }
        } while (w == 0);

        getProyDAO().actualizarProyecto(getProyecto());

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
    public List<ProyectoDTO> eliminar1() {

        getAsignaDAO().eliminarTodos();
        getTareaDAO().eliminarTodos();
        getProyDAO().eliminarTodos();

        setImprimir(getProyDAO().encontrarTodos());
        return getImprimir();
    }

    public List<ProyectoDTO> eliminar2(int proy) {

        getProyDAO().eliminarPorID2(proy);
        getProyDAO().eliminarPorID3(proy);
        getProyDAO().eliminarPorID(proy);

        setImprimir(getProyDAO().encontrarTodos());
        return getImprimir();
    }

    /**
     * @return the proyecto
     */
    public ProyectoDTO getProyecto() {
        return proyecto;
    }

    /**
     * @return the imprimir
     */
    public List<ProyectoDTO> getImprimir() {
        return imprimir;
    }

    /**
     * @return the imprimir2
     */
    public ProyectoDTO getImprimir2() {
        return imprimir2;
    }

    /**
     * @return the proyDAO
     */
    public ProyectoDAOImpl getProyDAO() {
        return proyDAO;
    }

    /**
     * @return the leer
     */
    public Scanner getLeer() {
        return leer;
    }

    /**
     * @param proyecto the proyecto to set
     */
    public void setProyecto(ProyectoDTO proyecto) {
        this.proyecto = proyecto;
    }

    /**
     * @param imprimir the imprimir to set
     */
    public void setImprimir(List<ProyectoDTO> imprimir) {
        this.imprimir = imprimir;
    }

    /**
     * @param imprimir2 the imprimir2 to set
     */
    public void setImprimir2(ProyectoDTO imprimir2) {
        this.imprimir2 = imprimir2;
    }

    /**
     * @param proyDAO the proyDAO to set
     */
    public void setProyDAO(ProyectoDAOImpl proyDAO) {
        this.proyDAO = proyDAO;
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

    /**
     * @return the tareaDAO
     */
    public TareaDAOImpl getTareaDAO() {
        return tareaDAO;
    }

    /**
     * @param tareaDAO the tareaDAO to set
     */
    public void setTareaDAO(TareaDAOImpl tareaDAO) {
        this.tareaDAO = tareaDAO;
    }

    /**
     * @return the desaDAO
     */
    public DesarrolladorDAOImpl getDesaDAO() {
        return desaDAO;
    }

    /**
     * @param desaDAO the desaDAO to set
     */
    public void setDesaDAO(DesarrolladorDAOImpl desaDAO) {
        this.desaDAO = desaDAO;
    }

}
