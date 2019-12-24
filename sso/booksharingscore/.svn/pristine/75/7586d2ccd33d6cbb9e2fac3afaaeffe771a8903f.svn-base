package com.hidm.booksharingscore.service;

import java.util.List;

import com.hidm.booksharingscore.entity.Score;
import com.hidm.booksharingscore.vo.ScoreSearchVo;
import com.hidm.booksharingscore.vo.ScoreVo;



public interface ScoreService {

    public int count(ScoreSearchVo vo);
    
    public List<ScoreVo> selectList(ScoreSearchVo vo);

	public void insert(Score score);

	public void updateById(Score score);

	public int countByCidUid(Score score);

	public int countRater(Long id);

	public List<ScoreVo> selectUserByCourseId(Long id);

	public void deleteByCourseId(Long courseId);

	public void insertScoreList(List<Score> scoreList);
    
}
