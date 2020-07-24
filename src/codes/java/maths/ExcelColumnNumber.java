package codes.java.maths;

public class ExcelColumnNumber {
    int excelColumnNumber(String columnName)
    {
        int res = 0;

        for(int i = 0; i < columnName.length(); i++)
            res = res * 26 + (columnName.charAt(i) - 'A' + 1);

        return res;
    }

    public static void main(String[] args)
    {
        System.out.println(new ExcelColumnNumber().excelColumnNumber("A"));
        System.out.println(new ExcelColumnNumber().excelColumnNumber("AA"));
        System.out.println(new ExcelColumnNumber().excelColumnNumber("Z"));
        System.out.println(new ExcelColumnNumber().excelColumnNumber("AZ"));
    }
}
