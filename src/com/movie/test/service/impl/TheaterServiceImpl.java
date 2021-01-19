package com.movie.test.service.impl;

import java.util.List;
import java.util.Map;

import com.movie.test.dao.TheaterDAO;
import com.movie.test.dao.impl.TheaterDAOImpl;
import com.movie.test.service.TheaterService;

public class TheaterServiceImpl implements TheaterService {
	private TheaterDAO tDao = new TheaterDAOImpl();

	@Override
	public List<Map<String, String>> selectTheaterList() {
		return tDao.selectTheaterList();
	}

	@Override
	public Map<String, String> selectTheater(int tiNum) {
		return tDao.selectTheater(tiNum);
	}

	@Override
	public int insertTheater(Map<String, String> theater) {
		return tDao.insertTheater(theater);
	}

	@Override
	public int updateTheater(Map<String, String> theater) {
		return tDao.updateTheater(theater);
	}

	@Override
	public int deleteTheater(int tiNum) {
		return tDao.deleteTheater(tiNum);
	}

}
