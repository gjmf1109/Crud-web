package com.dish.mx.dev.menu;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author gerardo.martinez
 */
public class MenuId {

//    @NotNull
//    @Min(1)
//    @Max(1000)
    private int opcion;
    
    public MenuId(){
    }

    public MenuId(int opcion) {
        this.opcion = opcion;
    }

    /**
     * @return the opcion
     */
    public int getOpcion() {
        return opcion;
    }

    /**
     * @param opcion the opcion to set
     */
    public void setOpcion(int opcion) {
        this.opcion = opcion;
    }
    
}
