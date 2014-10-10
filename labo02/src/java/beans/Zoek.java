/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import be.ugent.tiwi.immo.interfaces.IImmoKantoor;
import be.ugent.tiwi.immo.interfaces.IPand;
import be.ugent.tiwi.immo.interfaces.ImmoException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author brecht
 */
public class Zoek {
    private int type;
    private double min;
    private double max;
    private IImmoKantoor immoKantoor;
    private boolean gevonden;
    List<IPand> panden;

    public Zoek() {
        this.type = 0;
        this.min = 0.0;
        this.max = 0.0;
        this.gevonden = false;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public IImmoKantoor getImmoKantoor() {
        return immoKantoor;
    }

    public void setImmoKantoor(IImmoKantoor immoKantoor) {
        this.immoKantoor = immoKantoor;
    }

    public boolean isGevonden() {
        return gevonden;
    }

    public void setGevonden(boolean gevonden) {
        this.gevonden = gevonden;
    }
    
    public List<IPand> getPanden() {
        return panden;
    }

    public void setPanden(List<IPand> panden) {
        this.panden = panden;
    }

    
    public String zoek() {
        String res = "nietGevonden";
        try {
            panden = immoKantoor.getPanden(getType(), getMin(), getMax());
            if(!panden.isEmpty()) res = "gevonden";
        } catch (ImmoException ex) {
            Logger.getLogger(Zoek.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return res;
    }
    
    
    
    
}
