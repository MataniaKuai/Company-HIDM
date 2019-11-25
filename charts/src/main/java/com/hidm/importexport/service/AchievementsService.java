package com.hidm.importexport.service;

import java.util.List;

import com.hidm.importexport.entity.Achievements;
import com.hidm.importexport.entity.AchievementsPrice;


public interface AchievementsService {

	int sync();
	
    void insertAchievements(List<Achievements> inventoryAchievements); 
    
    List<AchievementsPrice> getAchievement();

    void delAchievementsHis();

    void delAchievements();
    

}
