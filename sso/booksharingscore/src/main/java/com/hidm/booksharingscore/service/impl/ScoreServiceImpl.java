package com.hidm.booksharingscore.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hidm.booksharingscore.dao.ScoreDao;
import com.hidm.booksharingscore.entity.Score;
import com.hidm.booksharingscore.service.ScoreService;
import com.hidm.booksharingscore.vo.ScoreSearchVo;
import com.hidm.booksharingscore.vo.ScoreVo;


@Service(value = "scoreService")
public class ScoreServiceImpl implements ScoreService {
	private static final Logger log = LoggerFactory.getLogger(ScoreServiceImpl.class);
    
    @Autowired
    private ScoreDao scoreDao;

	@Override
	public int count(ScoreSearchVo vo) {
		// TODO Auto-generated method stub
		return scoreDao.count(vo);
	}

	@Override
	public List<ScoreVo> selectList(ScoreSearchVo vo) {
		// TODO Auto-generated method stub
		return scoreDao.selectList(vo);
	}

	@Override
	public void insert(Score score) {
		// TODO Auto-generated method stub
		scoreDao.insert(score);
	}

	@Override
	public void updateById(Score score) {
		// TODO Auto-generated method stub
		scoreDao.updateById(score);
		
	}

	@Override
	public int countByCidUid(Score score) {
		return scoreDao.countByCidUid(score);
	}

	@Override
	public int countRater(Long id) {
		return scoreDao.countRater(id);
	}

	@Override
	public List<ScoreVo> selectUserByCourseId(Long id) {
		return scoreDao.selectUserByCourseId(id);
	}

	@Override
	public void deleteByCourseId(Long courseId) {
		scoreDao.deleteByCourseId(courseId);
		
	}

	@Override
	public void insertScoreList(List<Score> scoreList) {
		scoreDao.insertScoreList(scoreList);
		
	}
}
