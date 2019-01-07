package api

import theater.engine.TheaterConst
import theater.engine.object.SceneDsl

import static theater.engine.Theater.*
import static theater.engine.Syntax.*
import static theater.engine.TheaterConst.*

// no localization
TheaterConst.localizationEnabled = false
TheaterConst.pictureExtension = ""
TheaterConst.soundExtension = ""

// Usage 1 : you can create a scene like this
scene "my scene" with {
	add a background "1 : my background"
    add a music "1: my music"
} play()

// Usage 2
cornfield = background "2: my background"
atmosphere = music "2: my music"
scene = scene "my scene 2" with cornfield and atmosphere
play scene

// Usage 3 : More programmatic
SceneDsl myScene = scene("my scene 3")
myScene.background("3: my background")
myScene.music("3: my music")
myScene.play()

// Usage 4 : you can mix all of that to find a clearer way for you
def myOwnScene = scene("my scene 4") with {
    add a background "4: my back"
    this.background.name += "ground"
} and {
    add a music "4: my music"
}
play myOwnScene

// Find your own style :-)

// Remember that everytime you call scene "something", the scene is register to theater
scene "isRegister" with music("hello")
assert scene("isRegister").music.name == "hello"

TheaterConst.END_OF_GAME