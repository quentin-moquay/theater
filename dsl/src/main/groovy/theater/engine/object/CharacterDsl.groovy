package theater.engine.object

import theater.engine.EngineCommunication
import theater.engine.object.file.PictureDsl
import theater.engine.object.file.SoundDsl
import theater.engine.settings.LineSettings
import theater.engine.settings.file.PictureSettings

import static theater.engine.Theater.*

import static theater.engine.TheaterConst.*

class CharacterDsl extends Character {

	CharacterDsl(String name){
		super(name)
		addToSymbolsUsed(name)
	}

	/**
	 * Verify if key is found. If localization mode is off, the key is send in text.
	 * @param message
	 * @return
	 */
	private ParagraphDsl verifyParagraph(String message){
		ParagraphDsl paragraph = paragraph(message)
		if(localizationEnabled){
			assert !paragraph.empty : "[${message}] is missing"
		} else if(paragraph.empty) {
			paragraph.lines.add(paragraph.key)
		}
		paragraph
	}

	CharacterDsl thinks(String message, Closure<LineSettings> opts = null) {
		def lines = verifyParagraph(message)?.lines
		if (lines.size() > 1){
			lines.eachWithIndex { it, i ->
				def line = new Line(text: it, voice: null, character: this, id: "${message}[${i}]").with(opts)
				if(line.settings.mode == LineSettings.Mode.NVL_CLEAR && i > 0) {
					line.settings.mode = LineSettings.Mode.NVL
				}
				EngineCommunication.say(line,localizationEnabled)
			}
		} else {
			def line = new Line(text: lines.first(), voice: null, character: this, id: "${message}").with(opts)
			EngineCommunication.say(line,localizationEnabled)
		}
		this
	}

	CharacterDsl says(String message, Closure<LineSettings> opts = null) {
		def lines = verifyParagraph(message)?.lines

		if (lines.size() > 1){
			lines.eachWithIndex { it, i ->
				def line = new Line(character: this, dialog: true, id: "${message}[${i}]").with(opts)
				if(line.settings.mode == LineSettings.Mode.NVL_CLEAR && i > 0) {
					line.settings.mode = LineSettings.Mode.NVL
				}
				if(name) {
					line.voice = new SoundDsl("${voiceDirectory}/${message}[${i}]")
				} else {
					line.voice = new SoundDsl("${message}[${i}]")
				}
				line.text = it
				EngineCommunication.say(line,localizationEnabled)
			}
		} else {
			def line = new Line(character: this, dialog: true, text: lines.first(), id: "${message}").with(opts)
			if(name) {
				line.voice = new SoundDsl("${voiceDirectory}/${message}")
			} else {
				line.voice = new SoundDsl("${message}")
			}
			EngineCommunication.say(line,localizationEnabled)
		}
		this
	}

	CharacterDsl feels(PictureDsl picture) {
		if(name) {
			expression = picture
			expression.characterExpression = true
			EngineCommunication.show expression
		}
		this
	}

	CharacterDsl feels(String expression) {
		if(name) {
			this.feels(new PictureDsl("${expressionDirectory}/${expression}"))
		}
		this
	}

	CharacterDsl feels(String expression, Closure<PictureSettings> settings) {
		if(name) {
			def image = new PictureDsl("${expressionDirectory}/${expression}")
			image.with settings
			this.feels image
		}
		this
	}

	CharacterDsl hiding() {
		if(name && expression) {
			EngineCommunication.remove expression
		}
		this
	}

	CharacterDsl leftShift(String message, Closure<LineSettings> settings = null) {
		says(message, settings)
	}

	CharacterDsl rightShift(String message, Closure<LineSettings> settings = null) {
		thinks(message, settings)
	}
}