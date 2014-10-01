package com.gmail.pemapmodder.nbtbrowser.nbt;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;

public class ListTag extends NamedTag{
	public Tag[] value;

	@Override
	public byte getTagId(){
		return LIST;
	}

	@Override
	public void write(DataOutputStream os, NBTWriter writer) throws IOException{
		os.writeByte(getEntryTagId());
		os.writeInt(value.length);
		for(Tag entry: value){
			entry.write(os, writer);
		}
	}

	@Override
	public void read(DataInputStream is, NBTReader reader) throws IOException{
		TagType type = TagType.forTagId((byte) is.read());
		value = (Tag[]) Array.newInstance(type.clazz, is.readInt());
		for(int i = 0; i < value.length; i++){
			value[i] = type.newInstance(is, false);
		}
	}

	public byte getEntryTagId(){
		byte type = -1;
		for(Tag tag: value){
			byte tmp = tag.getTagId();
			if(tmp != type){
				throw new RuntimeException("Non-uniform tag type in ListTag!");
			}
			type = tmp;
		}
		return type;
	}
}
