package com.app.util;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface CollectionUtil {
	@SuppressWarnings("unchecked")
	public static Map<String, List<String>> toMap(List<Object[]> findByCriteria) {
		return findByCriteria
				.stream()
				.collect(
						Collectors.toMap(
								
								ob->(String)ob[0],ob->(List<String>)ob[1])
						);
	}
}
