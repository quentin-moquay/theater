package theater.engine.object

import theater.engine.object.file.Background
import theater.engine.object.file.Music
import theater.engine.object.file.Picture

class Scene {

	String name
	Background background
	List<Picture> pictures
	Music music

	Scene() {
		pictures = []
	}

	@Override
	String toString() {
		"${name}"
	}
}
