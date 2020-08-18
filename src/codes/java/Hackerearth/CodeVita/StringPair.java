package codes.java.Hackerearth.CodeVita;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class StringPair {
    static HashMap<Integer, String> map;
    static HashSet<Character> vowels;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new HashMap<>();
        map.put(0, "zero");
        map.put(1, "one");map.put(2, "two");map.put(3, "three"); map.put(4, "four");
        map.put(5, "five");map.put(6, "six"); map.put(7, "seven");map.put( 8, "eight"); map.put(9, "nine"); map.put(10, "ten");
        map.put(11, "eleven"); map.put( 12, "twelve"); map.put(13, "thirteen");map.put(14, "fourteen");
        map.put(15, "fifteen");map.put(16, "sixteen");map.put(17,"seventeen"); map.put(18, "eighteen");map.put( 19, "nineteen");map.put( 20, "twenty");
        map.put(21, "twentyone");map.put( 22, "twentytwo");map.put( 23, "twentythree"); map.put(24, "twentyfour");
        map.put(25, "twentyfive"); map.put(26, "twentysix");map.put( 27, "twentyseven");map.put(28, "twentyeight"); map.put(29, "twentynine"); map.put(30, "thirty");
        map.put(31, "thirtyone"); map.put(32, "thirtytwo"); map.put(33, "thirtythree"); map.put(34, "thirtyfour");
        map.put(35, "thirtyfive"); map.put(36, "thirtysix"); map.put(37, "thirtyseven"); map.put(38, "thirtyeight");map.put(39, "thirtynine");map.put(40, "forty");
        map.put(41, "fortyone"); map.put(42, "fortytwo"); map.put(43, "fortythree");map.put( 44, "fortyfour");
        map.put(45, "fortyfive"); map.put(46, "fortysix");map.put(47, "fortyseven");map.put( 48, "fortyeight"); map.put(49, "fortynine"); map.put(50, "fifty");
        map.put(51, "fiftyone");map.put(52, "fiftytwo"); map.put(53, "fiftythree"); map.put(54, "fiftyfour");
        map.put(55, "fiftyfive"); map.put(56, "fiftysix"); map.put(57, "fiftyseven"); map.put(58, "fiftyeight"); map.put(59, "fiftynine");map.put(60, "sixty");
        map.put(61, "sixtyone"); map.put(62, "sixtytwo"); map.put(63, "sixtythree"); map.put(64, "sixtyfour");
        map.put(65, "sixtyfive"); map.put(66, "sixtysix");map.put(67, "sixtyseven"); map.put(68, "sixtyeight"); map.put(69, "sixtynine");map.put( 70, "seventy");
        map.put(71, "seventyone"); map.put(72, "seventytwo");map.put(73, "seventythree"); map.put( 74, "seventyfour");
        map.put(75, "seventyfive"); map.put(76, "seventysix"); map.put(77, "seventyseven");map.put(78, "seventyeight"); map.put(79, "seventynine"); map.put(80, "eighty");
        map.put(81, "eightyone"); map.put(82, "eightytwo"); map.put(83, "eightythree"); map.put(84, "eightyfour");
        map.put(85, "eightyfive"); map.put(86, "eightysix"); map.put(87, "eightyseven"); map.put(88, "eightyeight"); map.put(89, "eightynine"); map.put(90, "ninety");
        map.put(91, "ninetyone"); map.put(92, "ninetytwo"); map.put(93, "ninetythree"); map.put(94, "ninetyfour");
        map.put(95, "ninetyfive"); map.put(96, "ninetysix"); map.put(97, "ninetyseven"); map.put(98, "ninetyeight"); map.put(99, "ninetynine"); map.put(100, "hundred");


        vowels = new HashSet<>();
        vowels.addAll(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        int totalVowels = countVowels(arr);
        //System.out.println(totalVowels);
        int pairs = twoSum2(arr, totalVowels);

        if(pairs > 100)
            System.out.println("greater 100");
        else
            System.out.println(map.get(pairs));

    }

    static int countVowels(int[] nums)
    {
        int total = 0;
        for(int num: nums)
        {
            for(char ch: map.get(num).toCharArray())
            {
                if(vowels.contains(ch))
                    total++;
            }
        }
        return total;
    }

    static int twoSum2(int[] arr, int target)
    {
        int count = 0;
        int i = 0, j = arr.length - 1;
        while(i < j)
        {
            if(arr[i] + arr[j] == target)
            {
                count++;
                i++; j--;

                while(i < j && arr[i] == arr[i - 1]) i++;
                while(i < j && arr[j] == arr[j + 1]) j--;
            }
            else
            {
                if(arr[i] + arr[j] > target)
                    j--;
                else
                    i++;
            }
        }
        return count;
    }
}
