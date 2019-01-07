package theater.engine.object

import theater.engine.object.file.Sound
import theater.engine.settings.LineSettings

class Line {

	String id // useful for save system
	String text
	Character character
	Sound voice
	boolean dialog

	LineSettings settings // Describe additional settings for a particular engine
	boolean enableCharacterExpression

	Line() {
		settings = new LineSettings()
	}
	
	Line with(Closure<LineSettings> closure) {
		if (closure) {
			def scope = this.settings
			def code = closure.rehydrate(scope, scope, scope)
			code()
		}
		this
	}
}
