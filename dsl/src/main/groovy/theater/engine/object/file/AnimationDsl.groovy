package theater.engine.object.file

import theater.engine.EngineCommunication
import theater.engine.settings.file.AnimationSettings

class AnimationDsl extends Animation {

    AnimationDsl(String name) {
		super(name)
	}
	
	AnimationDsl with(Closure<AnimationSettings> closure) {
		if (closure) {
			def scope = this.settings
			def code = closure.rehydrate(scope, scope, scope)
			code()
		}
		this
	}

	void play(){
		EngineCommunication.play this as AnimationDsl
	}

	void stop(){
		EngineCommunication.stop this as AnimationDsl
	}
}
