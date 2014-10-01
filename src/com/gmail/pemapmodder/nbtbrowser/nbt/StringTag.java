package com.gmail.pemapmodder.nbtbrowser.nbt;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class StringTag extends NamedTag{
	public String value;

	@Override
	public byte getTagId(){
		return STRING;
	}

	@Override
	public void write(DataOutputStream os, NBTWriter writer) throws IOException{
		os.writeShort(value.length());
		os.write(value.getBytes("UTF-8"));
	}

	@Override
	public void read(DataInputStream is, NBTReader reader) throws IOException{
		byte[] buffer = new byte[is.readShort()];
		is.read(buffer);
		value = new String(buffer, "UTF-8");
	}
}
