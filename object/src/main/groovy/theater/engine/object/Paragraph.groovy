package theater.engine.object

class Paragraph {

    String key
    List<String> lines

    Paragraph(String key) {
        this.key = key
        this.lines = new LinkedList<?>()
    }
	
	boolean isEmpty(){
		this.lines.empty
	}
	
	String getAt(def index) {
		lines[index]
	}

}