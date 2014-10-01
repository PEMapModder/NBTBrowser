package com.gmail.pemapmodder.nbtbrowser.nbt;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class EndTag implements Tag{
	@Override
	public byte getTagId(){
		return END;
	}

	@Override
	public void write(DataOutputStream os, NBTWriter writer) throws IOException{
	}

	@Override
	public void read(DataInputStream is, NBTReader reader) throws IOException{
	}
}
