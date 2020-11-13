package ch03.ex08;

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

	public void start(Stage stage) {

		Parameters params = getParameters();
		List<String> args = params.getRaw();

		Image image = new Image(args.get(0));
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

		BufferedImage resultImg = new BufferedImage((int) image.getWidth(), (int) image.getHeight(),
				BufferedImage.TYPE_INT_ARGB);
		SwingFXUtils.fromFXImage(transformedImage, resultImg);

		// ファイル書き出し
		try {
			ImageIO.write(resultImg, "png", new File("ex08.png"));
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}