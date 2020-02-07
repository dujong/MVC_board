package com.javalec.ex.frontController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.BCommand.BCommand;
import com.javalec.ex.BCommand.BContentCommand;
import com.javalec.ex.BCommand.BDeleteCommand;
import com.javalec.ex.BCommand.BListCommand;
import com.javalec.ex.BCommand.BModifyCommand;
import com.javalec.ex.BCommand.BReplyCommand;
import com.javalec.ex.BCommand.BReplyViewCommand;
import com.javalec.ex.BCommand.BWriteCommand;


@WebServlet("/*.do")
public class BFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public BFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		actionDo(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("actionDo");
		
		request.setCharacterEncoding("EUC-KR");
		
		String viewPage = null;
		BCommand command = null;
		
		String url = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = url.substring(conPath.length());
		
		if(com.equals("/write_view.do")) {		
			viewPage = "write_view.jsp";
		}
		else if(com.equals("/wirte.do")) {
			command = new BWriteCommand();
			command.execute(request, response);
			viewPage = "list.do";
		}
		else if(com.equals("/list.do")) {
			command = new BListCommand();
			command.execute(request, response);
			viewPage = "list.jsp";
		}
		else if(com.equals("/content_view.do")) {
				command = new BContentCommand();
				command.execute(request, response);
				viewPage = "content_view";
			}
		else if(com.equals("/modify.do")) {
			command = new BModifyCommand();
			command.execute(request, response);
			viewPage = "list.do";
				}
		else if(com.equals("delete.do")) {
			command = new BDeleteCommand();
			command.execute(request, response);
			viewPage = "list.do";
		}
		else if(com.equals("/reply_view.do"))
		{
			command = new BReplyViewCommand();
			command.execute(request, response);
			viewPage = "reply_view.jsp";
		}
		else if(com.equals("/reply.do")) {
			command = new BReplyCommand();
			command.execute(request, response);
			viewPage = "list.do";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
