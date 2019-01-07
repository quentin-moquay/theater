package theater.engine.object.file

class File {
	
	String name
	String extension

	File(String name, String extension) {
		this.name = name
		this.extension = extension
	}
	
	String getFullname(){
		"${name}.${extension}"
	}
}
