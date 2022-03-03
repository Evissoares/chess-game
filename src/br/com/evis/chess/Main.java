package br.com.evis.chess;

import br.com.evis.chess.game.Game;
import br.com.evis.chess.pieces.*;
import br.com.evis.chess.players.HumanPlayer;
import br.com.evis.chess.players.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Color;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.awt.Image.SCALE_SMOOTH;

public class Main {

    static Spot selectedSpot = null;
    static Player p1 = new HumanPlayer(true);
    static Player p2 = new HumanPlayer(false);

    public static void main(String[] args) throws IOException {


        Game game = new Game();

        game.inicialize(p1, p2);

        Board b = game.getBoard();

        JFrame frame = new JFrame();


        BufferedImage img = ImageIO.read(new File("src\\br\\com\\evis\\chess\\assets\\pieces.png"));
        System.out.println();
        Image[] imgs = new Image[12];

        int index = 0;

        for (int y = 0; y < img.getHeight(); y += img.getHeight() / 2) {
            for (int x = 0; x < img.getWidth(); x += img.getWidth() / 6) {
                imgs[index] = img.getSubimage(x, y, img.getWidth() / 6, img.getHeight() / 2).getScaledInstance(64, 64, SCALE_SMOOTH);
                index++;
            }
        }

        frame.setBounds(0, 0, 510, 510);
        frame.setUndecorated(true);


        JPanel panel = new JPanel() {

            @Override
            public void paint(Graphics g) {

                boolean white = true;

                for (int x = 0; x < 8; x++) {
                    for (int y = 0; y < 8; y++) {

                        g.setColor(white ? Color.WHITE.darker() : Color.DARK_GRAY.brighter());

                        g.fillRect(x * 64, y * 64, 64, 64);
                        white = !white;
                    }
                    white = !white;

                }

                placePieces(g);
            }

            private void placePieces(Graphics g) {
                for (int x = 0; x < 8; x++) {
                    for (int y = 0; y < 8; y++) {

                        int ind = 0;

                        if (b.getBox(x, y).getPiece() == null) {
                            continue;
                        }

                        if (b.getBox(x, y).getPiece() instanceof King) {
                            ind = 0;
                        }
                        if (b.getBox(x, y).getPiece() instanceof Queen) {
                            ind = 1;
                        }
                        if (b.getBox(x, y).getPiece() instanceof Bishop) {
                            ind = 2;
                        }
                        if (b.getBox(x, y).getPiece() instanceof Knight) {
                            ind = 3;
                        }
                        if (b.getBox(x, y).getPiece() instanceof Rook) {
                            ind = 4;
                        }
                        if (b.getBox(x, y).getPiece() instanceof Pawn) {
                            ind = 5;
                        }
                        if (!b.getBox(x, y).getPiece().isWhite()) {
                            ind += 6;
                        }

                        g.drawImage(imgs[ind], b.getBox(x, y).getPosY() * 64, b.getBox(x, y).getPosX() * 64, this);
                    }


                }
            }


        };

        frame.add(panel);
        frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Linha: " + e.getY() / 64+ "\nColuna: " + e.getX()/64);

            }

            @Override
            public void mousePressed(MouseEvent e) {
                selectedSpot = b.getBox(e.getY() / 64, e.getX() / 64);

            }

            @Override
            public void mouseReleased(MouseEvent e) {

                game.playerMove(game.getCurrentTurn(), selectedSpot.getPosX(), selectedSpot.getPosY(), e.getY() / 64, e.getX() / 64);
                frame.repaint();

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                /*
                Unnecessary implementation
                 */
            }

            @Override
            public void mouseExited(MouseEvent e) {
                /*
                Unnecessary implementation
                 */
            }
        });

        frame.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                /*
                Unnecessary implementation
                 */
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                /*
                Unnecessary implementation
                 */
            }
        });
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);


    }

}
