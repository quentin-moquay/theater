package theater.engine.object.file

import theater.engine.EngineCommunication
import theater.engine.TheaterConst
import theater.engine.settings.file.PictureSettings

class PictureDsl extends Picture {

	PictureDsl(String name, String extension) {
		super(name, extension)
	}

	PictureDsl(String name) {
		super(name, TheaterConst.pictureExtension)
	}
	
	PictureDsl with(Closure<PictureSettings> closure) {
		if (closure) {
			def scope = this.settings
			def code = closure.rehydrate(scope, scope, scope)
			code()
		}
		this
	}
	
	void show(){
		EngineCommunication.show this as Picture
	}

	void remove(){
		EngineCommunication.remove this as Picture
	}
}
