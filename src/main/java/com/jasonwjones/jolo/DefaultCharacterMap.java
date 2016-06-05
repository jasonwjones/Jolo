package com.jasonwjones.jolo;

/**
 * Here's an idea: pass in the semantics you need (connects left, connects
 * right, connects up, etc) and the proper character is returned. Hmm.
 * 
 * @author Jason W. Jones
 * 
 */
public class DefaultCharacterMap implements CharacterMap {

	@Override
	public char getCharacter(Pieces piece) {
		switch (piece) {
		case BOTTOM_CONNECTOR:
		case BOTTOM_LEFT_CORNER:
		case BOTTOM_RIGHT_CORNER:
		case INNER_CONNECTOR:
		case LEFT_CONNECTOR:
		case RIGHT_CONNECTOR:
		case TOP_CONNECTOR:
		case TOP_LEFT_CORNER:
		case TOP_RIGHT_CORNER:
			return '+';
		case INNER_VERTICAL_EDGE:
		case RIGHT_EDGE:
		case LEFT_EDGE:
			return '|';
		case INNER_HORIZONTAL_EDGE:
		case BOTTOM_EDGE:
		case TOP_EDGE:
		default:
			return '-';
		}
	}

}
