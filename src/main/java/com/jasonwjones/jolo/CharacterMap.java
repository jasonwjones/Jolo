package com.jasonwjones.jolo;

/**
 * Allows for flexible implementatino of the characters that are used to build
 * the table.
 * 
 * @author jasonwjones
 *
 */
public interface CharacterMap {

	public enum Pieces {
		TOP_LEFT_CORNER(true), 
		TOP_RIGHT_CORNER(true), 
		BOTTOM_LEFT_CORNER(true), 
		BOTTOM_RIGHT_CORNER(true),
		TOP_CONNECTOR(false), 
		RIGHT_CONNECTOR(false), 
		BOTTOM_CONNECTOR(false), 
		LEFT_CONNECTOR(false), 
		INNER_CONNECTOR(false), 
		TOP_EDGE(false), 
		RIGHT_EDGE(false), 
		BOTTOM_EDGE(false), 
		LEFT_EDGE(false), 
		INNER_HORIZONTAL_EDGE(false), 
		INNER_VERTICAL_EDGE(false);

		private boolean corner;

		private Pieces(boolean corner) {
			this.corner = corner;
		}

		public boolean isCorner() {
			return corner;
		}

	}

	public char getCharacter(Pieces piece);

}
