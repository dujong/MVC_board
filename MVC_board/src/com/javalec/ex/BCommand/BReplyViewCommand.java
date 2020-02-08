package com.javalec.ex.BCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.BDAO.BDao;
import com.javalec.ex.BDTO.BDto;

public class BReplyViewCommand implements BCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String BId = (String)request.getParameter("BId");
		BDao dao = new BDao();
		BDto dto = dao.reply_view(BId);
		
		request.setAttribute("reply_view", dto);
	}

}
