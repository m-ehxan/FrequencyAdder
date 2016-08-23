package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import signal.Sine;
import signal.Square;
import signal.Triangle;
import signal.Tone;
import userdataobject.FreqObject;

/**
 * FreqServlet class handles the request from client and forwards it to specific java resource based
 * on type of request. It extends from HttpServlet class
 * @author Ehsan-Ul-Haq
 * @Date 3 February 2016
 * @version 1.0
 * @see HttpServlet
 *
 */
@WebServlet("/FreqServlet")
public class FreqServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int waveSelection = 0;

	/**
	 * Constructor of the super class: HttpServlet
	 * @see HttpServlet #HttpServlet()
	 */
	public FreqServlet() {
		super();
	}

	/**
	 * HttpServlet doPost methods handles the incoming post request from index.html, gets user inputs and 
	 * calls different methods based on user selections.
	 * @param request takes request from client
	 * @param response generates response for the client
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			
			/** creates instance of FreqObjet class, which handles all the use data  */
			FreqObject dao = new FreqObject();
			/** 
			 * Creates an instance variable of RequestDispatcher class for forwarding requests to specific resources 
			 * @param rd is a request dispatcher instance variable for forwarding requests.
			 */
			RequestDispatcher rd=null;
			/** 
			 * Creates an instance variable of Tone class
			 * @param logic is a instance variable of Tone class for generating signals  
			 */
			Tone logic = null;
		
		
		
		//Checks whether or not user has pressed the button
		if(request.getParameter("btn").equals("PlayorFile")){
			
			//Accessing the user input values
			getValues(dao, request);
		
					
		//This condition is used to check whether the user wants to generate Frequency 1, 2 or Sum
		if(request.getParameter("selection").equals("Frequency1")) {
			waveSelection = 0;
		}
		else if(request.getParameter("selection").equals("Frequency2")){
			waveSelection = 1;
		}
		else {
			waveSelection = 2;
		}
			
		
		//This statement is used to check the Signal Type (Sine,Triangle,Square) entered by the user
		switch (dao.getSignal()) {
			case "Sine":logic = new Sine(dao,waveSelection);
			break;
			case "Triangle": logic = new Triangle(dao,waveSelection);
			break;
			case "Square": logic = new Square(dao,waveSelection);
			break;
		}
		
		//calls the method for creating frequency based on user selections
		logic.createTone();
		
		//This method is used the store the values from different class necessary for Frequency generation
		storeServletValues(dao,logic);
		
		// Checks whether to play or create a .wave file
		if(request.getParameter("action").equals("Listen")) {
			rd = request.getRequestDispatcher("Play");
			rd.forward(request, response);
		}
		else if(request.getParameter("action").equals("File")){
			rd = request.getRequestDispatcher("Download");
			rd.forward(request, response);
		}

	}
	}

	/**
	 * This method takes and sets the user inputs e.g Amplitude, Phase, Frequency,Signal Type,FileName
	 * Sample Rate and User Selections for Frequency1, 2 or Sum
	 * @param dao getting the user input values from #FreqObject
	 * @param request getting the user input values using #HttpServletRequest
	 */
	private void getValues(FreqObject dao, HttpServletRequest request) {
		dao.setAmp_1(Double.parseDouble(request.getParameter("Amplitude1")));
		dao.setAmp_2(Double.parseDouble(request.getParameter("Amplitude2")));
		dao.setPhase_1(Integer.parseInt(request.getParameter("Phase1")));
		dao.setPhase_2(Integer.parseInt(request.getParameter("Phase2")));
		dao.setF1(Integer.parseInt(request.getParameter("First Freq")));
		dao.setF2(Integer.parseInt(request.getParameter("Second Freq")));
		dao.setSignal(request.getParameter("Signal"));
		dao.setWavefilename(request.getParameter("Filename"));

		dao.setTime(4);
		dao.setSampRate(1000 * Double.parseDouble(request.getParameter("Sample")));
		dao.setFreq1(request.getParameter("selection"));
		dao.setFreq2(request.getParameter("selection"));
		dao.setSum(request.getParameter("selection"));
		
	}
	
	/**
	 * This method is used the store the output variables of Tone class e.g Filename, Byte Array of 
	 * generated signal, Audio Format
	 * @param dao user input values from #FreqObject
	 * @param logic instance variable of Tone class
	 */
	private void storeServletValues(FreqObject dao,Tone logic) {
		ServletContext context = getServletContext();
		context.setAttribute("filename", logic.getFilename());
		context.setAttribute("bytearray", logic.getBuf());
		context.setAttribute("dao", dao);
		context.setAttribute("AudioFormat", logic.getAudioFormat());
	}

}
