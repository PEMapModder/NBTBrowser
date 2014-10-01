package com.gmail.pemapmodder.nbtbrowser.nbt;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ByteArrayTag extends NamedTag{
	public byte[] value;

	@Override
	public byte getTagId(){
		return BYTE_ARRAY;
	}

	@Override
	public void write(DataOutputStream os, NBTWriter writer) throws IOException{
		os.write(value);
	}

	@Override
	public void read(DataInputStream is, NBTReader reader) throws IOException{
		is.read(value);
	}
}
