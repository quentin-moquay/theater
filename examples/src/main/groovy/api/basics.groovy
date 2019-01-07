package api

import theater.engine.object.file.MusicDsl

import static theater.engine.Theater.*
import static theater.engine.TheaterConst.*
import static theater.engine.TechnicalActionBuilder.Action.*

// Please read this File first if you want to know how Theater DSL works.
// Keep in mind that everything is actually Groovy langage.
// Theater DSL try to be very simple but a little knowledge on programming can be useful

// Book elements, this is the story
paragraph "every text"
dialog "dialog in book"

// This is those whose gonna play your story
character "actor"

// This is where you describe the story
scene "where everything happens, combinate background, pictures and music"

// All media elements to immerge the player into the story
background "picture in the back"
picture "asset above background"
animation "a set of pictures to animate on screen"
music "your music"
sound "a sound above music"

// And that's all for Theater DSL language elements !
// They all responds to the same logic.
// The first parameter is always the name of the element
// if you already call it before, Theater knows and will give you the old object
// if not, he will create it and give it to you
// That's why a call to an element can never give you a null object
assert music("my music") != null // never null
music = music("my music") // you can affect it to a local variable
music.extension = "new value" // you can update values
assert music("my music") == music("my music")
assert music == music("my music") // theater knows you change it

// Be careful because you can break this logic if you bypass Theater by creating your own object
music = new MusicDsl("my own music", "my extension")
assert music != music("my own music") // not the same object !
// That's why you should always ask to Theater to create an object unless you know what you are doing

// INTERACT

// I said we saw every element but it's not totally true. You can interact with the player
paragraph("this question") << ["A", "B"]
response = answer("this question")
assert response in [0, 1] // response is a position into paragraph array

// You can also write a flag to remember a choice or everything else you want
flag "answer", response // write the answer in flag

if (flag("answer") == 0) {
    println "player said earlier A"
} else {
    println "player said earlier B"
}

// OTHERS
_wait 2000 // make him wait 2 seconds (2 000 milliseconds)
hud hide // hide graphic interface
hud show // show graphic interface
hud erase // remove it (user can't interact to see it)
