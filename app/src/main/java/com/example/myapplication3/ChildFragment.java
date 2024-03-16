package com.example.myapplication3;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.myapplication3.databinding.ChildFragmentBinding;

public class ChildFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ChildFragmentBinding binding = ChildFragmentBinding.inflate(inflater, container,
                false);
        binding.button.setOnClickListener(view -> {
            Bundle result = new Bundle();
            result.putString("bundleKey", "Данные от другого фрагмента");
            getParentFragmentManager().setFragmentResult(
                    "requestKey", result);
            getParentFragmentManager().setFragmentResultListener("REQUEST_KEY",
                    this, (requestKey, bundle) -> {
                        String result2 = bundle.getString("BUNDLE_KEY");
                        binding.textView.setText(result2);
                    });

        });
        return binding.getRoot();
    }
}