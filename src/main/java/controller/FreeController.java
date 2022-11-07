package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import service.FreeAddService;
import service.FreeDetailService;
import service.FreeListService;
import service.FreeModifyService;
import service.FreeRemoveService;
import service.FreeService;

@WebServlet("*.do")

public class FreeController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String urlMapping = requestURI.substring(contextPath.length());

		FreeService service = null;

		ActionForward af = null;

		switch (urlMapping) {
		case "/BoardProject/list.do":
			service = new FreeListService();
			break;
		case "/BoardProject/add.do":
			service = new FreeAddService();
			break;
		case "/BoardProject/remove.do":
			service = new FreeRemoveService();
			break;
		case "/BoardProject/detail.do":
			service = new FreeDetailService();
			break;
		case "/BoardProject/edit.do":
			service = new FreeModifyService();
			break;
			
		case "/BoardProject/insertPage.do":
			af = new ActionForward();
			af.setView("/free/insert.jsp");
			af.setRedirect(false);
			break;
		}	
		
		
		try {
			if(service != null) {
				af = service.execute(request, response);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}

		if (af != null) {
			if (af.isRedirect()) {
				response.sendRedirect(af.getView());
			} else {
				request.getRequestDispatcher(af.getView()).forward(request, response);
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
