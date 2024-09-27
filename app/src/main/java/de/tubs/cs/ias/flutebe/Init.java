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

import de.tubs.cs.ias.flutebe.databinding.FragmentInitBinding;

public class Init extends Fragment {

    private FragmentInitBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentInitBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonInit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Init.this)
                        .navigate(R.id.action_Init_to_BasicFunc);
            }
        });
    }

    @Override
    public void onStart() {
        FlurryAgent.onStartSession(this.getActivity().getApplicationContext());
        binding.textviewInit.setText("Initialized: " + FlurryAgent.isInitialized());
        Log.i("custom","FlurryAgent is initialized:" + FlurryAgent.isInitialized());
        super.onStart();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}