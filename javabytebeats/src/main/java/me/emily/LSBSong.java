package me.emily;

public abstract class LSBSong extends Song{

	@Override
	final int getFrame(byte[] buffer) {
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

}
