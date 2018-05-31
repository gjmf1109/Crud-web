package com.dish.mx.dev.menu;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author gerardo.martinez
 */
public class Menu1 {
    
    @NotNull
    @Min(1)
    @Max(2)
    private int opcion;
    
    public Menu1(){
    }

    public Menu1(int opcion) {
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

