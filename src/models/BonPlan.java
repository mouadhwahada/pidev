/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;

/**
 *
 * @author MSADDAK
 */
public class BonPlan {
    private Integer idBonPlan;
    private String nameBonPlan;
    private Float rating;
    private Date startDate;
    private Date endDate;
    private Float avgPrice; 
    private Integer fk_idTypeBonPlan;
    
     public BonPlan() {
    }

    public BonPlan(Integer idBonPlan, String nameBonPlan, Float rating, Date startDate, Date endDate, Float avgPrice, Integer fk_idTypeBonPlan) {
        this.idBonPlan = idBonPlan;
        this.nameBonPlan = nameBonPlan;
        this.rating = rating;
        this.startDate = startDate;
        this.endDate = endDate;
        this.avgPrice = avgPrice;
        this.fk_idTypeBonPlan = fk_idTypeBonPlan;
    }

    public BonPlan(String nameBonPlan, Float rating, Date startDate, Date endDate, Float avgPrice, Integer fk_idTypeBonPlan) {
        this.nameBonPlan = nameBonPlan;
        this.rating = rating;
        this.startDate = startDate;
        this.endDate = endDate;
        this.avgPrice = avgPrice;
        this.fk_idTypeBonPlan = fk_idTypeBonPlan;
    }



    public BonPlan(String nameBonPlan, Float rating, Date startDate, Date endingDate, Float avgPrice) {
        this.nameBonPlan=nameBonPlan;
        this.rating=rating;
        this.startDate=startDate;
        this.endDate=endingDate;
        this.avgPrice=avgPrice;
    }




    public int getIdBonPlan() {
        return idBonPlan;
    }

    public void setIdBonPlan(int idBonPlan) {
        this.idBonPlan = idBonPlan;
    }

    public String getNameBonPlan() {
        return nameBonPlan;
    }

    public void setNameBonPlan(String nameBonPlan) {
        this.nameBonPlan = nameBonPlan;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public float getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(float avgPrice) {
        this.avgPrice = avgPrice;
    }

    public int getFk_idTypeBonPlan() {
        return fk_idTypeBonPlan;
    }

    public void setFk_idTypeBonPlan(int fk_idTypeBonPlan) {
        this.fk_idTypeBonPlan = fk_idTypeBonPlan;
    }


   

    @Override
    public String toString() {
        return "BonPlan{" + "idBonPlan=" + idBonPlan + ", nameBonPlan=" + nameBonPlan + ", rating=" + rating + ", startDate=" + startDate + ", endDate=" + endDate + ", avgPrice=" + avgPrice + ", fk_idTypeBonPlan=" + fk_idTypeBonPlan + '}';
    }
    
    

}