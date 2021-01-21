package com.movie.test.service.impl;

import java.util.List;
import java.util.Map;

import com.movie.test.dao.FoodDAO;
import com.movie.test.dao.impl.FoodDAOImpl;
import com.movie.test.service.FoodService;

public class FoodServiceImpl implements FoodService {
	private FoodDAO fDAO = new FoodDAOImpl();

	@Override
	public List<Map<String, String>> selectFoodList() {
		// TODO Auto-generated method stub
		return fDAO.selectFoodList();
	}

	@Override
	public Map<String, String> selectFood(int fiNum) {
		// TODO Auto-generated method stub
		return fDAO.selectFood(fiNum);
	}

	@Override
	public int insertFood(Map<String, String> food) {
		// TODO Auto-generated method stub
		return fDAO.insertFood(food);
	}

	@Override
	public int updateFood(Map<String, String> food) {
		// TODO Auto-generated method stub
		return fDAO.updateFood(food);
	}

	@Override
	public int deleteFood(int fiNum) {
		// TODO Auto-generated method stub
		return fDAO.deleteFood(fiNum);
	}

}
