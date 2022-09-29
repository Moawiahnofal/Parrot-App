package assigmnet5_000875260;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import static javafx.scene.paint.Color.PINK;

  /*
  ParrotApplication is the UI class
  @Author Moawiah Nofal - 000875260
  */
public class ParrotApplication extends Application {
    private Label parrot1Label, parrot2Label, parrot3Label, choicesLabel, userChoiceLabel, userChoiceParrotLabel,
            generalParrotLabel, feedParrotAmountLabel, feedParrotFinalLabel, commandParrotLabel, commandFinalLabel;
    private TextField choiceTextField, choiceParrotTextField, feedParrotTextField, feedParrotAmountTextField, commandParrotTextField;
    private Button choiceButton, feedButton, seedAmountButton, playAgainButton, commandButton;
    private Parrot firstParrot, secondParrot, thirdParrot;
    Parrot currentParrot;

    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root);
        Canvas canvas = new Canvas(1000, 1000); // Set canvas Size in Pixels
        stage.setTitle("Parrot App"); // Set window title
        root.getChildren().add(canvas);
        stage.setScene(scene);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // YOUR CODE STARTS HERE
        scene.setFill(PINK); // set field color

        // set first parrot object
        firstParrot = new Parrot();
        firstParrot.setTamed(true);
        firstParrot.setAlive(false);
        firstParrot.setName("Parrot Julius");
        firstParrot.setAmountOfSeeds(2.1);
        firstParrot.setNumberOfHearts(2);
        firstParrot.setFlying(true);

        // set second parrot object
        secondParrot = new Parrot();
        secondParrot.setTamed(false);
        secondParrot.setName("Parrot Nancy");
        secondParrot.setAmountOfSeeds(0.6);
        secondParrot.setNumberOfHearts(1);
        secondParrot.setFlying(true);

       // set third parrot object
        thirdParrot = new Parrot();
        thirdParrot.setTamed(true);
        thirdParrot.setName("Parrot Johnette");
        thirdParrot.setAmountOfSeeds(1.0);
        thirdParrot.setNumberOfHearts(2);
        thirdParrot.setFlying(true);

        // int labels for parrot objects
        parrot1Label = new Label("1. " + firstParrot.toString());
        parrot2Label = new Label("2. " + secondParrot.toString());
        parrot3Label = new Label("3. " + thirdParrot.toString());

        //init the other views
        choicesLabel = new Label("1. Feed   2. Command  3. Play  4. Hit  5. Quit");
        userChoiceLabel = new Label("Enter your choice: ");
        userChoiceParrotLabel = new Label("Which parrot: ");
        choiceTextField = new TextField();
        choiceParrotTextField = new TextField();
        choiceButton = new Button("Go!");

        generalParrotLabel = new Label("");
        generalParrotLabel.setVisible(false);
        feedParrotTextField = new TextField();
        feedParrotTextField.setVisible(false);
        feedParrotAmountLabel = new Label("How much seed?");
        feedParrotAmountTextField = new TextField();
        feedParrotFinalLabel = new Label("");
        feedButton = new Button("Feed!");
        seedAmountButton = new Button("Done!");
        playAgainButton = new Button("Play Again!");
        commandParrotLabel = new Label("");
        commandParrotTextField = new TextField("");
        commandButton = new Button("Command!");
        commandFinalLabel = new Label("");

        // add the views to the container
        root.getChildren().addAll(parrot1Label, parrot2Label, parrot3Label, choicesLabel, userChoiceLabel,
                choiceTextField, choiceButton, userChoiceParrotLabel, choiceParrotTextField, generalParrotLabel,
                feedParrotTextField, feedParrotAmountLabel, feedParrotAmountTextField, feedParrotFinalLabel,
                feedButton, seedAmountButton, playAgainButton,
                commandParrotLabel, commandParrotTextField, commandButton, commandFinalLabel);

        // set configurations for views
        parrot1Label.relocate(10, 0);
        parrot1Label.setFont(new Font("Courier New", 15));
        parrot1Label.setStyle("-fx-wrap-text:true;-fx-text-fill:darkblue;-fx-alignment:left; -fx-cursor: crosshair");
        parrot1Label.setPrefSize(600, 50);

        parrot2Label.relocate(10, 50);
        parrot2Label.setFont(new Font("Courier New", 15));
        parrot2Label.setStyle("-fx-wrap-text:true;-fx-text-fill:darkblue;-fx-alignment:left; -fx-cursor: crosshair");
        parrot2Label.setPrefSize(600, 50);

        parrot3Label.relocate(10, 100);
        parrot3Label.setFont(new Font("Courier New", 15));
        parrot3Label.setStyle("-fx-wrap-text:true;-fx-text-fill:darkblue;-fx-alignment:left; -fx-cursor: crosshair");
        parrot3Label.setPrefSize(600, 50);


        // set views for user choices
        choicesLabel.relocate(50, 150);
        choicesLabel.setFont(new Font("Courier New", 17));
        choicesLabel.setStyle("-fx-wrap-text:true;-fx-background-color: white;-fx-text-fill:black;-fx-alignment:center; -fx-cursor: crosshair");
        choicesLabel.setPrefSize(500, 50);

        userChoiceLabel.relocate(10, 200);
        userChoiceLabel.setFont(new Font("Courier New", 15));
        userChoiceLabel.setStyle("-fx-wrap-text:true;-fx-text-fill:black;-fx-alignment:left; -fx-cursor: crosshair");
        userChoiceLabel.setPrefSize(500, 50);

        choiceTextField.relocate(180, 210);
        choiceTextField.setFont(new Font("Courier New", 16));
        choiceTextField.setStyle("-fx-wrap-text:true;-fx-background-color: white;-fx-text-fill:black;-fx-alignment:center; -fx-cursor: crosshair");
        choiceTextField.setPrefSize(100, 30);


        userChoiceParrotLabel.relocate(10, 250);
        userChoiceParrotLabel.setFont(new Font("Courier New", 15));
        userChoiceParrotLabel.setStyle("-fx-wrap-text:true;-fx-text-fill:black;-fx-alignment:left; -fx-cursor: crosshair");
        userChoiceParrotLabel.setPrefSize(500, 50);


        choiceParrotTextField.relocate(180, 260);
        choiceParrotTextField.setFont(new Font("Courier New", 16));
        choiceParrotTextField.setStyle("-fx-wrap-text:true;-fx-background-color: white;-fx-text-fill:black;-fx-alignment:center; -fx-cursor: crosshair");
        choiceParrotTextField.setPrefSize(100, 30);

        choiceButton.relocate(10, 300);
        choiceButton.setOnAction(this::choiceButtonHandler);

        generalParrotLabel.relocate(10, 350);
        generalParrotLabel.setFont(new Font("Courier New", 15));
        generalParrotLabel.setStyle("-fx-wrap-text:true;-fx-text-fill:black;-fx-alignment:left; -fx-cursor: crosshair");
        generalParrotLabel.setPrefSize(500, 50);

        feedParrotTextField.relocate(180, 360);

        feedButton.relocate(10, 390);
        feedButton.setOnAction(this::feedButtonHandler);
        feedButton.setVisible(false);

        feedParrotAmountLabel.relocate(10, 430);
        feedParrotAmountLabel.setFont(new Font("Courier New", 15));
        feedParrotAmountLabel.setStyle("-fx-wrap-text:true;-fx-text-fill:black;-fx-alignment:left; -fx-cursor: crosshair");
        feedParrotAmountLabel.setPrefSize(500, 50);
        feedParrotAmountLabel.setVisible(false);

        feedParrotAmountTextField.relocate(180, 440);
        feedParrotAmountTextField.setVisible(false);

        seedAmountButton.relocate(10, 470);
        seedAmountButton.setOnAction(this::amountFeedButtonHandler);
        seedAmountButton.setVisible(false);

        feedParrotFinalLabel.setFont(new Font("Courier New", 15));
        feedParrotFinalLabel.setStyle("-fx-wrap-text:true;;-fx-background-color: red;-fx-text-fill:black;-fx-alignment:center; -fx-cursor: crosshair");
        feedParrotFinalLabel.setPrefSize(300, 50);
        feedParrotFinalLabel.setVisible(false);

        // button to reload the game with keeping the state of the game saved
        playAgainButton.relocate(400, 600);
        playAgainButton.setOnAction(this::playAgainButtonHandler);
        playAgainButton.setFont(new Font("Courier New", 30));
        playAgainButton.setStyle("-fx-wrap-text:true;;-fx-background-color: green;-fx-text-fill:white;-fx-alignment:center; -fx-cursor: crosshair");
        playAgainButton.setVisible(false);

        commandParrotLabel.relocate(10, 350);
        commandParrotLabel.setFont(new Font("Courier New", 15));
        commandParrotLabel.setStyle("-fx-wrap-text:true;-fx-text-fill:black;-fx-alignment:left; -fx-cursor: crosshair");
        commandParrotLabel.setPrefSize(500, 50);
        commandParrotLabel.setVisible(false);

        commandParrotTextField.relocate(450, 360);
        commandParrotTextField.setVisible(false);

        commandButton.relocate(10, 390);
        commandButton.setOnAction(this::commandButtonHandler);
        commandButton.setVisible(false);
        commandButton.setVisible(false);

        commandFinalLabel.relocate(10, 420);
        commandFinalLabel.setFont(new Font("Courier New", 15));
        commandFinalLabel.setStyle("-fx-wrap-text:true;;-fx-background-color: red;-fx-text-fill:black;-fx-alignment:center; -fx-cursor: crosshair");
        commandFinalLabel.setPrefSize(300, 50);
        commandFinalLabel.setVisible(false);

        // YOUR CODE STOPS HERE
        stage.show();
    }

    // restart the game event handler with keeping the current state of the game.
    private void playAgainButtonHandler(ActionEvent event) {
        parrot1Label.setText("1. " + firstParrot.toString());
        parrot2Label.setText("2. " + secondParrot.toString());
        parrot3Label.setText("3. " + thirdParrot.toString());
        generalParrotLabel.setVisible(false);
        feedParrotTextField.setVisible(false);
        feedParrotAmountLabel.setVisible(false);
        feedParrotAmountTextField.setVisible(false);
        feedParrotFinalLabel.setVisible(false);
        feedButton.setVisible(false);
        seedAmountButton.setVisible(false);
        playAgainButton.setVisible(false);
        feedParrotTextField.clear();
        feedParrotAmountTextField.clear();
        choiceTextField.clear();
        choiceParrotTextField.clear();

        commandParrotLabel.setVisible(false);
        commandParrotTextField.setVisible(false);
        commandParrotTextField.clear();
        commandButton.setVisible(false);
        commandFinalLabel.setVisible(false);
    }

    // command button event handler
    private void commandButtonHandler(ActionEvent event) {
        String command = commandParrotTextField.getText();
        if (command.equalsIgnoreCase("stay"))
            currentParrot.setFlying(false);
        if (command.equalsIgnoreCase("fly"))
            currentParrot.setFlying(true);

        commandFinalLabel.setVisible(true);
        commandFinalLabel.setText(currentParrot.getName() + " " + "is now " + command + "ing!");
        playAgainButton.setVisible(true);
    }

      // amount of seed button event handler
    private void amountFeedButtonHandler(ActionEvent event) {
        double seedsAmount = Double.parseDouble(feedParrotAmountTextField.getText());
        currentParrot.setAmountOfSeeds(currentParrot.getAmountOfSeeds() + seedsAmount);
        currentParrot.setTamed(true);
        feedParrotFinalLabel.relocate(10, 510);
        feedParrotFinalLabel.setVisible(true);
        feedParrotFinalLabel.setText("You tamed " + currentParrot.getName());
        playAgainButton.setVisible(true);
    }

    // Feed parrot button event handler
    private void feedButtonHandler(ActionEvent event) {
        if (feedParrotTextField.getText().equalsIgnoreCase("seed")) {
            feedParrotAmountLabel.setVisible(true);
            feedParrotAmountTextField.setVisible(true);
            seedAmountButton.setVisible(true);
        } else if (feedParrotTextField.getText().equalsIgnoreCase("cookie")) {
            feedParrotFinalLabel.setVisible(true);
            feedParrotFinalLabel.relocate(10, 450);
            feedParrotFinalLabel.setText(currentParrot.getName() + " is dead!");
            currentParrot.setAlive(false);
            playAgainButton.setVisible(true);
        }
    }


    // choices button event handler ("1. Feed   2. Command  3. Play  4. Hit  5. Quit")
    private void choiceButtonHandler(ActionEvent actionEvent) {
        currentParrot = null;
        int userChoice = Integer.parseInt(choiceTextField.getText());
        // Exit
        if (userChoice == 5) {
            Platform.exit();
        }
        int parrotNumber = Integer.parseInt(choiceParrotTextField.getText());
        if (parrotNumber == 1)
            currentParrot = firstParrot;
        if (parrotNumber == 2)
            currentParrot = secondParrot;
        if (parrotNumber == 3)
            currentParrot = thirdParrot;


        // feed
        if (userChoice == 1) {
            if (currentParrot.getAlive() == false) {
                generalParrotLabel.setVisible(true);
                generalParrotLabel.setStyle("-fx-wrap-text:true;;-fx-background-color: red;-fx-text-fill:black;-fx-alignment:center; -fx-cursor: crosshair");
                generalParrotLabel.setText("You can not feed a dead parrot!");
                playAgainButton.setVisible(true);
            } else {
                generalParrotLabel.setStyle("-fx-wrap-text:true;-fx-text-fill:black;-fx-alignment:left; -fx-cursor: crosshair");
                generalParrotLabel.setText("seed or cookie?:");
                generalParrotLabel.setVisible(true);
                feedParrotTextField.setVisible(true);
                feedButton.setVisible(true);
            }

        } else if (userChoice == 2) {  //command
            if (currentParrot.getAlive() == false || currentParrot.getTamed() == false) {
                generalParrotLabel.setVisible(true);
                generalParrotLabel.setStyle("-fx-wrap-text:true;;-fx-background-color: red;-fx-text-fill:black;-fx-alignment:center; -fx-cursor: crosshair");
                generalParrotLabel.setText("You can not command a dead or untamed parrot!");
                playAgainButton.setVisible(true);
            } else if (currentParrot.getTamed() == true) {
                commandParrotLabel.setVisible(true);
                commandParrotTextField.setVisible(true);
                commandButton.setVisible(true);
                commandParrotLabel.setText("Do you want the tamed parrot to Stay or fly?");
            }

        } else if (userChoice == 3) {  //play
            generalParrotLabel.setVisible(true);
            generalParrotLabel.setStyle("-fx-wrap-text:true;;-fx-background-color: red;-fx-text-fill:black;-fx-alignment:center; -fx-cursor: crosshair");
            if (currentParrot.getAlive() == false || currentParrot.getTamed() == false) {
                generalParrotLabel.setText("You can not play a dead or untamed parrot!");
            } else if (currentParrot.getTamed() == true) {
                currentParrot.setTamed(false);
                generalParrotLabel.setText("Ops! " + currentParrot.getName() + " " + "is now untamed!");
            }
            playAgainButton.setVisible(true);

        } else if (userChoice == 4) {    //hit
            currentParrot.setTamed(false);
            int parrotHealth = currentParrot.getNumberOfHearts();
            generalParrotLabel.setVisible(true);
            generalParrotLabel.setStyle("-fx-wrap-text:true;;-fx-background-color: red;-fx-text-fill:black;-fx-alignment:center; -fx-cursor: crosshair");
            if (parrotHealth == 0) {
                generalParrotLabel.setText(currentParrot.getName() + " is already dead!");
            }
            if (parrotHealth > 1) {
                currentParrot.setNumberOfHearts(parrotHealth - 1);
                generalParrotLabel.setText(currentParrot.getName() + " has become untamed");
            }
            if (parrotHealth == 1) {
                currentParrot.setAlive(false);
                currentParrot.setNumberOfHearts(parrotHealth - 1);
                generalParrotLabel.setText(currentParrot.getName() + " has become dead!");
            }
            playAgainButton.setVisible(true);
        }

    }

    public static void main(String[] args) {
        launch();
    }
}