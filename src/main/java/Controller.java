import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public AnchorPane mainPane;

    private ArrayList<myBtn> buttons;
    private Scene scene;
    private int buttonSize;

    private Game game;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.init();
        this.generateButtons();
        this.buttons.get(0).setNum(1024);

        game = new Game();
        game.initialize();

        this.draw(true);


//        this.buttons.get(0).setText("1024");
//        this.buttons.get(0).setStyle(this.buttons.get(0).getStyle() + String.format("-fx-font-size: %dpx;", (int) (buttonSize*0.25)));
    }

    /**
     * Инициализируем переменные, списки, массивы
     */
    private void init(){
        buttons = new ArrayList<>();
        this.buttonSize = 100;
    }

    /**
     * Устанавливаем сцену в контроллере
     * @param scene Сцена переданная из класса мейн
     */
    public void setScene(Scene scene){
        this.scene = scene;
        scene.setOnKeyTyped(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                String str = ke.getCharacter();
                // System.out.println(str);
                if( ke.getCharacter().equals("W") || ke.getCharacter().equals("w")
                        || ke.getCharacter().equals("Ц") || ke.getCharacter().equals("ц")) {
                    System.out.println("w");
                    boolean flagGenerate =  game.up();
                    draw(flagGenerate);
                }
                else  if( ke.getCharacter().equals("S") || ke.getCharacter().equals("s")
                        || ke.getCharacter().equals("Ы") || ke.getCharacter().equals("ы")) {
                    System.out.println("s");
                    boolean flagGenerate =  game.down();
                    draw(flagGenerate);
                }
                else  if( ke.getCharacter().equals("D") || ke.getCharacter().equals("d")
                        || ke.getCharacter().equals("В") || ke.getCharacter().equals("в")) {
                    System.out.println("d");
                    boolean flagGenerate = game.right();
                    draw(flagGenerate);
                }
                else  if( ke.getCharacter().equals("A") || ke.getCharacter().equals("a")
                        || ke.getCharacter().equals("Ф") || ke.getCharacter().equals("ф")) {
                    System.out.println("a");
                    boolean flagGenerate = game.left();
                    draw(flagGenerate);
                }
            }
        });
    }

    private void draw(boolean flagGenerate){
        for(int i = 0 ; i < game.getSize(); i++){
            for(int j = 0 ; j < game.getSize(); j++){
                buttons.get(i * game.getSize() + j ).setNum(game.getElem(i,j));
            }
        }
        if(flagGenerate == true) {
            new java.util.Timer().schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            int generated = game.generateNumber();
                            int[] free = game.findFreePlace();
                            game.setElem(free[0], free[1], generated);

                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    for (int i = 0; i < game.getSize(); i++) {
                                        for (int j = 0; j < game.getSize(); j++) {
                                            buttons.get(i * game.getSize() + j).setNum(game.getElem(i, j));
                                        }
                                    }
                                }
                            });


                        }
                    }, 200
            );
        }


    }

    /**
     * Генерируем кнопки
     */
    private void generateButtons(){
        Integer count = 1;
        for(int i = 0 ; i < 4 ; i++){

            for(int j = 0 ; j < 4 ; j++){
                Button btn = new Button();
                this.buttons.add(new myBtn(btn));
                //btn.getStyleClass().add("Button1");

                btn.setTranslateX(10 + buttonSize*j + 10*j );
                btn.setTranslateY(10 + buttonSize*i + 10*i);
                btn.setPrefSize(buttonSize,buttonSize);
                //btn.setDisable(true);
                //btn.setStyle("-fx-focus-color: -fx-control-inner-background ; -fx-faint-focus-color: -fx-control-inner-background ;");
                btn.setStyle("    -fx-background-color: #ddddd6;");

                this.mainPane.getChildren().add(btn);

                Integer finalCount = count;
                btn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                    Integer id = finalCount;
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        btn_click(id);
                    }
                });

                count++;
            }
        }


    }

    /**
     * Функция по нажатию на кнопку
     * @param id_Button айдигшник нажатой кнопки от 1 до кол-ва кнопок
     */
    private void btn_click(Integer id_Button) {

        System.out.println(id_Button);
    }

}
