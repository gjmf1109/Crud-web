package com.dish.mx.dev.controller;

import com.dish.mx.dev.casos.CasosMenuAsignacionDesarrolloTarea;
import com.dish.mx.dev.casos.CasosMenuDesarrollador;
import com.dish.mx.dev.casos.CasosMenuProyecto;
import com.dish.mx.dev.casos.CasosMenuTarea;
import com.dish.mx.dev.component.EjemploComponent;
import com.dish.mx.dev.config.AppConfig;
import com.dish.mx.dev.dto.AsignacionDesarrolloTareaDTO;
import com.dish.mx.dev.dto.DesarrolladorDTO;
import com.dish.mx.dev.dto.ProyectoDTO;
import com.dish.mx.dev.dto.TareaDTO;
import com.dish.mx.dev.menu.Menu;
import com.dish.mx.dev.menu.Menu1;
import com.dish.mx.dev.menu.MenuId;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author gerardo.martinez
 */
@Controller
@RequestMapping("/menu")
public class MenuController {

    public static final String MENU_VIEW = "menu";
    public static final String RESULTADO_VIEW = "resultado";
    //Desarrollador
    public static final String DESARROLLADOR_VIEW = "desarrollador/menuDesarrollador";
    public static final String MUESTRA_OPCION1_DESARROLLADOR_VIEW = "desarrollador/desarrolladorMuestraOpcion1";
    public static final String MUESTRA_OPCION2_DESARROLLADOR_VIEW = "desarrollador/desarrolladorMuestraOpcion2";
    public static final String MUESTRA_TODO_DESARROLLADOR_VIEW = "desarrollador/desarrolladorMuestraTodo";
    public static final String MUESTRA_ID_DESARROLLADOR_VIEW = "desarrollador/desarrolladorMuestraId";
    public static final String INSERTA_DESARROLLADOR_VIEW = "desarrollador/desarrolladorInserta";
    public static final String ACTUALIZA_DESARROLLADOR_VIEW = "desarrollador/desarrolladorActualiza";
    public static final String ACTUALIZA_DESARROLLADOR1_VIEW = "desarrollador/desarrolladorActualiza1";
    public static final String ELIMINA_OPCION1_DESARROLLADOR_VIEW = "desarrollador/desarrolladorEliminaOpcion1";
    public static final String ELIMINA_OPCION2_DESARROLLADOR_VIEW = "desarrollador/desarrolladorEliminaOpcion2";
    //Tarea
    public static final String TAREA_VIEW = "tarea/menuTarea";
    public static final String MUESTRA_OPCION1_TAREA_VIEW = "tarea/tareaMuestraOpcion1";
    public static final String MUESTRA_OPCION2_TAREA_VIEW = "tarea/tareaMuestraOpcion2";
    public static final String MUESTRA_TODO_TAREA_VIEW = "tarea/tareaMuestraTodo";
    public static final String MUESTRA_ID_TAREA_VIEW = "tarea/tareaMuestraId";
    public static final String INSERTA_TAREA_VIEW = "tarea/tareaInserta";
    public static final String ACTUALIZA_TAREA_VIEW = "tarea/tareaActualiza";
    public static final String ACTUALIZA_TAREA1_VIEW = "tarea/tareaActualiza1";
    public static final String ELIMINA_OPCION1_TAREA_VIEW = "tarea/tareaEliminaOpcion1";
    public static final String ELIMINA_OPCION2_TAREA_VIEW = "tarea/tareaEliminaOpcion2";
    //Asignación
    public static final String ASIGNACION_VIEW = "asignacion/menuAsignacion";
    public static final String MUESTRA_OPCION1_ASIGNACION_VIEW = "asignacion/asignacionMuestraOpcion1";
    public static final String MUESTRA_OPCION2_ASIGNACION_VIEW = "asignacion/asignacionMuestraOpcion2";
    public static final String MUESTRA_TODO_ASIGNACION_VIEW = "asignacion/asignacionMuestraTodo";
    public static final String MUESTRA_ID_ASIGNACION_VIEW = "asignacion/asignacionMuestraId";
    public static final String INSERTA_ASIGNACION_VIEW = "asignacion/asignacionInserta";
    public static final String ACTUALIZA_ASIGNACION_VIEW = "asignacion/asignacionActualiza";
    public static final String ACTUALIZA_ASIGNACION1_VIEW = "asignacion/asignacionActualiza1";
    public static final String ELIMINA_OPCION1_ASIGNACION_VIEW = "asignacion/asignacionEliminaOpcion1";
    public static final String ELIMINA_OPCION2_ASIGNACION_VIEW = "asignacion/asignacionEliminaOpcion2";
    //Proyecto
    public static final String PROYECTO_VIEW = "proyecto/menuProyecto";
    public static final String INSERTA_PROYECTO_VIEW = "proyecto/proyectoInserta";
    public static final String MUESTRA_PROYECTO_VIEW = "proyecto/proyectoMuestra";
    public static final String MUESTRA_TODO_PROYECTO_VIEW = "proyecto/proyectoMuestraTodo";
    public static final String MUESTRA_OPCION1_PROYECTO_VIEW = "proyecto/proyectoMuestraOpcion1";
    public static final String MUESTRA_OPCION2_PROYECTO_VIEW = "proyecto/proyectoMuestraOpcion2";
    public static final String MUESTRA_ID_PROYECTO_VIEW = "proyecto/proyectoMuestraId";
    public static final String ACTUALIZA_PROYECTO_VIEW = "proyecto/proyectoActualiza";
    public static final String ACTUALIZA_PROYECTO1_VIEW = "proyecto/proyectoActualiza1";
    public static final String ELIMINA_OPCION1_PROYECTO_VIEW = "proyecto/proyectoEliminaOpcion1";
    public static final String ELIMINA_OPCION2_PROYECTO_VIEW = "proyecto/proyectoEliminaOpcion2";
    //Errores
    public static final String ERROR_VIEW = "error";
    public static final String ERROR1_VIEW = "error1";

    private int tempIdActualizarProyecto = -1;
    private int tempIdActualizarDesarrollador = -1;
    private int tempIdActualizarTarea = -1;
    private int tempIdActualizarAsignacion = -1;

    @Autowired
    @Qualifier("ejemploComponent")
    private EjemploComponent ejemploComponent;

    @GetMapping("/")
    public String redirect() {
        return "redirect:/menu/opcionMenu";
    }

    @GetMapping("/opcionMenu")
    public String opcionMenu(Model model) {
        model.addAttribute("eleccion", new Menu());
        return MENU_VIEW;
    }

    /* ----------------------------------- Tabla asignacion ------------------------------------ */
    @PostMapping("/opcionElegidaAsignacion")
    public ModelAndView elegidaAsignacion(@Valid @ModelAttribute("eleccion") Menu eleccion, BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView();
        if (bindingResult.hasErrors()) {
            mav.setViewName(ASIGNACION_VIEW);
        } else {
            switch (eleccion.getOpcion()) {

                case 1:
                    ejemploComponent.opcion();
                    mav.addObject("eleccion", new Menu1());
                    mav.setViewName(MUESTRA_OPCION1_ASIGNACION_VIEW);
                    break;
                case 2:
                    mav.addObject("asignacion", new AsignacionDesarrolloTareaDTO());
                    mav.setViewName(INSERTA_ASIGNACION_VIEW);
                    break;
                case 3:
                    mav.addObject("id", new MenuId());
                    mav.setViewName(ACTUALIZA_ASIGNACION_VIEW);
                    break;
                case 4:
                    mav.addObject("eleccion", new Menu1());
                    mav.setViewName(ELIMINA_OPCION1_ASIGNACION_VIEW);
                    break;
                case 5:
                    mav.addObject("eleccion", new Menu());
                    mav.setViewName(MENU_VIEW);
                    break;
                default:
                    break;
            }
        }
        return mav;
    }

    @PostMapping("/asignacionMuestraTodo")
    public ModelAndView muestraAsigancion(@Valid @ModelAttribute("eleccion") Menu1 eleccion, BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView();
        CasosMenuAsignacionDesarrolloTarea casosAsignacion;
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        casosAsignacion = ctx.getBean(CasosMenuAsignacionDesarrolloTarea.class);

        if (bindingResult.hasErrors()) {
            mav.setViewName(MUESTRA_OPCION1_ASIGNACION_VIEW);
        } else {
            switch (eleccion.getOpcion()) {
                case 1:
                    mav.addObject("asignacion", casosAsignacion.consultar1());
                    mav.setViewName(MUESTRA_TODO_ASIGNACION_VIEW);
                    break;
                case 2:
                    mav.addObject("eleccion1", new MenuId());
                    mav.setViewName(MUESTRA_OPCION2_ASIGNACION_VIEW);
                    break;
                default:
                    break;
            }
        }
        return mav;
    }

    @PostMapping("/asignacionMuestraId")
    public ModelAndView asignacionMuestraId(@Valid @ModelAttribute("eleccion1") MenuId eleccion1,
            BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView();
        CasosMenuAsignacionDesarrolloTarea casosAsignacion;
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        casosAsignacion = ctx.getBean(CasosMenuAsignacionDesarrolloTarea.class);

        if (bindingResult.hasErrors() || eleccion1.getOpcion() < 1) {
            mav.setViewName(MUESTRA_OPCION2_ASIGNACION_VIEW);
        } else {
            try {
                mav.addObject("asignacion", casosAsignacion.consultar2(eleccion1.getOpcion()));
                mav.setViewName(MUESTRA_ID_ASIGNACION_VIEW);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                mav.setViewName(ERROR_VIEW);
            }
        }
        return mav;
    }

    @PostMapping("/insertaAsignacion")
    public ModelAndView insertaDesarrollador(@Valid @ModelAttribute("asignacion") AsignacionDesarrolloTareaDTO asignacion,
            BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView();
        CasosMenuAsignacionDesarrolloTarea casosAsignacion;
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        casosAsignacion = ctx.getBean(CasosMenuAsignacionDesarrolloTarea.class);

        if (bindingResult.hasErrors()) {
            mav.setViewName(INSERTA_ASIGNACION_VIEW);
        } else {
            try {
                casosAsignacion.insertar(asignacion.getAsignacionId(), asignacion.getDesarrolladorId(), asignacion.getTareaId());
                mav.addObject("asignacion", casosAsignacion.consultar1());
                mav.setViewName(MUESTRA_TODO_ASIGNACION_VIEW);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                mav.setViewName(ERROR1_VIEW);
            }
        }
        return mav;
    }

    @PostMapping("/asignacionActualiza")
    public ModelAndView asignacionActualiza(@Valid @ModelAttribute("eleccion1") MenuId eleccion1,
            BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView();
        CasosMenuAsignacionDesarrolloTarea casosAsignacion;
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        casosAsignacion = ctx.getBean(CasosMenuAsignacionDesarrolloTarea.class);

        if (bindingResult.hasErrors() || eleccion1.getOpcion() < 1) {
            mav.setViewName(ACTUALIZA_ASIGNACION_VIEW);
        } else {
            try {
                tempIdActualizarAsignacion = eleccion1.getOpcion();
                mav.addObject("asignacion1", new AsignacionDesarrolloTareaDTO());
                mav.addObject("asignacion", casosAsignacion.consultar2(eleccion1.getOpcion()));
                mav.setViewName(ACTUALIZA_ASIGNACION1_VIEW);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                mav.setViewName(ERROR_VIEW);
            }
        }
        return mav;
    }

    @PostMapping("/actualizaAsignacion1")
    public ModelAndView actualizaAsignacion1(@Valid @ModelAttribute("asignacion") AsignacionDesarrolloTareaDTO asignacion,
            @ModelAttribute("asignacion1") AsignacionDesarrolloTareaDTO asignacion1,
            BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView();
        CasosMenuAsignacionDesarrolloTarea casosAsignacion;
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        casosAsignacion = ctx.getBean(CasosMenuAsignacionDesarrolloTarea.class);

        if (bindingResult.hasErrors()) {
            mav.setViewName(ACTUALIZA_ASIGNACION1_VIEW);
        } else {
            try {
                casosAsignacion.actualizar(tempIdActualizarAsignacion, asignacion1.getDesarrolladorId(),
                        asignacion1.getTareaId());
                mav.addObject("asignacion", casosAsignacion.consultar1());
                mav.setViewName(MUESTRA_TODO_ASIGNACION_VIEW);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                mav.setViewName(ERROR1_VIEW);
            }
        }
        return mav;
    }

    @PostMapping("/asignacionEliminaTodo")
    public ModelAndView eliminaAsigancion(@Valid @ModelAttribute("eleccion") Menu1 eleccion, BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView();
        CasosMenuAsignacionDesarrolloTarea casosAsignacion;
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        casosAsignacion = ctx.getBean(CasosMenuAsignacionDesarrolloTarea.class);

        if (bindingResult.hasErrors()) {
            mav.setViewName(ELIMINA_OPCION1_ASIGNACION_VIEW);
        } else {
            switch (eleccion.getOpcion()) {
                case 1:
                    mav.addObject("asignacion", casosAsignacion.eliminar1());
                    mav.setViewName(MUESTRA_TODO_ASIGNACION_VIEW);
                    break;
                case 2:
                    mav.addObject("eleccion1", new MenuId());
                    mav.setViewName(ELIMINA_OPCION2_ASIGNACION_VIEW);
                    break;
                default:
                    break;
            }
        }
        return mav;
    }

    @PostMapping("/asignacionEliminaId")
    public ModelAndView asignacionEliminaId(@Valid @ModelAttribute("eleccion1") MenuId eleccion1,
            BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView();
        CasosMenuAsignacionDesarrolloTarea casosAsignacion;
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        casosAsignacion = ctx.getBean(CasosMenuAsignacionDesarrolloTarea.class);

        if (bindingResult.hasErrors() || eleccion1.getOpcion() < 1) {
            mav.setViewName(ELIMINA_OPCION2_ASIGNACION_VIEW);
        } else {

            mav.addObject("asignacion", casosAsignacion.eliminar2(eleccion1.getOpcion()));
            mav.setViewName(MUESTRA_TODO_ASIGNACION_VIEW);
        }
        return mav;
    }

    /* ------------------------------------ Tabla Tarea ------------------------------------------------------- */
    @PostMapping("/opcionElegidaTarea")
    public ModelAndView opcionElegidaTarea(@Valid @ModelAttribute("eleccion") Menu eleccion, BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView();
        if (bindingResult.hasErrors()) {
            mav.setViewName(TAREA_VIEW);
        } else {
            switch (eleccion.getOpcion()) {

                case 1:
                    mav.addObject("eleccion", new Menu1());
                    mav.setViewName(MUESTRA_OPCION1_TAREA_VIEW);
                    break;
                case 2:
                    mav.addObject("tarea", new TareaDTO());
                    mav.setViewName(INSERTA_TAREA_VIEW);
                    break;
                case 3:
                    mav.addObject("id", new MenuId());
                    mav.setViewName(ACTUALIZA_TAREA_VIEW);
                    break;
                case 4:
                    mav.addObject("eleccion", new Menu1());
                    mav.setViewName(ELIMINA_OPCION1_TAREA_VIEW);
                    break;
                case 5:
                    mav.addObject("eleccion", new Menu());
                    mav.setViewName(MENU_VIEW);
                    break;
                default:
                    break;
            }
        }
        return mav;
    }

    @PostMapping("/tareaMuestraTodo")
    public ModelAndView muestraTarea(@Valid @ModelAttribute("eleccion") Menu1 eleccion, BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView();
        CasosMenuTarea casosTarea;
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        casosTarea = ctx.getBean(CasosMenuTarea.class);

        if (bindingResult.hasErrors()) {
            mav.setViewName(MUESTRA_OPCION1_TAREA_VIEW);
        } else {
            switch (eleccion.getOpcion()) {
                case 1:
                    mav.addObject("tarea", casosTarea.consultar1());
                    mav.setViewName(MUESTRA_TODO_TAREA_VIEW);
                    break;
                case 2:
                    //ejemploComponent.opcion();
                    mav.addObject("eleccion1", new MenuId());
                    mav.setViewName(MUESTRA_OPCION2_TAREA_VIEW);
                    break;
                default:
                    break;
            }
        }
        return mav;
    }

    @PostMapping("/tareaMuestraId")
    public ModelAndView tareaMuestraId(@Valid @ModelAttribute("eleccion1") MenuId eleccion1,
            BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView();
        CasosMenuTarea casosTarea;
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        casosTarea = ctx.getBean(CasosMenuTarea.class);

        if (bindingResult.hasErrors() || eleccion1.getOpcion() < 0) {
            mav.setViewName(MUESTRA_OPCION2_TAREA_VIEW);
        } else {
            try {
                mav.addObject("tarea", casosTarea.consultar2(eleccion1.getOpcion()));
                mav.setViewName(MUESTRA_ID_TAREA_VIEW);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                mav.setViewName(ERROR_VIEW);
            }
        }
        return mav;
    }

    @PostMapping("/tareaActualiza")
    public ModelAndView tareaActualiza(@Valid @ModelAttribute("eleccion1") MenuId eleccion1,
            BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView();
        CasosMenuTarea casosTarea;
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        casosTarea = ctx.getBean(CasosMenuTarea.class);

        if (bindingResult.hasErrors() || eleccion1.getOpcion() == 0) {
            mav.setViewName(ACTUALIZA_TAREA_VIEW);
        } else {
            try {
                tempIdActualizarTarea = eleccion1.getOpcion();
                mav.addObject("tarea1", new TareaDTO());
                mav.addObject("tarea", casosTarea.consultar2(eleccion1.getOpcion()));
                mav.setViewName(ACTUALIZA_TAREA1_VIEW);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                mav.setViewName(ERROR_VIEW);
            }
        }
        return mav;
    }

    @PostMapping("/insertaTarea")
    public ModelAndView insertaDesarrollador(@Valid @ModelAttribute("tarea") TareaDTO tarea,
            BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView();
        CasosMenuTarea casosTarea;
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        casosTarea = ctx.getBean(CasosMenuTarea.class);

        if (bindingResult.hasErrors()) {
            mav.setViewName(INSERTA_TAREA_VIEW);
        } else {
            try {
                casosTarea.insertar(tarea.getTareaId(), tarea.getNombreTarea(), tarea.getDescripcion(), tarea.getProyectoId());
                mav.addObject("tarea", casosTarea.consultar1());
                mav.setViewName(MUESTRA_TODO_TAREA_VIEW);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                mav.setViewName(ERROR1_VIEW);
            }
        }
        return mav;
    }

    @PostMapping("/actualizaTarea1")
    public ModelAndView actualizaTarea1(@Valid @ModelAttribute("tarea") TareaDTO tarea,
            @ModelAttribute("tarea1") TareaDTO tarea1,
            BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView();
        CasosMenuTarea casosTarea;
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        casosTarea = ctx.getBean(CasosMenuTarea.class);

        if (bindingResult.hasErrors()) {
            mav.setViewName(ACTUALIZA_TAREA1_VIEW);
        } else {
            try {
                casosTarea.actualizar(tempIdActualizarTarea, tarea1.getNombreTarea(), tarea1.getDescripcion(),
                        tarea1.getProyectoId());
                mav.addObject("tarea", casosTarea.consultar1());
                mav.setViewName(MUESTRA_TODO_TAREA_VIEW);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                mav.setViewName(ERROR1_VIEW);
            }
        }
        return mav;
    }

    @PostMapping("/tareaEliminaTodo")
    public ModelAndView eliminaTarea(@Valid @ModelAttribute("eleccion") Menu1 eleccion, BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView();
        CasosMenuTarea casosTarea;
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        casosTarea = ctx.getBean(CasosMenuTarea.class);

        if (bindingResult.hasErrors()) {
            mav.setViewName(ELIMINA_OPCION1_TAREA_VIEW);
        } else {
            switch (eleccion.getOpcion()) {
                case 1:
                    mav.addObject("tarea", casosTarea.eliminar1());
                    mav.setViewName(MUESTRA_TODO_TAREA_VIEW);
                    break;
                case 2:
                    mav.addObject("eleccion1", new MenuId());
                    mav.setViewName(ELIMINA_OPCION2_TAREA_VIEW);
                    break;
                default:
                    break;
            }
        }
        return mav;
    }

    @PostMapping("/tareaEliminaId")
    public ModelAndView tareaEliminaId(@Valid @ModelAttribute("eleccion1") MenuId eleccion1,
            BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView();
        CasosMenuTarea casosTarea;
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        casosTarea = ctx.getBean(CasosMenuTarea.class);

        if (bindingResult.hasErrors() || eleccion1.getOpcion() < 1) {
            mav.setViewName(ELIMINA_OPCION2_TAREA_VIEW);
        } else {
            mav.addObject("tarea", casosTarea.eliminar2(eleccion1.getOpcion()));
            mav.setViewName(MUESTRA_TODO_TAREA_VIEW);
        }
        return mav;
    }

    /* ---------------------------------- Tabla Desarrollador ------------------------------------------------ */
    @PostMapping("/opcionElegidaDesarrollador")
    public ModelAndView opcionElegidaDesarrollador(@Valid @ModelAttribute("eleccion") Menu eleccion, BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView();
        if (bindingResult.hasErrors()) {
            mav.setViewName(DESARROLLADOR_VIEW);
        } else {
            switch (eleccion.getOpcion()) {

                case 1:
                    mav.addObject("eleccion", new Menu1());
                    mav.setViewName(MUESTRA_OPCION1_DESARROLLADOR_VIEW);
//                    mav.addObject("muestra", new ProyectoDTO());
//                    mav.setViewName(MUESTRA_PROYECTO_VIEW);
                    break;
                case 2:
                    mav.addObject("desa", new DesarrolladorDTO());
                    mav.setViewName(INSERTA_DESARROLLADOR_VIEW);
                    break;
                case 3:
                    mav.addObject("id", new MenuId());
                    mav.setViewName(ACTUALIZA_DESARROLLADOR_VIEW);
                    break;
                case 4:
                    mav.addObject("eleccion", new Menu1());
                    mav.setViewName(ELIMINA_OPCION1_DESARROLLADOR_VIEW);
                    break;
                case 5:
                    mav.addObject("eleccion", new Menu());
                    mav.setViewName(MENU_VIEW);
                    break;
                default:
                    break;
            }
        }
        return mav;
    }

    @PostMapping("/desarrolladorMuestraTodo")
    public ModelAndView muestraDesaroolador(@Valid @ModelAttribute("eleccion") Menu1 eleccion, BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView();
        CasosMenuDesarrollador casosDesarrollador;
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        casosDesarrollador = ctx.getBean(CasosMenuDesarrollador.class);

        if (bindingResult.hasErrors()) {
            mav.setViewName(MUESTRA_OPCION1_DESARROLLADOR_VIEW);
        } else {
            switch (eleccion.getOpcion()) {
                case 1:
                    mav.addObject("desarrollador", casosDesarrollador.consultar1());
                    mav.setViewName(MUESTRA_TODO_DESARROLLADOR_VIEW);
//                    mav.setViewName(RESULTADO_VIEW);
                    break;
                case 2:
                    //ejemploComponent.opcion();
                    mav.addObject("eleccion1", new MenuId());
                    mav.setViewName(MUESTRA_OPCION2_DESARROLLADOR_VIEW);
                    break;
                default:
                    break;
            }
        }
        return mav;
    }

    @PostMapping("/desarrolladorMuestraId")
    public ModelAndView desarrolladorMuestraId(@Valid @ModelAttribute("eleccion1") MenuId eleccion1,
            BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView();
        CasosMenuDesarrollador casosDesarrollador;
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        casosDesarrollador = ctx.getBean(CasosMenuDesarrollador.class);

        if (bindingResult.hasErrors() || eleccion1.getOpcion() < 0) {
            mav.setViewName(MUESTRA_OPCION2_DESARROLLADOR_VIEW);
        } else {
            try {
                mav.addObject("desarrollador", casosDesarrollador.consultar2(eleccion1.getOpcion()));
                mav.setViewName(MUESTRA_ID_DESARROLLADOR_VIEW);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                mav.setViewName(ERROR_VIEW);
            }
        }
        return mav;
    }

    @PostMapping("/insertaDesarrollador")
    public ModelAndView insertaDesarrollador(@Valid @ModelAttribute("desa") DesarrolladorDTO desarrollador,
            BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView();
        CasosMenuDesarrollador casosDesarrollador;
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        casosDesarrollador = ctx.getBean(CasosMenuDesarrollador.class);

        if (bindingResult.hasErrors()) {
            mav.setViewName(INSERTA_DESARROLLADOR_VIEW);
        } else {
            try {
                casosDesarrollador.insertar(desarrollador.getDesarrolladorId(), desarrollador.getNumEmpleado(),
                        desarrollador.getNombre(), desarrollador.getApPaterno(), desarrollador.getApMaterno());
                mav.addObject("desarrollador", casosDesarrollador.consultar1());
                mav.setViewName(MUESTRA_TODO_DESARROLLADOR_VIEW);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                mav.setViewName(ERROR1_VIEW);
            }
        }
        return mav;
    }

    @PostMapping("/desarrolladorActualiza")
    public ModelAndView desarrolladorActualiza(@Valid @ModelAttribute("eleccion1") MenuId eleccion1,
            BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView();
        CasosMenuDesarrollador casosDesarrollador;
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        casosDesarrollador = ctx.getBean(CasosMenuDesarrollador.class);

        if (bindingResult.hasErrors() || eleccion1.getOpcion() == 0) {
            mav.setViewName(ACTUALIZA_DESARROLLADOR_VIEW);
        } else {
            try {
                tempIdActualizarDesarrollador = eleccion1.getOpcion();
                mav.addObject("desa1", new DesarrolladorDTO());
                mav.addObject("desarrollador", casosDesarrollador.consultar2(eleccion1.getOpcion()));
                mav.setViewName(ACTUALIZA_DESARROLLADOR1_VIEW);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                mav.setViewName(ERROR_VIEW);
            }
        }
        return mav;
    }

    @PostMapping("/actualizaDesarrollador1")
    public ModelAndView actualizaDesarrollador1(@Valid @ModelAttribute("desarrollador") DesarrolladorDTO desarrollador,
            @ModelAttribute("desa1") DesarrolladorDTO desa1,
            BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView();
        CasosMenuDesarrollador casosDesarrollador;
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        casosDesarrollador = ctx.getBean(CasosMenuDesarrollador.class);

        if (bindingResult.hasErrors()) {
            mav.setViewName(ACTUALIZA_DESARROLLADOR1_VIEW);
        } else {
            try {
                casosDesarrollador.actualizar(tempIdActualizarDesarrollador, desa1.getNumEmpleado(), desa1.getNombre(),
                        desa1.getApPaterno(), desa1.getApMaterno());
                mav.addObject("desarrollador", casosDesarrollador.consultar1());
                mav.setViewName(MUESTRA_TODO_DESARROLLADOR_VIEW);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                mav.setViewName(ERROR1_VIEW);
            }
        }
        return mav;
    }

    @PostMapping("/desarrolladorEliminaTodo")
    public ModelAndView eliminaDesarrollador(@Valid @ModelAttribute("eleccion") Menu1 eleccion, BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView();
        CasosMenuDesarrollador casosDesarrollador;
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        casosDesarrollador = ctx.getBean(CasosMenuDesarrollador.class);

        if (bindingResult.hasErrors()) {
            mav.setViewName(ELIMINA_OPCION1_DESARROLLADOR_VIEW);
        } else {
            switch (eleccion.getOpcion()) {
                case 1:
                    mav.addObject("desarrollador", casosDesarrollador.eliminar1());
                    mav.setViewName(MUESTRA_TODO_DESARROLLADOR_VIEW);
                    break;
                case 2:
                    mav.addObject("eleccion1", new MenuId());
                    mav.setViewName(ELIMINA_OPCION2_DESARROLLADOR_VIEW);
                    break;
                default:
                    break;
            }
        }
        return mav;
    }

    @PostMapping("/desarrolladorEliminaId")
    public ModelAndView desarrolladorEliminaId(@Valid @ModelAttribute("eleccion1") MenuId eleccion1,
            BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView();
        CasosMenuDesarrollador casosDesarrollador;
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        casosDesarrollador = ctx.getBean(CasosMenuDesarrollador.class);

        if (bindingResult.hasErrors() || eleccion1.getOpcion() < 1) {
            mav.setViewName(ELIMINA_OPCION2_DESARROLLADOR_VIEW);
        } else {
            mav.addObject("desarrollador", casosDesarrollador.eliminar2(eleccion1.getOpcion()));
            mav.setViewName(MUESTRA_TODO_DESARROLLADOR_VIEW);
        }
        return mav;
    }

    /* ---------------------------------- Tabla Proyecto ------------------------------------------------ */
    @PostMapping("/opcionElegidaProyecto")
    public ModelAndView opcionElegidaProyecto(@Valid @ModelAttribute("eleccion") Menu eleccion, BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView();
        if (bindingResult.hasErrors()) {
            mav.setViewName(PROYECTO_VIEW);
        } else {
            switch (eleccion.getOpcion()) {

                case 1:
                    mav.addObject("eleccion", new Menu1());
                    mav.setViewName(MUESTRA_OPCION1_PROYECTO_VIEW);
//                    mav.addObject("muestra", new ProyectoDTO());
//                    mav.setViewName(MUESTRA_PROYECTO_VIEW);
                    break;
                case 2:
                    mav.addObject("proyecto", new ProyectoDTO());
                    mav.setViewName(INSERTA_PROYECTO_VIEW);
                    break;
                case 3:
                    mav.addObject("id", new MenuId());
                    mav.setViewName(ACTUALIZA_PROYECTO_VIEW);
                    break;
                case 4:
                    mav.addObject("eleccion", new Menu1());
                    mav.setViewName(ELIMINA_OPCION1_PROYECTO_VIEW);
                    break;
                case 5:
                    mav.addObject("eleccion", new Menu());
                    mav.setViewName(MENU_VIEW);
                    break;
                default:
                    break;
            }
        }
        return mav;
    }

    @PostMapping("/proyectoMuestraTodo")
    public ModelAndView muestraProyecto(@Valid @ModelAttribute("eleccion") Menu1 eleccion, BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView();
        CasosMenuProyecto casosProyecto;

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        casosProyecto = ctx.getBean(CasosMenuProyecto.class);

        if (bindingResult.hasErrors()) {
            mav.setViewName(MUESTRA_OPCION1_PROYECTO_VIEW);
        } else {
            switch (eleccion.getOpcion()) {
                case 1:
                    mav.addObject("proyecto", casosProyecto.consultar1());
                    mav.setViewName(MUESTRA_TODO_PROYECTO_VIEW);
                    break;
                case 2:
                    mav.addObject("eleccion1", new MenuId());
                    mav.setViewName(MUESTRA_OPCION2_PROYECTO_VIEW);
                    break;
                default:
                    break;
            }
        }
        return mav;
    }

    @PostMapping("/proyectoMuestraId")
    public ModelAndView proyectoMuestraId(@Valid @ModelAttribute("eleccion1") MenuId eleccion1,
            BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView();
        CasosMenuProyecto casosProyecto;
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        casosProyecto = ctx.getBean(CasosMenuProyecto.class);

        if (bindingResult.hasErrors() || eleccion1.getOpcion() < 0) {
            mav.setViewName(MUESTRA_OPCION2_PROYECTO_VIEW);
        } else {
            try {
                mav.addObject("proyecto", casosProyecto.consultar2(eleccion1.getOpcion()));
                mav.setViewName(MUESTRA_ID_PROYECTO_VIEW);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                mav.setViewName(ERROR_VIEW);
            }
        }
        return mav;
    }

    @PostMapping("/insertaProyecto")
    public ModelAndView insertaProyecto(@Valid @ModelAttribute("proyecto") ProyectoDTO proyecto,
            BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView();
        CasosMenuProyecto casosProyecto;
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        casosProyecto = ctx.getBean(CasosMenuProyecto.class);

        if (bindingResult.hasErrors()) {
            mav.setViewName(INSERTA_PROYECTO_VIEW);
        } else {
            try {
                casosProyecto.insertar(proyecto.getProyectoId(), proyecto.getNombreProyecto(), proyecto.getDescripcion(),
                        proyecto.getFechaInicio(), proyecto.getFechaFin());
                mav.addObject("proyecto", casosProyecto.consultar1());
                mav.setViewName(MUESTRA_TODO_PROYECTO_VIEW);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                mav.setViewName(ERROR1_VIEW);
            }
        }
        return mav;
    }

    @PostMapping("/proyectoActualiza")
    public ModelAndView proyectoActualiza(@Valid @ModelAttribute("eleccion1") MenuId eleccion1,
            BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView();
        CasosMenuProyecto casosProyecto;
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        casosProyecto = ctx.getBean(CasosMenuProyecto.class);

        if (bindingResult.hasErrors() || eleccion1.getOpcion() == 0) {
            mav.setViewName(ACTUALIZA_PROYECTO_VIEW);
        } else {
            try {
                tempIdActualizarProyecto = eleccion1.getOpcion();
                mav.addObject("proyecto1", new ProyectoDTO());
                mav.addObject("proyecto", casosProyecto.consultar2(eleccion1.getOpcion()));
                mav.setViewName(ACTUALIZA_PROYECTO1_VIEW);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                mav.setViewName(ERROR_VIEW);
            }
        }
        return mav;
    }

    @PostMapping("/actualizaProyecto1")
    public ModelAndView actualizaProyecto1(@Valid @ModelAttribute("proyecto") ProyectoDTO proyecto,
            @ModelAttribute("proyecto1") ProyectoDTO proyecto1,
            BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView();
        CasosMenuProyecto casosProyecto;
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        casosProyecto = ctx.getBean(CasosMenuProyecto.class);

        if (bindingResult.hasErrors()) {
            mav.setViewName(ACTUALIZA_PROYECTO1_VIEW);
        } else {
            try {
                casosProyecto.actualizar(tempIdActualizarProyecto, proyecto1.getNombreProyecto(), proyecto1.getDescripcion(),
                        proyecto1.getFechaInicio(), proyecto1.getFechaFin());
                mav.addObject("proyecto", casosProyecto.consultar1());
                mav.setViewName(MUESTRA_TODO_PROYECTO_VIEW);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                mav.setViewName(ERROR1_VIEW);
            }
        }
        return mav;
    }

    @PostMapping("/proyectoEliminaTodo")
    public ModelAndView eliminaProyecto(@Valid @ModelAttribute("eleccion") Menu1 eleccion, BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView();
        CasosMenuProyecto casosProyecto;
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        casosProyecto = ctx.getBean(CasosMenuProyecto.class);

        if (bindingResult.hasErrors()) {
            mav.setViewName(ELIMINA_OPCION1_PROYECTO_VIEW);
        } else {
            switch (eleccion.getOpcion()) {
                case 1:
                    mav.addObject("proyecto", casosProyecto.eliminar1());
                    mav.setViewName(MUESTRA_TODO_PROYECTO_VIEW);
                    break;
                case 2:
                    mav.addObject("eleccion1", new MenuId());
                    mav.setViewName(ELIMINA_OPCION2_PROYECTO_VIEW);
                    break;
                default:
                    break;
            }
        }
        return mav;
    }

    @PostMapping("/proyectoEliminaId")
    public ModelAndView proyectoEliminaId(@Valid @ModelAttribute("eleccion1") MenuId eleccion1,
            BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView();
        CasosMenuProyecto casosProyecto;
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        casosProyecto = ctx.getBean(CasosMenuProyecto.class);

        if (bindingResult.hasErrors() || eleccion1.getOpcion() < 1) {
            mav.setViewName(ELIMINA_OPCION2_PROYECTO_VIEW);
        } else {
            mav.addObject("proyecto", casosProyecto.eliminar2(eleccion1.getOpcion()));
            mav.setViewName(MUESTRA_TODO_PROYECTO_VIEW);
        }
        return mav;
    }

    /* ------------------------------------- Menu principal --------------------------------------------- */
    //BindingResult lo utiliza spring para verificar los campos
    @PostMapping("/opcionElegida")
    public ModelAndView opcionElegida(@Valid @ModelAttribute("eleccion") Menu eleccion, BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView();
        if (bindingResult.hasErrors()) {
            mav.setViewName(MENU_VIEW);
        } else {
            switch (eleccion.getOpcion()) {
                case 1:
                    ejemploComponent.opcion();
                    mav.setViewName(ASIGNACION_VIEW);
                    break;
                case 2:
                    mav.setViewName(TAREA_VIEW);
                    break;
                case 3:
                    mav.setViewName(DESARROLLADOR_VIEW);
                    break;
                case 4:
                    mav.setViewName(PROYECTO_VIEW);
                    break;
                case 5:
                    mav.setViewName(MENU_VIEW);
                    break;
                default:
                    break;
            }
        }
        return mav;
    }

}
