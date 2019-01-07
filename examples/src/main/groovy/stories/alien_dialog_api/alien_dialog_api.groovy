package stories.alien_dialog_api

import theater.engine.TheaterConst

import static theater.engine.Theater.*

// Now we will used the localization module !
// You can look alien_scene.groovy to see the same scene with no localization module and no dialog api.

narrator = character "" color "black"

lambert = character "LAMBERT" color "yellow"
parker = character "PARKER" color "blue"
brett = character "BRETT" color "green"
ripley = character "RIPLEY" color "white"
kane = character "KANE" color "magenta"
ash = character "ASH" color "cyan"
dallas = character "DALLAS" color "red"

narrator >> "intro"

dialog "am_i_cold", [
        lambert: lambert,
        parker : parker,
        brett  : brett,
        ripley : ripley
]

narrator >> "they_yawn"
kane << "i_feel_dead"
narrator >> "kane_is_not_yet"

dialog "you_look_dead", [
        parker: parker,
        ash   : ash,
        brett : brett,
        dallas: dallas
]

// With dialog, the flow is easy to write on localization side and don't take much place
// and keys everywhere on this script.

TheaterConst.END_OF_GAME