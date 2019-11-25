package com.hidm.importexport.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hidm.importexport.entity.Achievements;
import com.hidm.importexport.entity.AchievementsPrice;

@Mapper
public interface AchievementsDao {

	public void insertAchievements(List<Achievements> inventoryAchievements);
	
	public void insertAchievementsHis(List<Achievements> inventoryAchievements);
	
	public List<AchievementsPrice> getAchievement();
	
	List<Achievements> findDate(Achievements achievements);
	

    public void delAchievementsHis(int days);

    public void delAchievements();

}
