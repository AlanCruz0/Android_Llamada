package com.example.abrirllamada;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
    Button btnLlamar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLlamar = (Button) findViewById(R.id.btnllamar);
        btnLlamar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_DENIED) {
            requestPermissions(new String[]{android.Manifest.permission.CALL_PHONE}, 1987);
        } else if (ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.CALL_PHONE)) {
            new AlertDialog.Builder(this)
                    .setTitle("Permiso necesario")
                    .setMessage("Necesitamos el permiso para realizar llamadas telefónicas, ¿estás de acuerdo?")
                    .setPositiveButton("Sí", (dialog, which) -> ActivityCompat.requestPermissions(MainActivity.this, new String[]{android.Manifest.permission.CALL_PHONE}, 1))
                    .setNegativeButton("No", (dialog, which) -> Toast.makeText(MainActivity.this, "La función de llamada no estará disponible sin el permiso.", Toast.LENGTH_SHORT).show())
                    .show();
        } else {
            llamar();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 1987){
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                llamar();
            }
        }
    }

    public void llamar(){
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel: 5575534919"));
        startActivity(intent);
    }
}