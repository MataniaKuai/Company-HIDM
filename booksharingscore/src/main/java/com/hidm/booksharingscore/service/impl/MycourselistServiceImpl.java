package com.hidm.booksharingscore.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hidm.booksharingscore.dao.MycourselistDao;
import com.hidm.booksharingscore.entity.Course;
import com.hidm.booksharingscore.service.MycourselistService;
import com.hidm.booksharingscore.vo.MyCourseSearchVo;

@Service(value = "MycourselistService")
public class MycourselistServiceImpl implements MycourselistService {
	private static final Logger log = LoggerFactory.getLogger(MycourselistServiceImpl.class);
    
    @Autowired
    private MycourselistDao mycourseDao;

	
	@Override
	public int count(MyCourseSearchVo course) {
		return mycourseDao.count(course);
	}
	@Override
	public List<Course> mycourse(MyCourseSearchVo course) {
		return mycourseDao.mycourse(course);
	}
}
