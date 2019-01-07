package theater.engine.object.file

import theater.engine.settings.file.SoundSettings

class Sound extends File {

	SoundSettings settings // Describe additional settings for a particular engine

    Sound(String name, String extension) {
		super(name, extension)
		settings = new SoundSettings()
	}
	
}