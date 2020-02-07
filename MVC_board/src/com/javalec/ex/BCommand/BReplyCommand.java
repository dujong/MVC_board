package com.javalec.ex.BCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.BDAO.BDao;

public class BReplyCommand implements BCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String BId = request.getParameter("BId");
		String BName = request.getParameter("BName");
		String BTitle = request.getParameter("BTitle");
		String BContent = request.getParameter("BContent");
		String BGroup = request.getParameter("BGroup");
		String BStep = request.getParameter("BStep");
		String BIndent = request.getParameter("BIndent");
		
		BDao dao = new BDao();
		dao.reply(BName, BTitle, BContent, BGroup, BStep, BIndent);
		
	}

}
