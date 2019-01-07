package theater.engine

import theater.engine.object.SceneDsl
import theater.engine.object.file.AnimationDsl
import theater.engine.object.file.BackgroundDsl
import theater.engine.object.file.MusicDsl
import theater.engine.object.file.PictureDsl
import theater.engine.object.file.SoundDsl

class TheaterBuilder {

	boolean on
	Closure settings

	TheaterBuilder(boolean on) {
		this.on = on
	}

	// middle operation
	TheaterBuilder settings(Closure closure) {
		settings = closure
		this
	}

	private void genericOperation(def instance, Closure localSettings){
		def gb = new GenericBuild(instance).with localSettings
		if(on){
			gb.on()
		}else{
			gb.off()
		}
	}

	// Terminal operation
	void scene(SceneDsl scene) {
		scene.play()
	}
	
	// Terminal operation
	void scene(String name) {
		Theater.scene(name)?.play()
	}
	
	// Terminal operation
	void sound(String name, Closure localSettings = settings) {
		genericOperation(new SoundDsl(name), localSettings)
	}

	// Terminal operation
	void music(String name, Closure localSettings = settings) {
		genericOperation(new MusicDsl(name), localSettings)
	}

	// Terminal operation
	void picture(String name, Closure localSettings = settings) {
		genericOperation(new PictureDsl(name), localSettings)
	}

	// Terminal operation
	void background(String name, Closure localSettings = settings) {
		genericOperation(new BackgroundDsl(name), localSettings)
	}

	// Terminal operation
	void animation(String name, Closure localSettings = settings) {
		genericOperation(new AnimationDsl(name), localSettings)
	}
	
	// Terminal operation
	void sound(SoundDsl sound, Closure localSettings = settings) {
		genericOperation(sound, localSettings)
	}

	// Terminal operation
	void music(MusicDsl music, Closure localSettings = settings) {
		genericOperation(music, localSettings)
	}

	// Terminal operation
	void picture(PictureDsl picture, Closure localSettings = settings) {
		genericOperation(picture, localSettings)
	}

	// Terminal operation
	void background(BackgroundDsl background, Closure localSettings = settings) {
		genericOperation(background, localSettings)
	}

	// Terminal operation
	void animation(AnimationDsl animation, Closure localSettings = settings) {
		genericOperation(animation, localSettings)
	}
}
