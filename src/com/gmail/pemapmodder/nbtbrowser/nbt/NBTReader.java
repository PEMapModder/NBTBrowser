package com.gmail.pemapmodder.nbtbrowser.nbt;

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class NBTReader implements Closeable{
	private DataInputStream is;
	public NBTReader(InputStream is){
		this.is = new DataInputStream(is);
	}

	public Tag readTag() throws IOException{
		Tag tag = TagType.forTagId(is.readByte()).newInstance(is);
		tag.read(is, this);
		return tag;
	}

	@Override
	public void close() throws IOException{
		is.close();
	}
}
