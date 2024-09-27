package de.tubs.cs.ias.flutebe;

import static com.flurry.android.Constants.FEMALE;

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
import de.tubs.cs.ias.flutebe.databinding.FragmentBasicFuncBinding;

public class BasicFunc extends Fragment {

    private FragmentBasicFuncBinding binding;
    public static CharSequence text = "Fifth State: Basic Action";

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentBasicFuncBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        BasicFunc parent = this;

        binding.buttonConsentYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FlurryEventRecordStatus status = FlurryAgent.logEvent("MEASUREMENT_EVENT_202310102055");
                Log.i("custom","the result of the event is: " + status);
                binding.textviewBasicFunc.setText(BasicFunc.text + " [DONE]");
            }
        });
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
