package com.company;


import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class GUI extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        int direction=1;
        Text text = new Text();
        text.setText("You are in the forest");
        text.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        text.setX(30);
        text.setY(30);

        Group root =new Group();
//        Scene scene=  new Scene(root,600,300);
//        stage.setTitle("sample Application");
//        stage.setScene(scene);
//        stage.show();
        Path path=FileSystems.getDefault().getPath("pokemon.jpg.jpg");
        InputStream stream = new FileInputStream("C:\\Users\\user\\IdeaProjects\\AdventureGame\\pokemon.jpg.jpg");
        Image image =new Image(stream);
        ImageView imageView =new ImageView();
        imageView.setImage(image);
        imageView.setX(10);
        imageView.setY(10);
        imageView.setFitHeight(500);
        imageView.setPreserveRatio(true);
         Text text2 = new Text();
        text2.setText("Available exits are:\n" +
                direction);
        text2.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        text2.setX(100);
        text2.setY(50);


        root.getChildren().add(imageView);
        root.getChildren().add(text);
        root.getChildren().add(text2);

        Scene scene=  new Scene(root,600,300);
        stage.setTitle("Adventure game");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
