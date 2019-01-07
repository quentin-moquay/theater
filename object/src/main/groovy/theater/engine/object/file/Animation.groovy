package theater.engine.object.file

import theater.engine.settings.file.AnimationSettings

class Animation {

	String name
	AnimationSettings settings // Describe additional settings for a particular engine

    Animation(String name) {
		this.name = name
		settings = new AnimationSettings()
	}

}
