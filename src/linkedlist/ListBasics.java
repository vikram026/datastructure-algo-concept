package linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListBasics {
    public static void main(String[] args) {
        List<List<String>> favoriteCompanies =new ArrayList<>();



        List<Integer> result=new ArrayList<>();
        //if(n==0)return result;
        List<String> list1=new ArrayList<>();
        list1.add("leetcode");
        list1.add("google");
        list1.add("facebook");
        List<String> list2=new ArrayList<>();
        list2.add("google");
        list2.add("microsoft");
        List<String> list3=new ArrayList<>();
        list3.add("google");
        list3.add("facebook");
        List<String> list4=new ArrayList<>();
        list4.add("google");
        List<String> list5=new ArrayList<>();
        list5.add("amazon");
        favoriteCompanies.add(list1);
        favoriteCompanies.add(list2);
        favoriteCompanies.add(list3);
        favoriteCompanies.add(list4);
        favoriteCompanies.add(list5);


        int n=favoriteCompanies.size();
        boolean[] visited=new boolean[n];
        favoriteCompanies=favoriteCompanies.stream().map(e->e.stream().sorted().collect(Collectors.toList())).collect(Collectors.toList());
        //favoriteCompanies.stream().flatMap(e->e.stream()).forEach(System.out::println);


        for(int i=0;i<n;i++){
            if(visited[i]==true)continue;

            List<String> currList=favoriteCompanies.get(i);
            int currSize=currList.size();

            int k=0;
            for(;k<n;k++){
                if(k!=i){

                    List<String> lookUpList=favoriteCompanies.get(k);
                    int j=0;
                    for(;j<Math.min(currSize,lookUpList.size());j++){
                        if(lookUpList.get(j)!=currList.get(j))
                            break;
                    }
                    if(j==currSize) {
                        visited[k]=true;
                        visited[i]=true;
                        break;
                    }
                }
            }
            if(k==n){
                result.add(i);
            }

        }
        result.stream().forEach(System.out::println);
    }
}
