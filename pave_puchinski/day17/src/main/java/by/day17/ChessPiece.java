package by.day17;

public enum ChessPiece {
    KING_WHITE(100, "Король (белый)","♚"),
    KING_BLACK(100, "Король (черный)","♔"),
    QUEEN_WHITE(9, "Ферзь (белый)","♛"),
    QUEEN_BLACK(9, "Ферзь (черный)","♕"),
    ROOK_WHITE(5, "Ладья (белая)","♜"),
    ROOK_BLACK(5, "Ладья (черная)","♖"),
    BISHOP_WHITE(3.5, "Слон (белый)","♝"),
    BISHOP_BLACK(3.5, "Слон (черный)","♗"),
    KNIGHT_WHITE(3, "Конь (белый)","♞"),
    KNIGHT_BLACK(3, "Конь (черный)","♘"),
    PAWN_WHITE(1, "Пешка (белая)","♟"),
    PAWN_BLACK(1, "Пешка (черная)","♙"),
    EMPTY(-1,"пустое место","_");

    private double value;
    private String title;
    private String figure;

    ChessPiece(double value, String title, String figure) {
        this.value = value;
        this.title = title;
        this.figure = figure;
    }
    public String getFigure(){

        return figure;

    }
}
