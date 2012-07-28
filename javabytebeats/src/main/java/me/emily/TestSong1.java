package me.emily;

import java.util.Iterator;

import javax.sound.sampled.LineUnavailableException;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;

public class TestSong1 extends Song {

	public static void main(String[] args) throws LineUnavailableException {
		new Player().play(new TestSong1());
	}

	@Override
	Iterable<Integer> song() {

		Iterable<Integer> a = Iterables.limit(part1(),500500);
		Iterable<Integer> b = Iterables.limit(part2(),5000000);
		//return Iterables.concat(a, a, b, b);
		
		return Iterables.cycle(part2());

	}

	private Iterable<Integer> part2() {
		return new Iterable<Integer>() {

			public Iterator<Integer> iterator() {
				return new AbstractIterator<Integer>() {
					int t = 0;

					char[] c = "36364689".toCharArray();

					@Override
					protected Integer computeNext() {
						t++;
						return ((t * (c[t >> 13 & 7] & 15)) / 12 & 128)
								+ (((((t >> 12) ^ (t >> 12) - 2) % 11 * t) / 4 | t >> 13) & 127);
					}
				};
			}
		};
	}

	private Iterable<Integer> part1() {
		return new Iterable<Integer>() {

			public Iterator<Integer> iterator() {
				return new AbstractIterator<Integer>() {
					int t = 0;

					@Override
					protected Integer computeNext() {
						t++;
						return ((t << 1) ^ ((t << 1) + (t >> 7) & t >> 12))
								| t >> (4 - (1 ^ 7 & (t >> 19))) | t >> 7;
					}

				};
			}
		};
	}
}
