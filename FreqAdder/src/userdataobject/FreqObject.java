package userdataobject;

/**
 * Class that handles user inputs e.g frequency, amplitude, phase, sampling rate, file name.
 * @see FreqObject #getAmp_1()
 * @see FreqObject #getAmp_2()
 * @see FreqObject #getF1()
 * @see FreqObject #getF2()
 * @see FreqObject #getFreq1()
 * @see FreqObject #getFreq2()
 * @see FreqObject #getPhase_1()
 * @see FreqObject #getPhase_2()
 * @see FreqObject #getSampRate()
 * @see FreqObject #getSignal()
 * @see FreqObject #getSum()
 * @see FreqObject #setTime(int)
 * @see FreqObject #getWavefilename()
 * @author Ehsan-Ul-Haq
 * @Date 3 February 2016
 * @version 1.0
 */
public class FreqObject {
	String Signal;
	
	String freq1;
	String freq2;
	String sum;
	String wavefilename;
	
	int f1,f2;

	double sampRate;
	double amp_1;
	double amp_2;
	int phase_1;
	int phase_2;
	
	int time;
	

	
	/**
	 * Gets the file name entered by user
	 * @return the wave filename
	 */
	public String getWavefilename()
	{
		return wavefilename;
	}
	/**
	 * Sets the file name entered by user
	 * @param wavefilename the wave filename to set
	 */
	public void setWavefilename(String wavefilename)
	{
		this.wavefilename = wavefilename;
	}
	/**
	 * Gets the phase 1 entered by the user
	 * @return the phase_1
	 */
	public int getPhase_1()
	{
		return phase_1;
	}
	/**
	 * Sets the phase 1 entered by the user
	 * @param phase_1 the phase_1 to set
	 */
	public void setPhase_1(int phase_1)
	{
		this.phase_1 = phase_1;
	}
	/**
	 * Gets the phase 2 entered by the user
	 * @return the phase_2
	 */
	public int getPhase_2()
	{
		return phase_2;
	}
	/**
	 * Sets the phase 2 entered by the user
	 * @param phase_2 the phase_2 to set
	 */
	public void setPhase_2(int phase_2)
	{
		this.phase_2 = phase_2;
	}
	/**
	 * Gets the amplitude 1 entered by the user
	 * @return the amp_1
	 */
	public double getAmp_1()
	{
		return amp_1;
	}
	/**
	 * Sets the amplitude 2 entered by the user
	 * @param amp_1 the amp_1 to set
	 */
	public void setAmp_1(double amp_1)
	{
		this.amp_1 = amp_1;
	}
	/**
	 * Gets the amplitude 2 entered by the user
	 * @return the amp_2
	 */
	public double getAmp_2()
	{
		return amp_2;
	}
	/**
	 * Sets the amplitude 2 entered by the user
	 * @param amp_2 the amp_2 to set
	 */
	public void setAmp_2(double amp_2)
	{
		this.amp_2 = amp_2;
	}
	
	
	/**
	 * Gets the type of signal selected by the user
	 * @return the signal
	 */
	public String getSignal()
	{
		return Signal;
	}
	/**
	 * Sets the type of signal selected by user
	 * @param signal the signal to set
	 */
	public void setSignal(String signal)
	{
		Signal = signal;
	}
	
	
	/**
	 * Gets the selection of Frequency 1 
	 * @return the freq1
	 */
	public String getFreq1()
	{
		return freq1;
	}
	/**
	 * Sets the selection of Frequency 1 
	 * @param freq1 the freq1 to set
	 */
	public void setFreq1(String freq1)
	{
		this.freq1 = freq1;
	}
	/**
	 * Gets the selection of Frequency 2 
	 * @return the freq2
	 */
	public String getFreq2()
	{
		return freq2;
	}
	/**
	 * Sets the selection of Frequency 2 
	 * @param freq2 the freq2 to set
	 */
	public void setFreq2(String freq2)
	{
		this.freq2 = freq2;
	}
	/**
	 * Gets the selection of Sum
	 * @return the sum
	 */
	public String getSum()
	{
		return sum;
	}
	/**
	 * Sets the selection of Sum
	 * @param sum the sum to set
	 */
	public void setSum(String sum)
	{
		this.sum = sum;
	}
	/**
	 * Gets the value of Frequency 1 entered by the user
	 * @return the f1
	 */
	public int getF1()
	{
		return f1;
	}
	/**
	 * Sets the value of Frequency 1 entered by the user
	 * @param f1 the f1 to set
	 */
	public void setF1(int f1)
	{
		this.f1 = f1;
	}
	/**
	 * Gets the value of Frequency 2 entered by the user
	 * @return the f2
	 */
	public int getF2()
	{
		return f2;
	}
	/**
	 * Sets the value of Frequency 2 entered by the user
	 * @param f2 the f2 to set
	 */
	public void setF2(int f2)
	{
		this.f2 = f2;
	}
	/**
	 * Gets the value of Sample rate selected by the user
	 * @return the sampRate
	 */
	public double getSampRate()
	{
		return sampRate;
	}
	/**
	 * Sets the value of Sample rate selected by the user
	 * @param sampRate the sampRate to set
	 */
	public void setSampRate(double sampRate)
	{
		this.sampRate = sampRate;
	}

	/**
	 * Gets the value of Time set in seconds 
	 * @return the time
	 */
	public int getTime()
	{
		return time;
	}
	/**
	 * Sets the value of Time set in seconds 
	 * @param time the time to set
	 */
	public void setTime(int time)
	{
		this.time = time;
	}	
}