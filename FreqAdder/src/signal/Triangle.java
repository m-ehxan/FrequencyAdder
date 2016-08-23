package signal;

import userdataobject.FreqObject;

/**
 * Class to create triangle wave audio signal. It extends from Tone class 
 * @author Ehsan-Ul-Haq
 * @Date 3 February 2016
 * @version 1.0
 */
public class Triangle extends Tone{

	/**
	 * Constructor of Sine class with specified user inputs e.g file name and user selection for 
	 * Frequency1, Frequency2 or Sum
	 * @param dao gets the user inputs e.g filename for .wav file. If user does not enter file name,
	 * then "untited.wav" is taken by default
	 * @param waveSelection parameter for user selection for Frequency 1, 2 or Sum
	 */
	public Triangle(FreqObject dao, int waveSelection) {
		super(dao, waveSelection);
		
		_filename= dao.getWavefilename()+".wav";

	}

	/**
	 * Method to generate audio signal on the basis of user selection and store the float values 
	 * of generated signal in a buffer array of type float
	 * @param sample is the sample number of audio signal
	 * @param waveSelection is the user selection for Frequency 1, 2 or Sum
	 */
	public void generateSignal(int sample, int waveSelection) {
		// TODO Auto-generated method stub
		
		// checks for user selection of Frequency 1 , 2 or Sum of both
		if(waveSelection==0)
		{
			buffer[sample]=(float)((float)amp_1 * Math.asin(Math.sin(twoPiF1*time + Math.toRadians( phase_1 ))));
		}
		
		else if(waveSelection==1)
		{
			buffer[sample]=(float)((float)amp_2 * Math.asin(Math.sin(twoPiF2*time + Math.toRadians( phase_2 ))));
		}
		else if(waveSelection==2)
		{
			double f1Component = 0.5 * amp_1 * Math.asin(Math.sin(twoPiF1*time + Math.toRadians( phase_1 )));
			double f2Component = 0.5 * amp_2 * Math.asin(Math.sin(twoPiF2*time + Math.toRadians( phase_2 )));
			buffer[sample] = (float) (f1Component + f2Component);

		}
	}

}
