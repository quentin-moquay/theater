package api

import static theater.engine.Theater.*
import static theater.engine.TheaterConst.*

// no localization
localizationEnabled = false

// With this, your new character "Me" is registered in Theater memory
character "me"

assert character("me") != null

// You can make him talk or thinks.
// difference is output will add Quotation mark or not
// On each says or thinks, the game will wait your input for next action

character "me" says "this is a dialog"
character "me" thinks "this is a thinking"

// Also, when you used assets to represent your character on screen, you
// can make him "feels" or "hiding". It's a way to describe emotion.

// will show in assets directory, then directory girl/expression, file happy
character "girl" feels "happy"

// In the same way, if you put a sound in girl/voices directory with the good key
// the sound will be played.
// will play sound call assets/girl/voice/hello
character "girl" says "hello"

// Remember that all our shorts examples removed the localization module !
// with the localization module, all dialogs will be in a separate file with keys
// In this configuration, voices sounds will be named on the key. It will avoid very
// complex names.




// you can create a blank name character, oftenly used as a narrator.
character ""

// You can add a color to represent your character text !
character "" color "magenta"

// Sadly we can't write : character "" color "magenta" says "hello"
// but you can write this
character("").color("magenta").says("hello")
// well not very elegant I know...
// That's why it's more simple to affect character result to local variable !
narrator = character "" color "magenta"

// Our character can talks or thinks like everyone else
narrator.says "I'm saying something"
narrator.thinks "It was a very long night ago..."

// Maybe you saw it but there is a small impact when you save a character on a local variable
// Because everything is based on Groovy langage, we need to add a coma between
// variable and the method.

// That's why, when you used a local variable (and only in this case), you can used two shortcuts
// << is for says
// >> is for thinks
narrator.says "Something"
narrator << "Something"
narrator.thinks "Something"
narrator >> "Something"

END_OF_GAME
