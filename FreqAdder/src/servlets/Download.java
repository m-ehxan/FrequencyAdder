package servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.sampled.AudioFormat;

import utilities.AudioDownload;

/**
 * Handles the request forwarded by FreqServlet to download the .wav file. It extends HttpServlet class
 * @author Ehsan-Ul-Haq
 * @Date 3 February 2016
 * @version 1.0 
 * @see HttpServlet
 */
@WebServlet("/Download")
public class Download extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the super class: HttpServlet
	 * @see HttpServlet #HttpServlet()
	 */
	public Download() {
		super();
	}

	/**
	 * Takes the post request from index.html and handles them accordingly to create and download .wav file
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// sets context of Servlet
		ServletContext context=getServletContext(); 
		//Gets file name for .wav file
		String filename=(String)context.getAttribute("filename");
		//Gets Byte Array of generated signal
		byte[] buffer = (byte[])context.getAttribute("bytearray");
		//Gets the format of audio signal
		AudioFormat af = ((AudioFormat)context.getAttribute("AudioFormat"));
		//Sets the content type and header
		response.setContentType("APPLICATION/OCTET-STREAM");
		response.setHeader("Content-Disposition","attachment; filename=\"" +filename + "\"");
		
		try {
			// Opens the output stream to write binary data
			ServletOutputStream outStream = response.getOutputStream();
			//Calls download method of AudioDownload class
			new AudioDownload(buffer,af,outStream).download();
			//closes the output stream  
			outStream.close();
        }
		catch(Exception e)	{
			e.printStackTrace();
        }
	}
}