package me.emily;

public abstract class FullRangeSong extends Song{

	@Override
	int getFrame(byte[] buffer) {
		if (active == null) {
			active = song().iterator();
		}
		int i = -1;
		int limit = buffer.length -1;
		while(active.hasNext() && limit !=  i) {
			int n = active.next();
			buffer[++i] = (byte)n;
			buffer[++i] = (byte)(n>>8);
			buffer[++i] = (byte)(n>>16);
			buffer[++i] = (byte)(n>>24);
		}
		return i;
	}

}
