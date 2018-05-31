package com.dish.mx.dev.component;

import com.dish.mx.dev.menu.Menu;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 *
 * @author gerardo.martinez
 */
@Component("ejemploComponent")
public class EjemploComponent {
    
    private static final Log LOG = LogFactory.getLog(EjemploComponent.class);
    
    public void opcion(){
        Menu menu = new Menu();
        LOG.info("La opcion elegida fue: ");
    }
}
