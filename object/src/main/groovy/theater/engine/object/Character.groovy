package theater.engine.object

import theater.engine.object.file.Picture

class Character {

	String name
	String voiceDirectory
	String expressionDirectory
	String color
	Picture expression

    Character(String name){
		this.name = name
		def directory = name?.toLowerCase()
		directory = directory?.replace(' ','_')
		 
		this.expressionDirectory = "${directory}/expression"
		this.voiceDirectory = "${directory}/voice"
	}

	Character color(String color) {
		this.color = color
		this
	}

	@Override
	String toString() {
		name
	}
}