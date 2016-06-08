package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;

import view.RenderInstructions;

public abstract class Controller implements MouseListener, MouseMotionListener{

	protected boolean switchScreen = false;

	public abstract void initialize();
	
	public abstract LinkedList<RenderInstructions> getRenderInstructions();

	public abstract boolean shouldSwitchScreen();

	public abstract void mouseDragged(MouseEvent e);

	public abstract void mouseMoved(MouseEvent e);

	public abstract void mouseClicked(MouseEvent e);

	public abstract void mouseEntered(MouseEvent e);

	public abstract void mouseExited(MouseEvent e);

	public abstract void mousePressed(MouseEvent e);

	public abstract void mouseReleased(MouseEvent e);

	public abstract String toString();
}
