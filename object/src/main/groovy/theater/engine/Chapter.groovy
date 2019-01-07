package theater.engine

abstract class Chapter {
	
	static final Chapter GAME_OVER = null

	String locale

	Chapter(String locale) {
		this.locale = locale
	}

	void init(){
		this.loadWings()
		this.loadBook()
	}

	void loadWings() {}

	void loadBook() {
		if(locale){
			Text paragraphs = Class.forName("${getClass().getCanonicalName()}_${locale}").newInstance() as Text
			paragraphs.load()
		}
	}

	abstract Chapter read()
}
