package com.example.edpfx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {
    Scene scene;
    @Override

    public void start(Stage stage) {
        stage.setTitle("TIMETABLE!");
        //var label = new Label("Hello, JavaFX");
        GridPane pane = new GridPane();
        pane.getChildren().add(new Label("Hello World!"));
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/edpfx/img_6.png"))));

        //**************************************Button 1**********************************************
        Button button1 = new Button("Schedule lecture");
        button1.setMinWidth(300);
        button1.prefHeightProperty().bind(pane.widthProperty().divide(5));//Binding the width and height of each button to our Frame
        button1.prefWidthProperty().bind(pane.widthProperty());
        button1.setFont(Font.font("Comic Sans",FontWeight.BOLD,30));
        button1.setStyle("-fx-background-color: #00FF36; ");
        button1.setOnAction(e-> Schedulelecture(stage));
        pane.add(button1, 0, 0);
        //**************************************Button 2**********************************************
        Text text = new Text("Cancel lecture");
        Button button2 = new Button(text.getText());
        button2.setMinWidth(300);
        button2.setOnAction(e->RemoveLecture(stage));
        button2.prefHeightProperty().bind(pane.heightProperty().divide(5));
        button2.prefWidthProperty().bind(pane.widthProperty());
        button2.setFont(Font.font("Comic Sans",FontWeight.BOLD,30));
        pane.add(button2, 0, 1);
        //**************************************Button 3**********************************************
        Image image3 = new Image(Objects.requireNonNull(getClass().getResource("/com/example/edpfx/img_2.png")).toExternalForm());
        ImageView view3 = new ImageView(image3);
        view3.setFitWidth(300);
        view3.setFitHeight(300);
        view3.setPreserveRatio(true);
        Button button3 = new Button("",view3);
        button3.setMinWidth(300);
        button3.prefHeightProperty().bind(pane.heightProperty().divide(5));
        button3.prefWidthProperty().bind(pane.widthProperty());
        button3.setStyle("-fx-background-color: #044489; ");
        pane.add(button3, 0, 2);
        //**************************************Button 4**********************************************
        Image image4 = new Image(Objects.requireNonNull(getClass().getResource("/com/example/edpfx/img_1.png")).toExternalForm());
        ImageView view4 = new ImageView(image4);
        view4.setFitWidth(300);
        view4.setFitHeight(100);
        view4.setPreserveRatio(true);
        Button button4 = new Button("",view4);
        button4.setMinWidth(300);
        button4.prefHeightProperty().bind(pane.heightProperty().divide(5));
        button4.prefWidthProperty().bind(pane.widthProperty());
        button4.setStyle("-fx-background-color: #ffffff; ");
        pane.add(button4, 0, 3);
        //**************************************Button 5**********************************************
        Image image5 = new Image(Objects.requireNonNull(getClass().getResource("/com/example/edpfx/img.png")).toExternalForm());
        ImageView view5 = new ImageView(image5);
        view5.setFitWidth(100);
        view5.setPreserveRatio(true);
        Button button5 = new Button("",view5);
        button5.setStyle("-fx-background-color: #ff0000; ");//BIG RED EXIT BUTTON
        button5.setMinWidth(300);
        //System.out.println("Ending communication");
        button5.prefWidthProperty().bind(pane.widthProperty());
        button5.prefHeightProperty().bind(pane.heightProperty().divide(5));
        button5.setOnAction(e->System.exit(0));
        pane.add(button5, 0, 4);
        //**************************************Button 5**********************************************











        button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("!");
            }
        });

        button4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("\n");
            }
        });




         scene = new Scene(pane,500,500);
         stage.setMinWidth(500);
         stage.setMinHeight(500);

        stage.setScene(scene);
        stage.show();

    }


        //stage.setScene(scene);
        //stage.show();
        private void Schedulelecture(Stage stage) {
        String[] lectureinfo = new String[4];

            GridPane LecturePane = new GridPane();
            LecturePane.setAlignment(Pos.CENTER);
            //*******************DAY********************
            TextField day = new TextField("What day is the lecture?");
            day.setOnKeyPressed(e->day.clear());
            day.setFont(Font.font("Comic Sans",FontWeight.BOLD,10));
            day.setStyle("-fx-background-color: #787e7d; -fx-border-width: 3px; -fx-border-color: black; -fx-border-style: solid;");
            day.setAlignment(Pos.CENTER);
            day.setMinWidth(300);
            day.prefHeightProperty().bind(LecturePane.widthProperty());
            day.prefHeightProperty().bind(LecturePane.heightProperty().divide(5));

            day.setOnKeyPressed(e-> {
                if (day.getText().equals("What day is the lecture?")) {
                    day.clear();
                }
            });
            day.setOnMouseExited(e-> {
                if(day.getText().equals("")) {
                    day.setText("What day is the lecture?");
                }
            });
            LecturePane.add(day, 20, 0);
            //*******************TIME********************
            TextField time = new TextField("When is the lecture?");
            time.setAlignment(Pos.CENTER);
            time.setOnKeyPressed(e->time.clear());
            time.setDisable(true);
            time.setFont(Font.font("Comic Sans",FontWeight.BOLD,10));
            time.setStyle("-fx-background-color: #787e7d; -fx-border-width: 3px; -fx-border-color: black; -fx-border-style: solid;");
            time.setMinWidth(300);
            time.prefHeightProperty().bind(LecturePane.heightProperty());
            time.prefHeightProperty().bind(LecturePane.heightProperty().divide(5));

            time.setOnKeyPressed(e-> {
                if (time.getText().equals("When is the lecture?")) {
                    time.clear();
                }
            });
            time.setOnMouseExited(e-> {
                if(time.getText().equals("")) {
                    time.setText("When is the lecture?");
                }
            });
            LecturePane.add(time, 20, 1);
            //*******************ROOM********************
            TextField room = new TextField("What room is the lecture?");
            room.setFont(Font.font("Comic Sans",FontWeight.BOLD,10));
            room.setAlignment(Pos.CENTER);
            room.setDisable(true);
            room.setStyle("-fx-background-color: #787e7d; -fx-border-width: 3px; -fx-border-color: black; -fx-border-style: solid;");
            room.setOnKeyPressed(e->room.clear());
            room.setMinWidth(300);
            room.prefHeightProperty().bind(LecturePane.heightProperty());
            room.prefHeightProperty().bind(LecturePane.heightProperty().divide(5));

            room.setOnKeyPressed(e-> {
                        if (room.getText().equals("What room is the lecture?")) {
                            room.clear();
                        }
                    });
            room.setOnMouseExited(e-> {
                if(room.getText().equals("")) {
                    room.setText("What room is the lecture?");
                }
            });
            LecturePane.add(room, 20, 2);
            //*******************MODULE********************
            TextField module = new TextField("What module is the lecture for?");
            module.setDisable(true);
            module.setFont(Font.font("Comic Sans",FontWeight.BOLD,10));
            module.setStyle("-fx-background-color: #787e7d; -fx-border-width: 3px; -fx-border-color: black; -fx-border-style: solid;");
            ;
            module.setAlignment(Pos.CENTER);
            module.setOnKeyPressed(e->{
                if (module.getText().equals("What module is the lecture for?")){
                    module.clear();
                }

            });
            module.setOnMouseExited(e-> {
                if(module.getText().equals("")) {
                module.setText("What module is the lecture for?");
            }
            });
            module.setMinWidth(300);
            module.prefHeightProperty().bind(LecturePane.heightProperty());
            module.prefHeightProperty().bind(LecturePane.heightProperty().divide(5));

            LecturePane.add(module, 20, 3);
            //*******************MENU BUTTON********************
            Button exit = new Button("MENU");
            exit.setFont(Font.font("Comic Sans",FontWeight.BOLD,10));
            exit.setMinWidth(300);
            LecturePane.add(exit,20,6);

            exit.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    stage.setScene(scene);
                }
            });
            //*******************SUBMIT BUTTON********************
            Button submit = new Button("SUBMIT");
            submit.setDisable(true);
            submit.setFont(Font.font("Comic Sans",FontWeight.BOLD,10));
            submit.setMinWidth(300);
            LecturePane.add(submit,20,5);
            //*******************CONTROLLERS********************




            day.setOnAction(e -> {time.setDisable(false);lectureinfo[0] = day.getText();});
            time.setOnAction(e->{room.setDisable(false);lectureinfo[1] = time.getText();});
            room.setOnAction(e->{module.setDisable(false);lectureinfo[2] = room.getText();});
            module.setOnAction(e->{submit.setDisable(false);lectureinfo[3] = module.getText();});
            submit.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    for (int i = 0; i < lectureinfo.length; i++) {
                        System.out.println(lectureinfo[i]);
                    }
                }
            });

            //*******************SCENE SETUP********************



            StackPane stack = new StackPane();
            Image image = new Image(Objects.requireNonNull(getClass().getResource("/com/example/edpfx/img_4.png")).toExternalForm());



            ImageView imageView = new ImageView(image);



            imageView.fitWidthProperty().bind(LecturePane.widthProperty());
            imageView.fitHeightProperty().bind(LecturePane.heightProperty());
            imageView.setPreserveRatio(false);

            stack.getChildren().add(imageView);

            stack.getChildren().add(LecturePane);



            Scene ScheduleScene = new Scene(stack, 450, 240);
            stage.setMinWidth(450);
            stage.setMinHeight(240);
            stage.getIcons().add(image);



            stage.setScene(ScheduleScene);
            stage.show();
        }

        private void RemoveLecture(Stage stage){

        GridPane grid = new GridPane();


        ///Thinking we could have a dropdown box for the day
            ///Another dropdown box for the time
            ///A lecture information section?
            ///AND A CONFIRM BUTTON
            grid.setAlignment(Pos.CENTER);
            //**************************DATE****************************
            ComboBox date = new ComboBox();
            date.setPromptText("Select  lecture date");
            date.getItems().addAll("Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday");
            date.prefHeightProperty().bind(grid.heightProperty());
            date.prefHeightProperty().bind(grid.heightProperty().divide(5));
            date.setMinWidth(300);
            grid.add(date,0,0);
            //**************************TIME****************************
            ComboBox time = new ComboBox();
            time.setPromptText("Select  lecture time");
            time.getItems().addAll("Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday");

            time.prefHeightProperty().bind(grid.heightProperty());
            time.prefHeightProperty().bind(grid.heightProperty().divide(5));
            time.setMinWidth(300);
            time.setDisable(true);//Might make it so that time is only shown when the date has been selected first
            grid.add(time,0,1);
            //**************************LECTURE INFO****************************
            TextField info = new TextField();
            info.prefHeightProperty().bind(grid.heightProperty());
            info.prefHeightProperty().bind(grid.heightProperty().divide(5));
            info.setDisable(true);

            info.setMinWidth(300);
            grid.add(info,0,2);

            //**************************BACKGROUND****************************
            Image image = new Image(Objects.requireNonNull(getClass().getResource("/com/example/edpfx/img_4.png")).toExternalForm());
            ImageView imageView = new ImageView(image);
            imageView.fitWidthProperty().bind(grid.widthProperty());
            imageView.fitHeightProperty().bind(grid.heightProperty());
            imageView.setPreserveRatio(false);
            //**************************SUBMIT BUTTON****************************
            Button submit = new Button("SUBMIT");
            submit.setFont(Font.font("Comic Sans",FontWeight.BOLD,10));
            submit.setDisable(true);
            submit.prefHeightProperty().bind(grid.heightProperty());
            submit.prefHeightProperty().bind(grid.heightProperty().divide(5));
            submit.setMinWidth(300);

            grid.add(submit,0,3);

            //**************************MENU BUTTON****************************
            Button menu = new Button("MENU");
            menu.setFont(Font.font("Comic Sans",FontWeight.BOLD,10));
            menu.prefHeightProperty().bind(grid.heightProperty());
            menu.prefHeightProperty().bind(grid.heightProperty().divide(5));
            menu.setMinWidth(300);
            menu.setOnAction(e-> stage.setScene(scene));

            grid.add(menu,0,4);


            //**************************SCENE SETUP****************************
            StackPane stack = new StackPane();
            stack.getChildren().add(imageView);
            stack.getChildren().add(grid);
            //**************************CONTROLLERS****************************
            date.setOnAction(e->{
                time.setDisable(false);
            });

            time.setOnAction(e->{
                info.setDisable(false);
                info.setText("Date: " + date.getValue() + " " + "\nTime: " + time.getValue());
                submit.setDisable(false);
            });

            Scene remove_scene = new Scene(stack,450,300);
            stage.getIcons().add(image);

            stage.setScene(remove_scene);
        stage.show();



        }
    public static void main(String[] args) {
        launch();
    }
}