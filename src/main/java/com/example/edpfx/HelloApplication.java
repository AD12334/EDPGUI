package com.example.edpfx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
        stage.setWidth(500);
        stage.setHeight(500);
        stage.setTitle("EDP_PROJECT");
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
        button3.setOnAction(e->{
            ViewSchedule(stage);
        });
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
        button4.setOnAction(e-> options(stage));
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


















         scene = new Scene(pane,500,500);

         stage.setMinWidth(500);
         stage.setMinHeight(500);

        stage.setScene(scene);
        stage.show();

    }


        //stage.setScene(scene);
        //stage.show();
        private void Schedulelecture(Stage stage) {
        stage.setHeight(240);
        stage.setWidth(450);
        String[] lectureinfo = new String[4];

            GridPane LecturePane = new GridPane();
            LecturePane.setAlignment(Pos.CENTER);
            //*******************DAY********************
            TextField day = new TextField("What day is the lecture?");
            //TODO change to dropboxes
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

            exit.setOnAction(e->{
                start(stage);
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
        stage.setWidth(450);
        stage.setHeight(300);


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

            menu.prefHeightProperty().bind(grid.heightProperty().divide(5));
            menu.setMinWidth(300);
            menu.setOnAction(e-> start(stage));

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
    //**************************VIEW SCHEDULE****************************

        private void ViewSchedule(Stage stage){
        stage.setWidth(900);
        stage.setHeight(500);

        GridPane grid = new GridPane();
        grid.minWidthProperty().bind(stage.widthProperty());
        grid.minHeightProperty().bind(stage.heightProperty());
        grid.prefHeightProperty().bind(stage.heightProperty());
        grid.prefWidthProperty().bind(stage.widthProperty());
        //grid.setGridLinesVisible(true);
        //grid.setStyle("-fx-border-color: black; -fx-border-width: 2; -fx-border-style: solid;");




        //**************************EXIT BUTTON****************************


            Button exit = new Button("EXIT");

            exit.setOnAction(e->{
                start(stage);
            });
            exit.setAlignment(Pos.CENTER);

            exit.setFont(Font.font("Comic Sans",FontWeight.BOLD,10));
            exit.minWidthProperty().bind(grid.widthProperty());
            exit.prefWidthProperty().bind(grid.widthProperty());
            GridPane.setColumnSpan(exit, 11);
            exit.prefHeightProperty().bind(stage.heightProperty().divide(10));
            exit.minHeightProperty().bind(stage.heightProperty().divide(10));
            grid.add(exit,0,0);//Column row
            //**************************BACKGROUND IMAGE SETUP****************************
//            Image image = new Image(Objects.requireNonNull(getClass().getResource("/com/example/edpfx/img_7.png")).toExternalForm());
//            ImageView imageView = new ImageView(image);
//            imageView.fitWidthProperty().bind(grid.widthProperty());
//            imageView.fitHeightProperty().bind(grid.heightProperty());
//            imageView.setPreserveRatio(false);
            //**************************TEXTFIELDS****************************





            VBox vbox = new VBox();

            vbox.minWidthProperty().bind(stage.widthProperty().divide(6));
            vbox.maxWidthProperty().bind(stage.widthProperty().divide(6));
            vbox.minHeightProperty().bind(stage.heightProperty());
            vbox.prefHeightProperty().bind(stage.heightProperty());
            vbox.setStyle("-fx-border-color: black; -fx-border-width: 2; -fx-border-style: solid;");






            VBox vbox2 = new VBox();

            vbox2.minWidthProperty().bind(stage.widthProperty().divide(6));
            vbox2.maxWidthProperty().bind(stage.widthProperty().divide(6));
            vbox2.minHeightProperty().bind(stage.heightProperty());
            vbox2.setStyle("-fx-border-color: black; -fx-border-width: 2; -fx-border-style: solid;");


            VBox vbox3 = new VBox();

            vbox3.minWidthProperty().bind(stage.widthProperty().divide(6));
            vbox3.maxWidthProperty().bind(stage.widthProperty().divide(6));
            vbox3.minHeightProperty().bind(stage.heightProperty());
            vbox3.setStyle("-fx-border-color: black; -fx-border-width: 2; -fx-border-style: solid;");


            VBox vbox4 = new VBox();

            vbox4.minWidthProperty().bind(stage.widthProperty().divide(6));
            vbox4.maxWidthProperty().bind(stage.widthProperty().divide(6));
            vbox4.minHeightProperty().bind(stage.heightProperty());
            vbox4.setStyle("-fx-border-color: black; -fx-border-width: 2; -fx-border-style: solid;");


            VBox vbox5 = new VBox();

            vbox5.minWidthProperty().bind(stage.widthProperty().divide(6));
            vbox5.maxWidthProperty().bind(stage.widthProperty().divide(6));
            vbox5.minHeightProperty().bind(stage.heightProperty());
            vbox5.setStyle("-fx-border-color: black; -fx-border-width: 2; -fx-border-style: solid;");


            VBox vbox6 = new VBox();

            vbox6.minWidthProperty().bind(stage.widthProperty().divide(6));
            vbox6.maxWidthProperty().bind(stage.widthProperty().divide(6));
            vbox6.minHeightProperty().bind(stage.heightProperty());
            vbox6.setStyle("-fx-border-color: black; -fx-border-width: 2; -fx-border-style: solid;");









            //Time
            TextField Time = new TextField();
            Time.setEditable(false);
            Time.setText("TIME");
            Time.setAlignment(Pos.CENTER);
            Time.setFont(Font.font("Comic Sans", FontWeight.BOLD, 15));
            Time.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");
            Time.prefHeightProperty().bind(vbox.heightProperty().divide(10));

            vbox.getChildren().addAll(Time);
            // Monday
            TextField Monday = new TextField();
            Monday.setEditable(false);
            Monday.setText("MONDAY");
            Monday.setAlignment(Pos.CENTER);
            Monday.setFont(Font.font("Comic Sans", FontWeight.BOLD, 15));
            Monday.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");
            vbox2.getChildren().addAll(Monday);

// Tuesday
            TextField Tuesday = new TextField();
            Tuesday.setEditable(false);
            Tuesday.setText("TUESDAY");
            Tuesday.setAlignment(Pos.CENTER);
            Tuesday.setFont(Font.font("Comic Sans", FontWeight.BOLD, 15));
            Tuesday.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");
            vbox3.getChildren().add(Tuesday); // Add Tuesday to HBox

// Wednesday
            TextField Wednesday = new TextField();
            Wednesday.setEditable(false);
            Wednesday.setText("WEDNESDAY");
            Wednesday.setAlignment(Pos.CENTER);
            Wednesday.setFont(Font.font("Comic Sans", FontWeight.BOLD, 15));
            Wednesday.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");
            vbox4.getChildren().add(Wednesday); // Add Wednesday to HBox

// Thursday
            TextField Thursday = new TextField();
            Thursday.setEditable(false);
            Thursday.setText("THURSDAY");
            Thursday.setAlignment(Pos.CENTER);
            Thursday.setFont(Font.font("Comic Sans", FontWeight.BOLD, 15));
            Thursday.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");
            vbox5.getChildren().add(Thursday);

// Friday
            TextField Friday = new TextField();
            Friday.setAlignment(Pos.CENTER);
            Friday.setEditable(false);
            Friday.setText("FRIDAY");
            Friday.setFont(Font.font("Comic Sans", FontWeight.BOLD, 15));
            Friday.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");
            vbox6.getChildren().add(Friday);

//LECTURE TIMES
            TextField t1 = new TextField("9:00 - 10:00");
            t1.setAlignment(Pos.CENTER);
            t1.setEditable(false);

            TextField t2 = new TextField("10:00 - 11:00");
            t2.setAlignment(Pos.CENTER);
            t2.setEditable(false);

            TextField t3 = new TextField("11:00 - 12:00");
            t3.setAlignment(Pos.CENTER);
            t3.setEditable(false);

            TextField t4 = new TextField("12:00 - 13:00");
            t4.setAlignment(Pos.CENTER);
            t4.setEditable(false);

            TextField t5 = new TextField("13:00 - 14:00");
            t5.setAlignment(Pos.CENTER);
            t5.setEditable(false);

            TextField t6 = new TextField("14:00 - 15:00");
            t6.setAlignment(Pos.CENTER);
            t6.setEditable(false);

            TextField t7 = new TextField("15:00 - 16:00");
            t7.setAlignment(Pos.CENTER);
            t7.setEditable(false);

            TextField t8 = new TextField("16:00 - 17:00");
            t8.setAlignment(Pos.CENTER);
            t8.setEditable(false);

            TextField t9 = new TextField("17:00 - 18:00");
            t9.setAlignment(Pos.CENTER);
            t9.setEditable(false);


            for (TextField t : new TextField[]{t1, t2, t3, t4, t5, t6, t7, t8, t9}) {
                t.prefHeightProperty().bind(vbox.heightProperty().subtract(Time.prefHeightProperty().get()).divide(9).subtract(16.0 * (stage.getHeight()/400)));
                t.maxHeightProperty().bind(vbox.heightProperty().subtract(Time.prefHeightProperty().get()).divide(9).subtract(16.0 * (stage.getHeight()/400)));// Hardcoded height
                vbox.getChildren().add(t);
            }



            grid.add(vbox,0,2);
            grid.add(vbox2,1,2);
            grid.add(vbox3,2,2);
            grid.add(vbox4,3,2);
            grid.add(vbox5,4,2);
            grid.add(vbox6,5,2);





            //**************************STAGE SETUP****************************




            Scene schedule = new Scene(grid,900,500);

            stage.setScene(schedule);
            stage.show();




        }



        private void options(Stage stage){
        GridPane grid = new GridPane();
        Button menu = new Button("MENU");
        menu.setFont(Font.font("Comic Sans",FontWeight.BOLD,10));
        menu.prefHeightProperty().bind(grid.heightProperty());
        menu.prefWidthProperty().bind(grid.widthProperty());
        menu.setAlignment(Pos.CENTER);



            menu.setOnAction(e-> start(stage));
        grid.getChildren().add(menu);
        Scene scene = new Scene(grid,500,500);
        stage.setMinWidth(500);
        stage.setMinHeight(500);
        stage.setScene(scene);

        stage.show();


    }
    public static void main(String[] args) {
        launch();
    }
}