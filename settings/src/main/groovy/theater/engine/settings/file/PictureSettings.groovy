package theater.engine.settings.file

class PictureSettings {

	Float x
	Float y
	
	void setPosition(Float x, Float y){
		this.x = x
		this.y = y
	}

	Transition transition = new Transition()

	class Transition {

		enum Type {
			FONDU,
			ZOOM,
			ROTATION,
			TRAVELLING_HORIZONTAL,
			TRAVELLING_VERTICAL,
		}

		Type type = Type.FONDU
		float duree = 0.5f
		boolean repeter = false
		// pour travelling
		Integer fenetre
	}
}
