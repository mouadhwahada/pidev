/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author MSADDAK
 */
public class TypeBonPlan {
    private Integer idTypeBonPlan;
    private String locationBonPlan;
    private String travelStyle;

    public TypeBonPlan() {
    }
    
    public TypeBonPlan(String locationBonPlan, String travelStyle) {
        this.locationBonPlan = locationBonPlan;
        this.travelStyle = travelStyle;
    }
    
    public TypeBonPlan(int idTypeBonPlan, String locationBonPlan, String travelStyle) {
        this.idTypeBonPlan = idTypeBonPlan;
        this.locationBonPlan = locationBonPlan;
        this.travelStyle = travelStyle;
    }

    public int getIdTypeBonPlan() {
        return idTypeBonPlan;
    }

    public String getLocationBonPlan() {
        return locationBonPlan;
    }

    public String getTravelStyle() {
        return travelStyle;
    }

    public void setIdTypeBonPlan(int idTypeBonPlan) {
        this.idTypeBonPlan = idTypeBonPlan;
    }

    public void setLocationBonPlan(String locationBonPlan) {
        this.locationBonPlan = locationBonPlan;
    }

    public void setTravelStyle(String travelStyle) {
        this.travelStyle = travelStyle;
    }

    @Override
    public String toString() {
        return "TypeBonPlan{" + "idTypeBonPlan=" + idTypeBonPlan + ", locationBonPlan=" + locationBonPlan + ", travelStyle=" + travelStyle + '}';
    }
    
    
   
    
}
