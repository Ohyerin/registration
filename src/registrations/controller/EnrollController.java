package registrations.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import registrations.controller.HttpUtil;
import registrations.service.Service;
import registrations.vo.Subject;

public class EnrollController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String count = request.getParameter("count");
		//String prof = request.getParameter("prof");
		
		HttpSession session = request.getSession();
		String prof = (String)session.getAttribute("prof");
		Subject subject = new Subject();
		subject.setId(id);
		subject.setName(name);
		subject.setCount(0);
		subject.setProf(prof);
		
		Service s = Service.getInstance();
		s.enrollSubject(subject);
		
		HttpUtil.forward(request, response, "/profEnroll.jsp");
	}

}
