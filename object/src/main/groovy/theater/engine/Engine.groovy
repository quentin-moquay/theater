package theater.engine

interface Engine {

	abstract void play(theater.engine.object.file.Music music)

	abstract void play(theater.engine.object.file.Sound sound)

	abstract void stop(theater.engine.object.file.Music music)

	abstract void stop(theater.engine.object.file.Sound sound)

	abstract void play(theater.engine.object.Scene scene)

	abstract void say(theater.engine.object.Line line, boolean localizeIt)

	abstract String ask(theater.engine.object.Paragraph choice)
	
	abstract void _wait(long msWaitingTime)

	abstract void show(theater.engine.object.file.Background background)

	abstract void show(theater.engine.object.file.Picture picture)

	abstract void remove(theater.engine.object.file.Picture picture)

	abstract void play(theater.engine.object.file.Animation animation)

	abstract void stop(theater.engine.object.file.Animation animation)

	abstract void remove(theater.engine.object.file.Background background)

	void flag(String key, def value)

	def flag(String key)

	abstract void showHud()
	abstract void hideHud()
	abstract void eraseHud()
}
