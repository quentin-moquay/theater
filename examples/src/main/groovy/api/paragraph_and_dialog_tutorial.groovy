package api

import static theater.engine.Theater.*
import static theater.engine.TheaterConst.*

// Let's declare a paragraph
paragraph "sample"

// like everything else, once you declared it, it's save into Theater.
// You can add text lines to your paragraph.
// Think of paragraphs likes a Book. This is the text content but nobody yet
// are playing it. We need a Character who gonna play your text !
// Remember each line will be told by only one character. So if you have
// Bob and Anne characters, don't put both lines on one paragraph.

paragraph("bob_lines") << [
        "Hello, my name is Bob.",
        "Nice to meet you."]
paragraph("anne_lines") << "Hello, I'm Anne."
paragraph("anne_lines") << "Nice to meet you too."

// As you can see, we can add lines in two ways.

// Now, Let's create two characters
character "Bob" color "Blue" // Create bob
character "Anne" color "Red" // Create Anne

// And let them talk
character "Bob" says "bob_lines"
character "Anne" says "anne_lines"

// Remember (As usual, you can bind everything to local variables)
bob = character "bob"
anne = character "anne"

// Ok but maybe you want to create a dialog like this :
// Bob : Hello, my name is Bob.
// Anne : Hello, I'm Anne.
// Bob : Nice to meet you.
// Anne : Nice to meet you too.

// There is two ways to do that.

// The rough way !
paragraph("bob_1") << "Hello, my name is Bob."
paragraph("anne_1") << "Hello, I'm Anne."
paragraph("bob_2") << "Nice to meet you."
paragraph("anne_2") << "Nice to meet you too."

// Then in the Script part !
bob << "bob_1"
anne << "anne_1"
bob << "bob_2"
anne << "anne_2"

// I think it's a little fastidious, especially with lot of text (which is the purpose of a visual novel, right ?)
// Well if you don't localize your visual novel, it can be OK because you don't need paragraph and keys everywhere.
// If you won't to see an example, read alien_scene.groovy in stories directory.

// Ok, now, let's try Dialog feature !
dialog("greetings") << [
        [bob: "Hello, my name is Bob."],
        [anne: "Hello, I'm Anne."],
        [bob: "Nice to meet you."],
        [anne: 'Nice to meet you too.']
]

// Then in the Script part !
dialog("greetings", [bob: bob, anne: anne])

// And, that's it !
// As you can see, this way is faster to write. No more keys everywhere, better flow for the writer.
// But sometimes, in a dialog, you want to change assets of characters right ?
// you can even make someone thinking into the dialog
// This is why you can declare in dialog an update on character.

paragraph("oups") << "I forgot my keys at home..." // bob thinking insert into dialog
dialog("greetings_2") << [
        [bob: "Hello, my name is Bob."],
        [bob: { character -> character.feels "happy" }],
        [anne: "Hello, I'm Anne."],
        [anne: { character -> character.feels "shy" }],
        [bob: { character -> bob.thinks "oups" }],
        [bob: "Nice to meet you."],
        [bob: { character -> character.hiding() }],
        [anne: 'Nice to meet you too.']
]
dialog("greetings_2", [bob: bob, anne: anne])

// OK, I think now it's great. The only counterpart of this feature is that when you'll translate your
// dialog into another language, you have to be careful about those lines. Because you don't want to
// break the flow of assets update !

// Of course, you can do that in a rough way
bob.says "bob_1"
bob.feels "happy"
anne.says "anne_1"
anne.feels "shy"
bob.thinks "oups"
bob.says "bob_2"
bob.hiding()
anne.says "anne_2"

// At the end of the day, every way of writing it is OK. Find your own style !
END_OF_GAME
