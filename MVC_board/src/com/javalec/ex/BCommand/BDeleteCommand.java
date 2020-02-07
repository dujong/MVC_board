package com.javalec.ex.BCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.BDAO.BDao;

public class BDeleteCommand implements BCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String BId = request.getParameter("BId");
		BDao  dao = new BDao();
		dao.delete(BId);
		
	}

}
