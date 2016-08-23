package utilities;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

/**
 * Class that plays the generated audio signal
 * @see AudioPlay #AudioPlay(byte[], AudioFormat)
 * @see AudioPlay #play()
 * @author Ehsan-Ul-Haq
 * @Date 3 February 2016
 * @version 1.0
 */
public class AudioPlay {
	private byte[] audioBufferArray;
	private AudioFormat af;
	
	/**
	 * Constructor AudioPlay class with parameters of Byte array and Audio Format
	 * @param audioBufferArray is a Byte array of generated signal
	 * @param af format of generated audio signal 
	 */
	public AudioPlay(byte[] audioBufferArray,AudioFormat af){
		this.audioBufferArray=audioBufferArray;
		this.af=af;
	}
	
	/**
	 * Method that plays the audio signal 
	 * @see javax.sound.sampled.SourceDataLine
	 */
	public void play(){
	try
	{
		SourceDataLine line;
		DataLine.Info info;
		info = new DataLine.Info(SourceDataLine.class, af);
		line = (SourceDataLine) AudioSystem.getLine(info);
		line.open();
		line.start();
		line.write(audioBufferArray, 0, audioBufferArray.length);
		line.drain();
		line.stop();
		line.close();
	}catch (Exception e)
		{
		e.printStackTrace();
		System.exit(0);
		}
	}
}
