package theater.engine.object.file

import theater.engine.EngineCommunication
import theater.engine.TheaterConst

class MusicDsl extends Music {
	
	MusicDsl(String name, String extension) {
		super(name, extension)
	}

	MusicDsl(String name) {
		super(name, TheaterConst.soundExtension)
	}
	
	void play(){
		EngineCommunication.play this as Music
	}
	
	void stop(){
		EngineCommunication.stop this as Music
	}
}
