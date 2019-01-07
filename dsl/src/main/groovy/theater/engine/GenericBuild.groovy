package theater.engine

import theater.engine.object.file.AnimationDsl
import theater.engine.object.file.BackgroundDsl
import theater.engine.object.file.MusicDsl
import theater.engine.object.file.PictureDsl
import theater.engine.object.file.SoundDsl

class GenericBuild<T> {
	T obj

    GenericBuild(T obj) {
		this.obj = obj
	}

	GenericBuild with(Closure closure) {
		if (closure) {
			def scope = obj.settings
			def code = closure.rehydrate(scope, scope, scope)
			code()
		}
		this
	}

	void on() {
		switch(obj.class){
			case SoundDsl.class:
			case MusicDsl.class:
			case AnimationDsl.class:
				EngineCommunication.play obj
				break
			case BackgroundDsl.class:
			case PictureDsl.class:
				EngineCommunication.show obj
				break
		}
	}
	
	void off() {
		switch(obj.class){
			case SoundDsl.class:
			case MusicDsl.class:
			case AnimationDsl.class:
				EngineCommunication.stop obj
				break
			case BackgroundDsl.class:
			case PictureDsl.class:
				EngineCommunication.remove obj
				break
		}
	}
}