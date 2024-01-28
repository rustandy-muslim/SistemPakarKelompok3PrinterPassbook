package ini.punya.rustandy.activities;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;

import com.azhar.spks.R;

public class Splash_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        VideoView videoView = findViewById(R.id.videoView);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.animasi1; // Ganti nama_video dengan nama file video Anda
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        // Set listener untuk menutup splash screen setelah video selesai
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                // Pindah ke activity berikutnya atau lakukan tindakan lainnya
                finish();
            }
        });

        videoView.start();
    }
}
