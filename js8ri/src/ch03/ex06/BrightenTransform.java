package ch03.ex06;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.function.BiFunction;

import javax.imageio.ImageIO;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public final class BrightenTransform extends Application {

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

	public void start(Stage stage) {

		Parameters params = getParameters();
		List<String> args = params.getRaw();

		Image image = new Image(args.get(0));
		Image transformedImage = transform(image, (c, factor) -> {
			return c.deriveColor(0, 1, factor, 1);
		}, Double.valueOf(args.get(1)));

		BufferedImage resultImg = new BufferedImage((int) image.getWidth(), (int) image.getHeight(),
				BufferedImage.TYPE_INT_ARGB);
		SwingFXUtils.fromFXImage(transformedImage, resultImg);

		// ファイル書き出し
		try {
			ImageIO.write(resultImg, "png", new File("ex06.png"));
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
