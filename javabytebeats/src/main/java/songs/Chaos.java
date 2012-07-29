package songs;

import java.util.Iterator;

import javax.sound.sampled.LineUnavailableException;

import com.google.common.collect.AbstractIterator;

import me.emily.FullRangeSong;
import me.emily.LSBSong;
import me.emily.Player;

public class Chaos extends FullRangeSong{
public static void main(String[] args) throws LineUnavailableException {
	new Player().play(new Chaos());
}
	@Override
	protected Iterable<Integer> song() {
		return new Iterable<Integer>(){

			@Override
			public Iterator<Integer> iterator() {
				return new AbstractIterator<Integer>(){
					int t = 0;
					int[] ns = new int[]{3,3,4,7,2};
					@Override
					protected Integer computeNext() {
						t++;
						int w=t>>9;
						int		k=32;
							int	m=2048;
							int	a=1-t/m%1;
							int	d=(14*t*t^t)%m*a;
							int p=w/k&3;
							//int	y=ns[p]*t/4;
							int	y=ns[p]/5*t;
							int	h="IQNNNN!!]]!Q!IWJWQNN??!!WJWQNNN?".toCharArray()[w/2&15|p/3<<4]/33*t-t;
		//	int h = "IQNNNN!!]]!Q!IW]WQNN??!!W]WQNNN?".toCharArray()[w/2&15|p/3<<4];				
double		s= (((y)*.96%64+y%64)*1.2+((5*t%m*a&k*4)*(0x53232323>>w/4&1)+((d=(14*t*t^t)%m*a)&127)*(0xa444c444>>w/4&1)*1.5+(d*w&1)/7.5+((
		h/33*t-t)%k+h*1.99%k+h*.49%k+h*.97%k-64)*(2-a)*2)*(w>>7&a));
									
	//						int	s=y*.98%80+y%80+(w>>7&a*((5*t%m*a&128)*(0x53232323>>w/4&1)+(d&127)*0xa444c444>>w/4&1)*1.5+(d*w&1)+(h%k+h*1.99%k+h*.49%k+h*.97%k-64)*(4-1-1));
							return	(int)s;

						
					}
					
				};
			}
			
		};
	}

}
