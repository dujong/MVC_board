package com.javalec.ex.BCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.javalec.ex.BDAO.BDao;

public class BWriteCommand implements BCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String BName = request.getParameter("BName");
		String BTitle = request.getParameter("BTitle");
		String BContent = request.getParameter("BContent");
		System.out.println(BName);
		BDao dao = new BDao();
		dao.write(BName,BTitle,BContent);
		
	}

}
