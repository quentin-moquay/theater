package theater.engine.object


import theater.engine.Theater
import theater.engine.TheaterConst

/**
 * This class purpose is to simplify Dialog management
 * 
 * @author Kent
 *
 */
class Dialog {

	String key
	List<Map> lines // Line or Closure to describe current Character
	int paragraphCount

	Dialog(String key){
		this.key = key
		lines = new LinkedList<>()
		paragraphCount = 0
	}

	Dialog leftShift(Map line) {

		def key = line.keySet().first()

		// It's a dialog
		if(line[key] instanceof String && TheaterConst.localizationEnabled){

			// unique id is created
			String id = "${this.key}[${paragraphCount++}]"

			// Create a new paragraph
			def paragraph = Theater.paragraph(id)

			// save into the paragraph the current dialog
			paragraph << line[key]

			// Replace text by id
			line[key] = id
		} else if(line[key] instanceof List && TheaterConst.localizationEnabled){

			String id = "${this.key}[${paragraphCount++}]"
			def paragraph = Theater.paragraph(id)
			line[key].each({paragraph << it})
			line[key] = id
		}

		lines += line

		this
	}

	Dialog leftShift(List<Map> lines) {
		lines.each(this.&leftShift)
		this
	}

	void read(Map characters) {
		lines.each{ Map line ->

			def key = line.keySet().first()
			def character = characters[key]

			if(line[key] instanceof String){
				character << line[key]
			} else if(line[key] instanceof Closure) {
				line[key].call(character)
			}
		}
	}
}
