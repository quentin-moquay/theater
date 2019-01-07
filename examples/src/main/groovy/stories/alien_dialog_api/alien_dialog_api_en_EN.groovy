package stories.alien_dialog_api

import static theater.engine.Theater.*

paragraph("intro") << [
        "The crew of the United States commercial starship Nostromo seated around a table.",
        "Dallas.........Captain",
        "Kane...........Executive Officer",
        "Ripley.........Warrant Officer",
        "Ash............Science Officer",
        "Lambert........Navigator",
        "Parker.........Engineer",
        "Brett..........Engineering Technician",
        "Jones..........Cat",
        "Five men and two women: Lambert and Ripley."
]

dialog("am_i_cold") << [
        [lambert: "Jesus am I cold."], // will try to play dialog voice in lambert/voice/am_i_cold[0].mp3
        [parker: "Still with us, Brett."], // will try to play dialog voice in parker/voice/am_i_cold[1].mp3
        [brett: "Yo."], // will try to play dialog voice in  brett/voice/am_i_cold[2].mp3
        [ripley: "Lucky us."] // will try to play dialog voice in ripley/voice/am_i_cold[3].mp3
]

paragraph("they_yawn") << [
        "They yawn, stretch, shiver.",
        "Dallas looks over at a flashing yellow light."]

paragraph("i_feel_dead") << "I feel dead."

paragraph("kane_is_not_yet") << [
        "Kane is not yet fully awake.",
        "Yawns."]

dialog("you_look_dead") << [
        [parker: "You look dead."],
        [ash: "Nice to be back."],
        [parker: "Before we dock maybe we'd better go over the bonus situation."],
        [brett: "Yeah."],
        [parker: "Brett and I think we deserve a full share."],
        [dallas: "You two will get what you contracted for."],
        [dallas: "Just like everybody else."],
        [brett: "Everybody else gets more than us."],
        [dallas: "Everybody else deserves more than you two."],
        [ash: "Mother wants to talk to you."],
        [dallas: "I saw it."],
        [dallas: "Yellow light for my eyes only..."],
        [dallas: "Now, everybody hit their stations."]
]