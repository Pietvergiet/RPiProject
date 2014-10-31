package Gpio;

import java.util.HashMap;

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
		gpio.provisionDigitalMultipurposePin(RaspiPin.GPIO_01, "Stable(out)/Ack(out)", PinMode.DIGITAL_OUTPUT, PinPullResistance.PULL_DOWN),
		gpio.provisionDigitalMultipurposePin(RaspiPin.GPIO_02, "Ack(in)/Stable(in)", PinMode.DIGITAL_INPUT, PinPullResistance.PULL_DOWN),
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
		pin[0].low();
		for (int i = 3; i < 11; i++) {
			pin[i].setMode(PinMode.DIGITAL_OUTPUT);
		}
	}

	public static void pSetupRecieve() {
		send = false;
		pin[0].high();
		for (int i = 3; i < 11; i++) {
			pin[i].setMode(PinMode.DIGITAL_INPUT);
		}
	}

	public static void setStable_Ack() {
		if (send){
			pin[1].high();
		}
	}

	public static void setUnstable_Ack() {
		if (send) {
			pin[1].low();
		}
	}

	public static void setDevice() {
		if (send) {
			setUnstable_Ack();
			pin[3].low();
			pin[4].low();
			pin[5].low();
			pin[6].high();
		}	
	}

	public static void setAction() {
		if (send) {
			setUnstable_Ack();
			pin[3].low();
			pin[4].low();
			pin[5].high();
			pin[6].low();
		}	
	}

	public static void setSeq() {
		if (send) {
			setUnstable_Ack();
			pin[3].low();
			pin[4].low();
			pin[5].high();
			pin[6].high();
		}	
	}

	public static void setAlarm() {
		if (send) {
			setUnstable_Ack();
			pin[3].low();
			pin[4].high();
			pin[5].low();
			pin[6].low();
		}	
	}

	public static void setList() {
		if (send) {
			setUnstable_Ack();
			pin[7].low();
			pin[8].low();
			pin[9].low();
			pin[10].low();
		}
	}

	public static void setRemove() {
		if (send) {
			setUnstable_Ack();
			pin[7].low();
			pin[8].low();
			pin[9].high();
			pin[10].low();
		}
	}

	public static void setAdd() {
		if (send) {
			setUnstable_Ack();
			pin[7].low();
			pin[8].high();
			pin[9].low();
			pin[10].low();
		}
	}

	public static void setExecute() {
		if (send) {
			setUnstable_Ack();
			pin[7].low();
			pin[8].high();
			pin[9].high();
			pin[10].low();
		}
	}

	public static void setSeqListAct() {
		if (send) {
			setUnstable_Ack();
			setSeq();
			pin[7].low();
			pin[8].low();
			pin[9].low();
			pin[10].high();
		}
	}

	public static void setSeqRemAct() {
		if (send) {
			setUnstable_Ack();
			setSeq();
			pin[7].low();
			pin[8].low();
			pin[9].high();
			pin[10].high();
		}
	}

	public static void setSeqAddAct() {
		if (send) {
			setUnstable_Ack();
			setSeq();
			pin[7].low();
			pin[8].high();
			pin[9].low();
			pin[10].high();
		}
	}

	public static void setTimeSet() {
		if (send) {
			setUnstable_Ack();
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
			setUnstable_Ack();
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
			setUnstable_Ack();
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
			setUnstable_Ack();
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
	
	@SuppressWarnings("unused")
	public static void waitAck_Stable() {
		if(send) {
			while (pin[2].isLow()) {
				int t = 0;
			}
			pin[1].low();
		} else {
			while (pin[2].isLow()) {
				int q = 0;
			}	
					
		}
	}
	
	@SuppressWarnings("unused")
	public static void sendAck() {
		if (!send && pin[2].isHigh()) {
			setStable_Ack();
			while(pin[2].isHigh()) {
				int t = 0;
			}
			setUnstable_Ack();
		}
	}
	
	public static void sendInts(int[] chars) {
		for(int i = 0; i < chars.length; i++) {
			setUnstable_Ack();
			boolean stand[] = intToBool(chars[i]);
			for(int j = 0; j < stand.length; j++) {
				if(stand[j]) {
					pin[j+3].high();
				} else {
					pin[j+3].low();
				}
				
			}
			setStable_Ack();
			waitAck_Stable();
		}
	}
	
	public static boolean[] intToBool(int cijfer) {
		if (cijfer > 255 && cijfer >= 0){
			return null;
		} else {
			int input = cijfer;

		    boolean[] bits = new boolean[8];
		    for (int i = 7; i >= 0; i--) {
		        bits[i] = (input & (1 << i)) != 0;
		    }
		    
		    return bits;
		}
	}
	
	public static int boolToTime() {
		waitAck_Stable();
		boolean[] ar1 = getBoolInput();
		sendAck();
		waitAck_Stable();
		boolean[] ar2 = getBoolInput();
		sendAck();
		boolean[] time = new boolean[16];
		for (int i = 0, j = 8; i < 8 && j < 16; i++, j++) {
			time[i] = ar1[i];
			time[j] = ar2[i];
		}
		int n = 0;
		for (int i = 0; i < 16; ++i) {
		    n = (n << 1) + (time[i] ? 1 : 0);
		}
		
		return n;
	}
	
	public static void sendTime(int hour, int min) {
		int totalMin = hour*60 + min;
		boolean[] bits = new boolean[16];
		boolean[] result = new boolean[16];
	    for (int i = 15; i >= 0; i--) {
	        bits[i] = (totalMin & (1 << i)) != 0;
	    }
	    for (int i = bits.length-1; i >= 0; i--) {
	    	result[i] = bits[15-i];
	    }
	    int ar1 = 0;
	    int ar2 = 0; 
		for (int i = 0; i < 8; ++i) {
		    ar1 = (ar1 << 1) + (result[i] ? 1 : 0);
		}
		for (int i = 8; i < 16; ++i) {
		    ar2 = (ar2 << 1) + (result[i] ? 1 : 0);
		}
		int[] time = {ar1, ar2};
		sendInts(time);
	}
	
	public static HashMap<Integer,String> getList() {
		HashMap<Integer, String> list = new HashMap<Integer, String>();
		for(;;) {
			StringBuilder name = new StringBuilder();
			int nr;
			waitAck_Stable();
			if (checkZByte()) {
				return list;
			}
			nr = getIntInput();
			sendAck();
			for (int j = 0; j < 16; j++) {
				waitAck_Stable();
				name.append(getCharInput());
				sendAck();
			}
			list.put(nr, name.toString());
		}
		
	}
	
	public static HashMap<Integer, HashMap<Integer, String>> getActionList() {
		HashMap<Integer, HashMap<Integer, String>> list = new HashMap<Integer, HashMap<Integer, String>>();
		HashMap<Integer, String> action = new HashMap<Integer, String>();
		for(;;) {
			action.clear();
			int nr;
			int id;
			StringBuilder name = new StringBuilder();
			waitAck_Stable();
			if(checkZByte()) {
				return list;
			}
			nr = getIntInput();
			sendAck();
			waitAck_Stable();
			id = getIntInput();
			sendAck();
			for (int j = 0; j < 16; j++) {
				waitAck_Stable();
				name.append(getCharInput());
				sendAck();
			}
			action.put(id, name.toString());
			list.put(nr, action);
		}
	}
	
	public static HashMap<Integer, Object[]> getAlarmList() {
		HashMap<Integer, Object[]> list = new HashMap<Integer, Object[]>();
		for(;;) {
			int alID;
			String time;
			int actID;
			StringBuilder name = new StringBuilder();
			waitAck_Stable();
			if (checkZByte()) {
				return list;
			}
			alID = getIntInput();
			sendAck();
			int tijd = boolToTime();
			waitAck_Stable();
			actID = getIntInput();
			sendAck();
			for (int j = 0; j < 16; j++) {
				waitAck_Stable();
				name.append(getCharInput());
				sendAck();
			}
			int uur = tijd/60;
			int min = tijd%60;
			time = uur + ":" + min;
			Object alarm[] = {time, actID, name.toString()};
			list.put(alID, alarm);
		}
	}
	
	public static boolean[] getBoolInput() {
		boolean[] input = new boolean[8];
		for (int i = 10; i > 2; i--) {
			input[10-i] = pin[i].isHigh();
		}
		return input;
	}
	
	public static int getIntInput() {
		boolean[] input = getBoolInput();
		int n = 0;
		for (int i = 0; i < 8; ++i) {
		    n = (n << 1) + (input[i] ? 1 : 0);
		}
		return n;
	}
	
	public static String getSucces() {
		if(getIntInput() == 0) {
			return "Failure: either what you are trying to do is impossible or something else we. We suggest you try, try, try again (or give up we don't judge ;) )";
		} else if (getIntInput() == 255) {
			return "Succes!";
		} else {
			return "Something happened but we are not sure what. Might be a fault on our side might be polar bears who knows.";
		}
	}
	
	public static boolean checkZByte() {
		return getIntInput() == 0;
	}
	
	public static String getPass() {
		StringBuilder pass = new StringBuilder();
		for (int i = 0; i < 20; i++) {
			waitAck_Stable();
			pass.append(getCharInput());
			sendAck();
		}
		return pass.toString();
	}
	
	public static char getCharInput() {
		int n = getIntInput();
		char ch = (char) n;
		return ch;
	}
	
	public static int[] turnStringtoInt(String string) {
		StringBuilder chars = new StringBuilder(string);
		int[] ints = new int[chars.length()];
		for (int i = 0; i < chars.length(); i++) {
			ints[i] = (int) chars.charAt(i);
		}
		
		return ints;
	}

	public static void main(String[] arg) {
		
		//Sending Data
		//When ack pin is receiving a 1 turn stable pin off
		pin[2].addListener(new GpioPinListenerDigital() {

			@Override
			public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
				if (send && event.getState() == PinState.HIGH && pin[1].isHigh()) {
					System.out.println("stabel pin is out");
					pin[1].low();
				} else if (!send && event.getState() == PinState.LOW) {
					pin[1].low();
				}
			}            
		});
	}




}
