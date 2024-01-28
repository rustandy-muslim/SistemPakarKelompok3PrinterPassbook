package ini.punya.rustandy.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.azhar.spks.R;

import ini.punya.rustandy.api.ApiClient;
import ini.punya.rustandy.api.ApiInterface;
import ini.punya.rustandy.database.DatabaseHelper;
import ini.punya.rustandy.model.HasilModul;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.google.android.material.button.MaterialButton;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class HasilDiagnosaActivity extends AppCompatActivity {

    SQLiteDatabase sqLiteDatabase;
    Toolbar toolbar;
    ApiInterface api;
    TextView tvGejala, tvNamaPenyakit, solusii;
    MaterialButton btnDiagnosaUlang, btnDaftarPenyakit, btnFiturWa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_diagnosa);

        setStatusBar();


        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        if (databaseHelper.openDatabase())
            sqLiteDatabase = databaseHelper.getReadableDatabase();

        toolbar = findViewById(R.id.toolbar);
        tvGejala = findViewById(R.id.tvGejala);
        tvNamaPenyakit = findViewById(R.id.tvNamaPenyakit);
        solusii = findViewById(R.id.tvsolusi);
        btnDiagnosaUlang = findViewById(R.id.btnDiagnosaUlang);
        btnDaftarPenyakit = findViewById(R.id.btnDaftarPenyakit);
        btnFiturWa = findViewById(R.id.btnFiturWa);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        btnFiturWa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber = "6282187105074";
                String url = "https://wa.me/" + phoneNumber;
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
        String str_hasil = getIntent().getStringExtra("HASIL");
        String kode = getIntent().getStringExtra("KODE");
        String[] gejala_terpilih = new String[0];
        String[] kode_terpilih = new String[0];
        if (str_hasil != null) {
            gejala_terpilih = str_hasil.split("#");
        }
        if (kode != null) {
            kode_terpilih = kode.split("#");
        }

        tvGejala.setText(kode);
        init(kode);
        btnDiagnosaUlang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
//        double cf_gabungan;
//        double cf;
//        HashMap<String, Double> mapHasil = new HashMap<>();
//
//        String query_penyakit = "SELECT kode_penyakit FROM penyakit order by kode_penyakit";
//        Cursor cursor_penyakit = sqLiteDatabase.rawQuery(query_penyakit, null);
//

//        StringBuffer output_gejala_terpilih = new StringBuffer();
//        int no = 1;
//        for (String s_gejala_terpilih : gejala_terpilih) {
//            output_gejala_terpilih.append(no++)
//                    .append(". ")
//                    .append(s_gejala_terpilih)
//                    .append("\n");
//        }
//
//        tvGejala.setText(output_gejala_terpilih);

//        Map<String, Double> sortedHasil = sortByValue(mapHasil);
//
//        Map.Entry<String, Double> entry = sortedHasil.entrySet().iterator().next();
//        String kode_penyakit = entry.getKey();
//        double hasil_cf = entry.getValue();
//        int persentase = (int) hasil_cf;

//        String query_penyakit_hasil = "SELECT nama_penyakit FROM penyakit where kode_penyakit='" + kode_penyakit + "'";
//        Cursor cursor_hasil = sqLiteDatabase.rawQuery(query_penyakit_hasil, null);
//        cursor_hasil.moveToFirst();
//
//        tvNamaPenyakit.setText(cursor_hasil.getString(0) + " " + persentase + "%");
//
//        cursor_hasil.close();

        StringBuffer output_gejala_terpilih = new StringBuffer();
        int no = 1;
        for (String s_gejala_terpilih : gejala_terpilih) {
            output_gejala_terpilih.append(no++)
                    .append(". ")
                    .append(s_gejala_terpilih)
                    .append("\n");
        }

        tvGejala.setText(output_gejala_terpilih);
        btnDiagnosaUlang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnDaftarPenyakit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HasilDiagnosaActivity.this, DaftarPenyakitActivity.class);
                startActivity(intent);
            }
        });

    }

//    public static HashMap<String, Double> sortByValue(HashMap<String, Double> hm) {
//        List<Map.Entry<String, Double>> list = new LinkedList<Map.Entry<String, Double>>(hm.entrySet());
//
//        Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
//            public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
//                return (o2.getValue()).compareTo(o1.getValue());
//            }
//        });
//
//        HashMap<String, Double> temp = new LinkedHashMap<String, Double>();
//        for (Map.Entry<String, Double> aa : list) {
//            temp.put(aa.getKey(), aa.getValue());
//        }
//        return temp;
//    }

    private void setStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    public static void setWindowFlag(Activity activity, final int bits, boolean on) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        if (on) {
            layoutParams.flags |= bits;
        } else {
            layoutParams.flags &= ~bits;
        }
        window.setAttributes(layoutParams);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void init(String key) {
        api = ApiClient.getClient().create(ApiInterface.class);
        Call<List<HasilModul>> call = api.gethasil(key);
        call.enqueue(new Callback<List<HasilModul>>() {
            @Override
            public void onResponse(Call<List<HasilModul>> call, Response<List<HasilModul>> response) {
                if (response.body() != null && response.isSuccessful()) {
                    List<HasilModul> hasilList = response.body();

                    // Loop through the list of objects and display them
                    for (HasilModul hsil : hasilList) {
                        String penya = hsil.getNamaPenyakit();
                        String persen = hsil.getPersentase();
                        String solusi = hsil.getSolusi();

                        // Display the result or handle as needed
                        // For example, append to a TextView or add to a list
                        tvNamaPenyakit.append(penya + " " + persen + "%\n");
                        solusii.append(solusi);

                    }
                } else {
                    // Handle the case where the response is not successful
                }
            }

            @Override
            public void onFailure(Call<List<HasilModul>> call, Throwable t) {
                AlertDialog.Builder builder = new AlertDialog.Builder(HasilDiagnosaActivity.this);
                builder.setTitle("Judul Pesan")
                        .setMessage(t.getLocalizedMessage())
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                // Aksi yang ingin dilakukan ketika tombol OK ditekan
                                dialogInterface.dismiss(); // Tutup dialog
                            }
                        })
                        .setNegativeButton("Batal", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                // Aksi yang ingin dilakukan ketika tombol Batal ditekan
                                dialogInterface.dismiss(); // Tutup dialog
                            }
                        });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });
    }

}
