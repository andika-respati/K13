package com.nyx_itech.k13.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;


import com.nyx_itech.k13.R;
import com.nyx_itech.k13.adapters.HomeChat;
import com.nyx_itech.k13.adapters.HomeChatListAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    /* Type: View Element
     * Description: Home Page ListView
     * ---- Layout: res/layout/fragment_home.xml
     * */
    public ListView homeChatsList;
    /* Class: HomeChatListAdapter
     * Package: com.atouchsimo.whatsup.adapters
     * */
    public HomeChatListAdapter adapter;
    /* Home chats array
     * Class: HomeChat
     * Package: com.atouchsimo.whatsup.adapters
     * */
    public List<HomeChat> chats = new ArrayList<HomeChat>();
    /* ListView Items
     * */
    public String[] names, dates, images, hints;
    public int[] newCounts;
    public View mView;

    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_home, container, false);
        homeChatsList = (ListView) mView.findViewById(R.id.homeChatsList);
        /* Class: HomeChatListAdapter
         * Package: com.atouchsimo.whatsup.adapters
    	 * */
        adapter = new HomeChatListAdapter(getActivity(), chats);
        homeChatsList.setAdapter(adapter);
        homeChatsList.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int position,
                                    long arg3) {
				/* when an item Clicked we run ChatActivity
				 * And we put an Extra "position" 
				 * */
//				Intent i = new Intent(getActivity(),ChatActivity.class);
//				i.putExtra("position", position);
//				startActivity(i);
            }
        });
        /* we load chats data from Resources
         * res/values/strings.xml
         * */
        String[] names = {"rifal","dion"};
        String[] dates = {"13:00","11:00"};
        String[] images = {"user_image_6","user_image_6"};
        Integer[] newCounts = {1,2};
        String[] hints = {"aduh", "sakiet"};
        for (int i = 0; i < names.length; i++) {
            HomeChat chat = new HomeChat();
			/* we use here HomeChat Class to set data
			 * then we add it to chats array
			 * */
            chat.setName(names[i]);
            chat.setDate(dates[i]);
            chat.setImage(images[i]);
            chat.setHint(hints[i]);
            chat.setCount(newCounts[i]);
            chats.add(chat);
        }
        adapter.notifyDataSetChanged();
        return mView;
    }
}
