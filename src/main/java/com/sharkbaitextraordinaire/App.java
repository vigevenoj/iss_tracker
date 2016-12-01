package com.sharkbaitextraordinaire;

import java.util.concurrent.LinkedBlockingQueue;

import com.sharkbaitextraordinaire.isstracker.IssLocation;
import com.sharkbaitextraordinaire.isstracker.IssLocationFetcher;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	LinkedBlockingQueue<IssLocation> queue = new LinkedBlockingQueue<IssLocation>();
        IssLocationFetcher fetcher = new IssLocationFetcher(queue);
        
        fetcher.fetch();
        
    }
}
