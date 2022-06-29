package com.slabstech.revive.server.dropwizard.retrofit.rx;
import java.io.IOException;

public class GitHubRxApp {

    public static void main(String[] args) throws IOException {
        String userName = "eugenp";
        new GitHubRxService().getTopContributors(userName).subscribe(System.out::println);
    }
}