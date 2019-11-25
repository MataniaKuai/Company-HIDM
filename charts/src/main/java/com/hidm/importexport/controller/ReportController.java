package com.hidm.importexport.controller;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hidm.importexport.service.InventoryService;
import com.hidm.importexport.service.KPIReportService;
import com.hidm.importexport.constant.SapConstant;
import com.hidm.importexport.entity.Achievements;
import com.hidm.importexport.entity.AchievementsPrice;
import com.hidm.importexport.entity.ChartsResult;
import com.hidm.importexport.entity.Inventory;
import com.hidm.importexport.entity.InventoryResult;
import com.hidm.importexport.entity.KPIReport;
import com.hidm.importexport.entity.Material;
import com.hidm.importexport.entity.MaterialType;
import com.hidm.importexport.service.ChartsService;
import com.hidm.importexport.service.AchievementsService;
import com.hidm.importexport.util.DateUtil;
import com.hidm.importexport.util.JsonUtil;
import com.hidm.importexport.util.MathUtil;
import com.hidm.importexport.vo.KPIReportVo;

@Controller
public class ReportController {
	private static final Logger log = LoggerFactory.getLogger(ReportController.class);

	@Autowired
	private ChartsService chartsService;
	@Autowired
	private InventoryService inventoryConsumptionService;
	@Autowired
	private AchievementsService inventoryAchievementsService;	
	@Autowired
	private KPIReportService kpiReportService;
	
	private static String REGEX_CHINESE = "[\u4e00-\u9fa5]";// 中文正则

	/**
	 * 1.删除T_MATERIAL_HIS存放天数之前的数据 2.删除T_MATERIAL表的数据
	 * 3.同步SAP更新T_MATERIAL_HIS和T_MATERIAL表
	 */
	// @Scheduled(cron = "* 0/5 * * * ? ")
	@Scheduled(cron = "0 0 1 * * ?") // 每天凌晨1点执行
	@Transactional(rollbackFor = { Exception.class })
	public void taskCycle() {
		log.info("=========start task===============");
		long startTime = System.currentTimeMillis();// 获取程序执行时间
		// 删除T_MATERIAL_HIS前一天之前的数据
		chartsService.delMaterialHis();
		log.info("=========MATERIAL_HIS删除完成===============");
		// 删除T_MATERIAL表的数据
		chartsService.delMaterial();
		log.info("=========T_MATERIAL删除完成===============");
		// 同步SAP更新T_MATERIAL_HIS和T_MATERIAL表
		chartsService.sync();
		long endTime = System.currentTimeMillis(); // 获取结束时间
		log.info("同步SAP数据： " + (endTime - startTime) + "ms");
		System.out.println("========end=task===========");

		/**
		 * INVENTORY表的操作
		 */

		long startTime1 = System.currentTimeMillis();
		// 删除T_INVENTORY_HIS前一天之前的数据
		inventoryConsumptionService.delInventoryHis();
		log.info("=========INVENTORY_HIS删除完成===============");
		// 删除T_INVENTORY表的数据
		inventoryConsumptionService.delInventory();
		log.info("=========T_INVENTORY删除完成===============");
		// 同步SAP更新T_INVENTORY_HIS和T_INVENTORY表
		inventoryConsumptionService.sync();
		long endTime1 = System.currentTimeMillis();
		log.info("同步SAP INVENTORY数据： " + (endTime1 - startTime1) + "ms");
		System.out.println("========end=task===========");

		/**
		 * ACHIEVEMENTS表的操作
		 */

		// 获取程序执行时间
		long startTime2 = System.currentTimeMillis();
		// 删除T_Achievements_HIS前一天之前的数据
		inventoryAchievementsService.delAchievementsHis();
		log.info("=========Achievements_HIS删除完成===============");
		// 删除T_Achievements表的数据
		inventoryAchievementsService.delAchievements();
		log.info("=========T_Achievements删除完成===============");
		inventoryAchievementsService.sync();
		// 获取结束时间
		long endTime2 = System.currentTimeMillis();
		log.info("同步SAP Achievements数据： " + (endTime2 - startTime2) + "ms");
		System.out.println("========end=task===========");
		
		/**
		 * KPIReport表的操作
		 */
		// 获取程序执行时间
		long startTime3 = System.currentTimeMillis();
		// 删除T_KPIREPORT_HIS前一天之前的数据
		kpiReportService.delKPIReportHis();
		log.info("=========KPIReportHis删除完成===============");
		// 删除T_KPIREPORT表的数据
		kpiReportService.delKPIReport();
		log.info("=========KPIReport删除完成===============");
		kpiReportService.sync();
		// 获取结束时间
		long endTime3 = System.currentTimeMillis();
		log.info("同步SAP KPIReport数据： " + (endTime3 - startTime3) + "ms");
		System.out.println("========end=task===========");


	}

	@RequestMapping("/test")
	public void getTestData(Model model, String name) {
		/**
		 * ACHIEVEMENTS表的操作
		 */

		// 获取程序执行时间
		long startTime2 = System.currentTimeMillis();
		// 删除T_Achievements_HIS前一天之前的数据
		inventoryAchievementsService.delAchievementsHis();
		log.info("=========Achievements_HIS删除完成===============");
		// 删除T_Achievements表的数据
		inventoryAchievementsService.delAchievements();
		log.info("=========T_Achievements删除完成===============");
		inventoryAchievementsService.sync();
		// 获取结束时间
		long endTime2 = System.currentTimeMillis();
		log.info("同步SAP Achievements数据： " + (endTime2 - startTime2) + "ms");
		System.out.println("========end=task===========");
	}

	@RequestMapping("/test1")
	public void getTestData1(Model model, String name) {
		/**
		 * T_MATERIAL表的操作
		 */
        
		// 获取程序执行时间
		long startTime2 = System.currentTimeMillis();
		chartsService.delMaterialHis();
		log.info("=========MATERIAL_HIS删除完成===============");
		// 删除T_MATERIAL表的数据
		chartsService.delMaterial();
		log.info("=========T_MATERIAL删除完成===============");
		chartsService.sync();
		// 获取结束时间
		long endTime2 = System.currentTimeMillis();
		log.info("同步SAP chartsService数据： " + (endTime2 - startTime2) + "ms");
		System.out.println("========end=task===========");
	}
	
	
	@RequestMapping("/test2")
	public void getTestData2(Model model, String name) {
		/**
		 * INVENTORY表的操作
		 */

		long startTime1 = System.currentTimeMillis();
		// 删除T_INVENTORY_HIS前一天之前的数据
		inventoryConsumptionService.delInventoryHis();
		log.info("=========INVENTORY_HIS删除完成===============");
		// 删除T_INVENTORY表的数据
		inventoryConsumptionService.delInventory();
		log.info("=========T_INVENTORY删除完成===============");
		// 同步SAP更新T_INVENTORY_HIS和T_INVENTORY表
		inventoryConsumptionService.sync();
		long endTime1 = System.currentTimeMillis();
		log.info("同步SAP INVENTORY数据： " + (endTime1 - startTime1) + "ms");
		System.out.println("========end=task===========");
	}
	@RequestMapping("/test3")
	public void getTestData3(Model model, String name) {
		// 获取程序执行时间
		long startTime3 = System.currentTimeMillis();
		// 删除T_KPIREPORT_HIS前一天之前的数据
//		kpiReportService.delKPIReportHis();
		log.info("=========T_KPIREPORT_HIS删除完成===============");
		// 删除T_KPIREPORT表的数据
		kpiReportService.delKPIReport();
		log.info("=========T_KPIREPORT删除完成===============");
		kpiReportService.sync();
		// 获取结束时间
		long endTime3 = System.currentTimeMillis();
		log.info("同步SAP Achievements数据： " + (endTime3 - startTime3) + "ms");
		System.out.println("========end=task===========");
	}

	@RequestMapping("/report1")
	public String getCharts(Model model) {
		List<ChartsResult> countMaterial = chartsService.countMaterial();
		List<String> typeList = new ArrayList<String>();
		List<String> countList = new ArrayList<String>();		 
		List<String> nameList = new ArrayList<String>();
		Integer total = 0;
		for (ChartsResult material : countMaterial) {
			nameList.add(material.getType());
			// 去除中文，并且以字母开头
			String materialType = getValue(material.getType());
			typeList.add(materialType);
			countList.add(Integer.toString(material.getCount()));
			total = total + material.getCount();
		}
		typeList.add(0, "Total");
		countList.add(0, Integer.toString(total));
		nameList.add(0, "Total");
		String typeData = JsonUtil.toJson(typeList);
		String countData = JsonUtil.toJson(countList);
		model.addAttribute("typeData", typeData);
		model.addAttribute("countData", countData);
		model.addAttribute("typeList", typeList);
		model.addAttribute("countList", countList);
		model.addAttribute("nameList", nameList);
		return "/report1/report1";
		
	}

	@RequestMapping("/report1Detail")
	public String getReport1Detail(Model model, String name) {
		List<Material> materialList = chartsService.findByType(name);
		  Collections.sort(materialList);
		model.addAttribute("materialList", materialList);
		return "/report1/detail";
	}

	@RequestMapping("/report2Detail")
	public String getReport2Detail(Model model, String date, String type) {
		InventoryResult inventoryResults = new InventoryResult();
		String year, month;
		if (date.length() > 4) {
			year = date.substring(0, 4);
			month = date.substring(4, 6);
		} else {
			year = date.substring(0, 4);
			month = "";
		}
		inventoryResults.setDate(year + "-" + month);
		inventoryResults.setWgbez(type);
		List<InventoryResult> inventoryList = inventoryConsumptionService.findByDateAndType(inventoryResults);
		for (int i = 0; i < inventoryList.size(); i++) {
			InventoryResult ir = inventoryList.get(i);
			if (ir.getVprsv() != "" || ir.getVprsv() != null) {
				if (ir.getVprsv().equals(SapConstant.VPRSV_VALUES)) {
					ir.setMoney(Double.parseDouble(ir.getStprs()) * Double.parseDouble(ir.getErfmg()));
				} else if (ir.getVprsv().equals(SapConstant.VPRSV_VALUEV)) {
					ir.setMoney(Double.parseDouble(ir.getVerpr()) * Double.parseDouble(ir.getErfmg()));
				}
			}
			String s=new BigDecimal(Double.parseDouble(ir.getErfmg())).toString();
			ir.setErfmg(s);
		}
		 Collections.sort(inventoryList);
		model.addAttribute("inventoryList", inventoryList);
		return "/report2/detail";
	}

	@RequestMapping("/report3Detail")
	public String getReport3Detail(Model model, String date, String type) {
		// type：1 计算总库存金额； type：2 计算不良品金额
		List<AchievementsPrice> achievementsList = inventoryAchievementsService.getAchievement();
		
		List<AchievementsPrice> achievementsList1 = new ArrayList<AchievementsPrice>();
		List<Double> sumList = new ArrayList<Double>();
		
         DecimalFormat df=new DecimalFormat(",###,##0"); //没有小数  
		double sum=0;
		if(type.equals("1")) {
			for(int i = achievementsList.size() -1; i >=0; i--) {
				achievementsList.get(i).setWgbez(getValue(achievementsList.get(i).getWgbez()));
				if(date.equals(achievementsList.get(i).getCdate().substring(0,6))) {
					
					if(null == achievementsList.get(i).getStprs() || achievementsList.get(i).getStprs().equals("")) {
						sum = MathUtil.mul(achievementsList.get(i).getZqmsl(), "0");
					}else {
						sum = MathUtil.mul(achievementsList.get(i).getZqmsl(), achievementsList.get(i).getStprs());
					}
					sum = Math.round(sum);
					sumList.add(sum);
				    AchievementsPrice obj= achievementsList.get(i);
					obj.setMoney(sum);
					achievementsList1.add(achievementsList.get(i));
				}
				 BigDecimal a=new BigDecimal(achievementsList.get(i).getZqmsl());  
				 AchievementsPrice obj= achievementsList.get(i); 
				 obj.setZqmsl( df.format(a));
			}
		}else if(type.equals("2")) {
			for(int i = achievementsList.size() -1; i >=0; i--) {
				achievementsList.get(i).setWgbez(getValue(achievementsList.get(i).getWgbez()));
				if(date.equals(achievementsList.get(i).getCdate().substring(0,6)) && (achievementsList.get(i).getLgort().equals("P001")|| achievementsList.get(i).getLgort().equals("R001"))) {
					
					if(null == achievementsList.get(i).getStprs() || achievementsList.get(i).getStprs().equals("")) {
						sum = MathUtil.mul(achievementsList.get(i).getZqmsl(), "0");
					}else {
						sum = MathUtil.mul(achievementsList.get(i).getZqmsl(), achievementsList.get(i).getStprs());
					}
					sum = Math.round(sum);
					sumList.add(sum); AchievementsPrice obj= achievementsList.get(i);
					obj.setMoney(sum);
					achievementsList1.add(achievementsList.get(i));
				}
				 BigDecimal a=new BigDecimal(achievementsList.get(i).getZqmsl());  
				 AchievementsPrice obj= achievementsList.get(i); 
				 obj.setZqmsl( df.format(a));
			}
		}
		 Collections.sort(achievementsList1);
		 for(AchievementsPrice s:achievementsList1){
	            System.out.println("info:"+JsonUtil.toJson(s));
	        }
		 System.out.println("777777777777"+JsonUtil.toJson(achievementsList1));
		model.addAttribute("achievementsList", achievementsList1);
		model.addAttribute("sumList",sumList);
		return "/report3/detail";
	}

	@RequestMapping("/inventoryReport")
	public String getInventoryCharts(InventoryResult inventoryResults, Model model, HttpSession session) {
		// 获取当前年的数据
		List<InventoryResult> resultList = inventoryConsumptionService.selectInventory(inventoryResults);
		List<MaterialType> materialTypeList = inventoryConsumptionService.getMaterialType();
	    System.out.println(inventoryResults.getMaterialTypes());
		for (MaterialType material : materialTypeList) {
			material.setShotType(getValue(material.getType()));
		}
		

		// 获取当前年
		DateFormat df = new SimpleDateFormat("yy"); // 只是一年，有2位数
		String year = df.format(Calendar.getInstance().getTime());
		List<String> yearMonth = new ArrayList<String>();// 日期格式为Jan-19,用于页面显示
		List<String> yearMon = new ArrayList<String>();// 日期格式为201901,用于查询数据
		for (int i = 1; i <= 12; i++) {
			if (Integer.toString(i).length() == 1) {
				yearMonth.add(DateUtil.getEnMonth("0" + i) + "-" + year);
				yearMon.add("20" + year + "0" + i);
			} else {
				yearMonth.add(DateUtil.getEnMonth(Integer.toString(i)) + "-" + year);
				yearMon.add("20" + year + i);
			}
		}
		
		
		List<String> typeList = new ArrayList<String>();// 类型去除中文,用于页面显示
		List<String> typeNameList = new ArrayList<String>();// 类型全称,用于检索数据
		typeList.add(0, "product");
		for (InventoryResult result : resultList) {
			String mType = getValue(result.getWgbez());
			if (!typeList.contains(mType)) {
				typeList.add(mType);
				typeNameList.add(result.getWgbez());
			}
		} 
		
		// 各个物料种类一至十二月数据
		List<String> januaryList1 = new ArrayList<String>();
		List<String> februaryList1 = new ArrayList<String>();
		List<String> marchList1 = new ArrayList<String>();
		List<String> aprilList1 = new ArrayList<String>();
		List<String> mayList1 = new ArrayList<String>();
		List<String> juneList1 = new ArrayList<String>();
		List<String> julyList1 = new ArrayList<String>();
		List<String> augustList1 = new ArrayList<String>();
		List<String> septemberList1 = new ArrayList<String>();
		List<String> octoberList1 = new ArrayList<String>();
		List<String> novemberList1 = new ArrayList<String>();
		List<String> decemberList1 = new ArrayList<String>();
		List<Double> monAmountList = new ArrayList<Double>();

		for (int i = 0; i < yearMon.size(); i++) {
			String mon = yearMon.get(i);
			List<String> typeDataList = new ArrayList<String>();
			typeDataList.add(yearMonth.get(i));
			double monAmount = 0;
			for (String typeName : typeNameList) {
				double monItemAmount = getAmount(resultList, mon, typeName);
				typeDataList.add(Double.toString((Math.round(monItemAmount))));
				monAmount = monAmount + monItemAmount;
			}
			monAmountList.add((double) Math.round(monAmount));
			String month = mon.substring(4, 6);
			if (month.equals("01")) {
				januaryList1 = typeDataList;				
			} else if (month.equals("02")) {
				februaryList1 = typeDataList;
			} else if (month.equals("03")) {
				marchList1 = typeDataList;
			} else if (month.equals("04")) {
				aprilList1 = typeDataList;
			} else if (month.equals("05")) {
				mayList1 = typeDataList;
			} else if (month.equals("06")) {
				juneList1 = typeDataList;
			} else if (month.equals("07")) {
				julyList1 = typeDataList;
			} else if (month.equals("08")) {
				augustList1 = typeDataList;
			} else if (month.equals("09")) {
				septemberList1 = typeDataList;
			} else if (month.equals("10")) {
				octoberList1 = typeDataList;
			} else if (month.equals("11")) {
				novemberList1 = typeDataList;
			} else if (month.equals("12")) {
				decemberList1 = typeDataList;
			}
		}

		// 计算每个类型的合计
		List<Double> typeAmountList = new ArrayList<Double>();
		typeAmountList.add(0, 0.0);
		for (String typeName : typeNameList) {
			double typeAmount = 0;
			for (String mon : yearMon) {
				double monItemAmount = getAmount(resultList, mon, typeName);
				typeAmount = typeAmount + monItemAmount;
			}
			typeAmountList.add((double) Math.round(typeAmount));			
		}
		
		// 计算总合计
		double amount = 0;
		for (Double value : typeAmountList) {
			amount = amount + value;
		}
		 amount=Math.round(amount);

		List<String> seriesList1 = new ArrayList<String>();
		for (int i = 0; i < typeNameList.size(); i++) {
			seriesList1.add("{type: 'bar'}");
		}

		model.addAttribute("materialTypeList", materialTypeList);
		model.addAttribute("monAmountList", monAmountList);
		model.addAttribute("typeAmountList", typeAmountList);
		model.addAttribute("typeLists", typeList);
		model.addAttribute("yearMonthList", yearMonth);
		model.addAttribute("yearMonList", yearMon);
		String seriesList = JsonUtil.toJson(seriesList1);
		model.addAttribute("seriesList", seriesList);
		String typejList = JsonUtil.toJson(typeList);
		model.addAttribute("typeList", typejList);
		String januaryList = JsonUtil.toJson(januaryList1);
		model.addAttribute("januaryList", januaryList);
		model.addAttribute("januaryList1", januaryList1);
		String februaryList = JsonUtil.toJson(februaryList1);
		model.addAttribute("februaryList", februaryList);
		model.addAttribute("februaryList1", februaryList1);
		String marchList = JsonUtil.toJson(marchList1);
		model.addAttribute("marchList", marchList);
		model.addAttribute("marchList1", marchList1);
		String aprilList = JsonUtil.toJson(aprilList1);
		model.addAttribute("aprilList", aprilList);
		model.addAttribute("aprilList1", aprilList1);
		String mayList = JsonUtil.toJson(mayList1);
		model.addAttribute("mayList", mayList);
		model.addAttribute("mayList1", mayList1);
		String juneList = JsonUtil.toJson(juneList1);
		model.addAttribute("juneList", juneList);
		model.addAttribute("juneList1", juneList1);
		String julyList = JsonUtil.toJson(julyList1);
		model.addAttribute("julyList", julyList);
		model.addAttribute("julyList1", julyList1);
		String augustList = JsonUtil.toJson(augustList1);
		model.addAttribute("augustList", augustList);
		model.addAttribute("augustList1", augustList1);
		String septemberList = JsonUtil.toJson(septemberList1);
		model.addAttribute("septemberList", septemberList);
		model.addAttribute("septemberList1", septemberList1);
		String octoberList = JsonUtil.toJson(octoberList1);
		model.addAttribute("octoberList", octoberList);
		model.addAttribute("octoberList1", octoberList1);
		String novemberList = JsonUtil.toJson(novemberList1);
		model.addAttribute("novemberList", novemberList);
		model.addAttribute("novemberList1", novemberList1);
		String decemberList = JsonUtil.toJson(decemberList1);
		model.addAttribute("decemberList", decemberList);
		model.addAttribute("decemberList1", decemberList1);
		model.addAttribute("amount", amount);
		model.addAttribute("year", "20" + year);
		return "/report2/report2";
	}

	@RequestMapping("/report3")
	public String report3(InventoryResult inventoryResults, Model model, HttpSession session) {
		// 获取当前年月日
		int year1 = Calendar.getInstance().get(Calendar.YEAR);
		int month = Calendar.getInstance().get(Calendar.MONTH);
		// 获取当前年
		DateFormat df = new SimpleDateFormat("yy"); // 只是一年，有2位数
		String year = df.format(Calendar.getInstance().getTime());
		List<String> yearMonth = new ArrayList<String>();// 日期格式为Jan-19,用于页面显示
		List<String> yearMon = new ArrayList<String>();// 日期格式为201901,用于查询数据
		List<String> tableyear = new ArrayList<String>();
			for (int i = 1; i <= 12; i++) {
					if (Integer.toString(i).length() == 1) {
						yearMonth.add(DateUtil.getEnMonth("0" + i) + "-" + year);
						yearMon.add("20" + year + "0" + i);
						tableyear.add(DateUtil.getEnMonth("0" + i) + "-" + year);
					} else {
						yearMonth.add(DateUtil.getEnMonth(Integer.toString(i)) + "-" + year);
						yearMon.add("20" + year + i);
						tableyear.add(DateUtil.getEnMonth(Integer.toString(i)) + "-" + year);
					}
				}
		
		//总库存金额（期末）
		List<Double> totaltList = new ArrayList<Double>();
		//出库金额
		List<Double> consumeList = new ArrayList<Double>();
		// 获取当前年的数据
		List<InventoryResult> resultList = inventoryConsumptionService.selectInventory(inventoryResults);	
		
		List<String> typeList = new ArrayList<String>();// 类型去除中文,用于页面显示
		List<String> typeNameList = new ArrayList<String>();// 类型全称,用于检索数据
				typeList.add(0, "product");
				for (InventoryResult result : resultList) {
					String mType = getValue(result.getWgbez());
					if (!typeList.contains(mType)) {
						typeList.add(mType);
						typeNameList.add(result.getWgbez());
					}
				}

          for (int i = 0; i < yearMon.size(); i++) {
					String mon = yearMon.get(i);
					double monAmount = 0;
					for (String typeName : typeNameList) {
						double monItemAmount = getAmount(resultList, mon, typeName);
						monAmount = monAmount + monItemAmount;
					}
					if(i <= month) {
						consumeList.add((double) Math.round(monAmount));	
					}else {
						consumeList.add(0.01);
					}
				}
		//不良品金额
		List<Double> badtotalList = new ArrayList<Double>();
		//不良率
		List<String> PoorrateList = new ArrayList<String>();
		//周转天数
		List<Object> daysList = new ArrayList<Object>();
		//坐标周转
		List<String> daysList1 =  new ArrayList<String>();
		List<AchievementsPrice> AchievementsList = inventoryAchievementsService.getAchievement();
		int k = 0;
		for (String mon : yearMon) {
			// 计算库存金额
			double total = 0;
			// 不良金额
			double badtotal = 0;
			// 不良率
			String Poorrate = "";
			// 期初总库存金额
			double starttotal = 0;
			// 周转天数
			Object days = null;
			// 坐标天数
			String days1 = "";
			// 期间天数
			int daycount = 0;
			for (int i = 0; i <= AchievementsList.size()-1; i++) {
				if ((AchievementsList.get(i).getCdate().substring(4, 6)).equals((mon).substring(4, 6))) {
					if(null == AchievementsList.get(i).getStprs() || AchievementsList.get(i).getStprs().equals("")) {
						starttotal = starttotal + MathUtil.mul(AchievementsList.get(i).getZqcsl(), "0");
						total = total + MathUtil.mul(AchievementsList.get(i).getZqmsl(), "0");
					}else {
						starttotal = starttotal + MathUtil.mul(AchievementsList.get(i).getZqcsl(), AchievementsList.get(i).getStprs());
						total = total + MathUtil.mul(AchievementsList.get(i).getZqmsl(), AchievementsList.get(i).getStprs());
						
					}
					
				}
				if (((AchievementsList.get(i).getCdate().substring(4, 6)).equals((mon).substring(4, 6))) 
						&& (AchievementsList.get(i).getLgort().equals("P001")|| AchievementsList.get(i).getLgort().equals("R001"))) {
					if(null == AchievementsList.get(i).getStprs() || AchievementsList.get(i).getStprs().equals("")) {
						badtotal = badtotal + MathUtil.mul(AchievementsList.get(i).getZqmsl(), "0");
						
					}else {
						badtotal = badtotal + MathUtil.mul(AchievementsList.get(i).getZqmsl(), AchievementsList.get(i).getStprs());
						
					}
					
				}
				
			}
			
			Calendar a = Calendar.getInstance();
			a.set(Calendar.YEAR, year1);
			a.set(Calendar.MONTH, k);
			a.set(Calendar.DATE, 1);
			a.roll(Calendar.DATE, -1);
			daycount = a.get(Calendar.DATE);
			if (k == month) {
				daycount = Calendar.getInstance().get(Calendar.DATE);
			}

			if (k < 12) {
				if (consumeList.get(k) == 0) {
					days1="0";
					days = 0;
				}else {
					days = Math.round(((((total + starttotal) / 2) / new Double(consumeList.get(k)).intValue()) * daycount));
		            days1 = Math.round((((total + starttotal) / 2) / new Double(consumeList.get(k)).intValue()) * daycount) + "";
		            System.out.println("day1"+((((total + starttotal) / 2) / new Double(consumeList.get(k)).intValue()) * daycount));
				}	
			}
            
			total = Math.round(total);
			badtotal = Math.round(badtotal);			
			if(total == 0) {
				Poorrate = "0.00";
			}else {
				DecimalFormat mDF = new DecimalFormat("0.00"); 
				Poorrate = mDF.format(badtotal/total * 100);
			}		
			if(k <= month) {
				daysList1.add(days1);	
				totaltList.add(total);
				badtotalList.add(badtotal);
				PoorrateList.add(Poorrate + "%");
				daysList.add(days);
				
			}else {	
				daysList1.add("");
				totaltList.add(0.01);
				badtotalList.add(0.01);
				PoorrateList.add("");
				daysList.add(0.01);
			}
			k++;		
		}
		
		
		
		model.addAttribute("yearMonthList", JsonUtil.toJson(yearMonth));
		model.addAttribute("totaltList", JsonUtil.toJson(totaltList));
		model.addAttribute("consumeList", JsonUtil.toJson(consumeList));
		model.addAttribute("badtotalsList", JsonUtil.toJson(badtotalList));
		model.addAttribute("daysList", JsonUtil.toJson(daysList1));		
		model.addAttribute("tableyear", tableyear);
		model.addAttribute("tabletotaltList", totaltList);
		model.addAttribute("tableconsumeList", consumeList);
		model.addAttribute("tablebadtotalsList", badtotalList);
		model.addAttribute("tablePoorrateList", PoorrateList);
		model.addAttribute("tabledaysList", daysList);
		
		// 用于查询数据
		model.addAttribute("yearMonList", yearMon);
		
		return "/report3/report3";
	}
	
	@RequestMapping("/report4")
	public String getKPIReport(InventoryResult inventoryResults, Model model, HttpSession session) {		
		// 获取当前年月
		int year1 = Calendar.getInstance().get(Calendar.YEAR);
		DateFormat df = new SimpleDateFormat("yy"); // 只是一年，有2位数
		String year = "20"+df.format(Calendar.getInstance().getTime());		
		int curmonth = Calendar.getInstance().get(Calendar.MONTH);		
		// 查找某月
		int mon;
		String month;   
		// 期间天数
        int daycount = 0;	
		if (inventoryResults.getDate() == null) {
			mon = curmonth+1;
			month = String.valueOf(mon);
			if (month.length()<2)
				  month = "0"+ month;	
			inventoryResults.setDate(year+"-"+month);
		}
		else 
			{		
			month = inventoryResults.getDate();			
		    mon = Integer.valueOf(month);
		    if (month.length()<2)
				  month = "0"+ month;	
		    }
		
		// 当前年数据		
		List<InventoryResult> resultList = inventoryConsumptionService.selectMonInventory(inventoryResults);
		 Calendar a = Calendar.getInstance();
	 	    a.set(Calendar.YEAR, year1);
	 	    a.set(Calendar.MONTH, mon - 1);
	 	    a.set(Calendar.DATE, 1);
	 	    a.roll(Calendar.DATE, -1);
	 	     daycount = a.get(Calendar.DATE);
				if (curmonth+1 == mon) {
					daycount = Calendar.getInstance().get(Calendar.DATE);
				}
		//总库存金额
		 double Inventorcost;		 
		 //期初总库存
		 double startcost = 0;
		 //不良品金額
		 double badtotal;
		 double lifetime=0;
	    List<KPIReportVo> KPIlist = new ArrayList<KPIReportVo>();
		List<MaterialType> getmatkl = kpiReportService.getMatkl();
		 //库存数据
	    List<AchievementsPrice> achievementsList = inventoryAchievementsService.getAchievement();
	    //	Lifetime Alarm（<120days）數據 
		  List<KPIReport> LifetimeList = kpiReportService.getKPIReport();
		  LinkedHashSet <String> set = new LinkedHashSet<String>(); 
				for (MaterialType Type : getmatkl) {
					if(Type.getMaterialtype() != null)
					{
					    KPIReportVo KPIValue =new KPIReportVo();
					    KPIValue.setGroup(Type.getMaterialtype());
					    KPIValue.setExpenseValue(getAmount(resultList, year + month, Type.getType()));
					    KPIValue.setMatklgroup(Type.getTypesmatkl());
					    KPIValue.setType(getValue(Type.getType()));	
					    Inventorcost= 0;
			    		startcost = 0; 
			    		badtotal = 0;
			    		lifetime = 0;
					    for (AchievementsPrice achievement : achievementsList) 
					    {
				    		 
				    		 if((achievement!=null)&&month.equals(achievement.getCdate().substring(4, 6))&&Type.getTypesmatkl().equals(achievement.getMatkl())&&achievement.getStprs()!="")
				    		 {
								 Inventorcost = Inventorcost+MathUtil.mul(achievement.getZqmsl(), achievement.getStprs());
								 startcost = startcost+MathUtil.mul(achievement.getZqcsl(), achievement.getStprs()); 
								 KPIValue.setInventoryValue(Inventorcost);
								 KPIValue.setStartValue(startcost); 
				    		 }
				    		 if((achievement.getWgbez()!=null)&&month.equals(achievement.getCdate().substring(4, 6))&&Type.getTypesmatkl().equals(achievement.getMatkl())&&(achievement.getLgort().equals("P001")|| achievement.getLgort().equals("R001"))&&achievement.getStprs()!="")
				    		 
				    		   { 
				    			 badtotal = badtotal + MathUtil.mul(achievement.getZqmsl(), achievement.getStprs());	
				    			 KPIValue.setIdleValue(badtotal);
				    		   }
				    			
					    }
					    if(KPIValue.getExpenseValue()!=0)
						{
					    	KPIValue.setDaytime((int) Math.round(((KPIValue.getStartValue() + KPIValue.getInventoryValue()) / 2) / KPIValue.getExpenseValue() * daycount));
						}
					    for(KPIReport kpilist:LifetimeList) {
					    	if(Type.getTypesmatkl().equals(getValue(kpilist.getMatkl()))&&kpilist.getMonthdate().equals(year+month))
				    			lifetime=lifetime+(int) MathUtil.mul(kpilist.getZprice(),kpilist.getZqty());
					    }
					      KPIValue.setLifetime((int)Math.round(lifetime));
					    KPIlist.add(KPIValue);
					    set.add(Type.getMaterialtype());
					}
			}
				List<KPIReportVo> total = new ArrayList<KPIReportVo>();
				List<Integer> lastTotal = new ArrayList<Integer>();
					double sum1 = 0, sum2=0, sum3=0, startsum=0, totalday=0, totallife=0;
				for(String Group:set)
				{  
					KPIReportVo  allvalue = new  KPIReportVo();
					double expanse=0.0;
					double idel=0.0;
					double invent=0.0;
					double start=0.0;
					double days=0.0;
					double life=0.0;
					for(int m = 0;m<KPIlist.size();m++)
					{  	
						 if(Group.equals(KPIlist.get(m).getGroup()))
						{
						  expanse=expanse+KPIlist.get(m).getExpenseValue();
						  idel=idel+KPIlist.get(m).getIdleValue();
						  invent=invent+KPIlist.get(m).getInventoryValue();
						  start=start+KPIlist.get(m).getStartValue();
						  life=life+KPIlist.get(m).getLifetime();
						}
						 if(expanse!=0)
						 {
							 days =Math.round(((((start + invent) / 2) /expanse) * daycount));
						 }
				    }
					  sum1=sum1+expanse;
					  sum2=sum2+invent;
					  sum3=sum3+idel;
					  totallife=totallife+life;
					  startsum=startsum+start;
					allvalue.setType("Subtotal");
					allvalue.setGroup(Group);
					allvalue.setExpenseValue(expanse);
					allvalue.setIdleValue(idel);
					allvalue.setInventoryValue(invent); 
					allvalue.setStartValue(start);
					allvalue.setDaytime((int)days);
					allvalue.setLifetime((int)life);
					total.add(allvalue);
				}
				   if(sum1 != 0)
				    totalday=((startsum+sum2)/2/new Double(Math.round(sum1)).intValue())*daycount;
				    System.out.println("day"+totalday);
				for(int j=0;j<KPIlist.size();j++)
				{
					KPIReportVo obj1 = KPIlist.get(j);
					if(sum2 != 0)
					obj1.setInventoryRate(new BigDecimal((KPIlist.get(j).getInventoryValue()/sum2)*100).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
					else obj1.setInventoryRate(0);
					if(sum3 != 0)
					obj1.setIdleRate(new BigDecimal((KPIlist.get(j).getIdleValue()/sum3)*100).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
					else obj1.setIdleRate(0);
					if(sum1 != 0)
					obj1.setExpenseRate(new BigDecimal((KPIlist.get(j).getExpenseValue()/sum1)*100).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
					else obj1.setExpenseRate(0);
					obj1.setExpenseValue(Math.round(KPIlist.get(j).getExpenseValue()));
					obj1.setInventoryValue(Math.round(KPIlist.get(j).getInventoryValue()));
					obj1.setIdleValue(Math.round(KPIlist.get(j).getIdleValue()));
				}
				for(int j=0;j<total.size();j++)
				{
					KPIReportVo obj1 = total.get(j);
					if(sum2 != 0)
					obj1.setInventoryRate(new BigDecimal((total.get(j).getInventoryValue()/sum2)*100).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
					else obj1.setInventoryRate(0);
					if(sum3 != 0)
					obj1.setIdleRate(new BigDecimal((total.get(j).getIdleValue()/sum3)*100).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
					else obj1.setIdleRate(0);
					if(sum1 != 0)
					obj1.setExpenseRate(new BigDecimal((total.get(j).getExpenseValue()/sum1)*100).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
					else obj1.setExpenseRate(0);
					obj1.setExpenseValue(Math.round(total.get(j).getExpenseValue()));
					obj1.setInventoryValue(Math.round(total.get(j).getInventoryValue()));
					obj1.setIdleValue(Math.round(total.get(j).getIdleValue()));
				}
				
		lastTotal.add((int) Math.round(sum1));
		lastTotal.add((int) Math.round(sum2));
		lastTotal.add((int) Math.round(sum3));
		lastTotal.add((int) Math.round(totalday));
		lastTotal.add((int) totallife);
		
		model.addAttribute("Grouplist", set);
		model.addAttribute("KPIvalue", KPIlist);
		model.addAttribute("totalvalue", total);
		model.addAttribute("lasttotal", lastTotal);
		model.addAttribute("mon", mon);
		return "/report4/report4";
	}

	/**
	 * 去除中文
	 * 
	 * @return
	 */
	public String getValue(String value) {
		Pattern pat = Pattern.compile(REGEX_CHINESE);
		Matcher mat = pat.matcher(value);
		String materialType = mat.replaceAll("").trim();

		Pattern pattern = Pattern.compile("[a-zA-Z0-9]");
		Matcher matcher = pattern.matcher(materialType);
		if (matcher.find()) {
			int index = materialType.indexOf(matcher.group());
			if (index > 0) {
				materialType = materialType.substring(index, materialType.length());
			}
		}
		return materialType;
	}
	public String getGroup(String matkl) {
		List<MaterialType> getmatkl = kpiReportService.getMatkl();
		String material="";
		for(MaterialType matkl1:getmatkl) {
			if(matkl1.getTypesmatkl().equals(matkl))
				material=getValue(matkl1.getType());
		}
     return material;
	}

	public Double getAmount(List<InventoryResult> resultList, String yearMon, String typeName) {
		double amount = 0;
		for (InventoryResult result : resultList) {
			// 格式化日期格式为201901
			String date = DateUtil.formatDate(result.getDate()).replaceAll("-", "");
			if (yearMon.equals(date) && typeName.equals(result.getWgbez())) {
				double price = 0;
				if (SapConstant.VPRSV_VALUES.equals(result.getVprsv())) {
					price = MathUtil.mul(result.getErfmg(), result.getStprs());
				} else if (SapConstant.VPRSV_VALUEV.equals(result.getVprsv())) {
					price = MathUtil.mul(result.getErfmg(), result.getVerpr());
				}
				if (SapConstant.BWART_VALUE201.equals(result.getBwart())) {
					amount = amount + price;
				} else if (SapConstant.BWART_VALUE202.equals(result.getBwart())) {
					amount = amount - price;
				}
			}
		}
		return amount;
	}
	public static void main(String[] args) {
		int year1 = Calendar.getInstance().get(Calendar.YEAR);
		 BigDecimal a=new BigDecimal("123456789");  
         DecimalFormat df=new DecimalFormat(",###,##0"); //没有小数  
		 df.format(a);
		 System.out.println(df.format(a));
		
	}
	
}
