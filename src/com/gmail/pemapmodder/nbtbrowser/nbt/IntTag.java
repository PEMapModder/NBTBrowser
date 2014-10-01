package com.gmail.pemapmodder.nbtbrowser.nbt;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class IntTag extends NamedTag{
	public int value;

	@Override
	public byte getTagId(){
		return INT;
	}

	@Override
	public void write(DataOutputStream os, NBTWriter writer) throws IOException{
		os.writeInt(value);
	}

	@Override
	public void read(DataInputStream is, NBTReader reader) throws IOException{
		value = is.readInt();
	}
}
