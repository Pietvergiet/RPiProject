package Gpio;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pi4j.io.gpio.GpioPinDigitalOutput;

@WebServlet("/Action")
@SuppressWarnings("serial")
public class Action {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("AcIONTTTT!!");
		GPIOInit gpio = new GPIOInit();
		Object pins[] = gpio.Init();
		
		response.sendRedirect(response.encodeURL(request.getHeader("Referer")));
	}
}
