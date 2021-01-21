package com.movie.test.service.impl;

import java.util.List;
import java.util.Map;

import com.movie.test.dao.ParkDAO;
import com.movie.test.dao.impl.ParkDAOImpl;
import com.movie.test.service.ParkService;

public class ParkServiceImpl implements ParkService {
// 인터페이스를 추가해서 클래스 만들기
	
	private ParkDAO pDAO = new ParkDAOImpl();
	@Override
	public List<Map<String, String>> selectParkList() {
		return pDAO.selectParkList();
	}

	@Override
	public Map<String, String> selectPark(int tpNum) {
		return pDAO.selectPark(tpNum);
	}

	@Override
	public int insertPark(Map<String, String> park) {
		return pDAO.insertPark(park);
	}

	@Override
	public int updatePark(Map<String, String> park) {
		return pDAO.updatePark(park);
	}

	@Override
	public int deletePark(int tpNum) {
		return pDAO.deletePark(tpNum);
	}

}
