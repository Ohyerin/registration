package registrations.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import registrations.controller.EnrollController;
import registrations.controller.LoginController;
//import registrations.controller.ShowController;
import registrations.controller.Controller;

public class FrontController extends HttpServlet {
	HashMap<String, Controller> map = null;
		@Override
		public void init(ServletConfig config) throws ServletException {
			// TODO Auto-generated method stub
			map = new HashMap<String, Controller>();
			map.put("/login.do", new LoginController());
			map.put("/enroll.do", new EnrollController());
			map.put("/showList.do", new ShowController());
		}
		
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			String contextP = req.getContextPath();
			String url = req.getRequestURI();
			String path = url.substring(contextP.length());
			Controller cont = map.get(path);
			cont.execute(req, resp);
		}
}
