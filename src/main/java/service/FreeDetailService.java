package service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ActionForward;
import domain.Free;
import repository.FreeDAO;

public class FreeDetailService implements FreeService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Optional<String> opt = Optional.ofNullable(request.getParameter("freeNo"));
		int freeNo = Integer.parseInt(opt.orElse("0"));
		Optional<String> opt2 = Optional.ofNullable(request.getParameter("hit"));
		Long hit = Long.parseLong(opt2.orElse("0"));
		
		Free free = new Free();
		

		String referer = request.getHeader("referer"); 
		HttpSession session = request.getSession();
		if(referer.endsWith("list.do") && session.getAttribute("updateHit") == null) {  
			FreeDAO.getInstance().updateHit(freeNo);
			free.setHit(hit);
			session.setAttribute("updateHit", "done");
		}
		
		
		
		free = FreeDAO.getInstance().selectFreeByNo(freeNo);

		if (free != null) {
			request.setAttribute("free", free);
			ActionForward af = new ActionForward();
			af.setView("/free/detail.jsp");
			af.setRedirect(false);
			return af;
		}
		return null;
	}
}
