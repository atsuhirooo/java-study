package ch03.ex08;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public final class GrayTransform {

	private static final int FRAME_SIZE = 10;

	static Image transform(Image in, ColorTransformer colorTransformer, Color colorDst, int frameSize) {

		int width = (int) in.getWidth();
		int height = (int) in.getHeight();
		WritableImage out = new WritableImage(width, height);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				out.getPixelWriter().setColor(x, y,
						colorTransformer.apply(x, y, in.getPixelReader().getColor(x, y), colorDst, frameSize));
			}
		}
		return out;
	}

	public static void main(String[] args) {
		Image image = new Image(args[0]);

		int width = (int) image.getWidth();
		int height = (int) image.getHeight();

		final int F = 10;

		Image transformedImage = transform(image, (x, y, colorSrc, colorDst, framesize) -> {
			if (x < framesize || x > (width - framesize)) {
				return colorDst;
			}
			if (y < framesize || y > (height - framesize)) {
				return colorDst;
			}
			return colorSrc;
		}, Color.GRAY, 10);

	}

}
