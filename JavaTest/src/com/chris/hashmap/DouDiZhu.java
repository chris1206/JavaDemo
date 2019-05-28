package com.chris.hashmap;

import java.util.*;

/**
 * Created by Chris on 2017/11/7.
 */
public class DouDiZhu {
    public static void main(String[] args) {
        //♥♠♣♦
        //第一步：组装牌<牌编号，具体的牌名>
        HashMap<Integer, String> pooker = new HashMap<>();
        String[] pookerNums = {"2","A","K","Q","J","10","9","8","7","6","5","4","3"};
        String[] pookerTypes = {"♥","♠","♣","♦"};
        //定义牌的编号
        ArrayList<Integer> nums = new ArrayList<>();

        pooker.put(0,"大王");
        nums.add(0);
        pooker.put(1,"小王");
        nums.add(1);

        int index = 2;

        for (String num : pookerNums) {
            for (String type: pookerTypes) {
                pooker.put(index, type+num);
                nums.add(index);
                index++;
            }
        }
        System.out.print(pooker);
        System.out.println();

        //第二步：洗牌-对编号集合
        System.out.println(nums);
        Collections.shuffle(nums);
        System.out.println(nums);
        //第三步：发牌
        //定义三个玩家及三张底牌集合
        List<Integer> player1 = new ArrayList<>();
        List<Integer> player2 = new ArrayList<>();
        List<Integer> player3 = new ArrayList<>();
        List<Integer> bottoms = new ArrayList<>();

        for (int i=0; i<nums.size(); i++){
            if (i<3) {
                bottoms.add(nums.get(i));
            }else if(i%3==0){
                player1.add(nums.get(i));
            }else if(i%3==1){
                player2.add(nums.get(i));
            }else if(i%3==2){
                player3.add(nums.get(i));
            }
        }

        //第四步：看牌
        look("刘德华", player1, pooker);
        look("张曼玉", player2, pooker);
        look("张柏芝", player3, pooker);
        look("底牌", bottoms, pooker);
    }

    private static void look(String name, List<Integer> player, HashMap<Integer, String> pooker) {
        System.out.print(name+"：");
        for(Integer i : player){
            System.out.print(pooker.get(i)+" ");
        }
        System.out.println();
    }
}
