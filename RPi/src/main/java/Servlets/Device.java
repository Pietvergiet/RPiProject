package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;

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
		//System.out.println("AcIONTTTT!!");
		RequestDispatcher rd;
		int length = 0;
		if (request.getParameter("dynamic") != null) {
			length = Integer.parseInt(request.getParameter("length"));
			rd = request.getRequestDispatcher("/Dynamic.jsp");
			//System.out.println("Dynamic");
		} else {
			rd = request.getRequestDispatcher(response.encodeRedirectURL("/Action"));
			//System.out.println("not dynamic");
		}
		String action = (String) request.getParameter("button");
		if (action.contains("List")) {
			//System.out.println(action);
			GPIO.pSetupSend();
			GPIO.setDevice();
			GPIO.setList();
			GPIO.setStable_Ack();
			GPIO.waitAck_Stable();
			GPIO.pSetupRecieve();
			Map<Integer, String> lijst = GPIO.getList();
			GPIO.pSetupSend();
			GPIO.pSetupSend();
			/*Map<Integer, String> examp = new TreeMap<Integer, String>(); 
			examp.put(1, "TV");
			examp.put(2, "DVD");
			examp.put(3, "RADIO");
			examp.put(4, "PS3");
			examp.put(5, "IRontvangerofo weet ik veel");*/
			request.setAttribute("deviceList", lijst);
			request.getRequestDispatcher("/Dynamic.jsp").forward(request, response);
		} else if (action.equals("Remove")) {
			//System.out.println(action);
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
			//String s = request.getParameter("remDev");
			PrintWriter out= response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('" + s + "');");
			out.println("</script>");
			out.println(s);
			if (request.getParameter("dynamic") == null) {
				rd.include(request, response);
			} else {
				request.setAttribute("succes", s);
				request.setAttribute("deviceList", getMap(length, request));
				//System.out.println(getMap(length, request).entrySet());
				rd.forward(request, response);
			}
		} else if (action.equals("Add")) {
			//System.out.println(action);
			GPIO.pSetupSend();
			GPIO.setDevice();
			GPIO.setAdd();
			GPIO.setStable_Ack();
			String devName = request.getParameter("addDev");
			GPIO.sendInts(GPIO.turnStringtoInt(GPIO.make16Chars(devName)));
			GPIO.pSetupRecieve();
			GPIO.waitAck_Stable();
			int id = GPIO.getIntInput();
			GPIO.sendAck();
			GPIO.pSetupSend();
			PrintWriter out= response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('" + id + " is het nieuwe device id!');");
			out.println("</script>");
			out.println(id + " is het nieuwe device id!");
			rd.include(request, response);
		} else {
			//System.out.println("PANIEK PANIEK PANIEK ER IS IETS OF IEMAND FOUT BEZIGN OMG OMG OMG ABORT ABORT ABORT");
		}
	}
	
	public Map<Integer, String> getMap(int length, HttpServletRequest request) {
		Map<Integer, String> map = new TreeMap<Integer, String>();
		for(int i = 1; i <= length; i++) {
			map.put(Integer.parseInt(request.getParameter("key" + i)), request.getParameter("value" + i));
		}
		return map;
	}
}
