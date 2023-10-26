/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import models.TypeBonPlan;

/**
 *
 * @author MSADDAK
 */
public interface IServiceTypeBonPlan {
        public void createTypeBonPlan(TypeBonPlan tbp);
        //public List<TypeBonPlan> getAllTypeBonPlans();
        public void deleteTypeBonPlan(TypeBonPlan tbp) ;
        public void updateTypeBonPlan(TypeBonPlan tbp);
        List<TypeBonPlan> getAllTypebonPlan(TypeBonPlan typeBonPlan);
       public List<TypeBonPlan>searchBonPlanByAvgPrice(String location);
       

}
