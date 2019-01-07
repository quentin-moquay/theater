package theater.engine.object.file

import theater.engine.settings.file.PictureSettings

class Background extends File {

	PictureSettings settings

    Background(String name, String extension) {
		super(name, extension)
		settings = new PictureSettings()
	}
}
