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
import com.flurry.android.FlurryPerformance;

import de.tubs.cs.ias.flutebe.databinding.FragmentCreateObjectBinding;

public class CreateObject extends Fragment {

    private FragmentCreateObjectBinding binding;
    private String FLURRY_IDENT = "FLURRY_ID_PLACEHOLDER";

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentCreateObjectBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonCreateObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("some","action");
                NavHostFragment.findNavController(CreateObject.this)
                        .navigate(R.id.action_CreateObject_to_Consent);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        // as found at https://developer.yahoo.com/flurry/docs/
        new FlurryAgent.Builder()
                .withLogEnabled(true)
                .withDataSaleOptOut(false)
                .withCaptureUncaughtExceptions(true)
                .withIncludeBackgroundSessionsInMetrics(true)
                .withLogLevel(Log.VERBOSE)
                .withPerformanceMetrics(FlurryPerformance.ALL)
                .withReportLocation(true) // this is also suggested
                .build(this.getActivity(), FLURRY_IDENT);

        CharSequence text = binding.textviewCreateObject.getText() + " [CREATED]";
        binding.textviewCreateObject.setText(text);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
