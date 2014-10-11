/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import java.util.Locale;
import javax.faces.context.FacesContext;
import javax.ws.rs.core.Response.StatusType;

/**
 *
 * @author brecht
 */
public class StatusManager {
    private FacesContext ctx = FacesContext.getCurrentInstance();
    private Locale locale;

    /** Creates a new instance of StatusManager */
    public StatusManager() {
        locale = ctx.getViewRoot().getLocale();
    }
    
    public String getLocalizedStatus(StatusType status) {
        return status.toString();
    }
}
