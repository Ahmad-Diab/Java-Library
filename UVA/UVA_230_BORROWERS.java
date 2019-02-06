package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class UVA_230_BORROWERS {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		StringBuilder st = new StringBuilder();
		ArrayList<Book> books = new ArrayList<Book>();
		while (true) {
			String s = sc.nextLine();
			if (s.equals("END"))
				break;

			StringTokenizer str = new StringTokenizer(s, "\"");
			String title = str.nextToken();
			StringTokenizer str1 = new StringTokenizer(str.nextToken(), "by ");
			String author = "";
			while (str1.hasMoreTokens())
				author += str1.nextToken();

			books.add(new Book(author, title));
			Collections.shuffle(books);
			Collections.sort(books);
		}

		ArrayList<Book> borrow = new ArrayList<>();
		ArrayList<Book> returnBooks = new ArrayList<>();
		while (true) {
			String type = sc.next();
			if (type.equals("END"))
				break;

			StringTokenizer str = null;
			if (!type.equals("SHELVE")) {

				String s = "";
				while (sc.st.hasMoreTokens())
					s += sc.st.nextToken() + " ";
				s = s.substring(0, s.length() - 1);

				str = new StringTokenizer(s, "\"");
			}
			if (type.equals("BORROW")) {
				String title = str.nextToken();
				while (str.hasMoreTokens())
					title += " " + str.nextToken();

				int index = -1;
				for (int i = 0; i < books.size(); i++)
					if (books.get(i).title.equals(title)) {
						index = i;
						break;
					}
				if (index != -1) {
					Book book = books.get(index);
					books.remove(book);
					borrow.add(book);
				}
			} else if (type.equals("RETURN")) {
				String title = str.nextToken();
				while (str.hasMoreTokens())
					title += " " + str.nextToken();

				int index = -1;
				for (int i = 0; i < borrow.size(); i++)
					if (borrow.get(i).title.equals(title)) {
						index = i;
						break;
					}
				if (index != -1) {

					Book book = borrow.get(index);

					borrow.remove(book);
					returnBooks.add(book);
					books.add(book);
				}
			} else if (type.equals("SHELVE")) {
				Collections.sort(books);
				Collections.sort(returnBooks);
				for (Book book : returnBooks) {
					int index = books.indexOf(book);

					if (index == 0)
						out.printf("Put \"%s\" first\n", book);
					else
						out.printf("Put \"%s\" after \"%s\"\n", book, books.get(index - 1));

				}
				returnBooks.clear();
				out.println("END");

			}

		}

		out.flush();
		out.close();

	}

	static class Book implements Comparable<Book> {
		String author;
		String title;

		public Book(String author, String title) {
			this.author = author;
			this.title = title;

		}

		@Override
		public boolean equals(Object b) {
			return this.title.equals(((Book) b).title);
		}

		@Override
		public int compareTo(Book b) {
			if (this.author == null || this.author == "")
				return this.title.compareTo(b.title);

			return this.author.compareTo(b.author) == 0 ? this.title.compareTo(b.title)
					: this.author.compareTo(b.author);
		}

		@Override
		public String toString() {
			return this.title;
		}

	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public double nextDouble() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}

}
