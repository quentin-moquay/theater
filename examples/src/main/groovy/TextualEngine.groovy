import theater.engine.Engine
import theater.engine.object.file.*
import theater.engine.object.*

class TextualEngine implements Engine {

    BufferedReader input

    // flags
    private static Map<String, ?> flags = [:]

    TextualEngine() {
        input = new BufferedReader(new InputStreamReader(System.in))
    }

    void play(Music music) {
        println "[a ${music?.name} can be heard.]"
    }

    void play(Sound sound) {
        println "[a ${sound?.name} resound.]"
    }

    void stop(Music music) {
        println "[a ${music?.name} stopped.]"
    }

    void stop(Sound sound) {
        println "[a ${sound?.name}] stopped."
    }

    void play(Scene scene) {
        show scene.background as Background
        scene.pictures.each { this.show(it) }
        play scene.music as Music
    }

    void play(Animation animation) {
        // nothing
    }

    void stop(Animation animation) {
        // nothing
    }

    void showHud() {
        // nothing
    }

    void hideHud() {
        // nothing
    }

    void eraseHud() {
        // nothing
    }

    void say(Line line, boolean localizeIt) {
        assert line?.character: "Character is mandatory"
        def color = line.character.color ? line.character.color : "white"

        if (line.voice && localizeIt) {
            play line.voice
        }

        if (line.character.name && line.dialog) {
            decorate(color, "${line.character.name} : \"${line.text}\" ")
        } else if (line.dialog) {
            decorate(color, "\"${line.text}\" ")
        } else if (line.character.name) {
            // thinking
            decorate(color, "${line.character.name} : ${line.text}")
        } else {
            decorate(color, line.text)
        }

        // wait for ENTER input
        input.readLine()
    }

    /*
    +~~~~~~+~~~~~~+~~~~~~~~~~~+
    |  fg  |  bg  |  color    |
    +~~~~~~+~~~~~~+~~~~~~~~~~~+
    |  30  |  40  |  black    |
    |  31  |  41  |  red      |
    |  32  |  42  |  green    |
    |  33  |  43  |  yellow   |
    |  34  |  44  |  blue     |
    |  35  |  45  |  magenta  |
    |  36  |  46  |  cyan     |
    |  37  |  47  |  white    |
    |  39  |  49  |  default  |
    +~~~~~~+~~~~~~+~~~~~~~~~~~+
     */
    static Map colors = [
            black  : [30, 47],
            red    : [31, 49],
            green  : [32, 49],
            yellow : [33, 49],
            blue   : [34, 49],
            magenta: [35, 49],
            cyan   : [36, 49],
            white  : [37, 49]
    ]

    String decorate(String color, String line) {
        def arr = colors[color.toLowerCase()] ? colors[color.toLowerCase()] : colors['white']
        def fg = arr[0]
        def bg = arr[1]
        def style = "${(char) 27}[$fg;$bg" + "m"
        println(style + line)
        // reset style
        print "${(char) 27}[39;49" + "m"
    }

    String ask(Paragraph p) {
        def choice = p.lines
        println "Responds to : ${choice}"
        int i = 0
        String answer
        while (!answer) {
            println "Answer : ${choice[i]}"
            answer = input.readLine()?.trim()
            if (!answer) {
                i++
            }
            if (i >= choice.size()) {
                i = 0
            }
        }
        println "you said ${choice[i]}"
        choice[i]
    }

    void show(Background image) {
        println "[you arrived to ${image?.name}]"
    }

    void show(Picture image) {
        println "[You see in front of you ${image?.name}]"
    }

    void remove(Picture image) {
        println "[${image?.name} disappears]"
    }

    void remove(Background fondEcran) {
        println "[you left from ${fondEcran?.name}]"
    }

    void flag(String key, def value) {
        flags.put(key, value)
    }

    def flag(String key) {
        flags.get(key)
    }

    void _wait(long msWaitingTime) {
        sleep msWaitingTime
    }
}
