package msku.ceng.madlab.week10;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import msku.ceng.madlab.week10.placeholder.PlaceholderContent;

/**
 * A fragment representing a list of Items.
 */
public class fragment_note extends Fragment {

    private OnNoteListInteractionListener listener;

    // TODO: Customize parameter argument names
    private static final String ARG_NOTE = "column-count";

    // TODO: Customize parameters
    private ArrayList<Note> notes;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public fragment_note() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static fragment_note newInstance(ArrayList<Note> notes) {
        fragment_note fragment = new fragment_note();
        Bundle args = new Bundle();
        args.putSerializable(ARG_NOTE, notes);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            notes = (ArrayList<Note>) getArguments().getSerializable(ARG_NOTE);        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(new MyNoteRecyclerViewAdapter(notes, listener));
        }
        return view;
    }

    public interface OnNoteListInteractionListener{
        void onNotesSelected(Note note);
    }
    @Override
    public void onAttach(@NonNull Context context){
        super.onAttach(context);
        if (context instanceof OnNoteListInteractionListener){
            listener = (OnNoteListInteractionListener) context;
        }
        else{
            throw new RuntimeException(context.getClass().getName() +
                    "should implement OnNoteListInteractionListener");
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

}