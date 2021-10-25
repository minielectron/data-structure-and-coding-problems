package datastructure.list;
/*
We are given an datastructure.array buildings of integers. Each item represents the height of a building on a skyline from left to right.

        Here are the details:
        The sun sits on the far left
        A building is "blocked" from seeing the sun if there is a building to its left that is >= in height than itself

        You should:
        Return a revised list of the buildings with "blocked" buildings excluded
        Maintain the relative order of the buildings as they stood in buildings
        Represent each building by its original index in buildings (rather than by its value)

        Example 1:
        Input: [11, 12, 13, 14, 15]
        Output: [0, 1, 2, 3, 4]
        Explanation: No building is blocked. All buildings stay.*/

import java.util.ArrayList;
import java.util.List;

public class SunsetViewProblem {


    public static void main(String[] args) {
        int [] buildings = new int[]{7,4,8,2,9};
        SunsetViewProblem s = new SunsetViewProblem();
        System.out.println(s.getBuildingsWithAView(buildings));
    }


    public List<Integer> getBuildingsWithAView(int[] buildingHeight) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        int max = buildingHeight[0];
        for (int i = 1; i < buildingHeight.length ;i++){
            if (buildingHeight[i] > max){
                result.add(i);
                max = buildingHeight[i];
            }
        }
        return result;
    }
}

