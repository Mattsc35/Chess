package controller;

import java.util.LinkedList;

import view.RenderInstructions;

public interface Renderable {
	public LinkedList<RenderInstructions> getRenderInstructions();
}
