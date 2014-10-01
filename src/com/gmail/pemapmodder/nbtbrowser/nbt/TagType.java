package com.gmail.pemapmodder.nbtbrowser.nbt;

import java.io.DataInputStream;
import java.io.IOException;

public enum TagType implements TagIds{
	TAG_END(END, EndTag.class){
		@Override
		public boolean isNamed(){
			return false;
		}
	},
	TAG_BYTE(BYTE, ByteTag.class),
	TAG_SHORT(SHORT, ShortTag.class),
	TAG_INT(INT, IntTag.class),
	TAG_LONG(LONG, LongTag.class),
	TAG_FLOAT(FLOAT, FloatTag.class),
	TAG_DOUBLE(DOUBLE, DoubleTag.class),
	TAG_BYTE_ARRAY(BYTE_ARRAY, ByteArrayTag.class),
	TAG_STRING(STRING, StringTag.class),
	TAG_LIST(LIST, ListTag.class),
	TAG_COMPOUND(COMPOUND, CompoundTag.class),
	TAG_INT_ARRAY(INT_ARRAY, IntArrayTag.class);

	byte tagId;
	Class<? extends Tag> clazz;
	TagType(byte tagId, Class<? extends Tag> clazz){
		this.tagId = tagId;
		this.clazz = clazz;
	}

	public Tag newInstance(DataInputStream is) throws IOException{
		return newInstance(is, true);
	}
	public Tag newInstance(DataInputStream is, boolean readName) throws IOException{
		try{
			Tag result = clazz.newInstance();
			if(isNamed() && readName){
				byte[] buffer = new byte[is.readShort()];
				is.read(buffer);
				((NamedTag) result).setName(new String(buffer, "UTF-8"));
			}
			return result;
		}
		catch(Exception e){
			return null;
		}
	}
	public boolean isNamed(){
		return true;
	}

	public static TagType forTagId(byte id){
		for(TagType type: values()){
			if(type.tagId == id){
				return type;
			}
		}
		return null;
	}
	public static TagType forTag(Tag tag){
		return forClass(tag.getClass());
	}
	public static TagType forClass(Class<? extends Tag> clazz){
		for(TagType type: values()){
			if(type.clazz.equals(clazz)){
				return type;
			}
		}
		return null;
	}
}
