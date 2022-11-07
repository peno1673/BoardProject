package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ActionForward;
import repository.FreeDAO;

public class FreeListService implements FreeService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		if(session.getAttribute("updateHit") != null) {
			session.removeAttribute("updateHit");
		}
		
		
		request.setAttribute("frees", FreeDAO.getInstance().selectAllFrees());
		
		ActionForward af = new ActionForward();
		af.setView("/free/list.jsp");
		af.setRedirect(false);
		return af;
	}

}
