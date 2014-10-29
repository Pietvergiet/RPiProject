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

@WebServlet("/getDevice")
@SuppressWarnings("serial")
public class Device extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("AcIONTTTT!!");
		RequestDispatcher rd = request.getRequestDispatcher(response.encodeRedirectURL(request.getHeader("Referer"))); 
		String action = (String) request.getParameter("button");
		if (action.contains("List")) {
			System.out.println(action);
			GPIO.pSetupSend();
			GPIO.setDevice();
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
			GPIO.setDevice();
			GPIO.setRemove();
			GPIO.setStable_Ack();
			GPIO.waitAck_Stable();
			int devID = Integer.parseInt(request.getParameter("remDev"));
			int dId[] = {devID};
			GPIO.sendInts(dId);
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
		} else if (action.equals("Add")) {
			System.out.println(action);
			GPIO.pSetupSend();
			GPIO.setDevice();
			GPIO.setAdd();
			GPIO.setStable_Ack();
			String devName = request.getParameter("addDev");
			GPIO.sendInts(GPIO.turnStringtoInt(devName));
			GPIO.pSetupRecieve();
			GPIO.waitAck_Stable();
			int id = GPIO.getIntInput();
			GPIO.sendAck();
			GPIO.pSetupSend();
			PrintWriter out= response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('" + id + " is het nieuwe device id!');");
			out.println("window.open('Device', '_parent');");
			out.println("</script>");

			rd.include(request, response);
		} else {
			System.out.println("PANIEK PANIEK PANIEK ER IS IETS OF IEMAND FOUT BEZIGN OMG OMG OMG ABORT ABORT ABORT");
		}
		
		
		
		response.sendRedirect(response.encodeURL(request.getHeader("Referer")));
	}
}
