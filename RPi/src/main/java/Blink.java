import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;


@WebServlet("/Blink")
@SuppressWarnings("serial")
public class Blink extends HttpServlet{

	/*GpioController gpio = GpioFactory.getInstance();
	GpioPinDigitalOutput myLed = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00,   // PIN NUMBER
			"My LED",           // PIN FRIENDLY NAME (optional)
			PinState.LOW);
	boolean repeat = false;*/

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		response.setContentType("text/html;charset=UTF-8");
		RequestDispatcher rd = request.getRequestDispatcher(response.encodeRedirectURL("./")); 
		System.out.println("hij doet iets");
		/*for (int i =0; i < 10;i++) {
			myLed.toggle();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ie) {
			}
		}
		myLed.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);*/
		rd.include(request, response);


	}

}
