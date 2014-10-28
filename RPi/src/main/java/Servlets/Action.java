package Servlets;

import java.io.IOException;
import java.util.HashMap;

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
		GPIO.setUnstable();
		String action = (String) request.getParameter("button");
		if (action.contains("List")) {
			System.out.println(action);
			GPIO.pSetupSend();
			GPIO.setAction();
			GPIO.setList();
			GPIO.setStable();
			GPIO.waitAck_Stable();
			GPIO.pSetupRecieve();
			GPIO.waitAck_Stable();
			int length = GPIO.getIntInput();
			HashMap<Integer, String> lijst = GPIO.getList(length);
			//TODO doe iets met lijst
			GPIO.pSetupSend();
		} else if (action.equals("Remove")) {
			System.out.println(action);
			GPIO.pSetupSend();
			GPIO.setAction();
			GPIO.setRemove();
			GPIO.setStable();
			GPIO.waitAck_Stable();
			String actId = request.getParameter("actId");
			GPIO.sendInts(GPIO.turnStringtoInt(actId));
		} else if (action.equals("Record")) {
			System.out.println(action);
			GPIO.pSetupSend();
			GPIO.setAction();
			GPIO.setAdd();
			GPIO.setStable();
			GPIO.waitAck_Stable();
			int newId = Integer.parseInt(request.getParameter("nActId"));
			int nId[] = {newId};
			String newName = request.getParameter("nActNam");
			GPIO.sendInts(nId);
			GPIO.sendInts(GPIO.turnStringtoInt(newName));
		} else if (action.equals("Execute")) {
			System.out.println(action);
			GPIO.pSetupSend();
			GPIO.setAction();
			GPIO.setExecute();
			GPIO.setStable();
			GPIO.waitAck_Stable();
			int exeId = Integer.parseInt(request.getParameter("actIdexe"));
			int eId[] = {exeId};
			GPIO.sendInts(eId);
		} else {
			System.out.println("PANIEK PANIEK PANIEK ER IS IETS OF IEMAND FOUT BEZIGN OMG OMG OMG ABORT ABORT ABORT");
		}
		
		
		
		response.sendRedirect(response.encodeURL(request.getHeader("Referer")));
	}
}
