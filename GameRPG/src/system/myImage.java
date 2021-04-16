package system;

import java.io.File;

import javafx.scene.image.Image;

public class myImage extends Image{
	public myImage() {super("");}
	public myImage(String path)
	{
		super(new File(path).toURI().toString());
	}
}
