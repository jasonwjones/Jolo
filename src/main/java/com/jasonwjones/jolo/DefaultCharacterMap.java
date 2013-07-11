package com.jasonwjones.jolo;

/**
 * Here's an idea: pass in the semantics you need (connects left, connects
 * right, connects up, etc) and the proper character is returned. Hmm.
 * 
 * @author Jason W. Jones
 * 
 */
public class DefaultCharacterMap {

	public enum Pieces {
		TOP_LEFT_CORNER, TOP_RIGHT_CORNER, BOTTOM_LEFT_CORNER, BOTTOM_RIGHT_CORNER, EDGE_DOWN, EDGE_RIGHT, EDGE_UP, EDGE_LEFT, EDGE_HORIZONTAL, EDGE_VERTICAL, INNER_CONNECTOR
	}

	public char getCharacter(Pieces piece) {
		return '-';
	}

}
