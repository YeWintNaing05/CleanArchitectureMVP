package test.project.ywn.mvpcleanarchitecture.presentation.view.base;

import android.app.AlertDialog;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import test.project.ywn.mvpcleanarchitecture.R;

/**
 * Created by root on 11/20/17.
 */

public class DialogUtil {

    public static void insertData(Context context, final confirmDelegate delegate) {


        LayoutInflater inflater = (LayoutInflater) LayoutInflater.from(context).getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View alertLayout = inflater.inflate(R.layout.view_dialog, null);

        final EditText edtTitle = alertLayout.findViewById(R.id.edtTitle);
        final EditText edtDesc = alertLayout.findViewById(R.id.edtDesc);
        Button btn = alertLayout.findViewById(R.id.btnOk);

        final AlertDialog.Builder alert = new AlertDialog.Builder(context);
        alert.setTitle("Add");
        // this is set the view from XML inside AlertDialog
        alert.setView(alertLayout);
        alert.setCancelable(true);

        final AlertDialog dialog = alert.create();
        dialog.show();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!edtTitle.getText().toString().isEmpty() && !edtDesc.getText().toString().isEmpty()) {
                    delegate.confirmOk(edtTitle.getText().toString(), edtDesc.getText().toString());
                    dialog.dismiss();

                } else
                    Snackbar.make(v, "Title or desc is empty", Snackbar.LENGTH_SHORT).show();

            }
        });


    }

    public interface confirmDelegate {
        void confirmOk(String title, String desc);
    }


}
