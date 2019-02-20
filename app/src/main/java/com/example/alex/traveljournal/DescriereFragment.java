package com.example.alex.traveljournal;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DescriereFragment extends Fragment {
    private WebView webView;


    public DescriereFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_descriere, container, false);
        webView = view.findViewById(R.id.Web_view);

        webView.loadUrl("https://www.wikipedia.org/wiki/" + );


        return view;
    }


}
