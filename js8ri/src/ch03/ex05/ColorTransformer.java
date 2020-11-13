package ch03.ex05;

import javafx.scene.paint.Color;

@FunctionalInterface
public interface ColorTransformer {
	public Color apply(int x, int y, Color colorAtXY);

}