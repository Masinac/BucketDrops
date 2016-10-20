package freetesting.masinac.bucketdrops;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;

/**
 * Created by masinac on 10/20/16.
 */

public class DialogAdd extends DialogFragment {

    private Button addDrop;
    private ImageButton closeDialog;
    private EditText dropInput;
    private DatePicker datePicker;

    private View.OnClickListener closeDialogClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dismiss();
        }
    };


    public DialogAdd() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_add_drop, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addDrop = (Button) view.findViewById(R.id.btn_add_drop);
        closeDialog = (ImageButton) view.findViewById(R.id.dialog_close_button);
        dropInput = (EditText) view.findViewById(R.id.dialog_drop_text);
        datePicker = (DatePicker) view.findViewById(R.id.dialog_date_picker);

        closeDialog.setOnClickListener(closeDialogClickListener);

    }
}
