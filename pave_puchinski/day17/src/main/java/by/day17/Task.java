package by.day17;

import java.util.ArrayList;
import java.util.List;

import static by.day17.ChessPiece.*;

public class Task {
    public static void main(String[] args) {


        List<ChessPiece> figures = new ArrayList<>();
        for (int i = 0; i < 4; i++)
            figures.add(PAWN_WHITE);
        for (int i = 0; i < 4; i++)
            figures.add(ROOK_BLACK);

        for (ChessPiece chessPiece : figures)
            System.out.print(chessPiece.getFigure());

        System.out.println("\n");

        String[][] board = new String[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                board[i][j] = EMPTY.getFigure();
            }
        }
        board[0][0] = ROOK_BLACK.getFigure();
        board[0][5] = ROOK_BLACK.getFigure();
        board[0][6] = KING_BLACK.getFigure();
        board[1][1] = ROOK_WHITE.getFigure();
        board[1][4] = PAWN_BLACK.getFigure();
        board[1][5] = PAWN_BLACK.getFigure();
        board[1][7] = PAWN_BLACK.getFigure();
        board[2][0] = PAWN_BLACK.getFigure();
        board[2][2] = KNIGHT_BLACK.getFigure();
        board[2][6] = PAWN_BLACK.getFigure();
        board[3][0] = QUEEN_BLACK.getFigure();
        board[3][3] = BISHOP_WHITE.getFigure();
        board[4][3] = BISHOP_BLACK.getFigure();
        board[4][4] = PAWN_WHITE.getFigure();
        board[5][4] = BISHOP_WHITE.getFigure();
        board[5][5] = PAWN_WHITE.getFigure();
        board[6][0] = PAWN_WHITE.getFigure();
        board[6][3] = QUEEN_WHITE.getFigure();
        board[6][5] = PAWN_WHITE.getFigure();
        board[6][7] = PAWN_WHITE.getFigure();
        board[7][5] = BISHOP_WHITE.getFigure();
        board[7][6] = KING_WHITE.getFigure();

        ChessBoard chessPiece = new ChessBoard(board);
        chessPiece.print();

    }
}
