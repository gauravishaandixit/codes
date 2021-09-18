package codes.java.amazonOA;

import java.util.Arrays;

public class TeamHackathon {

    static int countTeams(int[] skill, int teamSize, int maxDiff) {
        int ans = 0;
        Arrays.sort(skill);
        for(int i = 0; i < skill.length - teamSize + 1;) {
            if(skill[i + teamSize - 1] - skill[i] <= maxDiff) {
                ans++;
                i += teamSize;
            }
            else {
                i++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countTeams(new int[]{3,4,3,1,6,5},3,2));
        System.out.println(countTeams(new int[]{3,4,3,1,6,5},2,4));
        System.out.println(countTeams(new int[]{3,4,3,1,6,5},3,1));
    }

}
