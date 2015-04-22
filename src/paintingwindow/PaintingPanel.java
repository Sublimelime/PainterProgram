package paintingwindow;

import paintinglogic.Logger;
import paintinglogic.PaintBrush;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * @author K1211282
 *         Created on: 3/17/2015 , Time is: 1:04 PM
 *         Part of Project: PaintingProgram
 */

public class PaintingPanel extends JPanel implements MouseMotionListener, MouseListener {
    public static Color canvasColour = new Color(238, 238, 238);
    public static Color non_eraserColor = Color.BLACK;
    PaintBrush brush = new PaintBrush(); //creates the PaintBrush to hold data about the current state of the brush.
    Image circle, paintbucket, square, xMark, small, medium, big, huge, eraser;
    BufferedImage canvas;
    Graphics b;
    int dynamicMouseX = 0, dynamicMouseY = 0;

    public PaintingPanel() {
        Logger.logCodeMessage("Setting size of window to 900x1000");
        setSize(900, 1000); //set size to 900x1000 pixels
        //load all images, such as brush size chooser, and other icons
        try {
            circle = ImageIO.read(new File("resource/circle.png"));
            paintbucket = ImageIO.read(new File("resource/paintbucket.png"));
            square = ImageIO.read(new File("resource/square.png"));
            xMark = ImageIO.read(new File("resource/x.png"));
            small = ImageIO.read(new File("resource/small.png"));
            medium = ImageIO.read(new File("resource/medium.png"));
            big = ImageIO.read(new File("resource/big.png"));
            huge = ImageIO.read(new File("resource/hug.png"));
            eraser = ImageIO.read(new File("resource/eraser.png"));
            //canvas-----------------
            Logger.logOtherMessage("Canvas_Loader", "Loading the canvas...");
            canvas = new BufferedImage(900, 850, BufferedImage.TYPE_4BYTE_ABGR); //creates the canvas to paint to.
            b = canvas.getGraphics(); //gets a graphics object off of the canvas.
            Logger.logOtherMessage("Canvas_Loader", "Succeeded.");

            Logger.logOtherMessage("ImageLoader", "Succeeded.");
        } catch (Exception e) { //if something goes wrong with loading images, such as missing files.
            System.err.println("Error Reading images. Program will exit.");
            Logger.logErrorMessage("Error reading in images.");
            System.exit(-2);
        }
        addMouseMotionListener(this); //adds mouse listeners to the program
        addMouseListener(this);
    }


    public void paint(Graphics g) {
        //paint gui ----------------------
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), 150);
        g.setColor(Color.BLACK);
        g.drawString("Painter Program", 10, 20);

        //draw all brush choices to the screen --------------
        g.drawString("Brushes:", 150, 20);
        //g.drawImage(paintbucket, 150, 30, null);
        g.drawImage(circle, 215, 30, null);
        g.drawImage(square, 279, 30, null);
        g.drawImage(eraser, 343, 30, null);
        g.drawString("Set custom colour:", 790, 50);
        g.setColor(Color.BLUE);
        g.fillRect(820, 70, 50, 50);
        g.setColor(Color.BLACK);

        //draw screen clearer --------
        g.drawString("Clear all:", 10, 50);
        g.drawImage(xMark, 10, 60, null);

        //draw size choices -------------
        g.drawImage(small, 150, 85, null);
        g.drawImage(medium, 200, 85, null);
        g.drawImage(big, 250, 85, null);
        g.drawImage(huge, 320, 85, null);
        g.drawString("Sizes:", 150, 100);

        //draw colour choices -----------
        g.drawString("Colours:", 500, 30);
        g.setColor(Color.RED);
        g.fillRect(500, 40, 10, 10);
        g.setColor(Color.BLUE);
        g.fillRect(515, 40, 10, 10);
        g.setColor(Color.orange);
        g.fillRect(530, 40, 10, 10);
        g.setColor(Color.yellow);
        g.fillRect(545, 40, 10, 10);
        g.setColor(Color.green);
        g.fillRect(560, 40, 10, 10);
        g.setColor(Color.black);
        g.fillRect(575, 40, 10, 10);
        g.setColor(Color.CYAN);
        g.fillRect(590, 40, 10, 10);
        g.setColor(Color.PINK);
        g.fillRect(605, 40, 10, 10);
        g.setColor(Color.MAGENTA);
        g.fillRect(620, 40, 10, 10);
        g.setColor(new Color(150, 70, 0)); //brown
        g.fillRect(635, 40, 10, 10);
        g.setColor(new Color(0, 0, 100)); //dark blue
        g.fillRect(650, 40, 10, 10);
        g.setColor(new Color(100, 100, 0)); //olive green
        g.fillRect(665, 40, 10, 10);
        g.setColor(Color.GRAY);
        g.fillRect(680, 40, 10, 10);
        g.setColor(new Color(232, 227, 163)); //tan
        g.fillRect(695, 40, 10, 10);
        g.setColor(new Color(163, 255, 210)); //light green
        g.fillRect(710, 40, 10, 10);
        //second line of colours--
        g.setColor(new Color(67, 97, 178)); //navy blue
        g.fillRect(500, 60, 10, 10);
        g.setColor(new Color(110, 7, 0)); //dark red
        g.fillRect(515, 60, 10, 10);
        g.setColor(new Color(197, 232, 255)); //baby blue
        g.fillRect(530, 60, 10, 10);

        //draw the canvas----------------
        g.drawImage(canvas, 0, 150, null);
    }

    @Deprecated
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        brush.setDown(true);
        dynamicMouseX = e.getX();
        dynamicMouseY = e.getY();

        //Shapes---------------------------
        /*if ((e.getX() >= 150 && e.getX() <= 150 + 64) && (e.getY() >= 30 && e.getY() <= 30 + 64)) { //if user clicks on the paint bucket option
            brush.setShape(PaintBrush.FILL);
            brush.setColor(non_eraserColor);
            Logger.logUserMessage("Set brush shape to FILL."); todo implement filling. also remember to re-enable paintbukt icon

        }*/
        if ((e.getX() >= 215 && e.getX() <= 215 + 64) && (e.getY() >= 30 && e.getY() <= 30 + 64)) { //if user clicks on the circle brush option
            brush.setShape(PaintBrush.CIRCLE);
            brush.setColor(non_eraserColor);
            Logger.logUserMessage("Set brush shape to CIRCLE.");
        } else if ((e.getX() >= 279 && e.getX() <= 279 + 64) && (e.getY() >= 30 && e.getY() <= 30 + 64)) {//if user clicks on the square brush option
            brush.setShape(PaintBrush.SQUARE);
            brush.setColor(non_eraserColor);
            Logger.logUserMessage("Set brush shape to SQUARE.");
        } else if ((e.getX() >= 343 && e.getX() <= 343 + 64) && (e.getY() >= 30 && e.getY() <= 30 + 64)) {//if user clicks on the eraser option
            brush.setShape(PaintBrush.ERASER);
            Logger.logUserMessage("Set brush shape to ERASER.");
        }
        //Sizes-----------------------
        if ((e.getX() >= 150 && e.getX() <= 150 + 64) && (e.getY() >= 85 && e.getY() <= 85 + 64)) { //if user clicks on the small brush option
            brush.setSize(PaintBrush.SMALL);
            Logger.logUserMessage("Set brush SIZE to SMALL.");
        } else if ((e.getX() >= 200 && e.getX() <= 200 + 64) && (e.getY() >= 85 && e.getY() <= 85 + 64)) { //if user clicks on the medium brush option
            brush.setSize(PaintBrush.MEDIUM);
            Logger.logUserMessage("Set brush size to MEDIUM.");
        } else if ((e.getX() >= 250 && e.getX() <= 250 + 64) && (e.getY() >= 85 && e.getY() <= 85 + 64)) { //if user clicks on the big brush option
            brush.setSize(PaintBrush.BIG);
            Logger.logUserMessage("Set brush size to BIG.");
        } else if ((e.getX() >= 320 && e.getX() <= 320 + 64) && (e.getY() >= 85 && e.getY() <= 85 + 64)) { //if user clicks on the huge brush option
            brush.setSize(PaintBrush.HUGE);
            Logger.logUserMessage("Set brush size to HUGE");
        }
        //Colours ---------------------------
        setCurrentPaint(brush); //sets the current paint based on the user's click.
        if ((e.getX() >= 820 && e.getX() <= 870) && (e.getY() >= 70 && e.getY() <= 120)) {
            getUserRGB(brush);
        }
        //Paint--------------------
        b.setColor(brush.getColor()); //sets the painting colour to the current colour of the brush
        if (e.getY() > 150) {
            repaint();
            if (brush.getShape() == PaintBrush.CIRCLE && brush.isDown()) {
                switch (brush.getSize()) {
                    case PaintBrush.SMALL:
                        b.fillOval(e.getX() - 5, e.getY() - 150, 10, 10);
                        break;
                    case PaintBrush.MEDIUM:
                        b.fillOval(e.getX() - 25, e.getY() - 170, 50, 50);
                        break;
                    case PaintBrush.BIG:
                        b.fillOval(e.getX() - 45, e.getY() - 200, 90, 90);
                        break;
                    case PaintBrush.HUGE:
                        b.fillOval(e.getX() - 65, e.getY() - 210, 130, 130);
                        break;
                }
            } else if (brush.getShape() == PaintBrush.SQUARE && brush.isDown()) {
                switch (brush.getSize()) {
                    case PaintBrush.SMALL:
                        b.fillRect(e.getX() - 5, e.getY() - 150, 10, 10);
                        break;
                    case PaintBrush.MEDIUM:
                        b.fillRect(e.getX() - 25, e.getY() - 170, 50, 50);
                        break;
                    case PaintBrush.BIG:
                        b.fillRect(e.getX() - 45, e.getY() - 200, 90, 90);
                        break;
                    case PaintBrush.HUGE:
                        b.fillRect(e.getX() - 65, e.getY() - 210, 130, 130);
                        break;
                }
            } else if (brush.getShape() == PaintBrush.ERASER && brush.isDown()) {
                switch (brush.getSize()) {
                    case PaintBrush.SMALL:
                        b.fillRect(e.getX() - 5, e.getY() - 150, 10, 10);
                        break;
                    case PaintBrush.MEDIUM:
                        b.fillRect(e.getX() - 25, e.getY() - 170, 50, 50);
                        break;
                    case PaintBrush.BIG:
                        b.fillRect(e.getX() - 45, e.getY() - 200, 90, 90);
                        break;
                    case PaintBrush.HUGE:
                        b.fillRect(e.getX() - 65, e.getY() - 210, 130, 130);
                        break;
                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        brush.setDown(false);
        dynamicMouseX = e.getX();
        dynamicMouseY = e.getY();
        //Clearing -----------------
        if ((e.getX() >= 10 && e.getX() <= 74) && (e.getY() >= 60 && e.getY() <= 124)) { //if user clicks on the clearing X.
            b.setColor(canvasColour);
            b.fillRect(canvas.getMinX(), canvas.getMinY(), canvas.getWidth(), canvas.getHeight()); //fill a large rectangle to clear the screen
            repaint();
            //resets the canvas and brush paint back to black, the default.
            brush.setColor(Color.BLACK);
            b.setColor(brush.getColor());
            brush.setShape(PaintBrush.CIRCLE);
            brush.setSize(PaintBrush.SMALL);
            Logger.logUserMessage("Cleared the canvas.");
        }
    }

    @Deprecated
    public void mouseEntered(MouseEvent e) {

    }

    @Deprecated
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void addNotify() {
        super.addNotify();
        requestFocus(); //brings the window to the screen.
        Logger.logOtherMessage("Window", "Requesting focus on the window.");
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        dynamicMouseX = e.getX();
        dynamicMouseY = e.getY();
        if (e.getY() > 150) {
            b.setColor(brush.getColor());
            repaint();
            if (brush.getShape() == PaintBrush.CIRCLE && brush.isDown()) { //circle brush
                switch (brush.getSize()) {
                    case PaintBrush.SMALL:
                        b.fillOval(e.getX() - 5, e.getY() - 150, 10, 10);
                        break;
                    case PaintBrush.MEDIUM:
                        b.fillOval(e.getX() - 25, e.getY() - 170, 50, 50);
                        break;
                    case PaintBrush.BIG:
                        b.fillOval(e.getX() - 45, e.getY() - 200, 90, 90);
                        break;
                    case PaintBrush.HUGE:
                        b.fillOval(e.getX() - 65, e.getY() - 210, 130, 130);
                        break;
                }
            } else if (brush.getShape() == PaintBrush.SQUARE && brush.isDown()) { //square brush
                switch (brush.getSize()) {
                    case PaintBrush.SMALL:
                        b.fillRect(e.getX() - 5, e.getY() - 150, 10, 10);
                        break;
                    case PaintBrush.MEDIUM:
                        b.fillRect(e.getX() - 25, e.getY() - 170, 50, 50);
                        break;
                    case PaintBrush.BIG:
                        b.fillRect(e.getX() - 45, e.getY() - 200, 90, 90);
                        break;
                    case PaintBrush.HUGE:
                        b.fillRect(e.getX() - 65, e.getY() - 210, 130, 130);
                        break;
                }
            } else if (brush.getShape() == PaintBrush.ERASER && brush.isDown()) { //square brush.
                switch (brush.getSize()) {
                    case PaintBrush.SMALL:
                        b.fillRect(e.getX() - 5, e.getY() - 150, 10, 10);
                        break;
                    case PaintBrush.MEDIUM:
                        b.fillRect(e.getX() - 25, e.getY() - 170, 50, 50);
                        break;
                    case PaintBrush.BIG:
                        b.fillRect(e.getX() - 45, e.getY() - 200, 90, 90);
                        break;
                    case PaintBrush.HUGE:
                        b.fillRect(e.getX() - 65, e.getY() - 210, 130, 130);
                        break;
                }
            }
        }
        repaint();
    }

    @Deprecated
    public void mouseMoved(MouseEvent e) {

    }

    /**
     * Method to fill an area with colour.
     *
     * @param g     the graphics from paint
     * @param color the colour to fill with
     */
    private void fillWithColour(Graphics g, Color color, int startX, int startY) {
        //todo recursive colour filling method
    }

    /**
     * Method to set the current painting colour
     *
     * @param brush the brush from the panel
     */
    private void setCurrentPaint(PaintBrush brush) {
        if ((dynamicMouseX >= 500 && dynamicMouseX <= 510) && (dynamicMouseY >= 40 && dynamicMouseY <= 50)) {
            brush.setColor(Color.RED);
            non_eraserColor = brush.getColor();
            Logger.logUserMessage("Set the colour of the brush to RED.");
        } else if ((dynamicMouseX >= 515 && dynamicMouseX <= 525) && (dynamicMouseY >= 40 && dynamicMouseY <= 50)) {
            brush.setColor(Color.BLUE);
            non_eraserColor = brush.getColor();
            Logger.logUserMessage("Set the colour of the brush to BLUE.");
        } else if ((dynamicMouseX >= 530 && dynamicMouseX <= 540) && (dynamicMouseY >= 40 && dynamicMouseY <= 50)) {
            brush.setColor(Color.orange);
            non_eraserColor = brush.getColor();
            Logger.logUserMessage("Set the colour of the brush to ORANGE.");
        } else if ((dynamicMouseX >= 545 && dynamicMouseX <= 555) && (dynamicMouseY >= 40 && dynamicMouseY <= 50)) {
            brush.setColor(Color.yellow);
            non_eraserColor = brush.getColor();
            Logger.logUserMessage("Set the colour of the brush to YELLOW.");
        } else if ((dynamicMouseX >= 560 && dynamicMouseX <= 570) && (dynamicMouseY >= 40 && dynamicMouseY <= 50)) {
            brush.setColor(Color.green);
            non_eraserColor = brush.getColor();
            Logger.logUserMessage("Set the colour of the brush to GREEN.");
        } else if ((dynamicMouseX >= 575 && dynamicMouseX <= 585) && (dynamicMouseY >= 40 && dynamicMouseY <= 50)) {
            brush.setColor(Color.black);
            non_eraserColor = brush.getColor();
            Logger.logUserMessage("Set the colour of the brush to BLACK.");
        } else if ((dynamicMouseX >= 590 && dynamicMouseX <= 600) && (dynamicMouseY >= 40 && dynamicMouseY <= 50)) {
            brush.setColor(Color.CYAN);
            non_eraserColor = brush.getColor();
            Logger.logUserMessage("Set the colour of the brush to CYAN.");
        } else if ((dynamicMouseX >= 605 && dynamicMouseX <= 615) && (dynamicMouseY >= 40 && dynamicMouseY <= 50)) {
            brush.setColor(Color.pink);
            non_eraserColor = brush.getColor();
            Logger.logUserMessage("Set the colour of the brush to PINK.");
        } else if ((dynamicMouseX >= 620 && dynamicMouseX <= 630) && (dynamicMouseY >= 40 && dynamicMouseY <= 50)) {
            brush.setColor(Color.MAGENTA);
            non_eraserColor = brush.getColor();
            Logger.logUserMessage("Set the colour of the brush to MAGENTA.");
        } else if ((dynamicMouseX >= 635 && dynamicMouseX <= 645) && (dynamicMouseY >= 40 && dynamicMouseY <= 50)) {
            brush.setColor(new Color(150, 70, 0));
            non_eraserColor = brush.getColor();
            Logger.logUserMessage("Set the colour of the brush to BROWN.");
        } else if ((dynamicMouseX >= 650 && dynamicMouseX <= 660) && (dynamicMouseY >= 40 && dynamicMouseY <= 50)) {
            brush.setColor(new Color(0, 0, 100));
            non_eraserColor = brush.getColor();
            Logger.logUserMessage("Set the colour of the brush to DARK_BLUE.");
        } else if ((dynamicMouseX >= 665 && dynamicMouseX <= 675) && (dynamicMouseY >= 40 && dynamicMouseY <= 50)) {
            brush.setColor(new Color(100, 100, 0));
            non_eraserColor = brush.getColor();
            Logger.logUserMessage("Set the colour of the brush to OLIVE_GREEN.");
        } else if ((dynamicMouseX >= 680 && dynamicMouseX <= 690) && (dynamicMouseY >= 40 && dynamicMouseY <= 50)) {
            brush.setColor(Color.GRAY);
            non_eraserColor = brush.getColor();
            Logger.logUserMessage("Set the colour of the brush to GREY.");
        } else if ((dynamicMouseX >= 695 && dynamicMouseX <= 705) && (dynamicMouseY >= 40 && dynamicMouseY <= 50)) {
            brush.setColor(new Color(232, 227, 163));
            non_eraserColor = brush.getColor();
            Logger.logUserMessage("Set the colour of the brush to TAN.");
        } else if ((dynamicMouseX >= 710 && dynamicMouseX <= 720) && (dynamicMouseY >= 40 && dynamicMouseY <= 50)) {
            brush.setColor(new Color(163, 255, 210));
            non_eraserColor = brush.getColor();
            Logger.logUserMessage("Set the colour of the brush to LIGHT_GREEN.");
        } else if ((dynamicMouseX >= 500 && dynamicMouseX <= 510) && (dynamicMouseY >= 60 && dynamicMouseY <= 70)) {
            brush.setColor(new Color(67, 97, 178));
            non_eraserColor = brush.getColor();
            Logger.logUserMessage("Set the colour of the brush to NAVY_BLUE");
        } else if ((dynamicMouseX >= 515 && dynamicMouseX <= 525) && (dynamicMouseY >= 60 && dynamicMouseY <= 70)) {
            brush.setColor(new Color(110, 8, 0));
            non_eraserColor = brush.getColor();
            Logger.logUserMessage("Set the colour of the brush to DARK_RED");
        } else if ((dynamicMouseX >= 500 && dynamicMouseX <= 510) && (dynamicMouseY >= 60 && dynamicMouseY <= 70)) {
            brush.setColor(new Color(197, 232, 255));
            non_eraserColor = brush.getColor();
            Logger.logUserMessage("Set the colour of the brush to BABY_BLUE");
        }
    }

    /**
     * Method to open a dialogue to let the user set their own colour.
     *
     * @param brush the paintbrush, to set the colour to.
     */
    private void getUserRGB(PaintBrush brush) {
        try {
            int r = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter RED's value."));
            int g = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter GREEN's value."));
            int b = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter BLUE's value."));
            //if numbers are too high or low, fix them.
            if (r > 255) r = 255;
            if (r < 0) r = 0;
            if (g > 255) g = 255;
            if (g < 0) g = 0;
            if (b > 255) b = 255;
            if (b < 0) b = 0;

            brush.setColor(new Color(r, g, b));
        } catch (Exception e) {
            System.err.println("[Error] Color selector had an issue.");
            Logger.logErrorMessage("Seems the colour selector had an issue. Ending it silently...");
        }
    }
}
