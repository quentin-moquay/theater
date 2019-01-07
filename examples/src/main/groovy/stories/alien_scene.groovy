package stories

import theater.engine.TheaterConst

import static theater.engine.Theater.*
import static theater.engine.TheaterConst.*

// no localization
TheaterConst.localizationEnabled = false
TheaterConst.pictureExtension = ""
TheaterConst.soundExtension = ""

narrator = character "" color "black"

narrator >> "The crew of the United States commercial starship Nostromo seated around a table."
narrator >> "Dallas.........Captain"
narrator >> "Kane...........Executive Officer"
narrator >> "Ripley.........Warrant Officer"
narrator >> "Ash............Science Officer"
narrator >> "Lambert........Navigator"
narrator >> "Parker.........Engineer"
narrator >> "Brett..........Engineering Technician"
narrator >> "Jones..........Cat"
narrator >> "Five men and two women: Lambert and Ripley."

// Dialog

lambert = character "LAMBERT" color "yellow"
parker = character "PARKER" color "blue"
brett = character "BRETT" color "green"
ripley = character "RIPLEY" color "white"
kane = character "KANE" color "magenta"
ash = character "ASH" color "cyan"
dallas = character "DALLAS" color "red"

lambert << "Jesus am I cold."
parker << "Still with us, Brett."
brett << "Yo."
ripley << "Lucky us."

narrator >> "They yawn, stretch, shiver."
narrator >> "Dallas looks over at a flashing yellow light."

kane << "I feel dead."

narrator >> "Kane is not yet fully awake."
narrator >> "Yawns."

parker << "You look dead."
ash << "Nice to be back."
parker << "Before we dock maybe we'd better go over the bonus situation."
brett << "Yeah."
parker << "Brett and I think we deserve a full share."
dallas << "You two will get what you contracted for."
dallas << "Just like everybody else."
brett << "Everybody else gets more than us."
dallas << "Everybody else deserves more than you two."
ash << "Mother wants to talk to you."
dallas << "I saw it."
dallas << "Yellow light for my eyes only..."
dallas << "Now, everybody hit their stations."

TheaterConst.END_OF_GAME