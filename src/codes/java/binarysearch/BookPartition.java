package codes.java.binarysearch;

import java.util.Arrays;
//You have to allocate books to B number of students so that
// maximum number of pages allotted to a student is minimum.
public class BookPartition {
    int bookPartition(int[] books, int students) {
        if(books.length < students)
            return -1;

        int low = Arrays.stream(books).max().getAsInt();
        int high = Arrays.stream(books).sum();
        int ans = -1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(isPossibleToRead(books, students, mid)) {
                ans = mid;
                high = mid - 1;
            }
            else
                low = mid + 1;
        }
        return ans;
    }
    boolean isPossibleToRead(int[] books, int students, int currMaxm) {
        int noOfStudents = 1;
        int currPages = 0;

        for(int book: books) {
            currPages += book;
            if(currPages > currMaxm) {
                noOfStudents++;
                currPages = book;
            }
            if(noOfStudents > students)
                return false;
        }
        return true;
    }

    public static void main(String[] arg) {
        int[] books = new int[]{25, 98, 113, 47, 83};
        int students = 3;
        System.out.println(new BookPartition().bookPartition(books, students));

        books = new int[]{12, 34, 67, 90};
        students = 2;
        System.out.println(new BookPartition().bookPartition(books, students));

        books = new int[]{5, 17, 100, 11};
        students = 4;
        System.out.println(new BookPartition().bookPartition(books, students));

        books = new int[]{5, 17, 100, 11};
        students = 7;
        System.out.println(new BookPartition().bookPartition(books, students));

    }
}
