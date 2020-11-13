package ch03.ex05;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public final class GrayTransform extends Application {

	private static final int FRAME_SIZE = 10;

	static Image transform(Image in, ColorTransformer colorTransformer) {

		int width = (int) in.getWidth();
		int height = (int) in.getHeight();
		WritableImage out = new WritableImage(width, height);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				out.getPixelWriter().setColor(x, y, colorTransformer.apply(x, y, in.getPixelReader().getColor(x, y)));
			}
		}
		return out;
	}

	public void start(Stage stage) {

		Parameters params = getParameters();
		List<String> args = params.getRaw();

		Image image = new Image(args.get(0));

		int width = (int) image.getWidth();
		int height = (int) image.getHeight();
		Image transformedImage = transform(image, (x, y, c) -> {
			if (x < FRAME_SIZE || x > (width - FRAME_SIZE)) {
				return Color.GRAY;
			}
			if (y < FRAME_SIZE || y > (height - FRAME_SIZE)) {
				return Color.GRAY;
			}
			return c;
		});

		BufferedImage resultImg = new BufferedImage((int) image.getWidth(), (int) image.getHeight(),
				BufferedImage.TYPE_INT_ARGB);
		SwingFXUtils.fromFXImage(transformedImage, resultImg);

		// ファイル書き出し
		try {
			ImageIO.write(resultImg, "png", new File("new.png"));
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
