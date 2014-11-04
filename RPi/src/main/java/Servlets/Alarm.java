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

@WebServlet("/getAlarm")
@SuppressWarnings("serial")
public class Alarm extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html;charset=UTF-8");
		RequestDispatcher rd = request.getRequestDispatcher(response.encodeRedirectURL("/Alarm")); 
		/*GPIO.setUnstable_Ack();
		GPIO.pSetupSend();*/
		String action = (String) request.getParameter("button");
		if (action.contains("List")) {
			GPIO.setAlarm();
			GPIO.setList();
			GPIO.setStable_Ack();
			GPIO.waitAck_Stable();
			GPIO.pSetupRecieve();
			Map<Integer, String[]> lijst = GPIO.getAlarmList();
			GPIO.pSetupSend();
			/*Map<Integer, String[]> examp = new TreeMap<Integer, String[]>();
			String id = "5";
			String tijd = "12:30";
			String name = "uitslapen";
			String[] arrr = {tijd, id, name};
			examp.put(1, arrr);
			examp.put(2, arrr);
			examp.put(3, arrr);
			examp.put(4, arrr);
			examp.put(5, arrr);*/
			request.setAttribute("alarmList", lijst);
			request.getRequestDispatcher("/Dynamic.jsp").forward(request, response);
			
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
			out.println("</script>");
			out.println(s);

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
			out.println("</script>");
			out.println(s);

			rd.include(request, response);
		}
	}	

}
