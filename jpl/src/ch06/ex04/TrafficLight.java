package ch06.ex04;

import java.awt.Color;

public enum TrafficLight {
	RED(new Color(255, 0, 0)), YELLOW(new Color(255, 255, 0)), GREEN(new Color(0, 255, 0));

	TrafficLight(Color color) {
		this.color = color;
	}

	private Color color;

	public Color getColor() {
		return color;
	}

}
