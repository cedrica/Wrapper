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
		}else{
			String[] propertyType = value.trim().split("\\s+");
			type = propertyType[0].replace("Property", "");
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
		}else{
			String[] propertyType = value.trim().split("\\s+");
			type = propertyType[0].replace("Property", "");
		}
		return "public final " + type + " get" + Helper.capitalizeFirstLetter(key) + "(){ return this." + key
				+ "Property().get();" + "}";
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
}
