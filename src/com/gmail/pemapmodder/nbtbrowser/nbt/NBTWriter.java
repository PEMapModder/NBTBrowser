package com.gmail.pemapmodder.nbtbrowser.nbt;

import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;

public class NBTWriter implements Closeable{
	private DataOutputStream os;

	public NBTWriter(DataOutputStream os){
		this.os = os;
	}

	public void writeTag(Tag tag) throws IOException{
		os.write(tag.getTagId());
		if(tag instanceof NamedTag){
			String name = ((NamedTag) tag).getName();
			os.writeShort(name.length());
			os.write(name.getBytes("UTF-8"));
		}
		tag.write(os, this);
	}

	@Override
	public void close() throws IOException{
		os.close();
	}
}
