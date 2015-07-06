package applist;

import java.io.Serializable;

public class MyFriendsSDetails implements Serializable {
	
	 private String myfriendname=null;
	 private String myfriendnickname=null;
	 private int photo=0;
	 
	 public MyFriendsSDetails(String friendname, int myphoto){
		 this.myfriendname=friendname;
		
		 this.photo=myphoto;
	 }

	public String getMyfriendname() {
		return myfriendname;
	}

	public void setMyfriendname(String myfriendname) {
		this.myfriendname = myfriendname;
	}

	

	public int getPhoto() {
		return photo;
	}

	public void setPhoto(int photo) {
		this.photo = photo;
	}

	

	 
}
