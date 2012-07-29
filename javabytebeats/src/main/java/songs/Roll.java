package songs;

import java.util.Iterator;

import javax.sound.sampled.LineUnavailableException;

import com.google.common.collect.AbstractIterator;

import me.emily.LSBSong;
import me.emily.Player;

public class Roll extends LSBSong {
public static void main(String[] args) throws LineUnavailableException {
	new Player().play(new Roll());
}
	@Override
	protected Iterable<Integer> song() {
		
		return new Iterable<Integer>() {

			@Override
			public Iterator<Integer> iterator() {
				return new AbstractIterator<Integer>() {
					int t = 0;
					@Override
					protected Integer computeNext() {
						t++;
						double[] d = new double[]{8/9,1,9/8,6/5,4/3,3/2,0};
						
						int[] i = new int[]{0xd2d2c8,0xce4088,0xca32c8,0x8e4009};
						
						int td = i[t>>14&3]>>(0x3dbe4688>>((t>>10&15)>9?18:t>>10&15)*3&7)*3&7;
						
						return (t<<3)* (int)d[td] & 255;
					}
					
				};
			}
			
		};
	}

	
	
}
