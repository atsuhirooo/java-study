package ch04.ex04;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public final class CircleSeene extends Application {

	@Override
	public void start(Stage stage) throws Exception {

		Circle circle = new Circle(10);

		Pane root = new Pane();
		Scene scene = new Scene(root);
		root.getChildren().add(circle);

		circle.centerXProperty().bind(Bindings.divide(scene.widthProperty(), 2));
		circle.centerYProperty().bind(Bindings.divide(scene.heightProperty(), 2));

		circle.radiusProperty().bind(Bindings.divide(Bindings.min(scene.widthProperty(), scene.heightProperty()), 2));

		stage.setTitle("circle");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
