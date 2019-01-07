package theater.engine

import theater.engine.object.CharacterDsl
import theater.engine.object.Dialog
import theater.engine.object.ParagraphDsl
import theater.engine.object.Scene
import theater.engine.object.SceneDsl
import theater.engine.object.file.AnimationDsl
import theater.engine.object.file.BackgroundDsl
import theater.engine.object.file.File
import theater.engine.object.file.MusicDsl
import theater.engine.object.file.PictureDsl
import theater.engine.object.file.SoundDsl

/**
 * DSL Reader
 */
class Theater {

	private static Map<String, CharacterDsl> characters = [:]
	private static Map<String, ParagraphDsl> chapters = [:]
	private static Map<String, Dialog> chapterDialogs = [:]
	private static Map<String, SceneDsl> scenes = [:]

	// Game engine can request this Map for save purpose
	static Map<String, Integer> answers = [:]

	// Game engine can request all text characters used in Chapter for creating specific font
	static String symbolsUsed = ""

	// At chapter transition, we drop everything
	static purge(){
		characters.clear()
		chapters.clear()
		chapterDialogs.clear()
		scenes.clear()
		answers.clear()
		symbolsUsed = ""
	}

	/**
	 * This is a Set of every char used in the game
	 * Can be useful for game engine which generated specific font for each language
	 * @param c
	 */
	static void addToSymbolsUsed(String line){
		symbolsUsed += line
		symbolsUsed = symbolsUsed.toSet().join()
	}

	static CharacterDsl character(String name) {
		createOfGet(characters, name, CharacterDsl.class)
	}

	static ParagraphDsl paragraph(String name) {
		createOfGet(chapters, name, ParagraphDsl.class)
	}

	static Dialog dialog(String name) {
		createOfGet(chapterDialogs, name, Dialog.class)
	}

	static SceneDsl scene(String name) {
		createOfGet(scenes, name, SceneDsl.class)
	}

	static File file(String filename) {
		new File(filename)
	}

	static void dialog(String name, Map characters) {
		Dialog dialogue = dialog(name)
		dialogue.read(characters)
	}

	static int answer(ParagraphDsl choice) {
		int value = choice.lines.indexOf(EngineCommunication.ask(choice))
		answers.put(choice.key,value)
		value
	}

	static void _wait(long msWaitingTime) {
		EngineCommunication._wait msWaitingTime
	}

	static TheaterBuilder play(Syntax syntax = null) {
		new TheaterBuilder(true)
	}

	static TheaterBuilder stop(Syntax syntax = null) {
		new TheaterBuilder(false)
	}

	static TheaterBuilder show(Syntax syntax = null) {
		new TheaterBuilder(true)
	}

	static TheaterBuilder remove(Syntax syntax = null) {
		new TheaterBuilder(false)
	}

	static TechnicalActionBuilder hud(TechnicalActionBuilder.Action act) {
		new TechnicalActionBuilder(act).call()
	}

	static void play(File o) {
		EngineCommunication.play o
	}
	static void stop(File o) {
		EngineCommunication.stop o
	}
	static void show(File o) {
		EngineCommunication.show o
	}
	static void remove(File o) {
		EngineCommunication.remove o
	}
	
	static void play(Scene o) {
		EngineCommunication.play o
	}

	static SoundDsl sound(String name) {
		new SoundDsl(name)
	}

	static MusicDsl music(String name) {
		new MusicDsl(name)
	}

	static PictureDsl picture(String name) {
		new PictureDsl(name)
	}

	static BackgroundDsl background(String name) {
		new BackgroundDsl(name)
	}

	static AnimationDsl animation(String name) {
		new AnimationDsl(name)
	}

	static void flag(String key, def value) {
		EngineCommunication.flag key, value
	}

	static def flag(String key) {
		EngineCommunication.flag key
	}

	/**
	 * Create or Get an instance of clazz based on a key
	 *
	 * @param name
	 * @return
	 */
	private static <T> T createOfGet(Map map, String key, Class<T> clazz) {
		if (!map.containsKey(key)) {
			map.put(key, clazz.newInstance(key))
		}
		map.get(key)
	}
}