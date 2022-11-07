package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import domain.Free;
import repository.FreeDAO;

public class FreeModifyService implements FreeService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String title = request.getParameter("title");
		long freeNo = Long.parseLong(request.getParameter("freeNo"));

		// DB로 보낼 Board board 생성
		Free free = new Free();
		free.setTitle(title);
		free.setFreeNo(freeNo);
		System.out.println(title);
		System.out.println(freeNo);
		// DB로 Board board 보내기(수정)
		int result = FreeDAO.getInstance().updateFree(free);

		// 수정 성공 / 실패
		PrintWriter out = response.getWriter();
		if (result > 0) {
			out.println("<script>");
			out.println("alert('게시글이 수정되었습니다.')");
			out.println(
					"location.href='" + request.getContextPath() + "/BoardProject/detail.do?freeNo=" + freeNo + "'");
			out.println("</script>");
		}
		out.close();

		return null;
	}
}
