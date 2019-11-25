package com.hidm.importexport.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hidm.importexport.dao.AchievementsDao;
import com.hidm.importexport.entity.Achievements;
import com.hidm.importexport.entity.AchievementsPrice;
import com.hidm.importexport.service.AchievementsService;
import com.hidm.importexport.service.SAPConn;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoTable;

@Service(value = "AchievementsService")
public class AchievementsServiceImpl implements AchievementsService {

	private static Logger log = Logger.getLogger(AchievementsServiceImpl.class);
	@Autowired
	private SAPConn sapConService;
	@Autowired
	private AchievementsDao achievementsDao;
    @Value("${hisdata_days}")
    private String hisDataDays;


	// 同步SAP绩效表数据
	@Transactional
	public int sync() {
		int rows = 0;
		log.info("===========start call to ZSIMM_003=============== ");

		    try {
			List<Achievements> inventoryAchievements = new ArrayList<Achievements>();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
			// 获取当前年月日
			int year = Calendar.getInstance().get(Calendar.YEAR);
			int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
			String lastday;
			List<String> yearmd = new ArrayList<String>();
			for (int i = 1; i <= month; i++) {
				JCoFunction function = null;
				JCoDestination destination = sapConService.connect();
				JCoTable table = null;
				function = destination.getRepository().getFunction("ZSIMM_003");
				JCoParameterList input = function.getImportParameterList();
				
				input.setValue("IV_WERKS", "1000");
				Calendar a = Calendar.getInstance();
				a.set(Calendar.YEAR, year);
				a.set(Calendar.MONTH, i-1);
				a.set(Calendar.DATE, 1);
				a.roll(Calendar.DATE, -1);
				lastday = a.get(Calendar.DATE)+"";
				if (i == month) {
					lastday = Calendar.getInstance().get(Calendar.DATE) + "";
					if(Integer.parseInt(lastday) < 10) {
						lastday = "0" + lastday;
					}
				}
				if (Integer.toString(i).length() == 1) {
					yearmd.add(year + "0" + i + lastday);
					input.setValue("IV_BUDAT1", sdf.parse(year + "." + 0 + i + "." + "01"));
					input.setValue("IV_BUDAT2", sdf.parse(year + "." + 0 + i + "." + lastday));
				} else {
					yearmd.add("20" + year + i + lastday);
					input.setValue("IV_BUDAT1", sdf.parse(year + "." + i + "." + "01"));
					input.setValue("IV_BUDAT2", sdf.parse(year + "." + i + "." + lastday));
				}
				function.execute(destination);
				table = function.getTableParameterList().getTable("T_DATA");
				// 连接SAP接口成功后 打印table信息
				log.info("Success to call SAP to sync Achievements info. " + table.toXML());
				rows = table.getNumRows();
				log.info("table rows:" + rows);
				table.firstRow();
				for (int j = 0; j < table.getNumRows(); j++, table.nextRow()) {
					Achievements mInventoryAchievements = new Achievements();
					String werks = table.getString("WERKS");
					String lgort = table.getString("LGORT");
					String matnr = table.getString("MATNR");
					String maktx = table.getString("MAKTX");
					String zqcsl = table.getString("ZQCSL");
					String zqmsl = table.getString("ZQMSL");
					String zshsl = table.getString("ZSHSL");
					String zfhsl = table.getString("ZFHSL");
					mInventoryAchievements.setWerks(werks);
					mInventoryAchievements.setLgort(lgort);
					mInventoryAchievements.setMatnr(matnr);
					mInventoryAchievements.setMaktx(maktx);
					mInventoryAchievements.setZqcsl(zqcsl);
					mInventoryAchievements.setZqmsl(zqmsl);
					mInventoryAchievements.setZshsl(zshsl);
					mInventoryAchievements.setZfhsl(zfhsl);
					if(i < 10) {
						mInventoryAchievements.setCdate(year + "0" + i + lastday);
					}else {
						mInventoryAchievements.setCdate(year + "" + i + lastday);
					}
					inventoryAchievements.add(mInventoryAchievements);
				}
			}

				log.info("=========inventoryAchievements.size()======= " + inventoryAchievements.size());

				// 分批插入数据库，每批500条
				int batchCount = 100;
				int index = 0;
				System.out.println(inventoryAchievements.toString());

				int size = inventoryAchievements.size();
				if (size > 0) {
					while (true) {
						if (index + batchCount >= size) {
							insertAchievements(inventoryAchievements.subList(index, size));
							insertAchievementsHis(inventoryAchievements.subList(index, size));
							break;
						} else {
							insertAchievements(inventoryAchievements.subList(index, index + batchCount));
							insertAchievementsHis(inventoryAchievements.subList(index, index +batchCount));
							index = index + batchCount;
						}
					}
				}
			
		} catch (Exception e) {
			log.error("Failed to sync.", e);
			throw new RuntimeException(e);
		}

		return rows;
	}

	public void insertAchievementsHis(List<Achievements> inventoryAchievements) {
		achievementsDao.insertAchievementsHis(inventoryAchievements);

	}

	public void insertAchievements(List<Achievements> inventoryAchievements) {
		achievementsDao.insertAchievements(inventoryAchievements);
	}

	public List<AchievementsPrice> getAchievement() {
		return achievementsDao.getAchievement();
	}

	@Override
	public void delAchievementsHis() {
		achievementsDao.delAchievementsHis(Integer.parseInt(hisDataDays)+1);
	}

	@Override
	public void delAchievements() {
		achievementsDao.delAchievements();
	}

	

}
