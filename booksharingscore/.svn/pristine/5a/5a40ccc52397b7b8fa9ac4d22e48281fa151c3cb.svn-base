package com.hidm.booksharingscore.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hidm.booksharingscore.dao.CourseDao;
import com.hidm.booksharingscore.entity.Course;
import com.hidm.booksharingscore.entity.Score;
import com.hidm.booksharingscore.service.CourseService;
import com.hidm.booksharingscore.vo.CourseSearchVo;
import com.hidm.booksharingscore.vo.SigninInfoSearchVo;


@Service(value = "importInfoService")
public class CourseServiceImpl implements CourseService {
	private static final Logger log = LoggerFactory.getLogger(CourseServiceImpl.class);
    
    @Autowired
    private CourseDao courseDao;
    
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public int insert(Course course) {
        return courseDao.insert(course);
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public void updateById(Course course) {
    	courseDao.updateById(course);
		
	}

	@Override
	public int count(CourseSearchVo course) {
		// TODO Auto-generated method stub
		return courseDao.count(course);
	}

	@Override
	public List<Course> selectList(CourseSearchVo course) {
		// TODO Auto-generated method stub
		return courseDao.selectList(course);
	}

	@Override
	public int deleteByIds(Long[] ids) {
		return courseDao.deleteByIds(ids);
	}

	@Override
	public Course selectById(Long id) {
		// TODO Auto-generated method stub
		return courseDao.selectById(id);
	}

	@Override
	public void updateStatus(Course course) {
		courseDao.updateStatus(course);
		
	}

	@Override
	public List<Score> selectAssessment(Long id) {

		return courseDao.selectAssessment(id);
	}

	@Override
	public void updateAssessment(Course course) {
		courseDao.updateAssessment(course);		
	}

	@Override
	public List<Course> selectTodyInfoByPage(SigninInfoSearchVo vo) {
		return courseDao.selectTodyInfoByPage(vo);
	}

	@Override
	public List<Course> selectTodyInfo(String dateStr) {
		return courseDao.selectTodyInfo(dateStr);
	}

	@Override
	public int countSpeaker(String employeeNo) {
		return courseDao.countSpeaker(employeeNo);
	}
    
    
}
