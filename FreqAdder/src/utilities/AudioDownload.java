package utilities;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
/**
 * Class that creates and downloads .wav audio file of generated signal
 * @see AudioDownload #AudioDownload(byte[], AudioFormat, ServletOutputStream)
 * @see AudioDownload #download()
 * @author Ehsan-Ul-Haq
 * @Date 3 February 2016
 * @version 1.0
 */
public class AudioDownload {
	/**
	 * Byte array of generated audio signal
	 */
	private byte[] audioBufferArray;
	/**
	 * Format of audio signal
	 */
	private AudioFormat af;
	private ServletOutputStream responseOutputStream;
	
	/**
	 * Constructor of AudioDownload class with parameters of Byte array, Audio Format and Response OutPut Stream
	 * @param audioBufferArray Byte array of generated signal
	 * @param af Format of audio file
	 * @param responseOutputStream Output Stream for sending binary data 
	 */
	public AudioDownload(byte[] audioBufferArray,AudioFormat af,ServletOutputStream responseOutputStream){
		this.audioBufferArray=audioBufferArray;
		this.af=af;
		this.responseOutputStream=responseOutputStream;
	}
	
	/**
	 * Method to download .wav audio file 
	 * @see ByteArrayInputStream 
	 * @see javax.sound.sampled.AudioSystem AudioSystem.write()
	 */
	public void download(){
		
		/**
		 * An instance of AudioInputStream class
		 */
		AudioInputStream ais = new AudioInputStream(
                new ByteArrayInputStream(audioBufferArray)
               ,af
               ,audioBufferArray.length / af.getFrameSize());
		
	
             try {
            	//write the data from AudioInputStream in .wav file
				AudioSystem.write(ais,AudioFileFormat.Type.WAVE,responseOutputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        

	}
}
