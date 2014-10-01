package com.gmail.pemapmodder.nbtbrowser.nbt;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import android.support.v4.util.ArrayMap;

public class CompoundTag extends NamedTag{
	private Map<String, NamedTag> value = new ArrayMap<String, NamedTag>(1);

	public boolean add(NamedTag tag){
		if(value.containsKey(tag.getName())){
			return false;
		}
		value.put(tag.getName(), tag);
		return true;
	}
	public NamedTag get(String name){
		return value.get(name);
	}
	public Map<String, NamedTag> getValue(){
		return value;
	}
	public Collection<NamedTag> getTags(){
		return value.values();
	}

	@Override
	public byte getTagId(){
		return COMPOUND;
	}

	@Override
	public void write(DataOutputStream os, NBTWriter writer) throws IOException{
		for(NamedTag tag: value.values()){
			writer.writeTag(tag);
		}
		writer.writeTag(new EndTag());
	}

	@Override
	public void read(DataInputStream is, NBTReader reader) throws IOException{
		while(true){
			Tag tag = reader.readTag();
			if(tag instanceof NamedTag){
				NamedTag namedTag = (NamedTag) tag;
				value.put(namedTag.getName(), namedTag);
			}
			else{
				break;
			}
		}
	}
}
