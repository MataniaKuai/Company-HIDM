package com.hidm.booksharingscore.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hidm.booksharingscore.entity.Course;
import com.hidm.booksharingscore.entity.Score;
import com.hidm.booksharingscore.vo.CourseSearchVo;
import com.hidm.booksharingscore.vo.SigninInfoSearchVo;

@Mapper
public interface CourseDao {
    public int insert(Course course);

	public int count(CourseSearchVo course);

	public List<Course> selectList(CourseSearchVo course);

	public Course selectById(Long id);

	public void updateById(Course course);

	public int deleteByIds(Long[] ids);

	public void updateStatus(Course course);

	public List<Score> selectAssessment(Long id);

	public void updateAssessment(Course course);

	public List<Course> selectTodyInfoByPage(SigninInfoSearchVo vo);

	public List<Course> selectTodyInfo(@Param("dateStr") String dateStr);

	public int countSpeaker(@Param("employeeNo") String employeeNo);
   
}
