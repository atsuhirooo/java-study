package ch03.ex08;

import javafx.scene.paint.Color;

@FunctionalInterface
public interface ColorTransformer {
	public Color apply(int x, int y, Color colorSrc, Color ColorDst, int frameSize);

}