package com.hidm.booksharingscore.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hidm.booksharingscore.entity.Score;
import com.hidm.booksharingscore.vo.ScoreSearchVo;
import com.hidm.booksharingscore.vo.ScoreVo;

@Mapper
public interface ScoreDao {

	public int count(ScoreSearchVo score);

	public List<ScoreVo> selectList(ScoreSearchVo score);

	public void insert(Score score);

	public void updateById(Score score);

	public int countByCidUid(Score score);

	public int countRater(@Param("userid") Long id);

	public List<ScoreVo> selectUserByCourseId(@Param("courseid") Long id);

	public void deleteByCourseId(@Param("courseId") Long courseId);

	public void insertScoreList(List<Score> scoreList);

}
