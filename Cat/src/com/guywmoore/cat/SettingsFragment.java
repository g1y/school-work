package com.guywmoore.cat;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

public class SettingsFragment extends Fragment
{
	private String[] menuOptions;
	private ArrayList<String> menuOptionsArray;
	
    
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, 
			Bundle savedIntanceState)
	{
		if (container == null)
		{
	        return null;
	    }
		RelativeLayout rl = (RelativeLayout) inflater.inflate(R.layout.fragment_settings, container,false);
		final ListView listview = (ListView)rl.findViewById(R.id.settingslistview);
		menuOptions = getResources().getStringArray(R.array.settings_strings);
		menuOptionsArray = new ArrayList<String>();
		for(int x = 0; x < menuOptions.length; x ++)
		{
			menuOptionsArray.add(menuOptions[x]);
		}
		
		final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1, menuOptionsArray);
		
		listview.setAdapter(adapter);
		
		listview.setOnItemClickListener(new OnItemClickListener()
		{
			@Override
			public void onItemClick(AdapterView<?> parent, final View view, int position, long id)
			{
				final String item = (String) parent.getItemAtPosition(position);
				menuOptionsArray.remove(item);
				adapter.notifyDataSetChanged();
			}
		});
		return inflater.inflate(R.layout.fragment_settings, container, false);
	}
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		/*
		final ListView listview = (ListView) getView().findViewById(R.id.settingslistview);
		menuOptions = getResources().getStringArray(R.array.settings_strings);
		for(int x = 0; x < menuOptions.length; x++)
		{
			menuOptionsArray.add(menuOptions[x]);
		}
		
		final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1, menuOptions);
		
		listview.setAdapter(adapter);
		
		listview.setOnItemClickListener(new OnItemClickListener()
		{
			public void onItemClick(AdapterView<?> parent, final View view, int position, long id)
			{
				final String item = (String) parent.getItemAtPosition(position);
				menuOptionsArray.remove(item);
				adapter.notifyDataSetChanged();
			}
		});
		*/
	}
	
}