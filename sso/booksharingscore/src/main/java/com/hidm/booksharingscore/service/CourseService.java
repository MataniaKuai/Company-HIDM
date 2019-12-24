package com.hidm.booksharingscore.service;

import java.util.List;

import com.hidm.booksharingscore.entity.Course;
import com.hidm.booksharingscore.entity.Score;
import com.hidm.booksharingscore.vo.CourseSearchVo;
import com.hidm.booksharingscore.vo.SigninInfoSearchVo;



public interface CourseService {

    public int insert(Course course);
   
    public void updateById(Course course);
    
    public int count(CourseSearchVo vo);
    
    
    public List<Course> selectList(CourseSearchVo vo);
    
    public int deleteByIds(Long[] ids);

	public Course selectById(Long id);

	public void updateStatus(Course course);

	public List<Score> selectAssessment(Long id);

	public void updateAssessment(Course course);

	public List<Course> selectTodyInfoByPage(SigninInfoSearchVo vo);

	public List<Course> selectTodyInfo(String dateStr);

	public int countSpeaker(String employeeNo);

}
