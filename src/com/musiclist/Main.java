package com.musiclist;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.LinkedList;
import java.util.Scanner;
public class Main {
	
	private static ArrayList<album> Albums=new ArrayList<>();
	public static void main(String[] args) 
	{
		
		
		album lbum =new album("Album1","AC/DC");
		lbum.addSong("TNT", 4.5);
		lbum.addSong("HELL TO HIGHWAY", 3.5);
		lbum.addSong("THUNDER STRUCK", 4.7);
		lbum.addSong("DIAMOND", 5.5);
		Albums.add(lbum);
		lbum =new album("Album2","Hit");
		lbum.addSong("TAKATAK", 3.5);
		lbum.addSong("PATOLA", 6.5);
		lbum.addSong("LATAK MATAK", 2.5);
		Albums.add(lbum);
		
		LinkedList<song> playlist1= new LinkedList<>();
		
		Albums.get(0).addToPlaylist("TNT", playlist1);
		Albums.get(1).addToPlaylist("DIAMOND", playlist1);
		Albums.get(2).addToPlaylist("TAKATAK", playlist1);
		Albums.get(3).addToPlaylist("HIGHWAY TO HELL ", playlist1);
		
		play(playlist1);
	}
	private static void play(LinkedList<song> playlist)
	{
		Scanner sc= new Scanner(System.in);
		boolean quit=false;
		boolean forward=true;
		ListIterator<song> listiterator=playlist.listIterator();
		if(playlist.size()==0)
		{
			System.out.println("this playlist have not songs");
		}
		else
		{
			System.out.println("Now Playing "+listiterator.next().toString());
			printMenu();
		}
		while(!quit)
		{
			int action=sc.nextInt();
			sc.nextLine();
			
			switch (action)
			{
			case 0: System.out.println("Playlist is complete->");
				quit=true;
				break;
			case 1:
					if(!forward)
					{
						if(listiterator.hasNext())
						{
							listiterator.next();
						}
						forward =true;
					}
					if(listiterator.hasNext())
					{
						System.out.println("Now Playing "+listiterator.next().toString());
					}
					else {
						System.out.println("No song available , reached to the end of list");
						forward=true;
					}
					break;
			case 2:
				if(forward)
				{
					if(listiterator.hasPrevious())
					{
						listiterator.previous();
					}
					forward=false;
				}
				if(listiterator.hasPrevious())
				{
					System.out.println("Now Playing "+ listiterator.previous());
					forward=false;
				}
				break;
			case 3: 
					if(forward)
					{
						if(listiterator.hasPrevious())
						{
						System.out.println("Now Playing "+listiterator.previous().toString());
							forward=false;
						}
						else
						{
						System.out.println("we are at the start of list");
						}
					}
					else {
						if(listiterator.hasNext())
						{
						System.out.println("Now Playing "+listiterator.next().toString());
						forward=true;
						}else {
							System.out.println("We reach at the end of List");
						}
					}
				
					break;
			case 4:	
					printList(playlist);
				break;
			case 5:
					printMenu();
				break;
			case 6:
					if(playlist.size()>0)
					{
						listiterator.remove();
						if(listiterator.hasNext())
						{
							System.out.println("Now Playing "+listiterator.next().toString());
							
						}
						else
						{
						 if(listiterator.hasPrevious())
						 {
						System.out.println("Now Playing "+listiterator.previous().toString());	
							
							}
							
						}
					}
				break;
			
			}
		}
		sc.close();
	}
	
	private static void printMenu() {
		System.out.println("Select your Choice \n press");
		System.out.println("0-to quite\n"+
							"1-to play next song\n"+
							"2-to play previous song\n"+
							"3-to replay the current song\n"+
							"4-list of all the songs\n"+
							"5-print all the available options\n"+
							"6-delet current song");
	}
	
	private static void printList(LinkedList<song> playList)
	{
		Iterator<song> iterator=playList.iterator();
		System.out.println("------------------------");
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
		System.out.println("-------------------------");
		
	}
	
}
