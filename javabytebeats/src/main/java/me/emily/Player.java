package me.emily;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

import com.google.common.math.IntMath;

public class Player {
	
	private final SourceDataLine  auline;

	private final AudioFormat format;
	
	public Player() throws LineUnavailableException {
		super();
	
		AudioFormat.Encoding encoding = AudioFormat.Encoding.PCM_SIGNED;
		float rate = 44100.0f;
		int channels = 1;
		
		int sampleSize = 16;
		int frameSize = (sampleSize / 8) * channels;
		boolean bigEndian = true;

		format = new AudioFormat(encoding, rate, sampleSize,
				channels, frameSize, rate, bigEndian);
		
		
		
		
		DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

		  auline = (SourceDataLine) AudioSystem.getLine(info);

		
		System.out.println("looping...");

		
	}

	public void play(Song song) throws LineUnavailableException {

		auline.open(format);
		auline.start();
		
		byte[] b = new byte[1024];
		int len = -1;
		while((len = song.getFrame(b)) != -1) {
			if (len == -1) {
				break;
			}
			auline.write(b, 0, nearestPowerOfTwo(len+1));
		}
		System.out.println("Done.");
		
	}
	int nearestPowerOfTwo(int i) {
		int n = 1;
		while(i > n) {
			n<<=1;
		}
		return n;
	}
}
