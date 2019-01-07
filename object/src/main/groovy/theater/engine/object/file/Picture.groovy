package theater.engine.object.file

import theater.engine.settings.file.PictureSettings

class Picture extends File {

	PictureSettings settings // Describe additional settings for a particular engine
	boolean characterExpression

    Picture(String name, String extension) {
		super(name, extension)
		settings = new PictureSettings()
		characterExpression = false
	}

}
