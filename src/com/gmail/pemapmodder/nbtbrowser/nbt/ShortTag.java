package com.gmail.pemapmodder.nbtbrowser.nbt;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ShortTag extends NamedTag{
	public short value;

	@Override
	public byte getTagId(){
		return SHORT;
	}

	@Override
	public void write(DataOutputStream os, NBTWriter writer) throws IOException{
		os.writeShort(value);
	}

	@Override
	public void read(DataInputStream is, NBTReader reader) throws IOException{
		value = is.readShort();
	}
}
