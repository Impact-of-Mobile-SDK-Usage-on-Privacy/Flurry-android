package de.tubs.cs.ias.flutebe;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.flurry.android.FlurryAgent;
import com.flurry.android.FlurryEvent;
import com.flurry.android.FlurryEventRecordStatus;

import de.tubs.cs.ias.flutebe.databinding.FragmentBasicFuncPostBinding;

public class BasicFuncPost extends Fragment {

    private FragmentBasicFuncPostBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentBasicFuncPostBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}