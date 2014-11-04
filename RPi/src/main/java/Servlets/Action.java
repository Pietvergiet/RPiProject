package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Gpio.GPIO;

@WebServlet("/doAction")
@SuppressWarnings("serial")
public class Action extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html;charset=UTF-8");
		RequestDispatcher rd = request.getRequestDispatcher(response.encodeRedirectURL("/Action")); 
		//GPIO.setUnstable_Ack();
		String action = (String) request.getParameter("button");
		if (action.contains("List")) {
			System.out.println(action);
			GPIO.pSetupSend();
			GPIO.setAction();
			GPIO.setList();
			GPIO.setStable_Ack();
			GPIO.waitAck_Stable();
			String devId = request.getParameter("devId");
			GPIO.sendInts(GPIO.turnStringtoInt(devId));
			GPIO.pSetupRecieve();
			Map<Integer, String> lijst = GPIO.getList();
			GPIO.pSetupSend();
			/*Map<Integer, String> examp = new TreeMap<Integer, String>(); 
			examp.put(1, "AAN/UIT");
			examp.put(2, "Next");
			examp.put(3, "PREV");
			examp.put(4, "Harder");
			examp.put(5, "Zachter");*/
			request.setAttribute("actionList", lijst);
			request.getRequestDispatcher("/Dynamic.jsp").forward(request, response);
		} else if (action.equals("Remove")) {
			System.out.println(action);
			GPIO.pSetupSend();
			GPIO.setAction();
			GPIO.setRemove();
			GPIO.setStable_Ack();
			GPIO.waitAck_Stable();
			String actId = request.getParameter("actId");
			GPIO.sendInts(GPIO.turnStringtoInt(actId));
			GPIO.pSetupRecieve();
			GPIO.waitAck_Stable();
			String s = GPIO.getSucces();
			GPIO.sendAck();
			GPIO.pSetupSend();
			//String s = "Act id: " + request.getParameter("actId");
			PrintWriter out= response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('" + s + "');");
			out.println("</script>");
			out.println(s);

			rd.include(request, response);
		} else if (action.equals("Record")) {
			System.out.println(action);
			GPIO.pSetupSend();
			GPIO.setAction();
			GPIO.setAdd();
			GPIO.setStable_Ack();
			GPIO.waitAck_Stable();
			int newId = Integer.parseInt(request.getParameter("nActId"));
			int nId[] = {newId};
			String newName = request.getParameter("nActNam");
			GPIO.sendInts(nId);
			GPIO.sendInts(GPIO.turnStringtoInt(GPIO.make16Chars(newName)));
			GPIO.pSetupRecieve();
			GPIO.waitAck_Stable();
			int id = GPIO.getIntInput();
			GPIO.sendAck();
			GPIO.pSetupSend();
			//String id = request.getParameter("nActId") + " --- " + request.getParameter("nActNam");
			PrintWriter out= response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('" + id + " is het nieuwe action id!');");
			out.println("</script>");
			out.println(id + "is het nieuwe device id!");
			rd.include(request, response);
		} else if (action.equals("Execute")) {
			System.out.println(action);
			GPIO.pSetupSend();
			GPIO.setAction();
			GPIO.setExecute();
			GPIO.setStable_Ack();
			GPIO.waitAck_Stable();
			int exeId = Integer.parseInt(request.getParameter("actIdexe"));
			int eId[] = {exeId};
			GPIO.sendInts(eId);
			GPIO.pSetupRecieve();
			GPIO.waitAck_Stable();
			String s = GPIO.getSucces();
			GPIO.sendAck();
			GPIO.pSetupSend();
			//String s = request.getParameter("actIdexe");
			PrintWriter out= response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('" + s + "');");
			out.println("</script>");
			out.println(s);
			rd.include(request, response);
		} else {
			System.out.println("PANIEK PANIEK PANIEK ER IS IETS OF IEMAND FOUT BEZIGN OMG OMG OMG ABORT ABORT ABORT");
		}
		
		
		
		//sresponse.sendRedirect(response.encodeURL(request.getHeader("Referer")));
	}
}
