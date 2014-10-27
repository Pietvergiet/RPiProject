package Gpio;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalMultipurpose;
import com.pi4j.io.gpio.GpioPinDigitalOutput;

@WebServlet("/doAction")
@SuppressWarnings("serial")
public class Action extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("AcIONTTTT!!");
		GPIOInit gpio = new GPIOInit();
		GpioPinDigitalMultipurpose pins[] = gpio.getMPins();
		gpio.setUnstable();
		String action = (String) request.getParameter("button");
		if (action.equals("List")) {
			System.out.println(action);
			gpio.pSetupSend();
			gpio.setAction();
			gpio.setList();
			gpio.setStable();
		} else if (action.equals("Remove")) {
			System.out.println(action);
			gpio.pSetupSend();
			gpio.setAction();
			gpio.setRemove();
			gpio.setStable();
		} else if (action.equals("Add")) {
			System.out.println(action);
			gpio.pSetupSend();
			gpio.setAction();
			gpio.setAdd();
			gpio.setStable();
		} else if (action.equals("Execute")) {
			System.out.println(action);
			gpio.pSetupSend();
			gpio.setAction();
			gpio.setExecute();
			gpio.setStable();
		} else {
			System.out.println("PANIEK PANIEK PANIEK ER IS IETS OF IEMAND FOUT BEZIGN OMG OMG OMG ABORT ABORT ABORT");
		}
		
		
		
		response.sendRedirect(response.encodeURL(request.getHeader("Referer")));
	}
}
