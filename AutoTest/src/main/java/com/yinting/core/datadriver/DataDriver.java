package com.yinting.core.datadriver;

import java.util.Iterator;

public abstract class DataDriver implements Iterator<Object[]> {
	public static String[] parameter = {""};
	public abstract int getType();
}
