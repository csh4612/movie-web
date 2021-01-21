package com.movie.test.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final int FILE_MAX_SIZE = 10 * 1024 * 1024;  // 10메가
    private final int TOTAL_MAX_SIZE = FILE_MAX_SIZE * 10; //100메가
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean check = ServletFileUpload.isMultipartContent(request);
		System.out.println("요청 객체가 파일 전송할 수 있는 애 맞니? : " + check);
		
		if(!check) {
			throw new ServletException("form태그의 enctype을 확인해주세요");
		}
		DiskFileItemFactory dfiFactory = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(dfiFactory);
		sfu.setFileSizeMax(FILE_MAX_SIZE);
		sfu.setSizeMax(TOTAL_MAX_SIZE);
		
		try {
			List<FileItem> fiList = sfu.parseRequest(request);
			for(int i=0;i<fiList.size();i++) {
				FileItem fi = fiList.get(i);
				String tagName = fi.getFieldName();
				if(fi.isFormField()) {
					System.out.println(tagName + "<- 애는 FormField임");
					String value = fi.getString("UTF-8");
					System.out.println("값 : " + value);
				}else {
					System.out.println(tagName + "<- 애는 FormField가 아니고 FileField임");
					String fileName = fi.getName();
					System.out.println("업로드한 파일 이름 : " + fileName);
					File targetFile = new File("C:\\Users\\Admin\\Desktop\\java\\movie-web\\WebContent\\" + fileName);
					fi.write(targetFile);
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		doGet(request, response);
	}

}
