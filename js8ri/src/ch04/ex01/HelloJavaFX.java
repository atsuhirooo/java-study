
package ch04.ex01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public final class HelloJavaFX extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Label label = new Label();
		label.setFont(new Font(100));
		TextField textField = new TextField("Hello, JavaFX");

		label.textProperty().bind(textField.textProperty());

		VBox root = new VBox();
		root.getChildren().add(label);
		root.getChildren().add(textField);
		Scene scene = new Scene(root);

		primaryStage.setTitle(HelloJavaFX.class.getSimpleName());
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
