package system;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class myGraphic extends ImageView {
	public myGraphic() {}
	public myGraphic(Image img) {
		super(img);
	}
	public myGraphic(String path) {
		this.setImage(new myImage(path));
	}
	public void setSize(double width, double height)
	{
		this.setFitWidth(width);
		this.setFitHeight(height);
	}
	public void setPosition(double x, double y)
	{
		this.setX(x);
		this.setY(y);
	}
}
