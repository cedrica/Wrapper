package com.preag.wrapper.maincontainer;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.preag.wrapper.helper.Helper;

public class MainContainerService {
	public static String builtSetterFunction(String key, String value) {
		String type = "";
		if (value.startsWith("ObjectProperty")) {
			Pattern pattern = Pattern.compile("<(.*?)>");
			Matcher matcher = pattern.matcher(value);
			if (matcher.find()) {
				type = matcher.group(1);
			}
		} else {
			String[] propertyType = value.trim().split("\\s+");
			type = propertyType[0].replace("Property", "");
			type = (type.equals("String")) ? type : type.toLowerCase();
		}

		return "public final void set" + Helper.capitalizeFirstLetter(key) + "(" + type + " " + key + "){" + " this."
				+ key + "Property().set(" + key + ");" + "}";
	}

	public static String builtGetterFunction(String key, String value) {
		String type = "";
		if (value.startsWith("ObjectProperty")) {
			Pattern pattern = Pattern.compile("<(.*?)>");
			Matcher matcher = pattern.matcher(value);
			if (matcher.find()) {
				type = matcher.group(1);
			}
		} else {
			String[] propertyType = value.trim().split("\\s+");
			type = propertyType[0].replace("Property", "");
			type = (type.equals("String")) ? type : type.toLowerCase();
		}
		return "public final " + type + " get" + Helper.capitalizeFirstLetter(key) + "(){ return this."
				+ key + "Property().get();" + "}";
	}

	public static String builtPropertyFunction(String key, String value) {
		String[] propertyType = value.trim().split("\\s+");
		return "public final " + propertyType[0] + " " + key + "Property(){" + "return this." + key + ";" + "}";

	}

	public static String builtMiniObjectFileHeader(String currentSelectedPojo) {
		return "public class " + currentSelectedPojo + "{";
	}

	public static String retrieveJAR(String path) {
		String[] split = path.split("src");
		return split[0] + "target";
	}


	public static String builtEqualsCodeHeader(String pojoName) {
		return "@Override public boolean equals(Object obj) { if (this == obj) return true;"
				+ " if (obj == null) return false;if (getClass() != obj.getClass())return false;"
				+ pojoName+" other = ("+pojoName+") obj;";
	}

	public static String builtHashCodeFunctionHeader() {
		return "@Override\n" + "public int hashCode() {" + "final int prime = 31;" + "int result = 1;";
	}
	public static String builtPackageName(File file) {
		Pattern pattern = Pattern.compile("com(.*)");
		Matcher matcher = pattern.matcher(file.getAbsolutePath());
		if (matcher.find()) {
			String split = matcher.group().replace("\\", ".");
			split = split.replace("." + file.getName(), "");
			return split;
		}
		return "";
	}

	public static boolean isDoubleProperty(String value) {
		String[] propertyType = value.trim().split("\\s+");
		return propertyType[0].trim().equals("DoubleProperty");
	}

	public static boolean isFloatProperty(String value) {
		String[] propertyType = value.trim().split("\\s+");
		return propertyType[0].trim().equals("FloatProperty");
	}

	public static boolean isIntegerProperty(String value) {
		String[] propertyType = value.trim().split("\\s+");
		return propertyType[0].trim().equals("IntegerProperty");
	}

	public static boolean isLongProperty(String value) {
		String[] propertyType = value.trim().split("\\s+");
		return propertyType[0].trim().equals("LongProperty");
	}

	public static boolean isBooleanProperty(String value) {
		String[] propertyType = value.trim().split("\\s+");
		return propertyType[0].trim().equals("BooleanProperty");
	}
}
