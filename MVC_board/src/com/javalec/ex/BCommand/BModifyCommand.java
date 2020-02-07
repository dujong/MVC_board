package com.javalec.ex.BCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.BDAO.BDao;
import com.javalec.ex.BDTO.BDto;

public class BModifyCommand implements BCommand{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String BId = request.getParameter("BId");
		String BName = request.getParameter("BName");
		String BTitle = request.getParameter("BTitle");
		String BContent = request.getParameter("BContent");
		
		BDao dao = new BDao();
		dao.Modify(BName, BTitle, BContent, BId);
		
	}

}
