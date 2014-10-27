package Gpio;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalMultipurpose;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinMode;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;

public class GPIO {

	public static final GpioController gpio = GpioFactory.getInstance();
	public static final GpioPinDigitalMultipurpose pin[] = { 
		gpio.provisionDigitalMultipurposePin(RaspiPin.GPIO_00, "Send", PinMode.DIGITAL_OUTPUT, PinPullResistance.PULL_DOWN),
		gpio.provisionDigitalMultipurposePin(RaspiPin.GPIO_01, "Stable(out)/Ack(in)", PinMode.DIGITAL_OUTPUT, PinPullResistance.PULL_DOWN),
		gpio.provisionDigitalMultipurposePin(RaspiPin.GPIO_02, "Ack(out)/Stable(in)", PinMode.DIGITAL_INPUT, PinPullResistance.PULL_DOWN),
		gpio.provisionDigitalMultipurposePin(RaspiPin.GPIO_03, "Data", PinMode.DIGITAL_OUTPUT, PinPullResistance.PULL_DOWN),
		gpio.provisionDigitalMultipurposePin(RaspiPin.GPIO_04, "Data", PinMode.DIGITAL_OUTPUT, PinPullResistance.PULL_DOWN),
		gpio.provisionDigitalMultipurposePin(RaspiPin.GPIO_05, "Data", PinMode.DIGITAL_OUTPUT, PinPullResistance.PULL_DOWN),
		gpio.provisionDigitalMultipurposePin(RaspiPin.GPIO_06, "Data", PinMode.DIGITAL_OUTPUT, PinPullResistance.PULL_DOWN),
		gpio.provisionDigitalMultipurposePin(RaspiPin.GPIO_07, "Data", PinMode.DIGITAL_OUTPUT, PinPullResistance.PULL_DOWN),
		gpio.provisionDigitalMultipurposePin(RaspiPin.GPIO_08, "Data", PinMode.DIGITAL_OUTPUT, PinPullResistance.PULL_DOWN),
		gpio.provisionDigitalMultipurposePin(RaspiPin.GPIO_09, "Data", PinMode.DIGITAL_OUTPUT, PinPullResistance.PULL_DOWN),
		gpio.provisionDigitalMultipurposePin(RaspiPin.GPIO_10, "Data", PinMode.DIGITAL_OUTPUT, PinPullResistance.PULL_DOWN)
	};
	public static boolean send = true;

	public static GpioPinDigitalMultipurpose[] getMPins() {
		return pin;
	}

	public static void pSetupSend() {
		send = true;
		pin[1].setMode(PinMode.DIGITAL_INPUT);
		pin[2].setMode(PinMode.DIGITAL_OUTPUT);
		for (int i = 3; i < 11; i++) {
			pin[i].setMode(PinMode.DIGITAL_OUTPUT);
		}
	}

	public static void pSetupRecieve() {
		send = false;
		pin[1].setMode(PinMode.DIGITAL_OUTPUT);
		pin[2].setMode(PinMode.DIGITAL_INPUT);
		for (int i = 3; i < 11; i++) {
			pin[i].setMode(PinMode.DIGITAL_INPUT);
		}
	}

	public static void setStable() {
		if (send){
			pin[1].high();
		}
	}

	public static void setUnstable() {
		if (send) {
			pin[1].low();
		}
	}

	public static void setDevice() {
		if (send) {
			setUnstable();
			pin[3].low();
			pin[4].low();
			pin[5].low();
			pin[6].high();
		}	
	}

	public static void setAction() {
		if (send) {
			setUnstable();
			pin[3].low();
			pin[4].low();
			pin[5].high();
			pin[6].low();
		}	
	}

	public static void setSeq() {
		if (send) {
			setUnstable();
			pin[3].low();
			pin[4].low();
			pin[5].high();
			pin[6].high();
		}	
	}

	public static void setAlarm() {
		if (send) {
			setUnstable();
			pin[3].low();
			pin[4].high();
			pin[5].low();
			pin[6].low();
		}	
	}

	public static void setList() {
		if (send) {
			setUnstable();
			pin[7].low();
			pin[8].low();
			pin[9].low();
			pin[10].low();
		}
	}

	public static void setRemove() {
		if (send) {
			setUnstable();
			pin[7].low();
			pin[8].low();
			pin[9].high();
			pin[10].low();
		}
	}

	public static void setAdd() {
		if (send) {
			setUnstable();
			pin[7].low();
			pin[8].high();
			pin[9].low();
			pin[10].low();
		}
	}

	public static void setExecute() {
		if (send) {
			setUnstable();
			pin[7].low();
			pin[8].high();
			pin[9].high();
			pin[10].low();
		}
	}

	public static void setSeqListAct() {
		if (send) {
			setUnstable();
			setSeq();
			pin[7].low();
			pin[8].low();
			pin[9].low();
			pin[10].high();
		}
	}

	public static void setSeqRemAct() {
		if (send) {
			setUnstable();
			setSeq();
			pin[7].low();
			pin[8].low();
			pin[9].high();
			pin[10].high();
		}
	}

	public static void setSeqAddAct() {
		if (send) {
			setUnstable();
			setSeq();
			pin[7].low();
			pin[8].high();
			pin[9].low();
			pin[10].high();
		}
	}

	public static void setTimeSet() {
		if (send) {
			setUnstable();
			pin[3].low();
			pin[4].high();
			pin[5].low();
			pin[6].high();
			pin[7].low();
			pin[8].low();
			pin[9].low();
			pin[10].low();
		}
	}

	public static void setLinkSeq() {
		if (send) {
			setUnstable();
			pin[3].low();
			pin[4].high();
			pin[5].low();
			pin[6].high();
			pin[7].low();
			pin[8].low();
			pin[9].low();
			pin[10].high();
		}
	}

	public static void setPassGet() {
		if (send) {
			setUnstable();
			pin[3].low();
			pin[4].high();
			pin[5].high();
			pin[6].low();
			pin[7].low();
			pin[8].low();
			pin[9].low();
			pin[10].low();
		}
	}

	public static void setPassSet() {
		if (send) {
			setUnstable();
			pin[3].low();
			pin[4].high();
			pin[5].high();
			pin[6].low();
			pin[7].low();
			pin[8].low();
			pin[9].low();
			pin[10].high();
		}
	}
	
	public static void waitAck() {
		while (pin[1].isLow()) {
			int t = 0;
		}
	}

	public static void main(String[] arg) {
		pin[2].addListener(new GpioPinListenerDigital() {

			@Override
			public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
				if (send && event.getState() == PinState.HIGH && pin[1].isHigh()) {
					pin[1].low();
				}
			}            
		});
		
		pin[1].addListener(new GpioPinListenerDigital() {

			@Override
			public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
				if (send && event.getState() == PinState.HIGH && pin[1].isHigh()) {
					pin[1].low();
				}
			}            
		});
	}




}
