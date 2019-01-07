package theater.engine

class TechnicalActionBuilder {

	enum Action{
		show,
		hide,
		erase
	}

	Action action

	TechnicalActionBuilder(Action action) {
		this.action = action
	}

	void call(){
		switch(action) {
			case Action.show:
				EngineCommunication.showHud()
				break
			case Action.hide:
				EngineCommunication.hideHud()
				break
			case Action.erase:
				EngineCommunication.eraseHud()
				break
		}
	}
}
