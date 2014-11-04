package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Gpio.GPIO;

@WebServlet("/doSequence")
@SuppressWarnings("serial")
public class Sequence extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html;charset=UTF-8");
		RequestDispatcher rd = request.getRequestDispatcher(response.encodeRedirectURL("/Sequence"));
		//GPIO.setUnstable_Ack();
		String action = (String) request.getParameter("button");
		if (action.equals("List Actions")) {
			GPIO.setSeq();
			GPIO.setSeqListAct();
			GPIO.setStable_Ack();
			GPIO.waitAck_Stable();
			int seqId = Integer.parseInt(request.getParameter("seqId"));
			int sId[] = {seqId};
			GPIO.sendInts(sId);
			GPIO.pSetupRecieve();
			Map<Integer, TreeMap<Integer,String>> lijst = GPIO.getActionList();
			GPIO.pSetupSend();
			/*Map<Integer, Map<Integer, String>> exampl = new TreeMap<Integer, Map<Integer, String>>();
			Map<Integer, String> examp = new TreeMap<Integer, String>(); 

			examp.put(4, "Harder");
			exampl.put(1, examp);
			exampl.put(2, examp);
			exampl.put(3, examp);
			exampl.put(4, examp);
			exampl.put(5, examp);*/
			request.setAttribute("seqActList", lijst);
			request.getRequestDispatcher("/Dynamic.jsp").forward(request, response);
		} else if (action.contains("List")) {
			GPIO.setSeq();
			GPIO.setList();
			GPIO.setStable_Ack();
			GPIO.waitAck_Stable();
			GPIO.pSetupRecieve();
			Map<Integer, String> lijst = GPIO.getList();
			GPIO.pSetupSend();
			/*Map<Integer, String> examp = new TreeMap<Integer, String>(); 
			examp.put(1, "AAN/UIT");
			examp.put(2, "Next");
			examp.put(3, "PREV");
			examp.put(4, "Harder");
			examp.put(5, "Zachter");*/
			request.setAttribute("seqList", lijst);
			request.getRequestDispatcher("/Dynamic.jsp").forward(request, response);
		} else if (action.equals("Remove Action")) {
			GPIO.setSeq();
			GPIO.setSeqRemAct();
			GPIO.setStable_Ack();
			GPIO.waitAck_Stable();
			int seqIdArem = Integer.parseInt(request.getParameter("seqIdArem"));
			int sIdArem[] = {seqIdArem};
			GPIO.sendInts(sIdArem);
			int iNr = Integer.parseInt(request.getParameter("iNr"));
			int inNr[] = {iNr};
			GPIO.sendInts(inNr);
			GPIO.pSetupRecieve();
			GPIO.waitAck_Stable();
			String s = GPIO.getSucces();
			GPIO.sendAck();
			GPIO.pSetupSend();
			//String s = request.getParameter("iNr") + "--" + request.getParameter("seqIdArem");
			PrintWriter out= response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('" + s + "');");
			out.println("</script>");
			out.println(s);
			rd.include(request, response);
		} else if (action.equals("Remove")) {
			GPIO.setSeq();
			GPIO.setRemove();
			GPIO.setStable_Ack();
			GPIO.waitAck_Stable();
			int seqIdrem = Integer.parseInt(request.getParameter("seqIdrem"));
			int id[] = {seqIdrem};
			GPIO.sendInts(id);
			GPIO.pSetupRecieve();
			GPIO.waitAck_Stable();
			String s = GPIO.getSucces();
			GPIO.sendAck();
			GPIO.pSetupSend();
			PrintWriter out= response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('" + s + "');");
			out.println("</script>");
			out.println(s);

			rd.include(request, response);
		} else if (action.equals("Add Action")) {
			GPIO.setSeq();
			GPIO.setSeqAddAct();
			GPIO.setStable_Ack();
			GPIO.waitAck_Stable();
			int seqIdAadd = Integer.parseInt(request.getParameter("seqIdAadd"));
			int sIdAadd[] = {seqIdAadd};
			GPIO.sendInts(sIdAadd);
			int iNrA = Integer.parseInt(request.getParameter("iNrA"));
			int inNrA[] = {iNrA};
			GPIO.sendInts(inNrA);
			if (request.getParameterValues("delay") != null) {
				int delayTime = Integer.parseInt(request.getParameter("delayTime"));
				int dTime[] = {128+delayTime};
				GPIO.sendInts(dTime);
			} else {
				int actIDadd = Integer.parseInt(request.getParameter("actIDadd"));
				int aIDadd[] = {actIDadd};
				GPIO.sendInts(aIDadd);
			}
			GPIO.pSetupRecieve();
			GPIO.waitAck_Stable();
			String s = GPIO.getSucces();
			GPIO.sendAck();
			GPIO.pSetupSend();
			PrintWriter out= response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('" + s + "');");
			out.println("</script>");
			out.println(s);

			rd.include(request, response);
		} else if (action.equals("Add")) {
			GPIO.setSeq();
			GPIO.setAdd();
			GPIO.setStable_Ack();
			GPIO.waitAck_Stable();
			String seqIdadd = request.getParameter("seqIdadd");
			GPIO.sendInts(GPIO.turnStringtoInt(seqIdadd));
			GPIO.pSetupRecieve();
			GPIO.waitAck_Stable();
			int id = GPIO.getIntInput();
			GPIO.sendAck();
			GPIO.pSetupSend();
			PrintWriter out= response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('" + id + " is het nieuwe sequence id!');");
			out.println("</script>");
			out.println(id + " is het nieuwe sequence id!");

			rd.include(request, response);
		} else if (action.equals("Execute")) {
			GPIO.setSeq();
			GPIO.setExecute();
			GPIO.setStable_Ack();
			GPIO.waitAck_Stable();
			int seqExe = Integer.parseInt(request.getParameter("seqExe"));
			int sExe[] = {seqExe};
			GPIO.sendInts(sExe);
			GPIO.pSetupRecieve();
			GPIO.waitAck_Stable();
			String s = GPIO.getSucces();
			GPIO.sendAck();
			GPIO.pSetupSend();
			PrintWriter out= response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('" + s + "');");
			out.println("</script>");
			out.println(s);
			rd.include(request, response);
		}

	}	
}
