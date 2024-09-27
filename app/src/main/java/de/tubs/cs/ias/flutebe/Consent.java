package de.tubs.cs.ias.flutebe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.flurry.android.FlurryAgent;
import com.flurry.android.FlurryConsent;

import java.util.HashMap;
import java.util.Map;

import de.tubs.cs.ias.flutebe.databinding.FragmentConsentBinding;

public class Consent extends Fragment {

    private FragmentConsentBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentConsentBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonConsentYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, String> consentString = new HashMap<>();
                binding.textviewConsent.setText(binding.textviewConsent.getText() + " [N/A]");
            }
        });

        binding.buttonConsentNo.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Map<String, String> consentString = new HashMap<>();
               binding.textviewConsent.setText(binding.textviewConsent.getText() + " [N/A]");
           }
        });

        binding.buttonConsent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Consent.this)
                        .navigate(R.id.action_Consent_to_Init);
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