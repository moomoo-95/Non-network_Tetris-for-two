package tetris;

public class TetrisLog {
	public static void d(String log) {
		System.out.println("Tetris [Debug] : "+ log);
	}
	public static void w(String log) {
		System.out.println("Tetris [Warning] : "+ log);
	}
	public static void e(String log) {
		System.out.println("Tetris [Error] : "+ log);
	}
}
