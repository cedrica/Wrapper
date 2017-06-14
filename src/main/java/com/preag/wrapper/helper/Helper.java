package com.preag.wrapper.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.controlsfx.glyphfont.FontAwesome;
import org.controlsfx.glyphfont.Glyph;
import org.controlsfx.glyphfont.GlyphFontRegistry;

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

	public static void savePojoLocaly(File pojo) {
		try {
			File file = new File(System.getProperty("user.dir") +  "/pojos_temp");
			if(!file.exists()){
				file.mkdirs();
			}
			String path = System.getProperty("user.dir") +  "/pojos_temp/" +  pojo.getName();
			path = path.replace("\\", "/");
			System.out.println("path Save: "+path);
			FileOutputStream fos = new FileOutputStream(path);
			byte[] pojoAsByte = FileUtil.readBytesFromFile(pojo);
			fos.write(pojoAsByte);
			fos.close();
		}
		catch (IOException e) {
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
		Circle clip = new Circle(imageView.getFitWidth()/2,imageView.getFitHeight()/2, 15);
		imageView.setClip(clip);
		return imageView;
	}

	public static VBox roundedGlyph(FontAwesome.Glyph icon,double size) {
		VBox vbBox = new VBox();
		vbBox.setMinHeight(size);
		vbBox.setMinWidth(size);
		Label image = new Label();
		image.setGraphic(setIcon(Color.GRAY, icon, size));
		vbBox.getChildren().add(image);
		Circle clip = new Circle(size/2,size/2, size/2);
		vbBox.setClip(clip);
		vbBox.setAlignment(Pos.CENTER);
		return vbBox;
	}
	
	public static void roundVBox(VBox vbBox,double size) {
		vbBox.setMinSize(size, size);
		Circle clip = new Circle(size/2,size/2, size/2);
		vbBox.setClip(clip);
		vbBox.setAlignment(Pos.CENTER);
	}
	public static void savePojosLocaly(List<File> pojosFiles, String destinationPath) {
		if(pojosFiles ==  null || pojosFiles.isEmpty())
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
	
}
