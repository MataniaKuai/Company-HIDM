package com.hidm.coo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hidm.coo.dao.ReportDao;
import com.hidm.coo.service.ReportService;
import com.hidm.coo.vo.ReportSearchVo;
import com.hidm.coo.vo.ReportVo;

@Service(value = "reportService")
public class ReportServiceImpl implements ReportService {

	@Autowired
	private ReportDao reportDao;

	@Override
	public List<ReportVo> selectList(ReportSearchVo report) {
		return reportDao.selectList(report);
	}

	
}
