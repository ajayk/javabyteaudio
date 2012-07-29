package me.emily;

import java.util.Iterator;

import com.google.common.base.Function;
import com.google.common.collect.AbstractIterator;

public class Folds {
	public static Function<Integer,Function<Integer,Integer>> or = new Function<Integer,Function<Integer,Integer>>() {

		@Override
		public Function<Integer, Integer> apply(final Integer first) {
			return new Function<Integer,Integer>() {

				@Override
				public Integer apply(Integer second) {
					return first|second;
				}
				
			};
			
		}
	};
	
	public static Function<Integer,Function<Integer,Integer>> xor = new Function<Integer,Function<Integer,Integer>>() {

		@Override
		public Function<Integer, Integer> apply(final Integer first) {
			return new Function<Integer,Integer>() {

				@Override
				public Integer apply(Integer second) {
					return first^second;
				}
				
			};
			
		}
	};
	
	public static Function<Integer,Function<Integer,Integer>> and = new Function<Integer,Function<Integer,Integer>>() {

		@Override
		public Function<Integer, Integer> apply(final Integer first) {
			return new Function<Integer,Integer>() {

				@Override
				public Integer apply(Integer second) {
					return first&second;
				}
				
			};
			
		}
	};
	
	public static Iterable<Integer> foldLeft(final Iterable<Integer> first,final Iterable<Integer> second, final Function<Integer,Function<Integer,Integer>> fold) {
		return new Iterable<Integer>() {

			@Override
			public Iterator<Integer> iterator() {
				final Iterator<Integer> a = first.iterator();
				final Iterator<Integer> b = second.iterator();
				return new AbstractIterator<Integer>() {

					@Override
					protected Integer computeNext() {
						if (a.hasNext() && b.hasNext()) {
							return fold.apply(a.next()).apply(b.next());
						}
						return endOfData();
					}
					
				};
			}
			
		};
	}
	
}
