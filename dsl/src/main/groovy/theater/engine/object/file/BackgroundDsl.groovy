package theater.engine.object.file

import theater.engine.EngineCommunication
import theater.engine.TheaterConst

class BackgroundDsl extends Background {

	BackgroundDsl(String name, String extension) {
		super(name, extension)
	}

	BackgroundDsl(String name) {
		super(name, TheaterConst.pictureExtension)
	}
	
	void show(){
		EngineCommunication.show this as Background
	}

	void remove(){
		EngineCommunication.remove this as Background
	}
}
