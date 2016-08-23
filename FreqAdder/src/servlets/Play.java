package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.sampled.AudioFormat;

import utilities.AudioPlay;

/**
 * Handles the incoming request from FreqServlet to play the generated signal. It extends HttpServlet class
 * @author Ehsan-Ul-Haq
 * @Date 3 February 2016
 * @version 1.0
 * @see HttpServlet
 */
@WebServlet("/Play")
public class Play extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the super class: HttpServlet
	 * @see HttpServlet#HttpServlet()
	 */
	public Play() {
		super();
	}

	/**
	 * HttpServlet doPost methods handles the incoming post request from index.html, gets user inputs and 
	 * calls different methods based on user selections.
	 * @param request takes request from client
	 * @param response generates response for the client
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// sets context of Servlet
		ServletContext context=getServletContext(); 
		//Gets Byte Array of generated signal and stores it in buffer array of type byte
		byte[] buffer = (byte[])context.getAttribute("bytearray");
		//Gets the format of audio signal
		AudioFormat af = ((AudioFormat)context.getAttribute("AudioFormat"));
		//creates an instance of RequestDispatcher class to forward the request to specific resourse
		RequestDispatcher rd=null;

		
		try {
			// Creates instance and calls Play method of AudioPlay Class in utilities package
			new AudioPlay(buffer,af).play();
			// forwards the request to index.html
			rd = request.getRequestDispatcher("index.html");
			rd.forward(request, response);

        }
		catch(Exception e)	{
			e.printStackTrace();
        }
	}
}