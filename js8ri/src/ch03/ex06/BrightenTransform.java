package ch03.ex06;

import java.util.function.BiFunction;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public final class BrightenTransform {

	public static <T> Image transform(Image in, BiFunction<Color, T, Color> biFunction, T arg) {

		int width = (int) in.getWidth();
		int height = (int) in.getHeight();
		WritableImage out = new WritableImage(width, height);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				out.getPixelWriter().setColor(x, y, biFunction.apply(in.getPixelReader().getColor(x, y), arg));
			}
		}
		return out;
	}

	public static void main(String[] args) {

		Image image = new Image(args[0]);
		Image transformedImage = transform(image, (c, factor) -> {
			return c.deriveColor(0, 1, factor, 1);
		}, Double.valueOf(args[1]));

	}

}
