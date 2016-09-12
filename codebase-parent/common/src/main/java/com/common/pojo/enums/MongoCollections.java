/**
 * 
 */
package com.common.pojo.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Goutham P N
 *
 */
public enum MongoCollections {

	DEFAULT(1, "DEFAULT", "DEFAULT"), BIRDS(2, "BIRDS", "BIRDS Collection"), LISTENER(3, "Listener", "Listeners");

	private int code;
	private String strcode;
	private String description;

	/**
	 * A mapping between the integer code and its corresponding Status to
	 * facilitate lookup by code.
	 */
	private static Map<Integer, MongoCollections> codeToStatusMapping;
	private static Map<String, MongoCollections> strCodeToStatusMapping;

	private MongoCollections(int code, String strcode, String description) {
		this.code = code;
		this.strcode = strcode;
		this.description = description;
	}

	public static MongoCollections getStatus(int i) {
		if (codeToStatusMapping == null) {
			initMapping();
		}
		return codeToStatusMapping.get(i);
	}

	public static Map<Integer, MongoCollections> getCodeToStatusMapping() {
		if (codeToStatusMapping == null) {
			initMapping();
		}
		return codeToStatusMapping;
	}

	public static int getCode(String strCode) {
		if (strCodeToStatusMapping == null) {
			initMapping();
		}
		if (strCodeToStatusMapping.containsKey(strCode.toLowerCase())) {
			return strCodeToStatusMapping.get(strCode.toLowerCase()).getCode();
		}
		return -1;
	}

	private static void initMapping() {
		codeToStatusMapping = new HashMap<Integer, MongoCollections>();
		strCodeToStatusMapping = new HashMap<String, MongoCollections>();

		for (MongoCollections s : values()) {
			codeToStatusMapping.put(s.code, s);
			strCodeToStatusMapping.put(s.strcode, s);
		}
	}

	public int getCode() {
		return code;
	}

	public String getStrcode() {
		return strcode;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Status");
		sb.append("{code=").append(code);
		sb.append(", label='").append(strcode).append('\'');
		sb.append(", description='").append(description).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
