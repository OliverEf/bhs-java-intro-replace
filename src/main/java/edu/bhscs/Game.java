public class Game {
    private Board board;
    private Player currentPlayer;

    public Game() {
        board = new Board();
        currentPlayer = new Player('X'); // Player X starts
    }

    public void start() {
        while (true) {
            board.printBoard();
            System.out.println("Player " + currentPlayer.getSymbol() + ", enter your move (row and column): ");
            Scanner scanner = new Scanner(System.in);
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            if (board.placeMark(row, col, currentPlayer.getSymbol())) {
                if (board.checkForWin(currentPlayer.getSymbol())) {
                    board.printBoard();
                    System.out.println("Player " + currentPlayer.getSymbol() + " wins!");
                    break;
                }
                if (board.isBoardFull()) {
                    board.printBoard();
                    System.out.println("The game is a draw!");
                    break;
                }
                changePlayer();
            } else {
                System.out.println("This move is not valid. Try again.");
            }
        }
    }

    private void changePlayer() {
        currentPlayer = (currentPlayer.getSymbol() == 'X') ? new Player('O') : new Player('X');
    }
}
