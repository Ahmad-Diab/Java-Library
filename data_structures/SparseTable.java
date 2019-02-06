package data_structures;

// static Range Minimum Query, DP Solution
public class SparseTable {

	int A[], SpT[][];

	SparseTable(int[] A) {
		computeLog();
		
		int n = A.length;
		this.A = A;
		int k = log2[n] + 1;
		SpT = new int[n][k];

		for (int i = 0; i < n; i++)
			SpT[i][0] = i; // RMQ of sub array starting at index i and of length 2^0=1

		// overall time complexity = O(n log n)
		for (int j = 1; (1 << j) <= n; j++)
			for (int i = 0; i + (1 << j) - 1 < n; i++)
				if (A[SpT[i][j - 1]] < A[SpT[i + (1 << (j - 1))][j - 1]])
					SpT[i][j] = SpT[i][j - 1]; // start at index i of length 2^(j-1)
				else // start at index i+2^(j-1) of length 2^(j-1)
					SpT[i][j] = SpT[i + (1 << (j - 1))][j - 1];
	}

	int query(int i, int j) {

		int k = log2[j - i + 1]; // 2^k <= (j-i+1)

		if (A[SpT[i][k]] <= A[SpT[j - (1 << k) + 1][k]])
			return SpT[i][k];
		else
			return SpT[j - (1 << k) + 1][k];
	}

	static int[] log2;

	static void computeLog() {
		log2 = new int[300000];
		log2[1] = 0;
		for (int i = 1; i <= 16; ++i)
			for (int j = 1 << i; j <= 1 << (i + 1); ++j)
				log2[j] = i;

	}
}
