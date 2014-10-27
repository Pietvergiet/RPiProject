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

public class GPIOInit {
	
	GpioController gpio = GpioFactory.getInstance();
	GpioPinDigitalMultipurpose pin[] = { 
			gpio.provisionDigitalMultipurposePin(RaspiPin.GPIO_00, "Send", PinMode.DIGITAL_OUTPUT, PinPullResistance.PULL_DOWN),
			gpio.provisionDigitalMultipurposePin(RaspiPin.GPIO_01, "Stable", PinMode.DIGITAL_INPUT, PinPullResistance.PULL_DOWN),
			gpio.provisionDigitalMultipurposePin(RaspiPin.GPIO_02, "Data", PinMode.DIGITAL_OUTPUT, PinPullResistance.PULL_DOWN),
			gpio.provisionDigitalMultipurposePin(RaspiPin.GPIO_03, "Data", PinMode.DIGITAL_OUTPUT, PinPullResistance.PULL_DOWN),
			gpio.provisionDigitalMultipurposePin(RaspiPin.GPIO_04, "Data", PinMode.DIGITAL_OUTPUT, PinPullResistance.PULL_DOWN),
			gpio.provisionDigitalMultipurposePin(RaspiPin.GPIO_05, "Data", PinMode.DIGITAL_OUTPUT, PinPullResistance.PULL_DOWN),
			gpio.provisionDigitalMultipurposePin(RaspiPin.GPIO_06, "Data", PinMode.DIGITAL_OUTPUT, PinPullResistance.PULL_DOWN),
			gpio.provisionDigitalMultipurposePin(RaspiPin.GPIO_07, "Data", PinMode.DIGITAL_OUTPUT, PinPullResistance.PULL_DOWN),
			gpio.provisionDigitalMultipurposePin(RaspiPin.GPIO_08, "Data", PinMode.DIGITAL_OUTPUT, PinPullResistance.PULL_DOWN),
			gpio.provisionDigitalMultipurposePin(RaspiPin.GPIO_09, "Data", PinMode.DIGITAL_OUTPUT, PinPullResistance.PULL_DOWN),
			gpio.provisionDigitalMultipurposePin(RaspiPin.GPIO_10, "Data", PinMode.DIGITAL_OUTPUT, PinPullResistance.PULL_DOWN),
			gpio.provisionDigitalMultipurposePin(RaspiPin.GPIO_11, "Parity", PinMode.DIGITAL_OUTPUT, PinPullResistance.PULL_DOWN)
	};
	
	public GpioPinDigitalMultipurpose[] getMPins() {
		return pin;
	}
	
	public void pSetupSend() {
		pin[0].high();
	}
	
	public void pSetupRecieve() {
		pin[0].low();
	}
	
	public void setStable() {
		pin[1].high();
	}
	
	public void setUnstable() {
		pin[1].low();
	}
	
	public void setDevice() {
		if (pin[0].isHigh()) {
			setUnstable();
			pin[3].low();
			pin[4].low();
			pin[5].low();
			pin[6].high();
		}	
	}
	
	public void setAction() {
		if (pin[0].isHigh()) {
			setUnstable();
			pin[3].low();
			pin[4].low();
			pin[5].high();
			pin[6].low();
		}	
	}
	
	public void setSeq() {
		if (pin[0].isHigh()) {
			setUnstable();
			pin[3].low();
			pin[4].low();
			pin[5].high();
			pin[6].high();
		}	
	}
	
	public void setAlarm() {
		if (pin[0].isHigh()) {
			setUnstable();
			pin[3].low();
			pin[4].high();
			pin[5].low();
			pin[6].low();
		}	
	}
	
	public void setList() {
		if (pin[0].isHigh()) {
			setUnstable();
			pin[7].low();
			pin[8].low();
			pin[9].low();
			pin[10].low();
		}
	}
	
	public void setRemove() {
		if (pin[0].isHigh()) {
			setUnstable();
			pin[7].low();
			pin[8].low();
			pin[9].high();
			pin[10].low();
		}
	}
	
	public void setAdd() {
		if (pin[0].isHigh()) {
			setUnstable();
			pin[7].low();
			pin[8].high();
			pin[9].low();
			pin[10].low();
		}
	}
	
	public void setExecute() {
		if (pin[0].isHigh()) {
			setUnstable();
			pin[7].low();
			pin[8].high();
			pin[9].high();
			pin[10].low();
		}
	}
	
	public void setSeqListAct() {
		if (pin[0].isHigh()) {
			setUnstable();
			setSeq();
			pin[7].low();
			pin[8].low();
			pin[9].low();
			pin[10].high();
		}
	}
	
	public void setSeqRemAct() {
		if (pin[0].isHigh()) {
			setUnstable();
			setSeq();
			pin[7].low();
			pin[8].low();
			pin[9].high();
			pin[10].high();
		}
	}
	
	public void setSeqAddAct() {
		if (pin[0].isHigh()) {
			setUnstable();
			setSeq();
			pin[7].low();
			pin[8].high();
			pin[9].low();
			pin[10].high();
		}
	}
	
	public void setTimeSet() {
		if (pin[0].isHigh()) {
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
	
	public void setLinkSeq() {
		if (pin[0].isHigh()) {
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
	
	public void setPassGet() {
		if (pin[0].isHigh()) {
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
	
	public void setPassSet() {
		if (pin[0].isHigh()) {
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
	
	
	

}
