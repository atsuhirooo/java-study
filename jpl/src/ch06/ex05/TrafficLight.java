package ch06.ex05;

import java.awt.Color;

public enum TrafficLight {
	RED() {
		Color color = new Color(255, 0, 0);

		Color getColor() {
			return color;
		}
	},
	YELLOW() {
		Color color = new Color(255, 255, 0);

		Color getColor() {
			return color;
		}
	},
	GREEN() {
		Color color = new Color(0, 255, 0);

		Color getColor() {
			return color;
		}
	};

	// private Color color;

	abstract Color getColor();

}
