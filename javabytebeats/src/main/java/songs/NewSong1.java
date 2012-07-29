package songs;

import java.util.Iterator;

import javax.sound.sampled.LineUnavailableException;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Iterables;
import com.google.common.math.IntMath;

import me.emily.Folds;
import me.emily.FullRangeSong;
import me.emily.LSBSong;
import me.emily.Player;

public class NewSong1 extends LSBSong{
	public static void main(String[] args) throws LineUnavailableException {
		new Player().play(new NewSong1());
	}
	@Override
	protected Iterable<Integer> song() {
		Iterable<Integer> first = Iterables.cycle(Iterables.limit(partA(),500000));
		Iterable<Integer> second = Iterables.cycle(Iterables.limit(partB(), 250000));
//		return Folds.foldLeft(first, second, Folds.xor);
		return second;
	}
	
	
	
	private Iterable<Integer> partB() {
		return new Iterable<Integer>() {

			@Override
			public Iterator<Integer> iterator() {
				
				return new AbstractIterator<Integer>() {
					int t = 1;
					
					@Override
					protected Integer computeNext() {
						t++;
						return t*(((t>>12)|(t>>8))&(63&(t>>4)));
						
					}
					
				};
			}
			
		};
	}
	private Iterable<Integer> partA() {
		return new Iterable<Integer>() {

			@Override
			public Iterator<Integer> iterator() {
				
				return new AbstractIterator<Integer>() {
					int t = 1;
					
					char[] c = "1232423282324232cacdcacrcacqcacr".toCharArray();
					int m = c.length;
					@Override
					protected Integer computeNext() {
						
						t ^=  c[IntMath.mod(t, m)];
						t ^= t<<19 | t >>>19;
						t ^=  c[IntMath.mod(t, m)]<<7;
						System.out.println(t);
						return t;
					}
					
				};
			}
			
		};
	}

}
