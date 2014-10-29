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

@WebServlet("/getAlarm")
@SuppressWarnings("serial")
public class Alarm extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html;charset=UTF-8");
		RequestDispatcher rd = request.getRequestDispatcher(response.encodeRedirectURL(request.getHeader("Referer"))); 
		GPIO.setUnstable_Ack();
		GPIO.pSetupSend();
		String action = (String) request.getParameter("button");
		if (action.contains("List")) {
			GPIO.setAlarm();
			GPIO.setList();
			GPIO.setStable_Ack();
			GPIO.waitAck_Stable();
			GPIO.pSetupRecieve();
			HashMap<Integer, Object[]> lijst = GPIO.getAlarmList();
			//TODO doe iets met lijst
			GPIO.pSetupSend();
		} else if (action.equals("Add")) {
			GPIO.setAlarm();
			GPIO.setAdd();
			GPIO.setStable_Ack();
			GPIO.waitAck_Stable();
			GPIO.sendTime(3, 3);
			int seqID = Integer.parseInt(request.getParameter("seqId"));
			int sID[] = {seqID};
			GPIO.sendInts(sID);
			GPIO.pSetupRecieve();
			GPIO.waitAck_Stable();
			String s = GPIO.getSucces();
			GPIO.sendAck();
			GPIO.pSetupSend();
			PrintWriter out= response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('" + s + "');");
			out.println("window.open('Alarm', '_parent');");
			out.println("</script>");

			rd.include(request, response);
		} else if (action.equals("Remove")) {
			GPIO.setAlarm();
			GPIO.setRemove();
			GPIO.setStable_Ack();
			GPIO.waitAck_Stable();
			int alId = Integer.parseInt(request.getParameter("alId"));
			int aID[] = {alId};
			GPIO.sendInts(aID);
			GPIO.pSetupRecieve();
			GPIO.waitAck_Stable();
			String s = GPIO.getSucces();
			GPIO.sendAck();
			GPIO.pSetupSend();
			PrintWriter out= response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('" + s + "');");
			out.println("window.open('Alarm', '_parent');");
			out.println("</script>");

			rd.include(request, response);
		}
	}	

}
