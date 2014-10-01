package com.gmail.pemapmodder.nbtbrowser.nbt;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class LongTag extends NamedTag{
	public long value;

	@Override
	public byte getTagId(){
		return LONG;
	}

	@Override
	public void write(DataOutputStream os, NBTWriter writer) throws IOException{
		os.writeLong(value);
	}

	@Override
	public void read(DataInputStream is, NBTReader reader) throws IOException{
		value = is.readLong();
	}
}
