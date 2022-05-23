package leecode;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Demo355 {


    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        twitter.postTweet(1, 3);
        System.out.println(twitter.getNewsFeed(1));
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        System.out.println(twitter.getNewsFeed(1));
        twitter.unfollow(1, 2);
        System.out.println(twitter.getNewsFeed(1));
    }

    public static class Twitter {

        private Map<Integer, Set<Integer>> followMap = new HashMap<>();
        private List<Map<Integer, Integer>> tweetList = new ArrayList<>();
        private final int VISIBLE_TWEET_NUM = 10;

        public Twitter() {

        }

        public void postTweet(int userId, int tweetId) {
            Map<Integer, Integer> tweetMap = new HashMap<>();
            tweetMap.put(userId, tweetId);
            tweetList.add(tweetMap);
        }

        public List<Integer> getNewsFeed(int userId) {
            Set<Integer> followList = new HashSet<>();
            if (followMap.containsKey(userId)) {
                followList = followMap.get(userId);
            }
            followList.add(userId);

            List<Integer> result = new ArrayList<>(VISIBLE_TWEET_NUM);
            for (int i = tweetList.size() - 1; i >= 0 && result.size() < 10; i--) {
                Map<Integer, Integer> tweet = tweetList.get(i);
                int tweetSender = 0;
                for (Integer t : tweet.keySet()) {
                    tweetSender = t;
                }
                if (!followList.isEmpty() && followList.contains(tweetSender)) {
                    result.add(tweet.get(tweetSender));
                }
            }

            return result;
        }

        public void follow(int followerId, int followeeId) {
            Set<Integer> followList = null;
            if (followMap.containsKey(followerId)) {
                followList = followMap.get(followerId);
                followList.add(followeeId);
                followMap.replace(followerId, followList);
            } else {
                followList = new HashSet<>();
                followList.add(followeeId);
                followMap.put(followerId, followList);
            }
        }

        public void unfollow(int followerId, int followeeId) {
            if (followMap.containsKey(followerId)) {
                Set<Integer> followList = followMap.get(followerId);
                followList.remove((Object) followeeId);
                followMap.replace(followerId, followList);
            }
        }
    }


}
