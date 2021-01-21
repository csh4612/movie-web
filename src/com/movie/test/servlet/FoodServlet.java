package com.movie.test.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movie.test.service.FoodService;
import com.movie.test.service.impl.FoodServiceImpl;


public class FoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String PREFIX = "/WEB-INF/views";
	private final String SUFFIX = ".jsp";
	private FoodService fService = new FoodServiceImpl();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/");
		String cmd = uri.substring(idx+1);
		String path = "";
		if("list".equals(cmd)) {
			path = "/food/food-list";
			List<Map<String,String>> foodList = fService.selectFoodList();
			request.setAttribute("list", foodList);
		}else if("insert".equals(cmd)) {
			path = "/food/food-insert";
		}else if("update".equals(cmd)) {
			path = "/food/food-update";
			String fiNum = request.getParameter("fi_num");
			Map<String,String> food = fService.selectFood(Integer.parseInt(fiNum));
			request.setAttribute("food", food);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(PREFIX + path + SUFFIX);
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/");
		String cmd = uri.substring(idx+1);
		String path = "";
		
		if("insert".equals(cmd)) {
			Map<String,String> food = new HashMap<String,String>();
			food.put("fi_name",request.getParameter("fi_name"));
			food.put("fi_price",request.getParameter("fi_price"));
			food.put("fi_type",request.getParameter("fi_type"));
			int cnt = fService.insertFood(food);
			String msg = "음식 등록이 성공하였습니다.";
			if(cnt!=1) {
				msg = "음식 등록이 실패하였습니다.";
			}
			request.setAttribute("msg", msg);
		}else if("update".equals(cmd)) {
			Map<String,String> food = new HashMap<String,String>();
			food.put("fi_name",request.getParameter("fi_name"));
			food.put("fi_price",request.getParameter("fi_price"));
			food.put("fi_type",request.getParameter("fi_type"));
			food.put("fi_num", request.getParameter("fi_num"));
			int cnt = fService.updateFood(food);
			String msg = "음식 수정이 성공하였습니다.";
			if(cnt!=1) {
				msg = "음식 수정이 실패하였습니다.";
			}
			request.setAttribute("msg", msg);
		}else if("delete".equals(cmd)) {
			String fiNum = request.getParameter("fi_num");
			int cnt = fService.deleteFood(Integer.parseInt(fiNum));
			String msg = "음식이 삭제되었습니다.";
			if(cnt!=1) {
				msg = "음식 삭제가 실패하였습니다.";
			}
			request.setAttribute("msg", msg);
		}
		RequestDispatcher rd = request.getRequestDispatcher(PREFIX + "/food/result" + SUFFIX);
		rd.forward(request, response);		
	}

}
