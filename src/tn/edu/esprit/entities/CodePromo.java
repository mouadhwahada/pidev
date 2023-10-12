/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.entities;

import java.sql.Date;

/**
 *
 * @author Maryem
 */

public class CodePromo {
    private int id_codepromo;
    private Long code;
    private String description;
    private Date datedexpiration;
    private boolean used ;
    private User u;

    public CodePromo(int id_codepromo, Long code, String description,Date datedexpiration, boolean used) {
        this.id_codepromo = id_codepromo;
        this.code = code;
        this.description = description;
        this.datedexpiration = datedexpiration;
        this.used = used;
    }

    
    
public CodePromo() {
   
    }

    public CodePromo(Long code, String description, Date datedexpiration, boolean used) {
        this.code = code;
        this.description = description;
        this.datedexpiration = datedexpiration;
        this.used = used;
    }

    public int getId_codepromo() {
        return id_codepromo;
    }

    public void setId_codepromo(int id_codepromo) {
        this.id_codepromo = id_codepromo;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDatedexpiration() {
        return datedexpiration;
    }

    public void setDatedexpiration(Date datedexpiration) {
        this.datedexpiration = datedexpiration;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    @Override
    public String toString() {
        return "CodePromo{" + "id_codepromo=" + id_codepromo + ", code=" + code + ", description=" + description + ", datedexpiration=" + datedexpiration + ", used=" + used + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.id_codepromo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CodePromo other = (CodePromo) obj;
        return this.id_codepromo == other.id_codepromo;
    }
    


}
    

