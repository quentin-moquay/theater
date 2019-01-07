package theater.engine.object


import theater.engine.Theater

class ParagraphDsl extends Paragraph {

    ParagraphDsl(String key) {
		super(key)
    }

    ParagraphDsl leftShift(String line) {
		Theater.addToSymbolsUsed(line)
        lines += line
        this
    }
	
	ParagraphDsl leftShift(List<String> lines) {
		lines.each(this.&leftShift)
		this
	}

}