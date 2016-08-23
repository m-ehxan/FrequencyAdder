package signal;

import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import userdataobject.FreqObject;
/**
 * Main class to generate audio Signals. Outputs of this class are File Name, Byte Array of generated signal
 * and Audio signals format
 * @see Tone #createTone()
 * @see Tone #getFilename()
 * @see Tone #getBuf()
 * @see Tone # getAudioFormat()
 * @author Ehsan-Ul-Haq
 * @Date 3 February 2016
 * @version 1.0
 */
public abstract class Tone {
	
	//stores the float values of output of Math.Sin function
	protected float [] buffer;
	//Stores the bytes conversion of float values of output of Math.Sin function
	protected byte[] byteBuffer;
	//instance variable of AudioFormat class
	protected AudioFormat _audio;
	//Stores the file name of .wav file
	String _filename = null;
	
	// user inputs
	protected double f1, f2;
	protected static double amp_1;
	protected static double amp_2;
	protected static double phase_1;
	protected static double phase_2;
	protected int waveSelection;
	protected static double _sampleRate;
	
	// Parameters of Math.Sin function
	protected static double nsamples;
	protected static double twoPiF1;
	protected static double twoPiF2;
	protected static double time;

	/**
	 * Constructor of Tone class with specified user inputs and waveSelection (Frequency 1, 2 or Sum)
	 * @param dao user data objects, gets all the user inputs e.g frequency, amplitude, phase
	 * and sample rate
	 * @param waveSelection gets the user selection for Frequency 1, 2 or Sum
	 */
	Tone(FreqObject dao, int waveSelection) {
		
		f1 = (double) dao.getF1();
		f2 = (double) dao.getF2();
		amp_1 = (double) dao.getAmp_1();
		amp_2 = (double) dao.getAmp_2();
		phase_1 = (double) dao.getPhase_1();
		phase_2 = (double) dao.getPhase_2();


		_sampleRate = (double) dao.getSampRate();
		this.waveSelection = waveSelection;
	}

	/**
	 * Method to create audio frequency signal. It calls the generate signal method in Sine, Triangle 
	 * or Square class depending upon the the user selection
	 * @throws IOException
	 * @see #generateSignal()
	 */
	public void createTone() throws IOException {
		
		nsamples = _sampleRate * 4;
		buffer =	new float[(int) (nsamples)];
		_audio = new AudioFormat((float) _sampleRate, 16, 1, true, false);

		
			twoPiF1 = 2.0 * Math.PI * f1;
			twoPiF2 = 2.0 * Math.PI * f2;
		

		for (int sample = 0; sample < buffer.length; sample ++) {
			
			 time = (double)sample / _sampleRate;
			
			generateSignal(sample,waveSelection);
			

		}
		
		//conversion from float to Byte. Byte Buffer is two times the length of float Buffer
		byteBuffer = new byte[buffer.length * 2];
		int bufferIndex = 0;
		for (int i = 0; i < byteBuffer.length; i++) {
		final int x = (int) (buffer[bufferIndex++] * 32767.0);
		byteBuffer[i] = (byte) x;
		i++;
		byteBuffer[i] = (byte) (x >>> 8);
		}

	}

	/**
	 * Method to generate audio signal on the basis of user selection and store the float values 
	 * of generated signal in a buffer array of type float
	 * @param sample is the sample number of audio signal
	 * @param waveSelection is the user selection for Frequency 1, 2 or Sum
	 */
	public abstract void generateSignal(int sample, int waveSelection);

	/**
	 * It returns a string with file name of .wav file
	 * @return file name of .wav file
	 */
	public String getFilename() {
		return _filename;
	}

	/**
	 * It is a buffer array with byte values of generated audio signal
	 * @return returns the Byte array of generated signal
	 */
	public byte[] getBuf(){
		return byteBuffer;
	}

	/**
	 * It returns the format of audio .wav file
	 * @return audio format of generated signal 
	 */
	public AudioFormat getAudioFormat(){
		return _audio;
	}
}
