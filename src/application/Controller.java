package application;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Controller {
	@FXML
	private Pane panel1;

	@FXML
	private Pane panel2;

	@FXML
	private Pane panel3;

	@FXML
	private Label countLabel;

	public void translateAnimation(double duration, Node node, double byX) {

		TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(duration), node);
		translateTransition.setByX(byX);
		translateTransition.play();

	}

	public void initialize() {
		translateAnimation(0.1, panel2, 600);
		translateAnimation(0.1, panel3, 600);
	}

	int showSlide = 0;

	@FXML
	void nextAction() {

		if (showSlide == 0) {
			translateAnimation(0.5, panel2, -600);
			showSlide++; // showSlide=1
			countLabel.setText("2/3");
		} else if (showSlide == 1) {

			translateAnimation(0.5, panel3, -600);
			showSlide++; // showSlide=2
			countLabel.setText("3/3");

		} else {
			showSlide = 0;
			translateAnimation(0.1, panel2, 600);
			translateAnimation(0.5, panel3, 600);
			countLabel.setText("1/3");
		}

	}

	@FXML
	void backAction() {

		if (showSlide == 0) {
			showSlide = 2;
			translateAnimation(0.6, panel2, -600);
			translateAnimation(0.5, panel3, -600);
			countLabel.setText("3/3");
		} else if (showSlide == 1) {
			translateAnimation(0.5, panel2, 600);
			showSlide--; // showSlide=0
			countLabel.setText("1/3");
		} else if (showSlide == 2) {
			translateAnimation(0.5, panel3, 600);
			showSlide--; // showSlide=1
			countLabel.setText("2/3");
		}

	}

}
