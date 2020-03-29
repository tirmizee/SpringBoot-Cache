package com.tirmizee.config.cache;

import java.io.Serializable;
import java.util.Arrays;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

public class CustomCacheKey implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final CustomCacheKey EMPTY = new CustomCacheKey();

	private final Object[] params;
	private final int hashCode;
	
	public CustomCacheKey(Object...elements) {
		Assert.notNull(elements, "null value");
		params = new Object[elements.length];
		System.arraycopy(elements, 0, params, 0, elements.length);
		this.hashCode = Arrays.deepHashCode(params);
	}
	
	@Override
	public boolean equals(Object obj) {
		return (this == obj || (obj instanceof CustomCacheKey &&
		Arrays.deepEquals(this.params, ((CustomCacheKey) obj).params)));
	}

	@Override
	public final int hashCode() {
		return this.hashCode;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [" + StringUtils.arrayToCommaDelimitedString(this.params) + "]";
	}

}
