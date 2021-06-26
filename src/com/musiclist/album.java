package com.musiclist;

import java.util.ArrayList;
import java.util.LinkedList;

public class album
{
	@SuppressWarnings("unused")
	private String name;
	@SuppressWarnings("unused")
	private String artist;
	private ArrayList<song> songs;
	
	public album (String name,String artist)
	{
		this.name=name;
		this.artist=artist;
		this.songs=new ArrayList<song>();
	}
	public album() {
		
	}
		public song findSong(String title)
		{
			for(song checkedSong:songs)
			if(checkedSong.getTitle().equals(title))
			{
				return checkedSong;
			}
			return null;
		}
	
	public boolean addSong(String title, double duration)
	{
		if(findSong(title)==null)
		{
			songs.add(new song(title,duration));
			System.out.println("title "+"Successfully added to the  list");
			return true;
		}
		else
		{
			System.out.println("Song with name "+title +"already exist in the list");
			return false;
		}
	}
	
	public boolean addToPlaylist(int trackNumber, LinkedList<song> Playlist)
	{
		int index=trackNumber-1;
		if(index>0 && index<=this.songs.size())
		{
			Playlist.add(this.songs.get(index));
			return true;
			
		}
		System.out.println("This Album does not have song with tracknumber"+trackNumber);
		return false;
	}
	
	public boolean addToPlaylist(String title,LinkedList<song> PlayList) 
	{
		for(song checkedSong :this.songs)
		{
			if(checkedSong.getTitle().equals(title))
			{
				PlayList.add(checkedSong);
				return true;
			}
		}
		System.out.println("title"+"there is no such song inalbum");
		return false;
	}
}
