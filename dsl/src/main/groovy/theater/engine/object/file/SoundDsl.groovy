package theater.engine.object.file

import theater.engine.EngineCommunication
import theater.engine.settings.file.SoundSettings
import theater.engine.TheaterConst

class SoundDsl extends Sound {
	
	SoundDsl(String name, String extension) {
		super(name, extension)
	}

	SoundDsl(String name) {
		super(name, TheaterConst.soundExtension)
	}

	SoundDsl(String name, float volume) {
		super(name, TheaterConst.soundExtension)
		this.options.volume = volume
	}
	
	SoundDsl with(Closure<SoundSettings> closure) {
		if (closure) {
			def scope = this.settings
			def code = closure.rehydrate(scope, scope, scope)
			code()
		}
		this
	}
	
	void play(){
		EngineCommunication.play this as Sound
	}
	
	void stop(){
		EngineCommunication.stop this as Sound
	}
}
