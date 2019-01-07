package theater.engine

import theater.engine.object.Line
import theater.engine.object.Paragraph
import theater.engine.object.Scene
import theater.engine.object.file.Animation
import theater.engine.object.file.Background
import theater.engine.object.file.Music
import theater.engine.object.file.Picture
import theater.engine.object.file.Sound

/**
 * Communicate with game engine
 */
class EngineCommunication {
	
	// Chosen Game Engine
	static Engine engine

	static void play(Music music) {
		engine.play music
	}

	static void play(Sound sound) {
		engine.play sound
	}

	static void stop(Music music) {
		engine.stop music
	}

	static void stop(Sound sound) {
		engine.stop sound
	}

	static void play(Scene scene) {
		engine.play scene
	}

	static void say(Line line, boolean localizeIt) {
		engine.say line,localizeIt
	}

	static String ask(Paragraph choice) {
		engine.ask choice
	}
	
	static void _wait(long msWaitingTime) {
		engine._wait msWaitingTime
	}

	static void show(Background background) {
		engine.show background
	}

	static void show(Picture picture) {
		engine.show picture
	}

	static void remove(Picture picture) {
		engine.remove picture
	}

	static void remove(Background background) {
		engine.remove background
	}

	static void play(Animation animation) {
		engine.play animation
	}

	static void stop(Animation animation) {
		engine.stop animation
	}

	static void flag(String key, def value) {
		engine.flag key, value
	}

	static def flag(String key) {
		engine.flag key
	}

	static void showHud(){
		engine.showHud()
	}

	static void hideHud(){
		engine.hideHud()
	}

	static void eraseHud(){
		engine.eraseHud()
	}
}
