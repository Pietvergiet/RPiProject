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


@WebServlet("/Blink")
@SuppressWarnings("serial")
public class Blink extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		response.setContentType("text/html;charset=UTF-8");
		GPIO.setUnstable();
		/*GPIO.setSeq();
		GPIO.setSeqRemAct();
		GPIO.setStable();
		GPIO.waitAck_Stable();*/
		GPIO.sendInts(GPIO.turnStringtoInt("@"));
		GPIO.pSetupRecieve();
		GPIO.waitAck_Stable();
		int i = GPIO.getIntInput();
		GPIO.pin[2].high();
		boolean bool[] = GPIO.intToBool(i);
		String s = Arrays.toString(bool);
		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp"); 
		PrintWriter out= response.getWriter();
		out.println("<br><br><br><br><br><br><br>Hallo");
		out.println(s);
		

		rd.include(request, response);


	}

}
