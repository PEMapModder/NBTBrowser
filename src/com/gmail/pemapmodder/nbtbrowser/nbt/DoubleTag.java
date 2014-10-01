package com.gmail.pemapmodder.nbtbrowser.nbt;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class DoubleTag extends NamedTag{
	public double value;

	@Override
	public byte getTagId(){
		return DOUBLE;
	}

	@Override
	public void write(DataOutputStream os, NBTWriter writer) throws IOException{
		os.writeDouble(value);
	}

	@Override
	public void read(DataInputStream is, NBTReader reader) throws IOException{
		value = is.readDouble();
	}
}
