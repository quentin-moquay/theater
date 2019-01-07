package theater.engine.settings.file

class AnimationSettings extends PictureSettings {

	enum Mode {
		NORMAL,
		REVERSE,
		LOOP,
		REVERSE_LOOP,
		PINGPONG_LOOP,
		RANDOM_LOOP
	}

	Mode mode
	Float speed
	boolean waitSoundEnd

	// if tileset
	Integer width
	Integer height

}
