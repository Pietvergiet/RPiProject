package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

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
		System.out.println("AcIONTTTT!!");
		RequestDispatcher rd = request.getRequestDispatcher(response.encodeRedirectURL("/")); 
		GPIO.setUnstable_Ack();
		String action = (String) request.getParameter("button");
		if (action.contains("List")) {
			System.out.println(action);
			GPIO.pSetupSend();
			GPIO.setAction();
			GPIO.setList();
			GPIO.setStable_Ack();
			GPIO.waitAck_Stable();
			GPIO.pSetupRecieve();
			HashMap<Integer, String> lijst = GPIO.getList();
			//TODO doe iets met lijst
			GPIO.pSetupSend();
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
			PrintWriter out= response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('" + s + "');");
			out.println("window.open('Device', '_parent');");
			out.println("</script>");

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
			GPIO.sendInts(GPIO.turnStringtoInt(newName));
			GPIO.pSetupRecieve();
			GPIO.waitAck_Stable();
			int id = GPIO.getIntInput();
			GPIO.sendAck();
			GPIO.pSetupSend();
			PrintWriter out= response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('" + id + " is het nieuwe action id!');");
			out.println("window.open('Device', '_parent');");
			out.println("</script>");

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
			PrintWriter out= response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('" + s + "');");
			out.println("window.open('Device', '_parent');");
			out.println("</script>");

			rd.include(request, response);
		} else {
			System.out.println("PANIEK PANIEK PANIEK ER IS IETS OF IEMAND FOUT BEZIGN OMG OMG OMG ABORT ABORT ABORT");
		}
		
		
		
		response.sendRedirect(response.encodeURL(request.getHeader("Referer")));
	}
}
