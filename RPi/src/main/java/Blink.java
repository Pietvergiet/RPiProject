import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Gpio.GPIO;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;


@WebServlet("/Blink")
@SuppressWarnings("serial")
public class Blink extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		response.setContentType("text/html;charset=UTF-8");
		/*GPIO.setUnstable_Ack();
		/*GPIO.setSeq();
		GPIO.setSeqRemAct();
		GPIO.setStable();
		GPIO.waitAck_Stable();
		GPIO.sendInts(GPIO.turnStringtoInt("@"));
		GPIO.pSetupRecieve();
		GPIO.waitAck_Stable();
		int i = GPIO.getIntInput();
		GPIO.pin[1].high();
		boolean bool[] = GPIO.intToBool(i);
		String s = Arrays.toString(bool);*/
		String t = "Hallo";
		RequestDispatcher rd = request.getRequestDispatcher("/"); 
		PrintWriter out= response.getWriter();
		out.println("<script type=\"text/javascript\">");
		out.println("alert('" + t + "');");
		out.println("window.open('', '_parent');");
		out.println("</script>");
		

		rd.include(request, response);


	}

}
