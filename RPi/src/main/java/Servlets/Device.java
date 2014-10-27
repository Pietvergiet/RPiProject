package Servlets;

import java.io.IOException;
import java.util.HashMap;

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
		GPIO.setUnstable();
		String action = (String) request.getParameter("button");
		if (action.equals("List")) {
			System.out.println(action);
			GPIO.pSetupSend();
			GPIO.setDevice();
			GPIO.setList();
			GPIO.setStable();
			GPIO.waitAck_Stable();
			GPIO.pSetupRecieve();
			GPIO.waitAck_Stable();
			int length = GPIO.getIntInput();
			HashMap<Integer, String> lijst = GPIO.getList(length);
			//TODO doe iets met lijst
		} else if (action.equals("Remove")) {
			System.out.println(action);
			GPIO.pSetupSend();
			GPIO.setDevice();
			GPIO.setRemove();
			GPIO.setStable();
			GPIO.waitAck_Stable();
			//TODO geef device id mee
			GPIO.setStable();
			GPIO.waitAck_Stable();
		} else if (action.equals("Add")) {
			System.out.println(action);
			GPIO.pSetupSend();
			GPIO.setDevice();
			GPIO.setAdd();
			GPIO.setStable();
			//TODO geef device name mee
			GPIO.setStable();
			GPIO.waitAck_Stable();
		} else {
			System.out.println("PANIEK PANIEK PANIEK ER IS IETS OF IEMAND FOUT BEZIGN OMG OMG OMG ABORT ABORT ABORT");
		}
		
		
		
		response.sendRedirect(response.encodeURL(request.getHeader("Referer")));
	}
}