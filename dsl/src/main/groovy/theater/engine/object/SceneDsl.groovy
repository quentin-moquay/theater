package theater.engine.object

import theater.engine.EngineCommunication
import theater.engine.Syntax
import theater.engine.object.file.BackgroundDsl
import theater.engine.object.file.File
import theater.engine.object.file.MusicDsl
import theater.engine.object.file.PictureDsl
import theater.engine.GenericBuild

class SceneDsl extends Scene {

	SceneDsl(String name){
		this.name = name
	}

	SceneDsl leftShift(def o) {
		this.with(o)
	}

	SceneDsl add(Syntax s){
		this
	}

	SceneDsl with(Closure closure) {
		if (closure) {
			def scope = this
			def code = closure.rehydrate(scope, scope, scope)
			code()
		}
		this
	}

	SceneDsl and(Object o) {
		with(o)
	}

	SceneDsl with(MusicDsl music) {
		this.music = music
		this
	}

	SceneDsl with(PictureDsl picture) {
		this.pictures += picture
		this
	}

	SceneDsl with(BackgroundDsl background) {
		this.background = background
		this
	}


	private void genericOperation(File instance, Closure localSettings){
		GenericBuild gb = new GenericBuild(instance)
		if (localSettings){
			gb.with localSettings
		}
		this << gb.obj
	}

	// Terminal operation
	void music(String name, Closure localSettings = null) {
		genericOperation(new MusicDsl(name), localSettings)
	}

	// Terminal operation
	void picture(String name, Closure localSettings = null) {
		genericOperation(new PictureDsl(name), localSettings)
	}

	// Terminal operation
	void background(String name, Closure localSettings = null) {
		genericOperation(new BackgroundDsl(name), localSettings)
	}

	// Terminal operation
	void music(MusicDsl music, Closure localSettings = null) {
		genericOperation(music, localSettings)
	}

	// Terminal operation
	void picture(PictureDsl picture, Closure localSettings = null) {
		genericOperation(picture, localSettings)
	}

	// Terminal operation
	void background(BackgroundDsl background, Closure localSettings = null) {
		genericOperation(background, localSettings)
	}

	void play(){
		EngineCommunication.play this as SceneDsl
	}

}
