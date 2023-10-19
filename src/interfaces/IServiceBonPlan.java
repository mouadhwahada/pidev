/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import models.BonPlan;

/**
 *
 * @author MSADDAK
 */
public interface IServiceBonPlan {
    public void createBonPlan(BonPlan bp);
    public void updateBonPlan(BonPlan bp);
    public void deleteBonPlan(BonPlan bp);
    //public List<BonPlan> getAllBonPlans();
        
   public List<BonPlan> getAll(BonPlan bp);

}
