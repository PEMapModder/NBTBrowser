package com.gmail.pemapmodder.nbtbrowser.nbt;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class IntArrayTag extends NamedTag{
	public int[] value;

	@Override
	public byte getTagId(){
		return INT_ARRAY;
	}

	@Override
	public void write(DataOutputStream os, NBTWriter writer) throws IOException{
		os.writeInt(value.length);
		for(int entry: value){
			os.writeInt(entry);
		}
	}

	@Override
	public void read(DataInputStream is, NBTReader reader) throws IOException{
		value = new int[is.readInt()];
		for(int i = 0; i < value.length; i++){
			value[i] = is.readInt();
		}
	}
}
