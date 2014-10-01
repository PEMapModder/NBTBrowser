package com.gmail.pemapmodder.nbtbrowser.nbt;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ByteTag extends NamedTag{
	public byte value;

	@Override
	public byte getTagId(){
		return BYTE;
	}

	@Override
	public void write(DataOutputStream os, NBTWriter writer) throws IOException{
		os.writeByte(value);
	}

	@Override
	public void read(DataInputStream is, NBTReader reader) throws IOException{
		value = is.readByte();
	}
}
