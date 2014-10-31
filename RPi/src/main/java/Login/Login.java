package Login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/doLogin")
public class Login extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html;charset=UTF-8");
		String pass = request.getParameter("pass");

		if(new Validate().checkUser(pass)) {
			HttpSession session = request.getSession();
			session.setAttribute("sessionId", "ingelogd");
			session.setMaxInactiveInterval(30*60);
			response.sendRedirect(response.encodeURL("./"));
		} else {
			System.out.println("nietyay");

			RequestDispatcher rd = request.getRequestDispatcher(response.encodeRedirectURL("./")); 
			PrintWriter out= response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Either your name or password was incorrect.');");
			out.println("window.open('Login', '_parent');");
			out.println("</script>");
			
			rd.include(request, response);
		}
	}
	
}
