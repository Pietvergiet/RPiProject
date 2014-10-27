package Gpio;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class GPIOInit {
	
	public Object[] Init() {
		GpioController gpio = GpioFactory.getInstance();
		GpioPinDigitalOutput send = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "J5/3-IO17", PinState.LOW);
		GpioPinDigitalInput ack = gpio.provisionDigitalInputPin(RaspiPin.GPIO_01, "J5/4-IO18");
		GpioPinDigitalOutput data[] = {
			gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, "J5/6-IO22", PinState.LOW),
			gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "J5/7-IO23", PinState.LOW),
			gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, "J5/8-IO24", PinState.LOW),
			gpio.provisionDigitalOutputPin(RaspiPin.GPIO_06, "J5/9-IO25", PinState.LOW),
			gpio.provisionDigitalOutputPin(RaspiPin.GPIO_07, "J4/7-RXD0", PinState.LOW),
			gpio.provisionDigitalOutputPin(RaspiPin.GPIO_08, "J10/3-IO28", PinState.LOW),
			gpio.provisionDigitalOutputPin(RaspiPin.GPIO_09, "J10/4-IO29", PinState.LOW),
			gpio.provisionDigitalOutputPin(RaspiPin.GPIO_10, "J10/5-IO30", PinState.LOW)
		};
		GpioPinDigitalOutput par = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_11, "J10/6-IO31", PinState.LOW);
		data[3].setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
		data[4].setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
		data[5].setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
		data[6].setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
		data[7].setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
		data[8].setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
		data[9].setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
		data[10].setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
		
		Object pins[] = {send, ack, data, par};
		
		return pins;
	}

}