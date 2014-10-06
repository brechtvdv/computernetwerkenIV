/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import be.ugent.tiwi.immo.interfaces.IImmoKantoor;

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
    
    
    
    
    
}
