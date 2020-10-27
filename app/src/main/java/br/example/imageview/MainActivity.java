package br.example.imageview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);
    }
    public void clicar(View view) {
        Intent galeria = new Intent(
                Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galeria , 1);
    }
    protected void onActivityResult(int requestCode, int resultCode,

                                    Intent intent) {

        super.onActivityResult(requestCode, resultCode, intent);
        if (resultCode == RESULT_OK && requestCode == 1){
            Uri selectedImage = intent.getData();
            imageView.setImageURI(selectedImage);
        }
    }

}