package com.preag.wrapper.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.controlsfx.glyphfont.FontAwesome;
import org.controlsfx.glyphfont.Glyph;
import org.controlsfx.glyphfont.GlyphFontRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.preag.core.ui.utils.FileUtil;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Helper {
	private final static Logger LOG = LoggerFactory.getLogger(Helper.class);

	public static String retrieveType(Type genericType) {
		Pattern pattern = Pattern.compile("<(.*?)>");
		Matcher matcher = pattern.matcher(genericType.getTypeName());
		if (matcher.find()) {
			String[] split = matcher.group(1).split("\\.");
			return (split != null && split.length > 0) ? split[split.length - 1] : matcher.group(1);
		} else {
			String[] split = genericType.getTypeName().split("\\.");
			return (split != null && split.length > 0) ? split[split.length - 1] : null;
		}
	}

	public static String removeFileExtension(String className) {
		if (className.trim().isEmpty())
			return "";
		else {
			String[] split = className.split("\\.");
			return split[0];
		}
	}

	public static File[] findFilesEndingWith(String dirPath, String endWith) {
		File dir = new File(dirPath);

		File[] fileList = dir.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.endsWith(endWith);
			}
		});
		return fileList;
	}

	public static void savePojoLocaly(File pojo) {
		try {
			File file = new File(System.getProperty("user.dir") + "/pojos_temp");
			if (!file.exists()) {
				file.mkdirs();
			}
			String path = System.getProperty("user.dir") + "/pojos_temp/" + pojo.getName();
			path = path.replace("\\", "/");
			System.out.println("path Save: " + path);
			FileOutputStream fos = new FileOutputStream(path);
			byte[] pojoAsByte = FileUtil.readBytesFromFile(pojo);
			fos.write(pojoAsByte);
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static boolean isString(String itemProPage) {
		for (char c : itemProPage.toCharArray()) {
			if (!Character.isDigit(c))
				return false;
		}
		return true;
	}

	public static boolean isNotNullAndNotEmpty(String str) {
		return str != null && !str.isEmpty();
	}

	public static Glyph setIcon(Color color, FontAwesome.Glyph iconTyp, double size) {
		Glyph font = GlyphFontRegistry.font("FontAwesome").create(iconTyp);
		font.setColor(color);
		font.setFontSize(size);
		return font;
	}

	public static <T> List<T> filter(Predicate<T> predicate, ObservableList<T> items) {
		if (items == null || items.size() <= 0)
			return null;
		List<T> resultList = items.stream().filter(predicate).collect(Collectors.toList());
		return resultList;
	}

	public static ImageView roundedImage(String path, double height, double width) {
		Image image = new Image(Helper.class.getResourceAsStream(path));
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(height);
		imageView.setFitWidth(width);
		imageView.setPickOnBounds(true);
		Circle clip = new Circle(imageView.getFitWidth() / 2, imageView.getFitHeight() / 2, 15);
		imageView.setClip(clip);
		return imageView;
	}

	public static VBox roundedGlyph(FontAwesome.Glyph icon, double size) {
		VBox vbBox = new VBox();
		vbBox.setMinHeight(size);
		vbBox.setMinWidth(size);
		Label image = new Label();
		image.setGraphic(setIcon(Color.GRAY, icon, size));
		vbBox.getChildren().add(image);
		Circle clip = new Circle(size / 2, size / 2, size / 2);
		vbBox.setClip(clip);
		vbBox.setAlignment(Pos.CENTER);
		return vbBox;
	}

	public static void roundVBox(VBox vbBox, double size) {
		vbBox.setMinSize(size, size);
		Circle clip = new Circle(size / 2, size / 2, size / 2);
		vbBox.setClip(clip);
		vbBox.setAlignment(Pos.CENTER);
	}

	public static void savePojosLocaly(List<File> pojosFiles, String destinationPath) {
		if (pojosFiles == null || pojosFiles.isEmpty())
			return;
		for (File file : pojosFiles) {
			try {
				File destDir = new File(destinationPath);
				FileUtils.copyFileToDirectory(file, destDir);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static String capitalizeFirstLetter(String line) {
		return Character.toUpperCase(line.charAt(0)) + line.substring(1);
	}

	public static boolean writeContaintToFileAndSave(String fileContaint,
			String absolutePath) {
		FileWriter fw = null;
		try
		{
			fw = new FileWriter(absolutePath+File.separator);
			fw.write(fileContaint);
			fw.close();
			return true;
		} catch (IOException e) {
			LOG.error("An error occured during saving the file "+absolutePath);
			return false;
		}
	}

}
