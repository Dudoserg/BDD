import javafx.scene.control.Button;
import javafx.scene.paint.Paint;

public class myBtn {
    public Button button;
    private String font;
    private String color;
    private String font_size;

    public void setFont(String font) {
        this.font = font;
        this.font +=  ";";
        this.applyStyle();
    }

    public void setColor(int num) {
        switch (num){
            case 0:{
                this.color = "-fx-background-color: #ddddd6";
                break;
            }
            case 2:{
                this.color = "-fx-background-color: #eee4da";
                break;
            }
            case 4:{
                this.color = "-fx-background-color: #ede0c8";
                break;
            }
            case 8:{
                this.color = "-fx-background-color: #f2b179";
                break;
            }
            case 16:{
                this.color = "-fx-background-color: #f28f4e";
                break;
            }
            case 32:{
                this.color = "-fx-background-color: #f67c5f";
                break;
            }
            case 64:{
                this.color = "-fx-background-color: #f65e3b";
                break;
            }
            case 128:{
                this.color = "-fx-background-color: #edcf72";
                break;
            }
            case 256:{
                this.color = "-fx-background-color: #edcc61";
                break;
            }
            case 512:{
                this.color = "-fx-background-color: #edc850";
                break;
            }
            case 1024:{
                this.color = "-fx-background-color: #edc53f";
                break;
            }
            case 2048:{
                this.color = "-fx-background-color: #edc22e";
                break;
            }
            case 4096:{
                this.color = "-fx-background-color: #edc22e";
                break;
            }
        }
        this.color += ";";
        this.applyStyle();
    }

    public void setFont_size(Integer font_size) {
        this.font_size = "-fx-font-size: " + font_size.toString() + "px" + ";";
        this.applyStyle();
    }

    public void applyStyle(){
        this.button.setStyle( font + " " + font_size + " " + color );
    }

    Integer num;
    public void setNum(Integer num){
        this.num = num;
        this.setColor(num);
        this.button.setText(num.toString());
        this.applyStyle();
    }

    public myBtn(Button button) {
        this.button = button;
        this.setFont_size(27);
        this.setFont("");
        this.button.setTextFill(Paint.valueOf("#3f3f3f"));
        this.setColor(2);
    }
}
