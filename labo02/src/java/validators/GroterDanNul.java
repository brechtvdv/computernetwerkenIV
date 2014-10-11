/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author brecht
 */
@FacesValidator("validators.GroterDanNul")
public class GroterDanNul implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {        
        if (value.equals(0.0)) {
            FacesMessage msg = new FacesMessage("Maximum moet groter dan nul zijn");
            throw new ValidatorException(msg);
        }
    }
    
}
