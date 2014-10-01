package com.gmail.pemapmodder.nbtbrowser.nbt;

public abstract class NamedTag implements Tag{
	protected String name;
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
}
