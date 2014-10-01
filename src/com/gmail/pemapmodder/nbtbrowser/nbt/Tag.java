package com.gmail.pemapmodder.nbtbrowser.nbt;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public interface Tag extends TagIds{
	public byte getTagId();
	/**
	 * @param os - the {@link DataOutputStream} to write into
	 * @throws IOException
	 */
	public void write(DataOutputStream os, NBTWriter writer) throws IOException;
	/**
	 * @param is - the {@link DataInputStream} to read with
	 * @throws IOException
	 */
	public void read(DataInputStream is, NBTReader reader) throws IOException;
}
