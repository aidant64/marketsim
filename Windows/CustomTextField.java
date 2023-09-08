package Windows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CustomTextField extends JTextField implements FocusListener, MouseListener, KeyListener {

    private final String initialText;

    CustomTextField(String text, boolean isSearch) {
        super(text);
        this.initialText = text;

        addFocusListener(this);
        addMouseListener(this);
        if(isSearch) {
            addKeyListener(this);
        }

        if(!isSearch){
            setPreferredSize(new Dimension(100, 23));
            setMinimumSize(new Dimension(100, 23));
            validate();
        }


    }

    public void focusLost(FocusEvent fe) {
        select(0, 0);
    }

    public void focusGained(FocusEvent fe) {
        //if (getText().equals(initialText)) {
            selectAll();
            setText("");
        //}
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        setText("");
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {
        forceUpperCase();
        validate();
        update(getGraphics());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        forceUpperCase();
        validate();
        update(getGraphics());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        forceUpperCase();
        validate();
        update(getGraphics());
    }

    private void forceUpperCase(){
        setText(getText().toUpperCase());
    }

}