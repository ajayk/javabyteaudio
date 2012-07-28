package me.emily;

import java.util.Iterator;


public abstract class Song {

	
	private Iterator<Integer> active;
	public final int getFrame(byte[] buffer) {
		if (active == null) {
			active = song().iterator();
		}
		int i = -1;
		int limit = buffer.length -1;
		while(active.hasNext() && limit !=  i) {
			buffer[++i] = active.next().byteValue();
		}
		return i;
	}
	
	abstract Iterable<Integer> song();
	
}
