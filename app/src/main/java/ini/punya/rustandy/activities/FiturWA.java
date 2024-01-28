package ini.punya.rustandy.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.azhar.spks.R;

public class FiturWA extends AppCompatActivity {

    Button button;
    EditText Edtnama, Edtemail, EdtTipekerusakan, Edtpesan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitur_wa);

        Edtnama = findViewById(R.id.editnama);
        Edtemail = findViewById(R.id.editemail);
        EdtTipekerusakan = findViewById(R.id.Tipekerusakan);
        Edtpesan = findViewById(R.id.editpesan);

        button = findViewById(R.id.btnkirim);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pesan1 = Edtnama.getText().toString();
                String pesan2 = Edtemail.getText().toString();
                String pesan3 = EdtTipekerusakan.getText().toString();
                String pesan4 = Edtpesan.getText().toString();

                String semuapesan = "Nama: " + pesan1 + "\n" + "Email : " +pesan2 + "\n" + "No. HP : " + pesan3 + "\n"+ "Pesan : " + pesan4;

                Intent kirimWA = new Intent(Intent.ACTION_SEND);
                kirimWA.setType("text/plain");
                kirimWA.putExtra(Intent.EXTRA_TEXT, semuapesan);
                kirimWA.putExtra( "rustandy", "6285219545757" + "whatsapp.net");
                kirimWA.setPackage("com.whatsapp");

                startActivity(kirimWA);
            }
        });
    }
}