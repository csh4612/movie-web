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

import com.movie.test.service.TheaterService;
import com.movie.test.service.impl.TheaterServiceImpl;

public class TheaterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String PREFIX = "/WEB-INF/views";
	private final String SUFFIX = ".jsp";
	private TheaterService tService = new TheaterServiceImpl();
	/*
	 * http
	 * 1개의 요청 - 1개의 응답 으로 이루어져 있음
	 * request - response
	 * MVC패선의 시작 , Model, View, Controller
	 */ 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/");
		String cmd = uri.substring(idx+1);
		String path = "";
		if("list".equals(cmd)) {
			path = "/theater/theater-list";
			List<Map<String,String>> theaterList = tService.selectTheaterList();
			request.setAttribute("list", theaterList);
		}else if("insert".equals(cmd)) {
			path = "/theater/theater-insert";
		}else if("update".equals(cmd)) {
			path = "/theater/theater-update";
			String tiNum = request.getParameter("ti_num");
			Map<String,String> theater = tService.selectTheater(Integer.parseInt(tiNum));
			request.setAttribute("theater", theater);
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
		System.out.println("cmd : " + cmd);
		if("insert".equals(cmd)) {
			Map<String,String> theater = new HashMap<String,String>();
			theater.put("ti_name",request.getParameter("ti_name"));
			theater.put("ti_address",request.getParameter("ti_address"));
			theater.put("ti_phone1",request.getParameter("ti_phone1"));
			theater.put("ti_phone2",request.getParameter("ti_phone2"));
			int cnt = tService.insertTheater(theater);
			String msg = "영화관 등록이 성공하였습니다.";
			if(cnt!=1) {
				msg = "영화관 등록이 실패하였습니다.";
			}
			request.setAttribute("msg", msg);
		}else if("update".equals(cmd)) {
			Map<String,String> theater = new HashMap<String,String>();
			theater.put("ti_name",request.getParameter("ti_name"));
			theater.put("ti_address",request.getParameter("ti_address"));
			theater.put("ti_phone1",request.getParameter("ti_phone1"));
			theater.put("ti_phone2",request.getParameter("ti_phone2"));
			theater.put("ti_num", request.getParameter("ti_num"));
			int cnt = tService.updateTheater(theater);
			String msg = "영화관 수정이 성공하였습니다.";
			if(cnt!=1) {
				msg = "영화관 수정이 실패하였습니다.";
			}
			request.setAttribute("msg", msg);
		}else if("delete".equals(cmd)) {
			String tiNum = request.getParameter("ti_num");
			int cnt = tService.deleteTheater(Integer.parseInt(tiNum));
			String msg = "영화관이 삭제되었습니다.";
			if(cnt!=1) {
				msg = "영화관 삭제가 실패하였습니다.";
			}
			request.setAttribute("msg", msg);
		}
		RequestDispatcher rd = request.getRequestDispatcher(PREFIX + "/theater/result" + SUFFIX);
		rd.forward(request, response);		
	}

}
