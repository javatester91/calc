import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Calc extends Application {
    Stage window;
    Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12, button13, button14, button15;
    String cacltext,text;
    Object x;
    Integer sum;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Calculator");
        cacltext="";
        x=null;
        sum=3;

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10,10,10,10));

        TextField result = new TextField("0");
        result.setFont(Font.font(20));
        result.setPrefSize(250,40);
        result.setAlignment(Pos.BASELINE_RIGHT);
        GridPane.setConstraints(result,0,0);
        GridPane.setColumnSpan(result,4);

        Button button1 = new Button("1");
        button1.setPrefSize(80,70);
        button1.setFont(Font.font(20));
        button1.setOnAction(e-> {
            cacltext = (cacltext + "1");
            result.setText((String) cacltext);
        });
        GridPane.setConstraints(button1,0,1);


        Button button2 = new Button("2");
        button2.setFont(Font.font(20));
        button2.setPrefSize(80,70);
        button2.setOnAction(e-> {
            cacltext = (cacltext + "2");
            result.setText(cacltext);
        });
        GridPane.setConstraints(button2,1,1);

        Button button3 = new Button("3");
        button3.setFont(Font.font(20));
        button3.setPrefSize(80,70);
        button3.setOnAction(e-> {
            cacltext = (cacltext + "3");
            result.setText(cacltext);
        });
        GridPane.setConstraints(button3,2,1);

        Button button4 = new Button("4");
        button4.setPrefSize(80,70);
        button4.setFont(Font.font(20));
        button4.setOnAction(e-> {
            cacltext = (cacltext + "4");
            result.setText(cacltext);
        });
        GridPane.setConstraints(button4,0,2);

        Button button5 = new Button("5");
        button5.setFont(Font.font(20));
        button5.setPrefSize(80,70);
        button5.setOnAction(e-> {
            cacltext = (cacltext + "5");
            result.setText(cacltext);
        });
        GridPane.setConstraints(button5,1,2);

        Button button6 = new Button("6");
        button6.setFont(Font.font(20));
        button6.setPrefSize(80,70);
        button6.setOnAction(e-> {
            cacltext = (cacltext + "6");
            result.setText(cacltext);
        });
        GridPane.setConstraints(button6,2,2);

        Button button7 = new Button("7");
        button7.setPrefSize(80,70);
        button7.setFont(Font.font(20));
        button7.setOnAction(e-> {
            cacltext = (cacltext + "7");
            result.setText(cacltext);
        });
        GridPane.setConstraints(button7,0,3);

        Button button8 = new Button("8");
        button8.setFont(Font.font(20));
        button8.setPrefSize(80,70);
        button8.setOnAction(e-> {
            cacltext = (cacltext + "8");
            result.setText(cacltext);
        });
        GridPane.setConstraints(button8,1,3);

        Button button9 = new Button("9");
        button9.setFont(Font.font(20));
        button9.setPrefSize(80,70);
        button9.setOnAction(e-> {
            cacltext = (cacltext + "9");
            result.setText(cacltext);
        });
        GridPane.setConstraints(button9,2,3);

        Button button10 = new Button("/");
        button10.setFont(Font.font(20));
        button10.setPrefSize(80,70);
        button10.setOnAction(e-> {
            cacltext = (cacltext + "/");
            result.setText(cacltext);
        });
        GridPane.setConstraints(button10,3,1);

        Button button11 = new Button("*");
        button11.setFont(Font.font(20));
        button11.setPrefSize(80,70);
        button11.setOnAction(e->{
            cacltext = (cacltext + "*");
            result.setText(cacltext);
        });
        GridPane.setConstraints(button11,3,2);

        Button button12 = new Button("+");
        button12.setFont(Font.font(20));
        button12.setPrefSize(80,70);
        button12.setOnAction(e-> {
            cacltext = (cacltext + "+");
            result.setText(cacltext);
        });
        GridPane.setConstraints(button12,3,3);

        Button button13 = new Button("-");
        button13.setFont(Font.font(20));
        button13.setPrefSize(80,70);
        button13.setOnAction(e->{
            cacltext = (cacltext + "-");
            result.setText(cacltext);
        });
        GridPane.setConstraints(button13,3,4);

        Button button14 = new Button("C");
        button14.setFont(Font.font(20));
        button14.setPrefSize(80,70);
        button14.setOnAction(e-> {
            cacltext = "0";
            result.setText(cacltext);
            cacltext = "";
        });
        GridPane.setConstraints(button14,2,4);

        Button button15 = new Button("0");
        button15.setFont(Font.font(20));
        button15.setPrefSize(80,70);
        button15.setOnAction(e-> {
            cacltext = (cacltext + "0");
            result.setText(cacltext);
        });
        GridPane.setConstraints(button15,1,4);

        // Обработка enter
        result.setOnKeyPressed((event) -> { if(event.getCode() == KeyCode.ENTER) {
            text=result.getText();
            if (text!=cacltext) {cacltext=text;}

            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("js");
            try {
                x = engine.eval(cacltext);

                Object[] arr = new Object[1];
                arr[0] = x;
                String String_Array[]=new String[arr.length];
                String_Array[0]=arr[0].toString();
                System.out.println(String_Array[0]);
                result.setText(String_Array[0]);
                cacltext=String_Array[0];
            } catch (ScriptException e1) {
                e1.printStackTrace();
            }
        }
        });

        Button button16 = new Button("=");
        button16.setFont(Font.font(20));
        button16.setPrefSize(80,70);
        button16.setOnAction(e-> {
            text=result.getText();
            // System.out.println(text);

            if (text!=cacltext) {cacltext=text;}

            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("js");
            try {
                x = engine.eval(cacltext);
                // System.out.println(x);

                Object[] arr = new Object[1];
                arr[0] = x;
                String String_Array[]=new String[arr.length];
                String_Array[0]=arr[0].toString();
                System.out.println(String_Array[0]);
                result.setText(String_Array[0]);
                cacltext=String_Array[0];
            } catch (ScriptException e1) {
                e1.printStackTrace();
            }

        });
        GridPane.setConstraints(button16,0,4);

        gridPane.getChildren().addAll(result, button1,button2,button3,button4,button5,button6,button7,button8,button9,button10,button11,button12,button13,button14,button15,button16);

        Scene scene = new Scene(gridPane,350,350);
        window.setScene(scene);
        window.show();
    }
}
