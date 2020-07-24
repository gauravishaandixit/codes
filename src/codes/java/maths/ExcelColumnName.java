package codes.java.maths;

public class ExcelColumnName {
    String excelColumnName(int columnName)
    {
        StringBuilder ans = new StringBuilder();
        while(columnName > 0)
        {
            columnName--;
            ans.insert(0, (char)('A' + columnName % 26));
            columnName /= 26;
        }
        return ans.toString();
    }

    public static void main(String args[])
    {
        System.out.println(new ExcelColumnName().excelColumnName(1));
        System.out.println(new ExcelColumnName().excelColumnName(27));
        System.out.println(new ExcelColumnName().excelColumnName(26));
        System.out.println(new ExcelColumnName().excelColumnName(52));
    }
}
