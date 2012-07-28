package me.emily;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer.Info;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Test1 {
	public static void main(String[] args) throws LineUnavailableException,
			IOException, UnsupportedAudioFileException {

		AudioFormat.Encoding encoding = AudioFormat.Encoding.PCM_SIGNED;
		float rate = 44100.0f;
		int channels = 1;
		
		int sampleSize = 16;
		int frameSize = (sampleSize / 8) * channels;
		boolean bigEndian = true;

		AudioFormat format = new AudioFormat(encoding, rate, sampleSize,
				channels, frameSize, rate, bigEndian);
		
		
		
//		InputStream istream = new InputStream() {
//			int t = 0;
//
//			@Override
//			public int read() throws IOException {
//				t++;
//				return ((t<<1)^((t<<1)+(t>>7)&t>>12))|t>>(4-(1^7&(t>>19)))|t>>7;
//			}
//			
//		};

		

//		AudioInputStream playbackInputStream = AudioSystem.getAudioInputStream(
//				format, AudioSystem.getAudioInputStream(istream));

		
		DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

		SourceDataLine  auline = (SourceDataLine) AudioSystem.getLine(info);
		auline.open(format);
		auline.start();
		byte[] b = new byte[1024];
		System.out.println("looping...");
		for (int i = 0; i < 1000; i++) {
			System.out.print(i+":");
//			istream.read(b);
			
			
			
			System.out.println();
			auline.write(b, 0, b.length);
		}
	}
}
