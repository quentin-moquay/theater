import theater.engine.EngineCommunication
import theater.engine.TheaterConst

// Set-up the engine
EngineCommunication.engine = new TextualEngine()

TheaterConst.historyDirectory = "./"
TheaterConst.locale = "en_EN"

// which chapter do you want to read
String chapter = "api/basics"

while(chapter) {
    // Reading the book (localization)
    def file = new File("${TheaterConst.historyDirectory}/${chapter}_${TheaterConst.locale}.groovy")
    if(file.exists()) {
        evaluate(file)
    }
    // Reading the scene
    chapter = evaluate(new File("${TheaterConst.historyDirectory}/${chapter}.groovy"))
}
