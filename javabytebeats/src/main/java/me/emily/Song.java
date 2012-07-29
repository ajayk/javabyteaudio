package me.emily;

import java.util.Iterator;


public abstract class Song {

	
	 Iterator<Integer> active;
	
	 abstract int getFrame(byte[] buffer); 
	
	
	protected abstract Iterable<Integer> song();
	
}
